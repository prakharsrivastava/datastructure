// Java program to implement
// the above approach
import java.util.*;
class Appear{

// Function to+ find the upper_bound of
// an array element
static int upperBound(int arr[], int N, int K)
{

	// Stores minimum index
	// in which K lies
	int l = 0;

	// Stores maximum index
	// in which K lies
	int r = N;

	// Calculate the upper
	// bound of K
	while (l < r)
	{

		// Stores mid element
		// of l and r
		int mid = (l + r) / 2;

		// If arr[mid] is less
		// than or equal to K
		if (arr[mid] <= K) 
		{

			// Right subarray
			l = mid + 1;
		}

		else
		{

			// Left subarray
			r = mid;
		}
	}
	return l;
}

// Function to print all array elements
// whose frequency is greater than N / K
static void NDivKWithFreq(int arr[], int N, int K)
{

	// Sort the array arr[]
	Arrays.sort(arr);

	// Stores index of
	// an array element
	int i = 0;

	// Traverse the array
	while (i < N) 
	{

		// Stores upper bound of arr[i]
		int X = upperBound(arr, N, arr[i]);

		// If frequency of arr[i] is
		// greater than N / 4
		if ((X - i) > N / 4)
		{

			System.out.print(arr[i] + " ");
		}

		// Update i
		i = X;
	}
}

// Driver Code
public static void main(String[] args)
{
	// Given array arr[]
	int arr[] = { 1, 2, 2, 6, 6, 6, 6, 7, 10 };

	// Size of array
	int N = arr.length;
	int K = 4;

	// Function Call
	NDivKWithFreq(arr, N, K);
}
}

// This code is contributed by shikhasingrajput
/*
 * import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class AppearStream {

    // Function to print elements whose frequency is greater than N / K
    static void NDivKWithFreq(int[] arr, int K) {
        int N = arr.length;

        // Count occurrences using groupingBy & Collectors.counting()
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print elements with frequency > N/K
        freqMap.entrySet().stream()
                .filter(entry -> entry.getValue() > N / K)
                .map(Map.Entry::getKey)
                .forEach(System.out::print);
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int K = 4;

        // Function Call
        NDivKWithFreq(arr, K);
    }
}

 */