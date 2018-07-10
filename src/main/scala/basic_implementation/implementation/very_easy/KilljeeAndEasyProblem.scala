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
    // TODO implement after data structure course
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

  def makePathConcatInImmutableWay(list: Vector[(Int, Int)]): Vector[Vector[(Int, Int)]] = {
    list.foldLeft(Vector.empty[Vector[(Int, Int)]])((listOfLists, curVal) => {
      val filteredVector = listOfLists.filter(p => p.last._2 == curVal._1)
      if (filteredVector.isEmpty) {
        listOfLists :+ Vector(curVal)
      } else {
        val updVect = listOfLists.foldLeft(Vector.empty[Vector[(Int, Int)]]) ((collect, vectVal) => {
          if (vectVal.last._2 == curVal._1) {
            collect :+ (vectVal :+ curVal)
          } else {
            collect :+ vectVal
          }
        })

        /* Or you can proceed with shorter form
          val updatedList = listOfLists.map(vec => if (vec.last._2 == curVal._1) vec :+ curVal
                                                 else vec)*/
        updVect
      }})
  }

  def main(args: Array[String]): Unit = {
    //val y = makePathConcatInMutableListWay(ListBuffer((1,2),(1,3),(2,3),(2,4),(3,4),(4,5),(4,6)))
    println(makePathConcatInImmutableWay(Vector((1,2),(1,3),(2,3),(2,4),(3,4),(4,5),(4,6))).mkString)
  }
}