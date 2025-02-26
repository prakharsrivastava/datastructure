object MajorityElement {
  def majorityElement(arr: Array[Int]): Int = {
    // Step 1: Find the candidate using Boyer-Moore Voting Algorithm
    val (candidate, _) = arr.foldLeft((-1, 0)) { case ((cand, count), num) =>
      if (count == 0) (num, 1)
      else if (num == cand) (cand, count + 1)
      else (cand, count - 1)
    }

    // Step 2: Validate the candidate
    if (arr.count(_ == candidate) > arr.length / 2) candidate else -1
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 1, 2, 1, 3, 5, 1)
    println(majorityElement(arr))  // Output: 1
  }
}
