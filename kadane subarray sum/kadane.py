from functools import reduce

def max_subarray_sum(arr):
    # Using reduce to process the array iteratively
    res, max_ending = reduce(
        lambda acc, num: (
            max(acc[0], max(acc[1] + num, num)),  # Update global max
            max(acc[1] + num, num)               # Update local max
        ),
        arr[1:],  # Start from second element, as first is pre-initialized
        (arr[0], arr[0])  # Initial values: (global max, local max)
    )
    return res

# Test case
arr = [2, 3, -8, 7, -1, 2, 3]
print("Max Subarray Sum:", max_subarray_sum(arr))
