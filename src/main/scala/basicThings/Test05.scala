package basicThings

object Test05 {
  def main(args: Array[String]): Unit = {
    {
      implicit val defaultGreeting: String = "Hello"
      println(greet("John")) }

    {
      implicit val spanishGreeting: String = "Hola"
      println(greet("John"))
    }

    val x: String = 42
    println(x)
  }

  def greet(name: String)(implicit greeting: String) = s"$greeting, $name!"

  implicit def intToString(x: Int): String = s"The number is $x"
}
