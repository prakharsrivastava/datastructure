from collections import Counter

arr = [3, 3, 4, 2, 4, 4, 2, 4, 4]

# Using Counter to count occurrences
frequency_map = Counter(arr)

# Finding the most frequent element
most_frequent = max(frequency_map, key=frequency_map.get)

print(most_frequent)
