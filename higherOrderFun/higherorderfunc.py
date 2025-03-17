# Higher-order function: takes a function as an argument
def apply_function(x, func):
    return func(x)

# Example functions
double_it = lambda n: n * 2
square_it = lambda n: n * n

print(apply_function(5, double_it))  # Output: 10
print(apply_function(4, square_it))  # Output: 16
