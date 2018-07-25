package basic_implementation.implementation.very_easy

object LittleJhool {

  def findSubStrStat(symbol: Char, text: String): List[Int] = {
    text.foldLeft(List.empty[Int])((accumList, curVal) => {
      if (symbol == curVal) {
        if (accumList.isEmpty) accumList :+ 1
        else accumList.init :+ accumList.last + 1
      } else {
        if (accumList.nonEmpty) {
          if (accumList.last != 0) accumList :+ 0
          else accumList
        } else accumList :+ 0
      }
    })
  }

  def main(args: Array[String]): Unit = {
    println(findSubStrStat('1', "000110100").toString())
  }
}
