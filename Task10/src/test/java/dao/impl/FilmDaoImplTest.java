package dao.impl;


import dao.AbstractJDBCDaoTest;
import entities.Film;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;

public class FilmDaoImplTest extends AbstractJDBCDaoTest {

    private final FilmDaoImpl filmDao = new FilmDaoImpl(connection);

    @Test
    public void testCreate() throws Exception {
        final Film film = new Film(null, 1, "The Dark Knight");
        filmDao.create(film);
        assertNotNull(film.getId());
        PreparedStatement preparedStatement = super.preparedStatementForSelect(filmDao);
        preparedStatement.setInt(1, film.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            assertEquals(1, resultSet.getInt(Film.GENRE_COLUMN));
            assertEquals("The Dark Knight", resultSet.getString(Film.NAME_COLUMN));
        }
    }

    @Test
    public void testGetByPK() throws Exception {
        final Film film = filmDao.getByPK(3);
        assertNotNull(film);
        assertEquals("Indiana Jones and the Raiders of the Lost Ark", film.getName());

        final Film filmEmpty = new Film(99999, 1, "Naughty girls");
        assertNull(filmDao.getByPK(filmEmpty.getId()));
    }

    @Test
    public void testUpdate() throws Exception {
        final Film film = new Film(3, 1, "The Dark Knight");
        filmDao.update(film);
        PreparedStatement preparedStatement = super.preparedStatementForSelect(filmDao);
        preparedStatement.setInt(1, film.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            assertEquals(1, resultSet.getInt(Film.GENRE_COLUMN));
            assertEquals("The Dark Knight", resultSet.getString(Film.NAME_COLUMN));
        }
    }

    @Test
    public void testDelete() throws Exception {
        final Film film = new Film(1, 1, "Die Hard");
        filmDao.delete(film);
        PreparedStatement preparedStatement = super.preparedStatementForSelect(filmDao);
        preparedStatement.setInt(1, film.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            assertNull(resultSet.getString(Film.NAME_COLUMN));
        }
    }

    @Test
    public void testGetAll() throws Exception {
        List<Film> expectedList = Arrays.asList(new Film(1, 1, "Die Hard"), new Film(2, 1, "Avengers"),
                new Film(3, 2, "Indiana Jones and the Raiders of the Lost Ark"),
                new Film(4, 2, "Harry Potter and the Philosopher's Stone"), new Film(5, 3, "Groundhog Day"));
        List<Film> actualList = filmDao.getAll();
        assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getId(), actualList.get(i).getId());
            assertEquals(expectedList.get(i).getName(), actualList.get(i).getName());
            assertEquals(expectedList.get(i).getName(), actualList.get(i).getName());
        }
    }

}