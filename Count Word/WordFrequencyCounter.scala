object WordFrequencyCounter extends App {
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

}
