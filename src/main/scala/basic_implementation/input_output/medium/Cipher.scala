package basic_implementation.input_output.medium

object Cipher {
  val ALPHABET_SIZE = 26
  val DIGIT_SIZE = 10

  def capitalLetters() : Iterator[Char] = Iterator.continually(('A' to 'Z').toList).flatten
  def lowLetters() : Iterator[Char] = Iterator.continually(('a' to 'z').toList).flatten
  def digits() : Iterator[Int] = Iterator.continually((0 to 9).toList).flatten

  def getIterator(str: String): Iterator[AnyVal] = {
    val chr = str.charAt(0)

    chr match {
      case x if x.isDigit => digits()
      case x if x.isLower => lowLetters()
      case x if x.isUpper => capitalLetters()
    }
  }

  def findPos(str: String): Int = {
    val chr = str.charAt(0)
    if (chr.isDigit) { getIterator(str).indexWhere(i => i == str.toInt)}
    else { getIterator(str).indexWhere(i => i == chr) }
  }

  def getCollectionSize(str: String): Int = {
    val chr = str.charAt(0)
    chr match {
      case x if x.isDigit => DIGIT_SIZE
      case x if x.isUpper || x.isLower => ALPHABET_SIZE
    }
  }

  def isElementExistsInCollections(ele: String): Boolean = {
    ('0' to '9').contains(ele.charAt(0)) || ('A' to 'Z').contains(ele.charAt(0)) || ('a' to 'z').contains(ele.charAt(0))
  }

  def getShiftedElement(ele: String, newPos: Int): String = {
    if (!isElementExistsInCollections(ele)) { ele }
    else {
      val curPos = findPos(ele)
      val collectionSize = getCollectionSize(ele)
      getIterator(ele).slice(curPos + newPos, collectionSize + newPos).next().toString
    }
  }

  def mapEleToShifted(str: String, newPos: Int): String = {
    str.foldLeft(new StringBuilder)((stringBuilder, curStr) =>
      stringBuilder append getShiftedElement(curStr.toString, newPos)).mkString
  }

  def main(args: Array[String]): Unit = {
    println(mapEleToShifted("A1;B", 2))
  }
}
