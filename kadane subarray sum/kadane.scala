object kadanes extends App{
def maxSubarraySum(arr: Array[Int]): Int = {
  arr.tail.foldLeft((arr(0), arr(0))) { case ((res, maxEnding), num) =>
    val newMaxEnding = Math.max(maxEnding + num, num) // Local max
    val newRes = Math.max(res, newMaxEnding)         // Global max
    (newRes, newMaxEnding)
  }._1
}

// Test case
val arr = Array(2, 3, -8, 7, -1, 2, 3)
println("Max Subarray Sum: " + maxSubarraySum(arr))
}