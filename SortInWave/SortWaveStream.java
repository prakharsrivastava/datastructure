import java.util.Arrays;
import java.util.stream.IntStream;

public class SortWaveStream {
    // A utility method to swap two elements in an array
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // This function sorts arr[0..n-1] in wave form using Streams
    private static void sortInWave(int[] arr) {
        IntStream.range(0, arr.length / 2)
                 .filter(i -> i %2==0)
                 .forEach(i -> {
                     if (i > 0 && arr[i - 1] > arr[i]) swap(arr, i, i - 1);
                     if (i < arr.length - 1 && arr[i + 1] > arr[i]) swap(arr, i, i + 1);
                 });
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[] arr = {10, 90, 49, 2, 1, 5, 23};
        sortInWave(arr);
        System.out.println(Arrays.toString(arr));
       //IntStream.range(0, arr.length).forEach(i->System.out.println(i));
    }
}
