package basic_implementation.input_output.very_easy

object FindProduct {
  def productElementsInArr(arr: List[Int]): Int = {
    arr.reduceLeft((accumulator, curVal) => accumulator * curVal)
  }

  def main(args: Array[String]): Unit = {
    println(productElementsInArr(List(1, 2, 3, 4, 5)))
  }
}
