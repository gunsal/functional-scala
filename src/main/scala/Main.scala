

object Main extends App {

  println("Hello world")

  val convertString: String => Int = _.toInt + 1

  val result: Int = firstFunction("1", convertString)
  val result2: Int = convertToInt("1")

  println("Result is: " + result)
  println("Result2 is: " + result2)

  def firstFunction(number: String, x: String => Int): Int = x(number)

  def convertToInt(number: String): Int = number.toInt

  Part1.example
}
