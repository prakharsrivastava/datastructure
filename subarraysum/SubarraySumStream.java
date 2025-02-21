import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SubarraySumStream {
    static class Accumulator {
        Map<Integer, Integer> prefixSumMap;
        int currentSum;

        Accumulator() {
            this.prefixSumMap = new HashMap<>();
            this.currentSum = 0;
        }
    }

    public static void findSubarray(int[] arr, int target) {
        Accumulator acc = new Accumulator();

        IntStream.range(0, arr.length).forEach(i -> {
            acc.currentSum += arr[i];

            if (acc.currentSum == target) {
                System.out.println("Sum found between indexes 0 to " + i);
                System.exit(0);
            }

            if (acc.prefixSumMap.containsKey(acc.currentSum - target)) {
                System.out.println("Sum found from indexes " + (acc.prefixSumMap.get(acc.currentSum - target) + 1) + " to " + i);
                System.exit(0);
            }

            acc.prefixSumMap.put(acc.currentSum, i);
        });
    }

    public static void main(String[] args) {
        int[] arr = {2, 12, -2, -20, 10, 0};
        int target = -10;
        findSubarray(arr, target);
    }
}
