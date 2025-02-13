package wThree

object Q1Basic {
  def main(args: Array[String]): Unit = {
    println(test1(2, 2))
    println(test6("wuwuwu"))

    println("Result: " + test7("Scala", 1))
    println(test8("evan"))

    println(test9("oioi"))
  }

  def test1(x: Int, y: Int): Int = {
    if (x == y) (x + y) * 3
    else
      x + y
  }

  def test2(n: Int): Int = {
    if (n > 51) Math.abs(n - 51) * 3
    else
      Math.abs(n - 51)
  }

  def test6(s: String): String = {
    if (s.startsWith("if")) s else "if" + s
  }

  def test7(s: String, n: Int): String = {
    s.take(n) + s.drop(n + 1)
  }

  def test8(s: String): String = {
    println(s.substring(1, s.length - 1))
    s.charAt(s.length - 1) + s.substring(1, s.length - 1) + s.charAt(0)
  }

  def test9(s: String): String = {
    if (s.length <= 2) s
    else
      s.substring(0, 2) * 4
  }
}
