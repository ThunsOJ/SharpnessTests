package problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckTest {

    AnagramCheck anagramCheck = new AnagramCheck();

    @Test
    void checkIfAnagram() {
        String s1 = "MarY";
        String s2 = "ArMY";
        String s3 = "MaSY";
        String s4 = "APSPDO";

        assertTrue(anagramCheck.isAnagram(s1,s2));
        assertFalse(anagramCheck.isAnagram(s1,s3));
        assertFalse(anagramCheck.isAnagram(s4,s3));

    }
}