package chap2

import scala.annotation.tailrec

object MyModule {

  def abs(n: Int): Int = if (n < 0) -n else n

  def factorial(n: Int): Int = {
    @tailrec
    def go(x: Int, acc: Int): Int = {
      if (x <= 0) acc
      else go(x - 1, x * acc)
    }

    go(n, 1)
  }

  private def formatAbs(x: Int): String = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(n: Int): String = {
    val msg = "The factorial of %d is %d"
    msg.format(n, factorial(n))
  }

  def formatResult(name: String, n: Int, f: Int => Int): String = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  def findFirst(ss: Array[String], key: String): Int = {
    @tailrec
    def loop(index: Int): Int = {
      if (index >= ss.length) -1
      else if (ss(index) == key) index
      else loop(index + 1)
    }

    loop(0)
  }

  def findFirstGeneric[A](ss: Array[A], p: A => Boolean): Int = {
    @tailrec
    def loop(index: Int): Int = {
      if (index >= ss.length) -1
      else if (p(ss(index))) index
      else loop(index + 1)
    }

    loop(0)
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = {
    (b: B) => f(a, b)
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(5))

    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 7, factorial))
    //println(fib(2))

    val arr = Array("bir", "uc", "bes")
    val arr2 = Array(1, 2, 5, 6, 9)
    println(findFirst(arr, "bes"))
    println(findFirstGeneric(arr, (a: String) => a == "bes"))
    println(findFirstGeneric(arr2, (num: Int) => num == 9))

    val sortedArr = Array(1, 2, 6, 9)

    def sortedMe: (Int, Int) => Boolean = (a, b) => a > b

    println(isSorted(sortedArr, sortedMe))
    println(fib(3))
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }

  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @tailrec
    def loop(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if (gt(as(n), as(n + 1))) false
      else loop(n + 1)
    }

    loop(0)
  }

  //Return the nth Fib number first two Fib numbers are 0 and 1
  def fib(n: Int): Int = {
    @tailrec
    def go(num: Int, prev: Int, current: Int): Int = {
      println(s"num is $num")
      println(s"prev is $prev")
      println(s"current is $current")
      println()
      if (num <= 0) prev
      else go(num - 1, current, current + prev)
    }

    go(n, 0, 1)
  }
}
