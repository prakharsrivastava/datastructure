import java.util.Arrays;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};

        int maxSum = maxSubarraySum(arr);
        System.out.println("Max Subarray Sum: " + maxSum);
    }

    public static int maxSubarraySum(int[] arr) {
        int[] maxEnding = {arr[0]};
        
        return Arrays.stream(arr, 1, arr.length)
                     .reduce(arr[0], (res, num) -> {
                         maxEnding[0] = Math.max(maxEnding[0] + num, num);
                         return Math.max(res, maxEnding[0]);
                     });
    }
}
