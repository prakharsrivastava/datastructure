from functools import reduce

def find_subarray(arr, target):
    prefix_sum_map = {}
    
    def check_subarray(acc, i):
        prefix_sum_map, current_sum  = acc
        new_sum = current_sum + arr[i]
        
        if new_sum == target:
            print("Sum found between indexes 0 to ",i)
            exit()
        
        if (new_sum - target) in prefix_sum_map:
            print("Sum found from indexes", prefix_sum_map[new_sum - target] + 1 , i)
            exit()
        
        prefix_sum_map[new_sum] = i
        return  prefix_sum_map,new_sum
    
    reduce(check_subarray, range(len(arr)), (prefix_sum_map,0))

arr = [2, 12, -2, -20, 10, 0]
target = -10
find_subarray(arr, target)