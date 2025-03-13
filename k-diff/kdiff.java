import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

class kdiff {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int k = 3;
        int a[] = {1, 2, 3, 4};
        int n = a.length;
        System.out.println(kthDiff(a, n, k));
    }

    // Returns k-th absolute difference
    static int kthDiff(int a[], int n, int k) {
        // Sort array
        Arrays.sort(a);

        // Minimum and Maximum absolute difference
        int low = Arrays.stream(a).reduce((x, y) -> Math.min(y - x, Integer.MAX_VALUE)).getAsInt();
        int high = a[n - 1] - a[0];

        // Upper bound lambda using binary search
        BiFunction<int[], Integer, Integer> upperbound = (arr, value) -> {
            int pos = Arrays.binarySearch(arr, value);
            return (pos < 0) ? -pos - 1 : pos + 1;
        };

        // Lambda for counting pairs
        BiFunction<int[], Integer, Integer> countPairs = (arr, mid) -> {
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                int ub = upperbound.apply(arr, arr[i] + mid);
                res += (ub - (i + 1));
            }
            return res;
        };

        // Binary search for k-th absolute difference
        while (low < high) {
            int mid = (low + high) >> 1;
            if (countPairs.apply(a, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}
