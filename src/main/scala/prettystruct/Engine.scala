package prettystruct

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

  val action = new Action {
    def indent       = indentLevel += 1
    def outdent      = indentLevel -= 1
    def newLine      = bldr.append('\n' + (" " * indentLevel * indentSize))
    def out(c: Char) = bldr += c
  }

  input.foreach(action)
  bldr.result
}
