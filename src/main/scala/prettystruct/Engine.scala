package prettystruct

import Action._

def main(args: Array[String]): Unit = {
  if (args.size != 1) return println(s"Usage: pstr <string you want to pretty-print>")
  val input = args.head
  val result = run(input)
  println(result)
}

def run(input: String): String = {
  val bldr = new StringBuilder
  var indentLevel = 0
  val indentSize  = 2

  input.flatMap(_.actions).foreach {
    case `indent`  => indentLevel += 1
    case `outdent` => indentLevel -= 1
    case `newLine` => bldr.append('\n' + (" " * indentLevel * indentSize))
    case `out`(c)  => bldr += c
  }

  bldr.result
}
