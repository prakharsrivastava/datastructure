import java.util.*;

public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String s, int index, StringBuilder current, List<String> result) {
        // Base case: If we've processed all characters, add the current combination to the result
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        // Get the character at the current index
        char ch = s.charAt(index);

        if (Character.isLetter(ch)) {
            // Try both lowercase and uppercase for letters
            current.append(Character.toLowerCase(ch)); // Add lowercase version
            backtrack(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Remove last character (backtrack)

            current.append(Character.toUpperCase(ch)); // Add uppercase version
            backtrack(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Remove last character (backtrack)
        } else {
            // If it's a digit, just add it
            current.append(ch);
            backtrack(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Remove last character (backtrack)
        }
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
