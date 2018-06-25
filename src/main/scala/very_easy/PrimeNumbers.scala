package very_easy

object PrimeNumbers {
  def isPrimeNumber(num: Integer): Boolean = {
    (1 to num).count(num % _ == 0) > 2
  }

  def main(args: Array[String]): Unit = {
    isPrimeNumber(6)
  }
}