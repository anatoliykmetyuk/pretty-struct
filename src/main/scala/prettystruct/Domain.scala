package prettystruct

enum CharTpe(p: Char => Boolean) extends Function1[Char, Boolean] {
  def this(cs: Set[Char]) = this(c => cs(c))
  def this(cs: Char*) = this(cs.toSet)

  def apply(c: Char): Boolean = p(c)

  case OpenBrace  extends CharTpe('(', '[')
  case CloseBrace extends CharTpe(')', ']')
  case Comma      extends CharTpe(',')
  case Neutral    extends CharTpe(c => !CharTpe.values.filter(x => x.toString != "Neutral").exists(_(c)))
}
import CharTpe._

enum Action {
  case indent, outdent, newLine
  case out(c: Char)
}
import Action._

def (c: Char) tpe: CharTpe = CharTpe.values.sortBy(_.ordinal).find(_(c)).get
def (c: Char) actions: List[Action] = c.tpe match {
  case OpenBrace  => out(c)  :: indent  :: newLine :: Nil
  case CloseBrace => outdent :: newLine :: out(c)  :: Nil
  case Comma      => outdent :: newLine :: indent  :: out(c) :: Nil
  case Neutral    => out(c)  :: Nil
}
