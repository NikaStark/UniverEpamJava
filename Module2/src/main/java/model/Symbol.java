package model;

/**
 * @author Alex Volochai
 */
public class Symbol {

    private final char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol + "";
    }
}
