package controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParsePostTest {

    private static final double delta = 0.001;

    @Test
    public void testDoParse() throws Exception {
        String infixInput = "345+*612+/-";
        ParsePost parsePost = new ParsePost(infixInput);
        double expectedResult = 25;

        double actualResult = parsePost.doParse();

        assertEquals(expectedResult,actualResult, delta);
    }

    @Test
    public void testDoParseWithSin() throws Exception {
        String infixInput = "3s";
        ParsePost parsePost = new ParsePost(infixInput);
        double expectedResult = 0.141;

        double actualResult = parsePost.doParse();

        assertEquals(expectedResult,actualResult, delta);
    }

    @Test
    public void testDoParseWithCos() throws Exception {
        String infixInput = "3c";
        ParsePost parsePost = new ParsePost(infixInput);
        double expectedResult = -0.989;

        double actualResult = parsePost.doParse();

        assertEquals(expectedResult,actualResult, delta);
    }
}