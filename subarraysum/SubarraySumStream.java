import java.util.HashMap;
import java.util.Map;

public class SubarraySumStream {

    public static void findSubarray(int[] arr, int target) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentSum = 0; // Now it's a simple int variable

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == target) {
                System.out.println("Sum found between indexes 0 to " + i);
                return;
            }

            if (prefixSumMap.containsKey(currentSum - target)) {
                System.out.println("Sum found from indexes " + (prefixSumMap.get(currentSum - target) + 1) + " to " + i);
                return;
            }

            prefixSumMap.put(currentSum, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 12, -2, -20, 10, 0};
        int target = -10;
        findSubarray(arr, target);
    }
}
