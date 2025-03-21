from functools import reduce

def is_balanced(s):
    mapping = {')': '(', '}': '{', ']': '['}  # Closing to opening map
    
    # Reduce acts like foldLeft, processing each character
    result_stack = reduce(
        lambda stack, char: (
            stack[:-1] if stack and stack[-1] == mapping.get(char, None)  # Pop if matching bracket
            else stack + [char]  # Push if opening bracket
        ),
        s,
        []
    )

    return not result_stack  # True if stack is empty

# Example Usage
print(is_balanced("{([])}"))  # ✅ True
print(is_balanced("{[(])}"))  # ❌ False
print(is_balanced("[{()}]"))  # ✅ True
print(is_balanced("((())"))   # ❌ False
