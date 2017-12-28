package controller;

/**
 * Class for finding in strings palindromes
 *
 * @author Alex Volochai
 */
public class TextController {

    public static String findMaxPalindrome(String srcString) {
        String maxPalindromeSubString = "", pairedSubStringPalindrome, nonPairedSubStringPalindrome;
        for (int i = 1; i < srcString.length() - 1; i++) {
            pairedSubStringPalindrome = pairedSubStringPalindrome(srcString, i);
            nonPairedSubStringPalindrome = nonPairedSubStringPalindrome(srcString, i);
            if (pairedSubStringPalindrome.length() > maxPalindromeSubString.length() ||
                    nonPairedSubStringPalindrome.length() > maxPalindromeSubString.length()) {
                maxPalindromeSubString = pairedSubStringPalindrome.length() > nonPairedSubStringPalindrome.length() ?
                        pairedSubStringPalindrome : nonPairedSubStringPalindrome;
            }
        }
        return "".equals(maxPalindromeSubString) ? "Not found palindromes" : maxPalindromeSubString;
    }

    private static String pairedSubStringPalindrome(String srcString, int pointer) {
        String subString = "";
        for (int i = 0; i <= (pointer <= srcString.length() / 2 ? pointer : srcString.length() - pointer); i++) {
            if (pointer - i < 0 || pointer + i + 1 > srcString.length() - 1) break;
            if (srcString.charAt(pointer - i) == srcString.charAt(pointer + i + 1)) {
                subString = srcString.substring(pointer - i, pointer + i + 1 + 1);
            } else {
                break;
            }
        }
        return subString;
    }

    private static String nonPairedSubStringPalindrome(String srcString, int pointer) {
        String subString = "";
        for (int i = 0; i < (pointer <= srcString.length() / 2 ? pointer : srcString.length() - pointer); i++) {
            if (pointer - i - 1 < 0 || pointer + i + 1 > srcString.length() - 1) break;
            if (srcString.charAt(pointer - i - 1) == srcString.charAt(pointer + i + 1)) {
                subString = srcString.substring(pointer - i - 1, pointer + i + 1 + 1);
            } else {
                break;
            }
        }
        return subString;
    }

}
