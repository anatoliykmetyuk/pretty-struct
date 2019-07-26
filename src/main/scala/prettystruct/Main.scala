package prettystruct

val openBrace  = Set('(', '[')
val closeBrace = Set(')', ']')
val comma      = Set(',')

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

  def indent       = indentLevel += 1
  def outdent      = indentLevel -= 1
  def newLine      = bldr.append('\n' + (" " * indentLevel * indentSize))
  def out(c: Char) = bldr += c

  def action(c: Char): Unit =
         if (openBrace(c) ) { out(c)  ; indent  ; newLine         }
    else if (closeBrace(c)) { outdent ; newLine ; out(c)          }
    else if (comma(c)     ) { outdent ; newLine ; indent ; out(c) }
    else                      out(c)

  input.foreach(action)
  bldr.result
}
