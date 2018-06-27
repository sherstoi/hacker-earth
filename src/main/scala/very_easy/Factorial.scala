package very_easy

object Factorial {
  def recursiveFactorial(n: Int): Int = {
    if (n == 0 || n == 1) 1
    else n * recursiveFactorial(n - 1)
  }

  def factorial(n: Int): Int = {
    (1 to n).foldLeft(1)((accumulator, curElement) => accumulator * curElement)
  }

  def factorialTailRecursive(accumulator: Int, n: Int): Int = {
    if (n == 1) accumulator
    else factorialTailRecursive(accumulator * n, n - 1)
  }

  def main(args: Array[String]): Unit = {
    println(factorialTailRecursive(1, 5))
  }
}
