package model;

public abstract class Figure {

    @Override
    public String toString() {
        return "Figure{" + toStringParameters() + "}";
    }

    /**
     * Outputs this figure in short form(without name class) as a {@code String}.
     *
     * @return a string representation of this year, not null
     */
    protected String toStringParameters() {
        return  "";
    }

}
