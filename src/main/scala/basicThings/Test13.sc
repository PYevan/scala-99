// product type often defined as a case class
case class ChessPiece(color: Color, name: Name)
val rook = ChessPiece(White, Rook)

// to define a type can assume different value, leverage the sum type pattern
sealed trait Color
final case object White extends Color
final case object Black extends Color

// Sealed traits are the ways of defining Sum Types
sealed trait Name
final case object Pawn extends Name
final case object Rook extends Name
final case object Knight extends Name
final case object Bishop extends Name
final case object Queen extends Name
final case object King extends Name

// has-a: or, is-a: and

//trait Semaphore {
//  val color: Color
//}
//
//trait Feline
//trait Animal
//trait Cat extends Animal with Feline
//
//
//def isTheMostImportantPiece(c: ChessPiece) : Boolean = c match {
//  case ChessPiece(_, King) => true
//  case _ => false
//}


