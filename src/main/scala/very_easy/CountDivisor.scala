package very_easy

object CountDivisor {
  def findDivisorInsideInterval(l: Int, r: Int, k: Int): Int = {
    (l to r).foldLeft(0)((accumulator, curValue) => { if (curValue % k == 0) { accumulator + 1 } else accumulator})
  }

  def main(args: Array[String]): Unit = {
    println(findDivisorInsideInterval(1, 10, 4))
  }
}
