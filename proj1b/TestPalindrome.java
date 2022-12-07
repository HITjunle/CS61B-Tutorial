import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");

        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /*Uncomment this class once you've created your Palindrome class. */

    @Test
    public void TestPalindrome(){
        CharacterComparator cc = new OffByOne();
        String word = "racecar";
        String word1 = "flake";
        assertTrue(palindrome.isPalindrome(word));
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome(word1,cc));
    }
}
