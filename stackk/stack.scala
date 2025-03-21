object BalancedParentheses {
    def isBalanced(s: String): Boolean = {
        val mapping = Map(')' -> '(', '}' -> '{', ']' -> '[') // Closing to opening map

        val resultStack = s.foldLeft(List.empty[Char]) { (stack, char) =>
            if (mapping.values.toSet.contains(char)) char :: stack // Push opening brackets
            else if (mapping.contains(char)) { // If it's a closing bracket
                stack match {
                    case head :: tail if head == mapping(char) => tail // Pop matching bracket
                    case _ => return false // Mismatch or empty stack
                }
            } else stack
        }

        resultStack.isEmpty // If stack is empty, it's balanced
    }

    def main(args: Array[String]): Unit = {
        val s1 = "{([])}"
        println(isBalanced(s1)) // ✅ True

        val s2 = "{[(])}"
        println(isBalanced(s2)) // ❌ False

        val s3 = "[{()}]"
        println(isBalanced(s3)) // ✅ True

        val s4 = "((())"
        println(isBalanced(s4)) // ❌ False
    }
}
