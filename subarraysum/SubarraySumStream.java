import java.util.HashMap;
import java.util.Map;

public class SubarraySumStream {

    public static void findSubarray(int[] arr, int target) {
           Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int[] sum = {0}; // Use array to hold sum for mutation within lambda
        Arrays.stream(arr).forEach(x -> {sum[0] += x; if (sum[0] == target || prefixSumMap.containsKey(sum[0] - target)) System.out.println("Sum found"); else prefixSumMap.put(sum[0], 0);});

    }

    public static void main(String[] args) {
        int[] arr = {2, 12, -2, -20, 10, 0};
        int target = -10;
        findSubarray(arr, target);
    }
}
