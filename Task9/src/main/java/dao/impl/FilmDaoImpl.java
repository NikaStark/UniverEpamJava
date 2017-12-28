package dao.impl;

import dao.AbstractJDBCDao;
import dao.FilmDao;
import entities.Film;
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
public class FilmDaoImpl extends AbstractJDBCDao<Film, Integer> implements FilmDao {

    {
        logger = Logger.getLogger(Film.class);
        SQL_FIND_ALL = "SELECT " + Film.ID_COLUMN + ", " + Film.GENRE_COLUMN + ", " + Film.NAME_COLUMN + " FROM " + Film.TABLE_NAME;
        SQL_FIND_BY_PK = SQL_FIND_ALL + " WHERE " + Film.ID_COLUMN + "=?";
        SQL_INSERT = "INSERT INTO " + Film.TABLE_NAME + " (" + Film.GENRE_COLUMN + ", " + Film.NAME_COLUMN + ") VALUES (?, ?)";
        SQL_UPDATE = "UPDATE " + Film.TABLE_NAME + " SET " + Film.GENRE_COLUMN + "=?, " + Film.NAME_COLUMN + "=? WHERE " + Film.ID_COLUMN + "=?";
        SQL_DELETE = "DELETE FROM " + Film.TABLE_NAME + " WHERE " + Film.ID_COLUMN + "=?";
    }

    public FilmDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected List<Film> parseResultSet(ResultSet resultSet) throws PersistentException {
        List<Film> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Film city = new Film();
                city.setId(resultSet.getInt(Film.ID_COLUMN));
                city.setGenre(resultSet.getInt(Film.GENRE_COLUMN));
                city.setName(resultSet.getString(Film.NAME_COLUMN));
                list.add(city);
            }
        } catch (SQLException e) {
            logger.error("parseResultSet ", e);
            throw new PersistentException(e);
        }
        return list;
    }

    @Override
    protected void parseResultSetGeneratedKeys(ResultSet generatedKeys, Film object) throws PersistentException {
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
    protected void preparedStatementForInsert(PreparedStatement preparedStatement, Film object) throws PersistentException {
        try {
            preparedStatement.setInt(1, object.getGenre());
            preparedStatement.setString(2, object.getName());
        } catch (SQLException e) {
            logger.error("preparedStatementForInsert ", e);
            throw new PersistentException(e);
        }
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement preparedStatement, Film object) throws PersistentException {
        try {
            preparedStatement.setInt(1, object.getGenre());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setInt(3, object.getId());
        } catch (SQLException e) {
            logger.error("preparedStatementForUpdate ", e);
            throw new PersistentException(e);
        }
    }

}
