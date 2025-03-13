import scala.io.StdIn
import scala.collection.mutable.ArrayBuffer

object KthAbsoluteDifference {
  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 4)
    val k = 3
    println(kthDiff(a, k))
  }

  // Returns the k-th absolute difference
  def kthDiff(a: Array[Int], k: Int): Int = {
    val sortedA = a.sorted

    // Compute min adjacent difference using foldLeft
    val low = sortedA.sliding(2).map { case Array(x, y) => y - x }.foldLeft(Int.MaxValue)(math.min)
    val high = sortedA.last - sortedA.head

    // Upper bound function using binary search
    def upperBound(arr: Array[Int], value: Int): Int = {
      var low = 0
      var high = arr.length
      while (low < high) {
        val mid = (low + high) / 2
        if (arr(mid) <= value) low = mid + 1
        else high = mid
      }
      low
    }

    // Count pairs with absolute difference ≤ mid
    def countPairs(mid: Int): Int = {
      sortedA.indices.foldLeft(0) { (res, i) =>
        val ub = upperBound(sortedA, sortedA(i) + mid)
        res + (ub - (i + 1))
      }
    }

    // Binary search for k-th absolute difference
    var (l, h) = (low, high)
    while (l < h) {
      val mid = (l + h) / 2
      if (countPairs(mid) < k) l = mid + 1
      else h = mid
    }

    l
  }
}
