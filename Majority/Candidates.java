import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Candidates {
    public static int majorityElement(int[] arr) {
        // Step 1: Find the candidate using Boyer-Moore Voting Algorithm with Streams
        int[] result = Arrays.stream(arr).boxed()
                .reduce(new int[]{-1, 0}, (acc, num) -> {
                    if (acc[1] == 0) return new int[]{num, 1};
                    if (acc[0] == num) return new int[]{acc[0], acc[1] + 1};
                    return new int[]{acc[0], acc[1] - 1};
                }, (a, b) -> a);  // Combiner (not used in sequential streams)

        int candidate = result[0];

        // Step 2: Validate the candidate
        long count = Arrays.stream(arr).filter(n -> n == candidate).count();
        return count > arr.length / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 3, 5, 1};
        System.out.println(majorityElement(arr));  // Output: 1
    }
}
