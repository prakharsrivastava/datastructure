error id: `<none>`.
file://<WORKSPACE>/subarraysum/sortInWave.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 1127
uri: file://<WORKSPACE>/subarraysum/sortInWave.scala
text:
```scala
/* 
Index (i) | Current Element | Cumulative Sum (curr_sum) | Check curr_sum - Sum Exists? | HashMap (Prefix Sums)               | Subarray Found? |
----------------------------------------------------------------------------------------------------------------------------
0         | 2               | 2                         | 2 - (-10) = 12 (❌ No)        | {2: 0}                              | ❌ No           |
1         | 12              | 14                        | 14 - (-10) = 24 (❌ No)       | {2: 0, 14: 1}                       | ❌ No           |
2         | -2              | 12                        | 12 - (-10) = 22 (❌ No)       | {2: 0, 14: 1, 12: 2}                | ❌ No           |
3         | -20             | -8                        | -8 - (-10) = 2 (✅ Yes!)      | {2: 0, 14: 1, 12: 2, -8: 3}         | ✅ Yes!         |
4         | 10              | 2                         | 2 - (-10) = 12 (❌ No)        | {2: 0, 14: 1, 12: 2, -8: 3, 2: 4}   | ❌ No           |

 */
object SubArraySum extends App {
  val arr = Array(2, 12, -2, -20, 10)
                //90 ,10 ,49 ,1 ,5 ,2 ,23 
  // Tra@@verse all even indices and print the elements at even indices
  SortInWav(arr)
  arr.foreach(println)
}
//o(n)
def sas(arr:Array[Int])={
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
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.