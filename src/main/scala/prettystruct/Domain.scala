package prettystruct

val openBrace  = Set('(', '[')
val closeBrace = Set(')', ']')
val comma      = Set(',')

trait Action extends Function1[Char, Unit] {
  def indent : Unit
  def outdent: Unit
  def newLine: Unit
  def out(c: Char): Unit

  def apply(c: Char): Unit =
         if (openBrace(c) ) { out(c)  ; indent  ; newLine         }
    else if (closeBrace(c)) { outdent ; newLine ; out(c)          }
    else if (comma(c)     ) { outdent ; newLine ; indent ; out(c) }
    else                      out(c)
}
