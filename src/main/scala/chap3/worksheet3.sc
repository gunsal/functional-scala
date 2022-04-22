import chap3.DataStructures.List.sum
import chap3.DataStructures.{Cons, List, Nil}

val x: Int = List(1,2,3,4,5) match {
  case Cons(x, Cons(2, Cons(4, _))) => x
  case Nil => 42
  case Cons(x, Cons(y, Cons(3, Cons(4, Cons(u, _))))) => x + u
  case Cons(h, t) => h + sum(t)
  case _ => 101
}