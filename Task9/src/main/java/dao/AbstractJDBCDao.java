package dao;

import entities.Identified;
import entities.exceptions.PersistentException;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 * @author Alex Volochai
 */
public abstract class AbstractJDBCDao<T extends Identified<PK>, PK extends Serializable> implements GenericDao<T, PK> {

    protected Logger logger;
    protected String SQL_FIND_ALL;
    protected String SQL_FIND_BY_PK;
    protected String SQL_INSERT;
    protected String SQL_UPDATE;
    protected String SQL_DELETE;
    protected Connection connection;

    protected AbstractJDBCDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(T object) throws PersistentException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatementForInsert(preparedStatement, object);
            preparedStatement.executeUpdate();
            parseResultSetGeneratedKeys(preparedStatement.getGeneratedKeys(), object);
        } catch (SQLException e) {
            logger.error("create", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public T getByPK(PK key) throws PersistentException {
        List<T> list;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_PK)) {
            preparedStatement.setObject(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            logger.error("getByPK with key=" + key, e);
            throw new PersistentException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            logger.warn("Received more than one record, with key=" + key);
        }
        return list.iterator().next();
    }

    @Override
    public void update(T object) throws PersistentException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatementForUpdate(preparedStatement, object);
            if (preparedStatement.executeUpdate() != 1) {
                logger.warn("On update modify more then 1 record!");
            }
        } catch (SQLException e) {
            logger.error("update with object=" + object, e);
            throw new PersistentException(e);
        }
    }

    @Override
    public void delete(T object) throws PersistentException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
            preparedStatement.setObject(1, object.getId());
            if (preparedStatement.executeUpdate() != 1) {
                logger.warn("On delete modify more then 1 record!");
            }
        } catch (SQLException e) {
            logger.error("delete with object=" + object, e);
            throw new PersistentException(e);
        }
    }

    @Override
    public List<T> getAll() throws PersistentException {
        List<T> list;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            logger.error("getAll", e);
            throw new PersistentException(e);
        }
        return list;
    }

    protected abstract List<T> parseResultSet(ResultSet resultSet) throws PersistentException;

    protected abstract void parseResultSetGeneratedKeys(ResultSet generatedKeys, T object) throws PersistentException;

    protected abstract void preparedStatementForInsert(PreparedStatement preparedStatement, T object) throws PersistentException;

    protected abstract void preparedStatementForUpdate(PreparedStatement preparedStatement, T object) throws PersistentException;

}
