package basic_implementation.input_output.easy

object TwoStrings {
  def isStringsIdentical(str1: String, str2: String): Boolean = {
    if (str1.length == str2.length) isMapsEqual(statisticMap(str1), statisticMap(str2)) else false
  }

  def isMapsEqual(map1: Map[Char, Int], map2: Map[Char, Int]): Boolean = {
    map1.foldLeft(true)((acc, curVal) => if (map2(curVal._1) != curVal._2) acc && false else acc && true)
  }

  def statisticMap(str: String): Map[Char, Int] = {
    str.foldLeft(Map.empty[Char, Int])((map, key) => map + (key -> (map.getOrElse(key, 0) + 1)))
  }

  def main(args: Array[String]): Unit = {
    println(isStringsIdentical("tpo","opt"))
  }
}
