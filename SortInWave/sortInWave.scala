object SortInWaves extends App {
  val arr = Array(10, 90, 49, 2, 1, 5, 23)
  // 90 ,10 ,49 ,1 ,5 ,2 ,23
  val x=arr.indices.foldLeft(arr) { 
    (arr, i) =>
    if (i % 2 == 0) {
      if (i > 0 && arr(i) < arr(i - 1)) {
        val temp = arr(i)
        arr(i) = arr(i-1)
        arr(i-1) = temp
      }
      if (i < arr.length-1 && arr(i) < arr(i + 1)) {
        val temp = arr(i)
        arr(i) = arr(i+1)
        arr(i+1) = temp
      }
    
    }
    arr
  }

  x.foreach(println)
}
