package basicThings

sealed trait Shape {
  def area: Double
}

case class Rectangle(width: Double, height: Double) extends Shape {
  def area: Double = width * height
}

case class Circle(radius: Double) extends Shape {
  def area: Double = Math.PI * radius * radius
}

sealed trait Color
case object Red extends Color
case object Blue extends Color
case object Green extends Color

object AlgebraicDataTypeDemo {
  def describeShape(shape: Shape): String = shape match {
    case Rectangle(w, h) => s"ectangle with width $w and height $h"
    case Circle(r) => s"Circle with radius $r"
  }

  def main(args: Array[String]): Unit = {}
  val rect = Rectangle(5.0, 3.0)
  val circle = Circle(2.5)

  println(describeShape(rect)) // Prints: Rectangle with width 5.0 and height 3.0
  println(rect.area) // Prints: 15.0
  println(describeShape(circle)) // Prints: Circle with radius 2.5
  println(circle.area) // Prints: 19.634954084936208
}