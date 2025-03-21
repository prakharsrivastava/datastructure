import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BalancedParentheses {
    public static boolean isBalanced(String s) {
        Map<Character, Character> mapping = Map.of(')', '(', '}', '{', ']', '[');

        // Stream-based reduce() to mimic foldLeft
        String resultStack = s.chars()
                .mapToObj(c -> (char) c) // Convert int to Character
                .reduce("", (stack, ch) -> {
                    if (mapping.containsKey(ch)) { // If it's a closing bracket
                        return (!stack.isEmpty() && stack.charAt(stack.length() - 1) == mapping.get(ch)) 
                               ? stack.substring(0, stack.length() - 1) // Pop last if matching
                               : stack + ch; // Otherwise, add it
                    } else {
                        return stack + ch; // Push opening bracket
                    }
                }, (s1, s2) -> s1); // No need for combiner

        return resultStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{([])}")); // ✅ True
        System.out.println(isBalanced("{[(])}")); // ❌ False
        System.out.println(isBalanced("[{()}]")); // ✅ True
        System.out.println(isBalanced("((())"));  // ❌ False
    }
}
