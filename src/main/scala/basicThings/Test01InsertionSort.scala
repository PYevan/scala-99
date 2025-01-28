package basicThings

object Test01InsertionSort {
  def main(args: Array[String]): Unit = {
    println("Evan scala Here")

    // Test cases
    println(insert(2, 1 :: 3 :: Nil)) // Should print: List(1, 2, 3)
    println(insert(1, 2 :: 3 :: Nil)) // Should print: List(1, 2, 3)
    println(insert(3, 1 :: 2 :: Nil)) // Should print: List(1, 2, 3)

    // Test insertionSort
    println(insertionSort(List(7, 3, 9, 2))) // Should print: List(2, 3, 7, 9)
    println(insertionSort(List(5, 1, 4, 2, 8))) // Should print: List(1, 2, 4, 5, 8)

  }

  val cond: (Int, Int) => Boolean = (x, y) => x <= y
  def insert(x: Int, xs: List[Int]): List[Int] =
    xs match {
      case Nil => List(x)
      case y :: ys =>
        if (cond(x, y)) x :: y :: ys
        else y :: insert(x, ys)
    }


  def insertionSort(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => insert(y, insertionSort(ys))
  }
}
