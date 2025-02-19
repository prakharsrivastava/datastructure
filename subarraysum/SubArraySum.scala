/* 
|Index (i) | Current Element | Cumulative Sum (curr_sum) | Check curr_sum - Sum Exists? | HashMap (Prefix Sums)               | Subarray Found? |
----------------------------------------------------------------------------------------------------------------------------
|0         | 2               | 2                         | 2 - (-10) = 12 (❌ No)        | {2: 0}                              | ❌ No           |
|1         | 12              | 14                        | 14 - (-10) = 24 (❌ No)       | {2: 0, 14: 1}                       | ❌ No           |
|2         | -2              | 12                        | 12 - (-10) = 22 (❌ No)       | {2: 0, 14: 1, 12: 2}                | ❌ No           |
|3         | -20             | -8                        | -8 - (-10) = 2 (✅ Yes!)      | {2: 0, 14: 1, 12: 2, -8: 3}         | ✅ Yes!         |
|4         | 10              | 2                         | 2 - (-10) = 12 (❌ No)        | {2: 0, 14: 1, 12: 2, -8: 3, 2: 4}   | ❌ No           |

 */
import scala.collection.mutable
object SubArraySum extends App {
  val arr = Array(2, 12, -2, -20, 10)
                //90 ,10 ,49 ,1 ,5 ,2 ,23 
  // Traverse all even indices and print the elements at even indices
  sas(arr,-10)
  //arr.foreach(println)
}
//o(n)
def sas(arr:Array[Int],target : Int):Unit={
  var current=0
  var found=false
   val prefixSumMap = mutable.Map[Int, Int]() 
   for (i <- 0 until arr.length by 1) { // for(i<-arr.indices)
    current += arr(i)
    if(current==target){
      println(s"Sum found between indexes 0 to $i") 
      found=true
    }

    if(prefixSumMap.contains(current-target)){
        println(s"Sum found from indexes  ${prefixSumMap(current - target) + 1}" +" to "+ i)
        found=true
    }
    if(found){
      System.exit(0)
    }

    //add in map current->i
    prefixSumMap(current)=i
    

  }
 
}