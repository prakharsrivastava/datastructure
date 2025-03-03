import java.security.Identity;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// input- stream -  index, ar element ,collect grouping  sorting max - comparingByValue
class code_java{
    public static void main(String[] args) {
        String text = "Java is awesome! Java streams are powerful. Streams make Java awesome.";
        String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\s+");

        Stream<String> s = Arrays.stream(words);

        // Count the frequency of each word (case-insensitive)
        Map<String, Long> wordCounts = Arrays.stream(words)
                .collect(Collectors.groupingBy(i->i ,Collectors.counting()));

        // Display the most frequent words and their frequencies
        wordCounts.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue()) // Sort by frequency (desc)
                        .limit(10) // Change the limit as needed
                        .forEach(System.out::println);


                        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
     
        
        // Finding the most frequent element using Streams
        int mostFrequent = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        System.out.println(mostFrequent);

        int[] result = Arrays.stream(arr).boxed()
        .reduce(new int[]{-1, 0}, 
        (x, num) -> {
            if (x[1] == 0) return new int[]{num, 1};
            if (x[0] == num) return new int[]{acc[0], acc[1] + 1};
            return new int[]{x[0], x[1] - 1};
        }, 
        (a, b) -> a);  // Combiner (not used in sequential streams)

int candidate = result[0];

  IntStream.range(0, arr.length / 2)
                 .filter(i -> i %2==0)
                 .forEach(i -> {
                     if (i > 0 && arr[i - 1] > arr[i]) swap(arr, i, i - 1);
                     if (i < arr.length - 1 && arr[i + 1] > arr[i]) swap(arr, i, i + 1);
                 });

                 final int INT_SIZE = 32;
        
                 Arrays.stream(new int[INT_SIZE]) // Create an array of 32 bits (all 0s)
                        .map(i -> {
                            int sum = Arrays.stream(arr) // Stream over input array
                                    .map(num -> (num >> i) & 1) // Extract ith bit from each number
                                    .sum(); // Count occurrences of 1s in this bit position
                            return (sum % 3) != 0 ? 1 << i : 0; // If not multiple of 3, set bit
                        })
                        .reduce(0, (a, b) ->{ 
                            int result = a | b
                            System.out.println("Merging bits: " + a + " | " + b + " = " + result);
                            return result;
                        },(a,b->a)
                        );

    }
}