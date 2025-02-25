import scala.collection.mutable.ArrayBuffer

// Represents a single bucket in extendible hashing
class Bucket(val size: Int, var localDepth: Int) {
  var keys: ArrayBuffer[Int] = ArrayBuffer()

  def isFull: Boolean = keys.length >= size

  def insert(key: Int): Boolean = {
    if (!isFull) {
      keys.append(key)
      true
    } else {
      false
    }
  }

  def search(key: Int): Boolean = keys.contains(key)

  def split(): (Bucket, ArrayBuffer[Int]) = {
    val newBucket = new Bucket(size, localDepth + 1)
    val oldKeys = keys.clone()  // Copy existing keys
    keys.clear()  // Clear the current bucket
    (newBucket, oldKeys)
  }
}

// Implements extendible hashing with dynamic bucket splitting
class ExtendibleHashing(val bucketSize: Int) {
  var globalDepth: Int = 1
  var directory: ArrayBuffer[Bucket] = ArrayBuffer.fill(2)(new Bucket(bucketSize, globalDepth))

  def getIndex(key: Int): Int = key % (1 << globalDepth)  // Get index using bitwise shift

  def insert(key: Int): Unit = {
    val index = getIndex(key)
    val bucket = directory(index)

    if (bucket.insert(key)) {
      println(s"Inserted $key in bucket $index.")
      return
    }

    // If the bucket is full, split it
    println(s"Bucket $index full, splitting...")
    val (newBucket, oldKeys) = bucket.split()
    bucket.localDepth += 1

    // If local depth exceeds global depth, expand the directory
    if (bucket.localDepth > globalDepth) {
      globalDepth += 1
      directory = directory ++ directory  // Duplicate directory pointers
    }

    // Redistribute keys
    directory(index) = bucket
    val newIndex = index + (1 << (bucket.localDepth - 1))
    directory(newIndex) = newBucket

    for (k <- oldKeys :+ key) {
      insert(k)
    }
  }

  def search(key: Int): Boolean = {
    val index = getIndex(key)
    directory(index).search(key)
  }

  def display(): Unit = {
    println("\n--- Extendible Hashing Directory ---")
    for ((bucket, i) <- directory.zipWithIndex) {
      println(s"Index $i (Depth ${bucket.localDepth}): ${bucket.keys.mkString(", ")}")
    }
  }
}

// Example Usage
object ExtendibleHashingTest extends App {
  val hashTable = new ExtendibleHashing(bucketSize = 2)
  val keysToInsert = Seq(5, 12, 15, 8, 25, 30)

  keysToInsert.foreach(hashTable.insert)

  hashTable.display()

  // Search for a key
  val keyToSearch = 12
  println(s"\nKey $keyToSearch found? ${hashTable.search(keyToSearch)}")
}
