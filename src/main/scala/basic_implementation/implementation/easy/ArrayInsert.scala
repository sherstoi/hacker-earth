package basic_implementation.implementation.easy

object ArrayInsert {
  def executeCommand(commandList: List[Int], arr: List[Int]): List[Int] = {
    if (commandList.head == 1) {
      arr.patch(commandList(1), Seq(commandList(2)), 1)
    } else {
      val sum = arr.zipWithIndex.foldLeft(0)((sum, curVal) =>
        if (curVal._2 >= commandList(1) && curVal._2 <= commandList(2)) { sum + curVal._1} else sum)
      List(sum)
    }
  }

  def main(args: Array[String]): Unit = {
    println(executeCommand(List(2, 3, 5), List(1,2,3,4,5,6,7,8)))
    println(executeCommand(List(1, 3, 12), List(1,2,3,4,5,6,7,8)))
  }
}
