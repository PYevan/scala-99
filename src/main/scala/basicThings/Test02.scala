package basicThings

object Main {
  def main(args: Array[String]): Unit = {

//    val symbol1: Symbol = Note("Evan", "Half", 3)
//    val symbol2: Symbol = Rest("Nitro")
//
//    println(symbolDuration(symbol2))
//
//    val p = new Person("evan", 13)
//    p.greet()
//
//    for (i <- 1 until 3) {
//      System.out.print(i.toString + " ")
//    }
//
//
//    println(factorial(5))
    val aliceAccount = new BankAccount
    val evanAccount = new BankAccount
    println(aliceAccount == evanAccount)

    val c3 = Note("C", "Quarter", 3)
    val c4 = Note("C", "Quarter", 3)

    println(c3 == c4)


    lazy val largeDataset: List[Int] = {
      println("XXXXXXXXXXXX")
      (1 to 10).toList
    }

    println(largeDataset)
    println(largeDataset)
  }

  def findPerson(name: String): Option[String] = {
    val people = Map("Alice" -> "Developer", "Bob" -> "Manager")
    people.get(name)
  }

//  def symbolDuration (symbol: Symbol): String =
//    symbol match {
//      case Note(name, duration, octave) => duration
//      case Rest(duration) => duration
//    }
//
//
//  def iterate(n: Int, f: Int => Int, x: Int): Int =
//    if (n == 0) x else iterate(n - 1, f, f(x))

//  def square(x: Int) = x * x

  // Test while loop
//  def power(x: Double, exp: Int): Double = {
//    var r = 1.0
//    var i = exp
//    while (i > 0) { r = r * x; i = i - 1 }
//    r
//  }
//
//  def factorial(n: Int): Int = {
//    var result = 1
//    var i = 1
//      while (i <= n) {
//        result = result * i
//        i = i + 1
//      }
//    result
//  }
}
class BankAccount {
  private var balance = 0

  def deposit (amount: Int): Unit = {
    if (amount > 0) balance = balance + amount
  }

  def withdraw(amount: Int): Int =
    if (0 < amount && amount <= balance) {
      balance = balance - amount
      balance
    } else throw new Error("insufficient funds")
}

case class Note(name: String, duration: String, octave: Int)

//sealed trait Symbol
//
//case class Note(name: String, duration: String, octave: Int) extends Symbol
//case class Rest(duration: String) extends Symbol





