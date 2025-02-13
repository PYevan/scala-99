package myanswers

import scala.annotation.tailrec

object P01 {
  def main(args: Array[String]) : Unit = {
    val list = "aaaabbcccdeeeff".toList

    val result = pack(list)
    println(result)

    val encodeRes = encode(list)
    println(encodeRes)
  }

// For the first 10 questions, flatten and compress are not difficult
  @tailrec
  def last[T](list: List[T]): T = list match {
    case Nil => throw new NoSuchElementException
    case x :: Nil => x
    case _ :: xs => last(xs)
  }


  @tailrec
  def lastButOne[T](list: List[T]): T = list match {
    case Nil => throw new NoSuchElementException
    case _ :: Nil => throw new NoSuchElementException
    case x :: _ :: Nil => x
    case _ :: xs => lastButOne(xs) // the xs represents the tail of the list
  }


  @tailrec
  def nth[T] (n: Int, list: List[T]): T = list match {
    case Nil => throw new NoSuchElementException
    case x :: xs =>
      if (n == 0) x
      else nth(n - 1, xs)
  }


  def length[T] (list: List[T]): Int = {
    @tailrec
    def tailHelper(list: List[T], len: Int): Int = list match {
      case Nil => len
      case _ :: xs => tailHelper(xs, len + 1)
    }

    tailHelper(list, 0)
  }


  def reverse[T] (list: List[T]): List[T] = {
    @tailrec
    def reverseHelper(list: List[T], acc: List[T]): List[T] = list match {
      case Nil => acc
      case x :: xs => reverseHelper(xs, x :: acc)
    }

    reverseHelper(list, List())
  }

  def isPalindrome[T] (list: List[T]): Boolean = {
    @tailrec
    def isEqual(xs: List[T], ys: List[T]): Boolean = {
      (xs, ys) match {
        case (Nil, Nil) => true
        case (x :: xs1, y :: ys1) =>
          if (x == y) isEqual(xs1, ys1)
          else false
        case _ => false
      }
    }

    val reversedList = reverse(list)

    isEqual(list, reversedList)
  }



  def flatten(list: List[Any]): List[Any] = { // any means any types of elements
    @tailrec
    def concatReverse(list1: List[Any], list2: List[Any]): List[Any] = list1 match{
      case Nil => list2
      case x :: xs =>
        concatReverse(xs, x :: list2)
    } 

    list match {
      case Nil => List()
      case ((x: List[Any]) :: xs) =>
        concatReverse(reverse(flatten(x)), flatten(xs))
      case (x :: xs) =>
        x :: flatten(xs)
    }
  }

  def divide(a: Int, b: Int): Option[Int] = {
    if (b != 0) Some(a / b) // Value exists
    else None // No value
  }

  def compress[T] (list: List[T]): List[T] = {
    @tailrec
    def compressHelper(list: List[T], acc: List[T], last: Option[T]): List[T] = {
      (list, last) match {
        case (Nil, _) => acc
        case (x :: xs, Some(y)) =>
          if (x == y) compressHelper(xs, acc, Some(x))
          else compressHelper(xs, x :: acc, Some(x))
        case (x :: xs, None) =>
          compressHelper(xs, x :: acc, Some(x))
      }
    }
    reverse(compressHelper(list, List(), None))
  }

  def pack[T] (list: List[T]): List[List[T]] = {
    if (list.isEmpty) List(List())
    else {
      val (packed, next) = list.span(_ == list.head)
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  def encode[T] (list: List[T]): List[(Int, T)] = {
    pack(list).map {e => (e.length, e.head)}
  }
}