package very_easy

object ToggleString {
  def toggle(str: String): String = {
    str.foldLeft("")((accumulator, curSymbol) =>
      if (curSymbol.isLower) { accumulator + curSymbol.toUpper.toString }
      else  { accumulator + curSymbol.toLower.toString })
  }

  def main(args: Array[String]): Unit = {
    println(toggle("AbCdF"))
  }
}
