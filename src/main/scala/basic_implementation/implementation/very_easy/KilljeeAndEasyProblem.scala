package basic_implementation.implementation.very_easy

import scala.collection.mutable.ListBuffer

object KilljeeAndEasyProblem {
  /** 1) Tree approach:
    *
    * [(1, 3) (1, 2) (2, 3) (2,4) (3, 4) (4,5) (4,6)] =>
    * -------------------------------------------------------------
    *             (1, 2)
    *     (2,3)             (2,4)
    *     (3,4)           (4,5)  (4,6)
    *  (4,5) (4,6)
    *
    *  (1,2) - (2,3) (2,4) -
    * -------------------------------------------------------------
    *             (1,3)
    *             (3,4)
    *          (4,5)   (4,6)
    * -------------------------------------------------------------
    */
    // TODO implement
    def treeAproach(list: List[(Int, Int)]): Boolean = {
      true
    }

    /**
    * 2) List approach:
    * [(1, 3) (1, 2) (2, 3) (2,4) (3, 4) (4,5) (4,6)] =>
    * (1,3) - new list
    * (1,2) - new list
    * (1,2) (2,3)
    * -----------------------------
    * [2,4]:
    * (1,3)
    * (1,2) (2,4)
    * (1,2) (2,3)
    * ------------------------------
    * [3,4]
    * (1,3) (3,4)
    * (1,2) (2,4)
    * (1,2) (2,3) (3,4)
    */
  def makePathConcatInMutableListWay(list: ListBuffer[(Int, Int)]): ListBuffer[ListBuffer[(Int, Int)]] = {
    list.foldLeft(ListBuffer.empty[ListBuffer[(Int, Int)]])((listOfList, curVal) => {
      val filteredLists = listOfList.filter(p => p.last._2 == curVal._1)
      if (filteredLists.isEmpty) listOfList += ListBuffer(curVal)
      else filteredLists.foldLeft(0)((lb, value) => { value += curVal; lb})
      listOfList
    })
  }

  def makePathConcatInListWay(list: Vector[(Int, Int)]): Vector[Vector[(Int, Int)]] = {
    list.foldLeft(Vector.empty[Vector[(Int, Int)]])((listOfLists, curVal) => {
      val filteredVector = listOfLists.filter(p => p.last._2 == curVal._1)
      println("ListOfLists: " + listOfLists.mkString)
      println("Filter by " + curVal._1)
      if (filteredVector.isEmpty) {
        val s = listOfLists :+ Vector(curVal)
        println("Filter is empty, concat result " + s.mkString)
        s
      } else {
        //listOfLists ++ filteredVector
        val p = filteredVector.foldLeft(Vector.empty[Vector[(Int, Int)]])((vect, curV) => {
          val newVal = curV :+ curVal
          vect :+ newVal
        })
        p ++ listOfLists
      }})
  }

  def main(args: Array[String]): Unit = {
    //val y = makePathConcatInMutableListWay(ListBuffer((1,2),(1,3),(2,3),(2,4),(3,4),(4,5),(4,6)))
    val r = makePathConcatInListWay(Vector((1,2),(1,3),(2,3),(2,4),(3,4),(4,5),(4,6)))
    val t = 1
  }
}