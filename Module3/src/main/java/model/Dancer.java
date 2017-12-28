package model;

/**
 * @author Alex Volochai
 */
public class Dancer {

    public static final String LIST_CLASS_TAG = "dancers";
    public static final String CLASS_TAG = "dancer";
    public static final String NAME_FIELD_TAG = "name";
    public static final String AGE_FIELD_TAG = "age";
    public static final String WORKING_AGE_FIELD_TAG = "working_age";

    private String name;
    private int age;
    private int workingAge;

    public Dancer() {
    }

    public Dancer(String name, int age, int workingAge) {
        this.name = name;
        this.age = age;
        this.workingAge = workingAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkingAge() {
        return workingAge;
    }

    public void setWorkingAge(int workingAge) {
        this.workingAge = workingAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dancer dancer = (Dancer) o;

        if (age != dancer.age) return false;
        if (workingAge != dancer.workingAge) return false;
        return name.equals(dancer.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + workingAge;
        return result;
    }

    @Override
    public String toString() {
        return "Dancer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workingAge=" + workingAge +
                '}';
    }

}
