
from functools import reduce
def sortInWave(acc, i):

    # Traverse all even elements
        arr=acc
        # If current even element is smaller than previous
        if (i > 0 and arr[i] < arr[i-1]):
            arr[i], arr[i-1] = arr[i-1], arr[i]

        # If current even element is smaller than next
        if (i < len(arr)-1 and arr[i] < arr[i+1]):
            arr[i], arr[i+1] = arr[i+1], arr[i]

        return arr

arr = [10, 90, 49, 2, 1, 5, 23]
reduce(sortInWave,range(0,len(arr),2),arr)
for i in range(0, len(arr)):
    print(arr[i])