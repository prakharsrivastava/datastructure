
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "Java is awesome! Java streams are powerful. Streams make Java awesome.";
        String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        // Count the frequency of each word (case-insensitive)
        Map<String, Long> wordCounts = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        // Display the most frequent words and their frequencies
        wordCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Sort by frequency (desc)
                .limit(10) // Change the limit as needed
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
