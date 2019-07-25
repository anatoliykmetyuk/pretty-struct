Usage: from SBT console, `run <string you want to pretty-format>`.

Example:

```
run """utest.Tests.apply(utest.framework.Tree.apply[scala.Predef.String]("<root>", scala.Nil: _*), new utest.framework.TestCallTree(scala.Right.apply[scala.Nothing, scala.collection.immutable.IndexedSeq[utest.framework.TestCallTree]](scala.Nil.toIndexedSeq)))"""
```

Output:

```
utest.Tests.apply(
  utest.framework.Tree.apply[scala.Predef.String](
    "<root>"
  , scala.Nil: _*
  )
, new utest.framework.TestCallTree(
    scala.Right.apply[scala.Nothing
  , scala.collection.immutable.IndexedSeq[utest.framework.TestCallTree]](
      scala.Nil.toIndexedSeq
    )
  )
)
```