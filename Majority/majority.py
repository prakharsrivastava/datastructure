
object x extends App{
import scala.collection.mutable
   val arr = Array(3, 3, 4, 2, 4, 4, 2, 4, 4)
   val result=arr.foldLeft(Map.empty[Int,Int]){
      (map,a)=>map + (a-> (map.getOrElse(a,0)+1))
   }
   print(result.maxBy(_._2)._1)

   val frequencyMap = arr.groupBy(identity).mapValues(_.length).toMap
   /*
   Map(
  3 -> Array(3, 3),
  4 -> Array(4, 4, 4, 4, 4),
  2 -> Array(2, 2)
)
Map(
  3 -> 2,
  4 -> 5,
  2 -> 2
)
*/

   print(frequencyMap.maxBy(_._2)._1)
}