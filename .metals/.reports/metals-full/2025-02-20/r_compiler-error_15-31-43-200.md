file://<WORKSPACE>/SortInWave/SortWaveStream.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file://<WORKSPACE>/SortInWave/SortWaveStream.java
text:
```scala
import java.util.stream.IntStream;

public class SortWaveStream {
    // A utility method to swap two elements in an array
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // This function sorts arr[0..n-1] in wave form using Streams
    private static void sortInWave(int[] arr) {
        IntStream.range(0, arr.length / 2)
                 .filter(i -> i %2==0)
                 .forEach(i -> {
                     if (i > 0 && arr[i - 1] > arr[i]) swap(arr, i, i - 1);
                     if (i < arr.length - 1 && arr[i + 1] > arr[i]) swap(arr, i, i + 1);
                 });
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[] arr = {10, 90, 49, 2, 1, 5, 23};
       // sortInWave(arr);
       // System.out.println(Arrays.toString(arr));
       IntStream.range(0, arr.length).forEach(i->System.out.println(i));
    }
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
	dotty.tools.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:31)
	dotty.tools.pc.SimpleCollector.<init>(PcCollector.scala:351)
	dotty.tools.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:88)
	dotty.tools.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:111)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator