package dao.impl;


import dao.AbstractJDBCDaoTest;
import entities.Genre;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class GenreDaoImplTest extends AbstractJDBCDaoTest {

    private final GenreDaoImpl genreDao = new GenreDaoImpl(connection);

    @Test
    public void testCreate() throws Exception {
        final Genre genre = new Genre(null, "historical");
        genreDao.create(genre);
        assertNotNull(genre.getId());
        PreparedStatement preparedStatement = super.preparedStatementForSelect(genreDao);
        preparedStatement.setInt(1, genre.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            assertEquals("historical", resultSet.getString(Genre.NAME_COLUMN));
        }
    }

    @Test
    public void testGetByPK() throws Exception {
        final Genre genre = genreDao.getByPK(2);
        assertNotNull(genre);
        assertEquals("adventure", genre.getName());

        final Genre genreEmpty = new Genre(99999, "shit");
        assertNull(genreDao.getByPK(genreEmpty.getId()));
    }

    @Test
    public void testUpdate() throws Exception {
        final Genre genre = new Genre(3, "historical");
        genreDao.update(genre);
        PreparedStatement preparedStatement = super.preparedStatementForSelect(genreDao);
        preparedStatement.setInt(1, genre.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            assertEquals("historical", resultSet.getString(Genre.NAME_COLUMN));
        }
    }

    @Test
    public void testDelete() throws Exception {
        final Genre genre = new Genre(4, "crime");
        genreDao.delete(genre);
        PreparedStatement preparedStatement = super.preparedStatementForSelect(genreDao);
        preparedStatement.setInt(1, genre.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            assertNull(resultSet.getString(Genre.NAME_COLUMN));
        }
    }

    @Test
    public void testGetAll() throws Exception {
        List<Genre> expectedList = Arrays.asList(new Genre(1, "action"), new Genre(2, "adventure"),
                new Genre(3, "comedy"), new Genre(4, "crime"), new Genre(5, "drama"));
        List<Genre> actualList = genreDao.getAll();
        assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i).getId(), actualList.get(i).getId());
            assertEquals(expectedList.get(i).getName(), actualList.get(i).getName());
        }
    }

}