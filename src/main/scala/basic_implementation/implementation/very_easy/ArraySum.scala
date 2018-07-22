package basic_implementation.implementation.very_easy


object ArraySum {
  def sumArr(arr: List[Long]): Long = {
    arr.foldLeft(0L)((accumulator, curVal) => curVal + accumulator)
  }

  def main(args: Array[String]): Unit = {
    println(sumArr(List(1000000001, 1000000002, 1000000003, 1000000004, 1000000005)))
  }
}
