package basicThings


object Test01 {
  def main(args: Array[String]): Unit = {
//    println(factorial(4))

    val someValue: Option[String] = Some("I am evan")
    println(someValue)

    val emptyValue: Option[String] = None
    println(emptyValue)

    println(maybeTest(true))

    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.map(_ * 1.5)
    val result2 = noNumber.map(_ * 1.5)

    println(result1)
    println(result2)


    val f = List(4, 2, 7).fold(1)((acc, int) => acc - int)
    println(f)

    val fl = List(4, 2, 7).foldLeft(1)((acc, int) => acc - int)
    println(fl)

    val fr = List(4, 2, 7).foldRight(1)((acc, int) => acc - int)
    println(fr)
  }

  def maybeTest(flag: Boolean): Option[String] = {
    if (flag) Some("~dididididdi") else None
  }

//  def factorial(n : Int): Int = {
//    @tailrec
//    def iter(x: Int, result: Int): Int =
//      if (x == 1) result
//      else iter(x - 1, result * x)
//
//    iter(n, 1)
//  }
}
