package task3.entities;

import java.util.Random;

/**
 * @author Alex Volochai
 */
public class Monk {

    static String[] monks = {"In'", "Yan'"};

    private static int id;

    private String name;

    private String village;

    private int energy;

    public Monk() {
        id++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public static Monk create() {
        Random r = new Random();
        Monk monk = new Monk();
        monk.setName("Monk #" + monk.getId());
        monk.setVillage(monks[r.nextInt(2)]);
        monk.setEnergy(r.nextInt(100));
        return monk;
    }

    @Override
    public String toString() {
        return "Monk{" +
                "name='" + name + '\'' +
                ", village='" + village + '\'' +
                ", energy=" + energy +
                '}';
    }
}
