package chap3

import chap3.DataStructures.List.sum

object DataStructures {


  def main(args: Array[String]): Unit = {
    println("Hello world from Data Structures")

    val ex1: List[Double] = Nil
    val ex2: List[Double] = Cons(1, Nil)
    val ex3: List[String] = Cons("a", Cons("b", Nil))

  }

  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
  }
}
