/* 
|Index (i) | Current Element | Cumulative Sum (curr_sum) | Check curr_sum(running total) - Sum Exists? | HashMap (Prefix Sums)               | Subarray Found? |
----------------------------------------------------------------------------------------------------------------------------
|0         | 2               | 2                         | 2 - (-10) = 12 (❌ No)        | {2: 0}                              | ❌ No           |
|1         | 12              | 14                        | 14 - (-10) = 24 (❌ No)       | {2: 0, 14: 1}                       | ❌ No           |
|2         | -2              | 12                        | 12 - (-10) = 22 (❌ No)       | {2: 0, 14: 1, 12: 2}                | ❌ No           |
|3         | -20             | -8                        | -8 - (-10) = 2 (✅ Yes!)      | {2: 0, 14: 1, 12: 2, -8: 3}         | ✅ Yes!         |
|4         | 10              | 2                         | 2 - (-10) = 12 (❌ No)        | {2: 0, 14: 1, 12: 2, -8: 3, 2: 4}   | ❌ No           |

 */import scala.collection.mutable

object SubArraySum extends App {
  val arr = Array(2, 12, -2, -20, 10, 0)
  val target = -10

  def findSubarray(arr: Array[Int], target: Int): Unit = {
    arr.indices.foldLeft((0, mutable.Map[Int, Int]())) {
      case ((current, prefixSumMap), i) =>
        val newSum = current + arr(i)

        if (newSum == target) {
          println(s"Sum found between indexes 0 to $i")
          System.exit(0)
        }

        prefixSumMap.get(newSum - target).foreach { startIdx =>
          println(s"Sum found from indexes ${startIdx + 1} to $i")
          System.exit(0)
        }

        prefixSumMap(newSum) = i // Store the prefix sum and index
        (newSum, prefixSumMap)
    }
  }

  findSubarray(arr, target)
}
