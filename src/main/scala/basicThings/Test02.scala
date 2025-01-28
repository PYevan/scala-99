package basicThings

object Main {
  def main(args: Array[String]): Unit = {

    val symbol1: Symbol = Note("Evan", "Half", 3)
    val symbol2: Symbol = Rest("Nitro")

    println(symbolDuration(symbol2))
  }

  def symbolDuration (symbol: Symbol): String =
    symbol match {
      case Note(name, duration, octave) => duration
      case Rest(duration) => duration
    }
}

sealed trait Symbol

case class Note(name: String, duration: String, octave: Int) extends Symbol
case class Rest(duration: String) extends Symbol



