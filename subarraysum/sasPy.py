def find_subarray(arr, target):
    prefix_sum, prefix_map = 0, {0: -1}  # Store {prefix_sum: index}
    
    for i, num in enumerate(arr):
        prefix_sum += num
        
        if prefix_sum - target in prefix_map:
            print(f"Sum found from indexes {prefix_map[prefix_sum - target] + 1} to {i}")
            return
        
        prefix_map[prefix_sum] = i  # Store prefix sum
        
    print("No subarray found")

# Example usage
arr = [2, 12, -2, -20, 10, 0]
target = -10
find_subarray(arr, target)
