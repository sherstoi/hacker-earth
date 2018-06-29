package easy

object PlayWithNumbers {

  def calculateSumOfArrToMap(arr: List[Int]): Map[Int, Int] = {
    arr.zipWithIndex.foldLeft(Map.empty[Int, Int])((map, keyVal) => map + (keyVal._2 -> {
        if (keyVal._2 == 0) keyVal._1 else map(keyVal._2 - 1) + keyVal._1
    }))
  }

  def calculateFloor(arr: List[Int], startPos: Int, endPos: Int): Int = {
    val sum = arr.indices.collect { case i if ((i >= startPos - 1) && (i <= endPos - 1)) => arr(i) }.toList.
      foldLeft(0)((accumulator, curValue) => accumulator + curValue)
    sum / (endPos - startPos + 1)
  }

  def main(args: Array[String]): Unit = {
    println(calculateFloor(List(1,2,3,4,5), 2, 5))
  }
}
