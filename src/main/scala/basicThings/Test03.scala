package basicThings

object Test03 {
  def main(args: Array[String]): Unit = {
//    println(pair(24, "Evan"))

//    val is: (Int, String) = (24, "Even")
//    is match {
//      case (i, s) =>
//        println(i)
//        println(s)
//    }
//
//    print(is._1)
//    print(is._2)

    val xs = List(1, 2, 3)
    println(xs.map(x => x + 1))

    for (x <- xs) yield println(x + 1)

    println(xs.filter(x => x % 2 == 0))
    for (x <- xs if x % 2 == 0) yield x + 1

    val ys = List(List(1), List(2))
    println(ys.flatten)

    val zs = List(1, 2).flatMap(element => List(element))
    val zss = List(1, 2).map(element => List(element))

    println(zs)
    println(zss)

//    println(xs.flatMap(x => ys.map(y => (x, y))))
  }

//  def pair(i: Int, s:String): (Int, String) = (i, s)
}
