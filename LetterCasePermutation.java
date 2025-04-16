import java.util.*;

public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        result.add(""); // Start with an empty string

        for (char ch : s.toCharArray()) {
            List<String> temp = new ArrayList<>();

            for (String str : result) {
                if (Character.isLetter(ch)) {
                    temp.add(str + Character.toLowerCase(ch)); // Lowercase branch
                    temp.add(str + Character.toUpperCase(ch)); // Uppercase branch
                } else {
                    temp.add(str + ch); // Digit, just append
                }
            }

            result = temp; // Update result to the new list for next round
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "a1b";
        List<String> output = letterCasePermutation(input);
        System.out.println("Permutations:");
        for (String str : output) {
            System.out.println(str);
        }
    }
}
