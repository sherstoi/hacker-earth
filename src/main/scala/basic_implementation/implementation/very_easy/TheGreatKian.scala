package basic_implementation.implementation.very_easy

object TheGreatKian {

  def identifyArrOfIndexesWay1(arr: List[Int], startFromIndex: Int, step: Int): Int = {
    val indexes = for (i <- startFromIndex until arr.size by step) yield i
    indexes.foldLeft(0)((accumulator, curVal) => accumulator + arr(curVal))
  }

  def arrOfIndexes(startEle: Int, step: Int): Stream[Int] =
    startEle #:: arrOfIndexes(startEle, step).scanLeft(startEle + step)((a, b) => a + step)

  def calcSum(arrIndex: Stream[Int], arr: List[Int]): Int = {
    arrIndex.takeWhile(_ < arr.length).foldLeft(0) ((accumulator, curStreamVal) => accumulator + arr(curStreamVal))
  }

  def main(args: Array[String]): Unit = {
    val arr = List(1,2,3,4,5)
    println(calcSum(arrOfIndexes(2, 3), arr))
  }
}
