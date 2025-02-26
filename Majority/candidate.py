from functools import reduce

def majority_element(arr):
    candidate, count = reduce(lambda acc, num: (num, 1)
                              if acc[1] == 0 else (acc[0], acc[1] + 1)
                              if acc[0] == num else (acc[0], acc[1] - 1),
                              arr, (-1, 0))

    # Validate the candidate
    return candidate if arr.count(candidate) > len(arr) // 2 else -1

arr = [1, 1, 2, 1, 3, 5, 1]
print(majority_element(arr))  # Output: 1


from functools import reduce

def update_candidate(acc, num):
    candidate, count = acc
    if count == 0:
        return (num, 1)
    elif num == candidate:
        return (candidate, count + 1)
    else:
        return (candidate, count - 1)

arr = [1, 1, 2, 1, 3, 5, 1]
candidate, count = reduce(update_candidate, arr, (-1, 0))

print(candidate, count)  # Output: (1, final count)
