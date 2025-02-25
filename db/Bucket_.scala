import scala.collection.mutable.ArrayBuffer

// Define a simple Bucket class for the example
class Bucket(val size: Int, var localDepth: Int) {
  override def toString: String = s"Bucket(size=$size, localDepth=$localDepth)"
}

// Initialize the directory with 2 buckets
val bucketSize = 2
val globalDepth = 1
var directory: ArrayBuffer[Bucket] = ArrayBuffer.fill(2)(new Bucket(bucketSize, globalDepth))

object x extends App{
// Print the directory structure
print("Initial Directory Structure:", ArrayBuffer.fill(2))
for ((bucket, index) <- directory.zipWithIndex) {
  println(s"Index $index: $bucket")
}
}