#Maximum Subarray Sum
def maxSubarraySum(arr):
    res = arr[0]  # Global maximum sum
    maxEnding = arr[0]  # Local maximum subarray sum
    
    print(f"Start: maxEnding = {maxEnding}, res = {res}")

    for i in range(1, len(arr)):
        prev_maxEnding = maxEnding  # Store previous maxEnding for debugging
        
        # Update maxEnding: extend or start new subarray
        maxEnding = max(maxEnding + arr[i], arr[i])

        # Update global maximum
        res = max(res, maxEnding)

        # Print step details
        print(f"Step {i}: arr[{i}] = {arr[i]}, Previous maxEnding = {prev_maxEnding}, New maxEnding = {maxEnding}, Updated res = {res}")

    return res

# Test case
arr = [2, 3, -8, 7, -1, 2, 3]
print("\nMax Subarray Sum:", maxSubarraySum(arr))
