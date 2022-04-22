object Part1 {

  def example = {
    println("Hello from part 1")

    val list: List[Int] = (1 to 10).toList

    println(list)

    val x = new StringBuilder("Hello")

    val r1 = x.append(", World").toString()

    val r2 = x.append(", World").toString()

    println(r1)
    println(r2)
  }
}
