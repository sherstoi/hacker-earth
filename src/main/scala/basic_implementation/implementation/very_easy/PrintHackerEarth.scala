package basic_implementation.implementation.very_easy

object PrintHackerEarth {

  def patternStatistic(pattern: String): Map[Char, Int] = {
    pattern.foldLeft(Map.empty[Char, Int])((accum, curChar) => {
      accum + (curChar -> (accum.getOrElse(curChar, 0) + 1))
    })
  }

  def textStat(patternStatMap: Map[Char, Int], text: String) = {
    patternStatMap.keys.foldLeft(Map.empty[Char, Int])((accum, curKeyChr) => {
      val symbolCount = text.count(p => p == curKeyChr)
      accum + (curKeyChr -> accum.getOrElse(curKeyChr, symbolCount))
    })
  }

  def divideMapsAndFindMin(textMap: Map[Char, Int], patternMap: Map[Char, Int]): Int = {
    textMap.foldLeft(List.empty[Int])((accumList, curVal) => {
      accumList :+ curVal._2 / patternMap(curVal._1)
    }).min
  }

  def main(args: Array[String]): Unit = {
    val patternStatMap = patternStatistic("hackerearth")
    val textStatMap = textStat(patternStatMap, "hackerearthhackerearthh")
    val count = divideMapsAndFindMin(textStatMap, patternStatMap)
  }
}
