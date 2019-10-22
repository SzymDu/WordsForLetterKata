import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsForLetterTest {

    @Test
    void getKeysTestWithString() {
        String testString = "ala ma kota";
        List<Character> expectedOutput = new ArrayList<>();
        expectedOutput.add('a');
        expectedOutput.add('l');
        expectedOutput.add('m');
        expectedOutput.add('k');
        expectedOutput.add('o');
        expectedOutput.add('t');
        assertEquals(expectedOutput, WordsForLetter.getKeys(testString));
    }

    @Test
    void getKeysTestWithEmptyString() {
        String testString = "";
        List<Character> expectedOutput = new ArrayList<>();
        assertEquals(expectedOutput, WordsForLetter.getKeys(testString));
    }

    @Test
    void splitInputIntoWordsWithoutSpecialCharacter() {
        String input = "ala ma kota, bez.";
        String[] expectedOutput = {"ala", "ma", "kota", "bez"};
        assertArrayEquals(expectedOutput, WordsForLetter.splitInputIntoWords(input));
    }

    @Test
    void splitInputIntoWordsWithoutInput() {
        String input = "";
        String[] expectedOutput = {""};
        assertArrayEquals(expectedOutput, WordsForLetter.splitInputIntoWords(input));
    }

    @Test
    void createWordsListForKeyTest() {
        Map<Character, List<String>> expectedOuput = new HashMap<>();
        List<Character> keys = WordsForLetter.getKeys("ala ma kota");
        String[] words = WordsForLetter.splitInputIntoWords("ala ma kota");
        expectedOuput.put('a', Arrays.asList("ala", "kota", "ma"));
        expectedOuput.put('l', Collections.singletonList("ala"));
        expectedOuput.put('m', Collections.singletonList("ma"));
        expectedOuput.put('k', Collections.singletonList("kota"));
        expectedOuput.put('o', Collections.singletonList("kota"));
        expectedOuput.put('t', Collections.singletonList("kota"));
        assertEquals(expectedOuput, WordsForLetter.createWordsListForKey(new HashMap<>(), keys, words));
    }

    @Test
    void createWordsListWordsInOrderTest(){
        Map<Character, List<String>> expectedOuput = new HashMap<>();
        List<Character> keys = WordsForLetter.getKeys("abecd");
        String[] words = WordsForLetter.splitInputIntoWords("a b c d e");
        expectedOuput.put('a', Collections.singletonList("a"));
        expectedOuput.put('b', Collections.singletonList("b"));
        expectedOuput.put('c', Collections.singletonList("c"));
        expectedOuput.put('d', Collections.singletonList("d"));
        expectedOuput.put('e', Collections.singletonList("e"));
        assertEquals(expectedOuput, WordsForLetter.createWordsListForKey(new HashMap<>(), keys, words));
    }

    @Test
    void createWordsListWithoutSameElementTest(){
        Map<Character, List<String>> expectedOuput = new HashMap<>();
        List<Character> keys = WordsForLetter.getKeys("ala ma kota");
        String[] words = WordsForLetter.splitInputIntoWords("ala ma kota, kota ma ala");
        expectedOuput.put('a', Arrays.asList("ala", "kota", "ma"));
        expectedOuput.put('l', Collections.singletonList("ala"));
        expectedOuput.put('m', Collections.singletonList("ma"));
        expectedOuput.put('k', Collections.singletonList("kota"));
        expectedOuput.put('o', Collections.singletonList("kota"));
        expectedOuput.put('t', Collections.singletonList("kota"));
        assertEquals(expectedOuput, WordsForLetter.createWordsListForKey(new HashMap<>(), keys, words));
    }
}