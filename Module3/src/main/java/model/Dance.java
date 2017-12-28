package model;

import model.enums.Music;
import model.enums.NumberOfDancers;
import model.enums.Scene;
import model.enums.Type;

import java.util.List;

/**
 * @author Alex Volochai
 */
public class Dance {

    public static final String LIST_CLASS_TAG = "dances";
    public static final String CLASS_TAG = "dance";
    public static final String ID_FIELD_TAG = "id";
    public static final String TYPE_FIELD_TAG = "type";
    public static final String SCENE_FIELD_TAG = "scene";
    public static final String NUMBER_OF_DANCERS_FIELD_TAG = "number_of_dancers";
    public static final String MUSIC_FIELD_TAG = "music";
    public static final String ORDER_FIELD_TAG = "order";
    public static final String DANCERS_FIELD_TAG = Dancer.LIST_CLASS_TAG;

    private int id;
    private Type type;
    private Scene scene;
    private NumberOfDancers numberOfDancers;
    private Music music;
    private int order;
    private List<Dancer> dancers;

    public Dance() {
    }

    public Dance(int id, Type type, Scene scene, NumberOfDancers numberOfDancers, Music music, int order, List<Dancer> dancers) {
        this.id = id;
        this.type = type;
        this.scene = scene;
        this.numberOfDancers = numberOfDancers;
        this.music = music;
        this.order = order;
        this.dancers = dancers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public NumberOfDancers getNumberOfDancers() {
        return numberOfDancers;
    }

    public void setNumberOfDancers(NumberOfDancers numberOfDancers) {
        this.numberOfDancers = numberOfDancers;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Dancer> getDancers() {
        return dancers;
    }

    public void setDancers(List<Dancer> dancers) {
        this.dancers = dancers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dance dance = (Dance) o;

        if (id != dance.id) return false;
        if (order != dance.order) return false;
        if (type != dance.type) return false;
        if (scene != dance.scene) return false;
        if (numberOfDancers != dance.numberOfDancers) return false;
        if (music != dance.music) return false;
        return dancers.equals(dance.dancers);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        result = 31 * result + scene.hashCode();
        result = 31 * result + numberOfDancers.hashCode();
        result = 31 * result + music.hashCode();
        result = 31 * result + order;
        result = 31 * result + dancers.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dance{" +
                "id=" + id +
                ", type=" + type +
                ", scene=" + scene +
                ", numberOfDancers=" + numberOfDancers +
                ", music=" + music +
                ", order=" + order +
                ", dancers=" + dancers +
                '}';
    }

}
