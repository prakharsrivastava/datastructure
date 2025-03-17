object HigherOrderFunctionExample {
  // Higher-order function: takes a function as a parameter
  def applyFunction(x: Int, func: Int => Int): Int = {
    func(x)
  }

  def main(args: Array[String]): Unit = {
    val doubleIt = (n: Int) => n * 2
    val squareIt = (n: Int) => n * n

    println(applyFunction(5, doubleIt)) // Output: 10
    println(applyFunction(4, squareIt)) // Output: 16
  }
}
