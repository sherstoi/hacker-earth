package very_easy

object Anagrams {
  def findCommonChars(firstStr: String, secStr: String): String = {
    val commonStr = firstStr intersect secStr
    commonStr.distinct
  }

  def countCharToMap(str: String): Map[Char, Int] = {
    str.foldLeft(Map.empty[Char, Int])((map, key) => {map + (key -> (map.getOrElse(key, 0) + 1))})
  }

  def getAnnagrams(firstStr: String, secStr: String): String = {
    val map1 = countCharToMap(firstStr.toLowerCase)
    val map2 = countCharToMap(secStr.toLowerCase)
    val commonStr = findCommonChars(firstStr.toLowerCase, secStr.toLowerCase)

    val rezMap = commonStr.foldLeft(Map.empty[Char, String])((map, key) => {
      val val1 = map1(key); val val2 = map2(key)
      if (val1 >= val2) { map + (key -> key.toString * val2) }
      else {map + (key -> key.toString * val1)}
    })

    rezMap.map{case (key, value) => s"$value"}.mkString
  }

  def main(args: Array[String]): Unit = {
    val t = getAnnagrams("abbc", "bbbhga")
    println(t)
  }
}
