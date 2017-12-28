package model;

/**
 * @author Alex Volochai
 */
public class Sentence {

    private final String sentence;

    public Sentence(String sentence){
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    @Override
    public String toString() {
        return sentence;
    }

}
