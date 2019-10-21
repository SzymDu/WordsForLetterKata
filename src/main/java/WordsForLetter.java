import java.util.*;
import java.util.stream.Collectors;

public class WordsForLetter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, List<String>> solution = new HashMap<>();
        List<Character> keys = getKeys(input);
        String[] splicedWords = splitInputIntoWords(input);
        printResult(createWordsListForKey(solution, keys, splicedWords));
    }

    private static void printResult(Map<Character, List<String>> result) {
        result.forEach((key, value) -> System.out.println(
                key + ":" + value));
    }

    private static Map<Character, List<String>> createWordsListForKey(Map<Character, List<String>> solution, List<Character> keys, String[] splicedWords) {
        keys.forEach(key -> {
            List<String> words = new ArrayList<>();
            for (String str : splicedWords) {
                if (str.indexOf(key) != -1 && !words.contains(str)) {
                    words.add(str);
                    words.sort(String::compareTo);
                }
            }
            solution.put(key, words);
        });
        return solution;
    }

    private static String[] splitInputIntoWords(String input) {
        String inputWithoutSpecialCharacters = input.replaceAll("[,;.]", "");
        return inputWithoutSpecialCharacters.split(" ");
    }

    private static List<Character> getKeys(String input) {
        return input.chars()
                .filter(Character::isLetter)
                .distinct()
                .mapToObj(intToChar -> (char) intToChar)
                .collect(Collectors.toList());
    }

}

