package controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Volochai
 */
public class TextControllerTest {

    @Test
    public void testFindMaxPalindrome() throws Exception {
        String inputString1 = "abba1";
        String inputString2 = " abba1";
        String inputString3 = " abba";
        String inputString4 = "ab1ba";
        String inputString5 = "ab1ba1";
        String inputString6 = " ab1ba1";

        String expectedString1 = "abba";
        String expectedString2 = "ab1ba";

        String actualString1 = TextController.findMaxPalindrome(inputString1);
        String actualString2 = TextController.findMaxPalindrome(inputString2);
        String actualString3 = TextController.findMaxPalindrome(inputString3);
        String actualString4 = TextController.findMaxPalindrome(inputString4);
        String actualString5 = TextController.findMaxPalindrome(inputString5);
        String actualString6 = TextController.findMaxPalindrome(inputString6);

        assertEquals(expectedString1, actualString1);
        assertEquals(expectedString1, actualString2);
        assertEquals(expectedString1, actualString3);
        assertEquals(expectedString2, actualString4);
        assertEquals(expectedString2, actualString5);
        assertEquals(expectedString2, actualString6);
    }
}