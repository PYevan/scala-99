package basicThings

import scala.annotation.tailrec

object Test01 {
  def main(args: Array[String]): Unit = {
    println(factorial(4))
  }

  def factorial(n : Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 1) result
      else iter(x - 1, result * x)

    iter(n, 1)
  }



}
