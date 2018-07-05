package basic_implementation.input_output.very_easy

import scala.collection.immutable.List

object PalindromicString {
  def isStringPalindrom(str: String): Boolean = {
    val immutableList = str.foldLeft(List.empty[Char])((list, curChr) => curChr::list)
    val reverseStr = immutableList.foldLeft("")((accumulator, curVal) => accumulator + curVal)

    str == reverseStr
  }

  def main(args: Array[String]): Unit = {
    println(isStringPalindrom("level").toString)
  }
}
