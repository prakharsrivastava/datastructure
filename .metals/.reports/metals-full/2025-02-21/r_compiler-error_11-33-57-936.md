file://<WORKSPACE>/subarraysum/SubarraySumStream.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file://<WORKSPACE>/subarraysum/SubarraySumStream.java
text:
```scala
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SubarraySumStream {
    static class Accumulator {
        Map<Integer, Integer> prefixSumMap;
        int currentSum;

        Accumulator() {
            this.prefixSumMap = new HashMap<>();
            this.currentSum = 0;
        }
    }

    public static void findSubarray(int[] arr, int target) {
        Accumulator acc = new Accumulator();

        IntStream.range(0, arr.length).forEach(i -> {
            acc.currentSum += arr[i];

            if (acc.currentSum == target) {
                System.out.println("Sum found between indexes 0 to " + i);
                System.exit(0);
            }

            if (acc.prefixSumMap.containsKey(acc.currentSum - target)) {
                System.out.println("Sum found from indexes " + (acc.prefixSumMap.get(acc.currentSum - target) + 1) + " to " + i);
                System.exit(0);
            }

            acc.prefixSumMap.put(acc.currentSum, i);
        });
    }

    public static void main(String[] args) {
        int[] arr = {2, 12, -2, -20, 10, 0};
        int target = -10;
        findSubarray(arr, target);
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