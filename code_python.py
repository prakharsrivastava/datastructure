 text = "Python is great. Python is easy. Python is powerful and easy to learn."
  words = text.lower().split()

    # Count the frequency of each word
    word_counts = Counter(words)

    # Display the most frequent words and their frequencies
    for word, count in word_counts.most_common(num_words):
        print(f"{word} -> {count}")



arr = [3, 3, 4, 2, 4, 4, 2, 4, 4]

# Using Counter to count occurrences
frequency_map = Counter(arr)

# Finding the most frequent element
most_frequent = max(frequency_map, key=frequency_map.get)

print(most_frequent)

majority_element(arr):
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



class Rectangle_:
    
    def __init__(self, h:int, w:int):
        self.w=w
        self.h=h

    def getArea(self)->int:
        return self.h * self.w
    



class Square_(Rectangle_):
    
     def __init__(self, s:int):
       super().__init__(s,s)


     def getArea(self)->int : 
        return self.h*self.w
    
 
if __name__ == "__main__":    
    r=Rectangle_(5,8).getArea()
    print(r)    
    s=Square_(5).getArea()
    print(s)    
    


from abc import ABC, abstractmethod

# Define an abstract base class for Shape
class Shape(ABC):

    @abstractmethod
    def get_area(self) -> int:
        pass  # Enforce implementation in subclasses


# Rectangle class inheriting from Shape
class Rectangle(Shape):
    def __init__(self, height: int, width: int):
        self.height = height
        self.width = width

    def get_area(self) -> int:
        return self.height * self.width


# Square class inheriting from Shape
class Square(Shape):
    def __init__(self, side: int):
        self.side = side

    def get_area(self) -> int:
        return self.side * self.side


# Example usage
rect = Rectangle(5, 10)
print("Rectangle Area:", rect.get_area())

sq = Square(4)
print("Square Area:", sq.get_area())

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