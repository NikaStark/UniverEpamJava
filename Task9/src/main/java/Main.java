import dao.FilmDao;
import dao.GenreDao;
import dao.impl.FilmDaoImpl;
import dao.impl.GenreDaoImpl;
import entities.Film;
import entities.Genre;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Alex Volochai
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Genre genre = new Genre();
        genre.setName("comedy");
        Film film = new Film();
        film.setGenre(1);
        film.setName("Pretty Woman");

        Properties properties = new Properties();
        properties.load(new FileReader(new File("Task10/src/main/resources/db.properties")));
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);

        GenreDao genreDao = new GenreDaoImpl(connection);
        genreDao.create(genre);
        FilmDao filmDao = new FilmDaoImpl(connection);
        filmDao.create(film);

        film.setName("American Made");
        genre.setName("horror");
        filmDao.update(film);
        genreDao.update(genre);

        System.out.println(genreDao.getByPK(genre.getId()));
        System.out.println(filmDao.getByPK(film.getId()));

        filmDao.delete(film);
        genreDao.delete(genre);

        connection.close();
    }

}
