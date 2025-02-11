import scala.annotation.tailrec

def sumMultiples(n: Int): Int = {
  (1 until n).filter(x => x % 3 == 0 || x % 5 == 0).sum
}




def sumOfEvenFibonacciTerms(limit: Int): Int = {
  def fibonacciSequence(a: Int, b: Int): LazyList[Int] = {
    val nextTerm = a + b
    if (nextTerm > limit) LazyList.empty
    else nextTerm #:: fibonacciSequence(b, nextTerm)
  }

  val fibonacciTerms = 1 #:: 2 #:: fibonacciSequence(1, 2)

  fibonacciTerms.filter(_ % 2 == 0).sum
}



def fibSequenceRecursion(sequenceSize: Int): Seq[Long] = {
  def getNextNum(num: Long): Long = {
    if (num <= 1) {
      num
    } else {
      getNextNum(num - 1) + getNextNum(num - 2)
    }
  }
  (0L until sequenceSize).map(getNextNum)
}

def fibTailRec(sequenceSize: Int): Seq[Long] = {
  @tailrec
  def fib(n: Int, a: Long, b: Long, acc: List[Long]): List[Long] = {
    if (n <= 0) acc
    else fib(n - 1, b, a + b, acc :+ a)
  }

  fib(sequenceSize, 0L, 1, Nil)
}

val ls = List(1, 2)
println(ls :+ 3)

println(fibTailRec(3))
//can not understand
//def fubLazyList(sequenceSize: Int): Seq[Long] = {
//  lazy val fib: LazyList[Long] = 0L #:: 1L #:: fib.zip(fib.tail).map(_ + _)
//  fib.take(sequenceSize).toList
//}
//can not understand




