// sum type
sealed trait Animal
case object Dog extends Animal
case object Cat extends Animal
case object Bird extends Animal

// product type
case class Person(name: String, age: Int)

// complex sum type
sealed trait Shape
case class Circle(radius: Double) extends Shape
case class Rectangle(width: Double, height: Double) extends Shape
case class Triangle(base: Double, height: Double) extends Shape

// recursive ADT
sealed trait BinaryTree[A]
case class Node[A] (value: A, left: BinaryTree[A], right: BinaryTree[A]) extends BinaryTree[A]
case class Leaf[A] (value: A) extends BinaryTree[A]
case object Empty extends BinaryTree[Nothing]

object ShapeCalculator {
  def area(shape: Shape): Double = shape match {
    case Circle(r) => Math.PI * r * r
    case Rectangle(w, h) => w * h
    case Triangle(b, h) => 0.5 * b * h
  }
}

object Main extends App {
  val c = Circle(10.0)
  println(ShapeCalculator.area(c))
}

