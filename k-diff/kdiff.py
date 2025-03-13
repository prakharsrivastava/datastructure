from functools import reduce

def upper_bound(arr, n, value):
    """Find the first index where arr[index] > value (Upper Bound)."""
    low, high = 0, n
    while low < high:
        mid = (low + high) // 2
        high = mid if arr[mid] > value else low + 1
    return low

def count_pairs(arr, n, mid):
    """Count number of pairs with absolute difference <= mid using lambda & reduce."""
    return reduce(lambda acc, i: acc + (upper_bound(arr, n, arr[i] + mid) - (i + 1)), range(n), 0)

def kth_diff(arr, k):
    arr.sort()
    
    # Finding the minimum absolute difference using reduce
    low = reduce(lambda acc, i: min(acc, arr[i+1] - arr[i]), range(len(arr)-1), float('inf'))
    high = arr[-1] - arr[0]  # Maximum absolute difference

    # Binary search to find the k-th smallest absolute difference
    while low < high:
        mid = (low + high) // 2
        if count_pairs(arr, len(arr), mid) < k:
            low = mid + 1
        else:
            high = mid

    return low

# Example usage
arr = [1, 2, 3, 4]
k = 3
print(kth_diff(arr, k))  # Output: 2
