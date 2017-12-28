package entities;

/**
 * @author Alex Volochai
 */
public class Film implements Identified<Integer> {

    public static final String TABLE_NAME = "films";
    public static final String ID_COLUMN = "id";
    public static final String GENRE_COLUMN = "id_genre";
    public static final String NAME_COLUMN = "name";

    private Integer id;
    private Integer genre;
    private String name;

    public Film() {
    }

    public Film(Integer id, Integer genre, String name) {
        this.id = id;
        this.genre = genre;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (!id.equals(film.id)) return false;
        if (!genre.equals(film.genre)) return false;
        return name.equals(film.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", genre=" + genre +
                ", name='" + name + '\'' +
                '}';
    }

}
