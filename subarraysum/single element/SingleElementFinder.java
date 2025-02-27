import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleElementFinder {
    public static void main(String[] args) {
        int[] arr = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};

        int singleElement = Arrays.stream(arr)
                .boxed() // Convert int to Integer
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Find the element that occurs once
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No unique element found"));

        System.out.println("The element with single occurrence is " + singleElement);
   
   
   
        final int INT_SIZE = 32;
        
         Arrays.stream(new int[INT_SIZE]) // Create an array of 32 bits (all 0s)
                .map(i -> {
                    int sum = Arrays.stream(arr) // Stream over input array
                            .map(num -> (num >> i) & 1) // Extract ith bit from each number
                            .sum(); // Count occurrences of 1s in this bit position
                    return (sum % 3) != 0 ? 1 << i : 0; // If not multiple of 3, set bit
                })
                .reduce(0, (a, b) ->{ 
                    int result = a | b;
                    System.out.println("Merging bits: " + a + " | " + b + " = " + result);
                    return result;
                }
                );
    }
}
