object x extends App {
  val content = "Scala is awesome! Scala streams are powerful. Streams make Scala awesome."
  
  val wordCounts = content.toLowerCase
    .replaceAll("[^a-zA-Z\\s]", "") // Remove punctuation
    .split("\\s+") // Split by spaces
    .groupBy(identity) // Group by word
    .mapValues(_.length) // Count occurrences

  // Display the most frequent words and their frequencies
  wordCounts.toSeq
    .sortBy(-_._2) // Sort by frequency (descending order)
    .take(10) // Limit to top 10
    .foreach { case (word, count) => println(s"$word -> $count") }

    val (candidate, _) = arr.foldLeft((-1, 0)) { case ((cand, count), num) =>
      if (count == 0) (num, 1)
      else if (num == cand) (cand, count + 1)
      else (cand, count - 1)
    }
 arr.tail.foldLeft((arr(0), arr(0))) { case ((res, maxEnding), num) =>
    val newMaxEnding = Math.max(maxEnding + num, num) // Local max
    val newRes = Math.max(res, newMaxEnding)         // Global max
    (newRes, newMaxEnding)
  }._1

      arr.indices.foldLeft((0, mutable.Map[Int, Int]())) {
      case ((current, prefixSumMap), i) =>
        val newSum = current + arr(i)

        if (newSum == target) {
          println(s"Sum found between indexes 0 to $i")
          System.exit(0)
        }
        prefixSumMap.get(newSum == target).f

        prefixSumMap.get(newSum - target).foreach { startIdx =>
          println(s"Sum found from indexes ${startIdx + 1} to $i")
          System.exit(0)
        }

        prefixSumMap(newSum) = i // Store the prefix sum and index
        (newSum, prefixSumMap)
    }
}

}
