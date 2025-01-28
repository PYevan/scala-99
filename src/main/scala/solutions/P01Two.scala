package solutions

import scala.annotation.tailrec

object P01Two {
  def main(args: Array[String]): Unit = {
    println("start scala99!")
    
    val testLs = List(1,2,3, List(1,3), List(5,7), "b")
    val resultLs = flattenTwice(testLs)
    println(resultLs)
  }

  def reverseList[T] (list: List[T]): List[T] = {

    @tailrec
    def helper(list: List[T], list1: List[T]): List[T] = list match {
      case Nil => list1
      case x :: xs => helper(xs, x :: list1)
    }

    helper(list, List())
  }

  def flattenTwice[T] (list: List[T]): List[T] = {
    @tailrec
    def concatList[T] (list1: List[T], list2: List[T]): List[T] = list1 match {
      case Nil => list2
      case x :: xs => concatList(xs, x :: list2)
    }

    list match {
      case Nil => List()
      case (x : List[T]) :: xs => concatList(reverseList(flattenTwice(x)), flattenTwice(xs))
      case x :: xs =>
        x :: flattenTwice(xs)
    }
  }
}