object SortInWaves extends App {
  val arr = Array(10, 90, 49, 2, 1, 5, 23)
                //90 ,10 ,49 ,1 ,5 ,2 ,23 
  // Traverse all even indices and print the elements at even indices
  SortInWav(arr)
  arr.foreach(println)
}

def SortInWav(arr:Array[Int])={
   for (i <- 0 until arr.length-1 by 2) {
    if(i>0 && arr(i)< arr(i-1)){ 
        val temp=arr(i)
        arr(i)=arr(i-1)
        arr(i-1)=temp
    }
    if(i<arr.length-1 && arr(i)< arr(i+1)){ 
        val temp=arr(i)
        arr(i)=arr(i+1)
        arr(i+1)=temp
    }
  }
}