package solutions

import scala.annotation.tailrec

object P01One {
  def main(args: Array[String]): Unit = {
    println("start scala99!")
    val list = "aaaabbcccdeeeff".toList

    val result = packList(list)
    println(result)

    val encodeRes = newEncode(list)
    println(encodeRes)
  }

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
    case _ :: xs => lastButOne(xs)
  }


  @tailrec
  def nth[T](n: Int, list: List[T]): T = list match {
    case Nil => throw new NoSuchElementException
    case x :: xs =>
      if (n == 0) x
      else nth(n - 1, xs)
  }

  def length[T] (list: List[T]): Int = {
    @tailrec
    def lenHelper(list: List[T], len: Int): Int = list match {
      case Nil => len
      case _ :: xs => lenHelper(xs, len + 1)
    }
    lenHelper(list, 0)
  }

  

  def reverseList[T] (list: List[T]): List[T] = {

    def helper(list: List[T], list1: List[T]): List[T] = list match {
      case Nil => list1
      case x :: xs => helper(xs, x :: list1)
    }

    helper(list, List())
  }


  def palindromeList[T](list: List[T]): Boolean = {

    def checkReverse(xs: List[T], ys: List[T]): Boolean = {
      (xs, ys) match {
        case (Nil, Nil) => true
        case (x :: xs1, y :: ys1) =>
          if (x == y) checkReverse(xs1, ys1)
          else false
        case _ => false
      }
    }

    val reversedList = reverseList(list)

    checkReverse(list, reversedList)
  }


  def flattenList(list: List[Any]): List[Any] = {

    def concatReverse(list1: List[Any], list2: List[Any]): List[Any] = list1 match {
      case Nil => list2
      case x :: xs => concatReverse(xs, x :: list2)
    }

    list match {
      case Nil => List()
      case (x: List[Any]) :: xs =>
        concatReverse(reverseList(flattenList(x)), flattenList(xs))
      case x :: xs =>
        x :: flattenList(xs)
    }
  }


  def compressTail[T] (list: List[T]): List[T] = {
    @tailrec
    def compressHelper(origin: List[T], result: List[T]): List[T] = origin match {
      case Nil => result.reverse
      case x :: tail =>
        val rest = tail.dropWhile(_ == x)
        compressHelper(rest, x :: result)
    }

    compressHelper(list, Nil)
  }

  def packList[T] (list: List[T]): List[List[T]] = {
    if (list.isEmpty) List(List())
    else {
      val (packed, next) = list.span(_ == list.head)
      if (next == Nil) List(packed)
      else packed :: packList(next)
    }
  }

  def newEncode[T] (list: List[T]): List[(Int, T)] = {
    packList(list).map {ls => (ls.length, ls.head)}
  }

}