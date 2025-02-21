file://<WORKSPACE>/Count%20Word/CountWords.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 373
uri: file://<WORKSPACE>/Count%20Word/CountWords.java
text:
```scala

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.stream.IntStream;

public class CountWords {

    public static void count(String FilePath) throws IOException {
    IntStream.range(0, 6).filter(i->i%2==0).forEach(i-> System.out.println(i));
      byte[] x = Files.readAllBytes(Paths.get(FilePath));
      String[] word@@ =new String(x).split("\\s+");
    }

    public static void main(String[] args) {
        int[] arr = {2, 12, -2, -20, 10, 0};
        count("<WORKSPACE>/Count Word/g.json");
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
	dotty.tools.pc.completions.CompletionProvider.completions(CompletionProvider.scala:72)
	dotty.tools.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:150)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator