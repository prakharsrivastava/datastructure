def sasPy(arr, target):
    current = 0
    found = False
    prefixSumMap = {}

    for i in range(len(arr)):
        current += arr[i]

        # Case 1: Subarray starts from index 0
        if current == target:
            print("Sum found between indexes 0 to", i)
            found = True
            break  # Exit since we found a solution

        # Case 2: Check if a subarray sum exists
        if (current - target) in prefixSumMap:
            print("Sum found between indexes",
            prefixSumMap[current - target] + 1, "to", i) 
            found = True
            break

        # Store current sum and index in the dictionary
        prefixSumMap[current] = i

    if not found:
        print("No subarray with given sum exists")

# Test case
arr = [2, 12, -2, -20, 10]
sasPy(arr, -10)
