package dao.impl;

import dao.AbstractJDBCDao;
import dao.GenreDao;
import entities.Genre;
import entities.exceptions.PersistentException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Volochai
 */
public class GenreDaoImpl extends AbstractJDBCDao<Genre, Integer> implements GenreDao {

    {
        logger = Logger.getLogger(GenreDaoImpl.class);
        SQL_FIND_ALL = "SELECT " + Genre.ID_COLUMN + ", " + Genre.NAME_COLUMN + " FROM " + Genre.TABLE_NAME;
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + Genre.ID_COLUMN + "=?";
        SQL_INSERT = "INSERT INTO " + Genre.TABLE_NAME + " (" + Genre.NAME_COLUMN + ") VALUES (?)";
        SQL_UPDATE = "UPDATE " + Genre.TABLE_NAME + " SET " + Genre.NAME_COLUMN + "=? WHERE " + Genre.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + Genre.TABLE_NAME + " WHERE " + Genre.ID_COLUMN + "=?";
    }

    public GenreDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected List<Genre> parseResultSet(ResultSet resultSet) throws PersistentException {
        List<Genre> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Genre country = new Genre();
                country.setId(resultSet.getInt(Genre.ID_COLUMN));
                country.setName(resultSet.getString(Genre.NAME_COLUMN));
                list.add(country);
            }
        } catch (SQLException e) {
            logger.error("parseResultSet ", e);
            throw new PersistentException(e);
        }
        return list;
    }

    @Override
    protected void parseResultSetGeneratedKeys(ResultSet generatedKeys, Genre object) throws PersistentException {
        try {
            if (generatedKeys.next()) {
                object.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            logger.error("parseResultSetGeneratedKeys ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, Genre object) throws PersistentException {
        try {
            preparedStatement.setString(1, object.getName());
        } catch (SQLException e) {
            logger.error("preparedStatementForInsert ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement preparedStatement, Genre object) throws PersistentException {
        try {
            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getId());
        } catch (SQLException e) {
            logger.error("preparedStatementForUpdate ", e);
            throw new PersistentException(e);
        }
    }

}
