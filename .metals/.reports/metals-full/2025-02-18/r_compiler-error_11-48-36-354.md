file://<WORKSPACE>/SortInWave/sortInWave.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 154
uri: file://<WORKSPACE>/SortInWave/sortInWave.java
text:
```scala
package SortInWave;
public class sortInWave {

    public static void main(String[] args) {
        int ar[]={10, 90, 49, 2, 1, 5, 23};
    for(int i=0;i<@@ar.length;i+=2){
        
    }
    }///3 fingers index finger middle and ring finger

    //1> stretegy pen think how you can achive output : find some pattern 
    //2>> create boundries 
    //3> read the code or explanation
    //write it on paper not the whole code psedo code //
    //steps acheiving the output
    //for loop for iteranting the index

}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:935)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:164)
	dotty.tools.pc.CachingDriver.run(CachingDriver.scala:45)
	dotty.tools.pc.HoverProvider$.hover(HoverProvider.scala:40)
	dotty.tools.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:389)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator