package basic_implementation.implementation.very_easy

object BatmanAndTickTackToe {

  def initMatrixTestCase1(size: Int): Array[Array[String]] = {
    val matrix = Array.ofDim[String](size, size)


    matrix(0)(0) = "x"; matrix(0)(1) = "x"; matrix(0)(2) = "."; matrix(0)(3) = "."
    matrix(1)(0) = "."; matrix(1)(1) = "o"; matrix(1)(2) = "o"; matrix(1)(3) = "."
    matrix(2)(0) = "x"; matrix(2)(1) = "."; matrix(2)(2) = "."; matrix(2)(3) = "."
    matrix(3)(0) = "o"; matrix(3)(1) = "o"; matrix(3)(2) = "x"; matrix(3)(3) = "."

    matrix
  }

  def initMatrixTestCase2(size: Int): Array[Array[String]] = {
    val matrix = Array.ofDim[String](size, size)

    matrix(0)(0) = "o"; matrix(0)(1) = "."; matrix(0)(2) = "x"; matrix(0)(3) = "."
    matrix(1)(0) = "o"; matrix(1)(1) = "."; matrix(1)(2) = "."; matrix(1)(3) = "."
    matrix(2)(0) = "."; matrix(2)(1) = "x"; matrix(2)(2) = "."; matrix(2)(3) = "."
    matrix(3)(0) = "o"; matrix(3)(1) = "o"; matrix(3)(2) = "x"; matrix(3)(3) = "x"

    matrix
  }

  def initMatrixTestCase3(size: Int): Array[Array[String]] = {
    val matrix = Array.ofDim[String](size, size)

    matrix(0)(0) = "x"; matrix(0)(1) = "."; matrix(0)(2) = "."; matrix(0)(3) = "x"
    matrix(1)(0) = "."; matrix(1)(1) = "."; matrix(1)(2) = "o"; matrix(1)(3) = "o"
    matrix(2)(0) = "o"; matrix(2)(1) = "."; matrix(2)(2) = "."; matrix(2)(3) = "."
    matrix(3)(0) = "x"; matrix(3)(1) = "."; matrix(3)(2) = "x"; matrix(3)(3) = "o"

    matrix
  }

  def initMatrixTestCase4(size: Int): List[List[String]] = {
    List(List("x", ".", ".", "x"),
         List(".", ".", "o", "o"),
         List("o", ".", ".", "."),
         List("x", ".", "x", "o"))
  }

  def gatherRightElementToArr(matrix: Array[Array[String]], winnerElementSetSize: Int): List[String] = {
    val rez = matrix.foldLeft(List.empty[String]) ((accumulatorCollect, curMatrixArr) => {
      val subArr = (for {
        i <- 0 until curMatrixArr.length - winnerElementSetSize + 1
        j <- i until i + winnerElementSetSize
      } yield curMatrixArr(j)).toList
      println("Res - " + subArr)
      accumulatorCollect :+ subArr.mkString
    })

    rez
  }

  def getRightEle(matrix: List[List[String]], step: Int): List[List[String]] = {
    matrix.foldLeft(List.empty[List[String]])((accumulatorCollection, curMatrixRow) => {
      val subArr = curMatrixRow.zipWithIndex.view.foldLeft(List.empty[List[String]])((acc, curRow) => {
        if (curRow._2 + step <= curMatrixRow.length) { acc :+ curMatrixRow.slice(curRow._2, curRow._2 + step) }
        else { acc }
      })
      accumulatorCollection ++ subArr
    })
  }

  def getTransparentMatrix(matrix: List[List[String]], step: Int): List[List[String]] = {
    matrix.zipWithIndex.view.foldLeft(List.empty[List[String]])((accumulator, curRow) => {
      accumulator :+ matrix.map(subArr => subArr(curRow._2))
    })
  }

  def findWinner(matrix: List[List[String]], countEleForWin: Int): List[List[String]] = {
    matrix.foldLeft(List.empty[List[String]]) ((acc, curRow) => {
      if (curRow.count(p => p == "x") == 2 && curRow.count(p => p == ".") == 1) {
        acc :+ curRow
      }  else { acc }
    })
  }

  def main(args: Array[String]): Unit = {
    //getRightEle(initMatrixTestCase4(4), 3)
    val revMatr = getTransparentMatrix(initMatrixTestCase4(4), 3)
    println(revMatr.mkString)
    val rightEle = getRightEle(revMatr, 3)
    println(rightEle.mkString)
    println("-----------------------------")
    println("-----------------------------")
    println("And winner is:")
    println(findWinner(rightEle, 2).mkString)
    println("-----------------------------")
    val anotherRight = getRightEle(initMatrixTestCase4(4), 3)
    println(anotherRight.mkString)
    println("And winner is:")
    println(findWinner(anotherRight, 2).mkString)
  }
}
