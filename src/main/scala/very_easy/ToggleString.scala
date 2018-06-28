package very_easy

object ToggleString {
  def toggle(str: String): String = {
    str.foldLeft("")((accumulator, curSymbol) =>
      if (curSymbol.isLower) accumulator + curSymbol.toUpper else accumulator + curSymbol.toLower)
  }

  def toggleOptimized(str: String): String = { str.foldLeft(new StringBuilder)((stringBuilder, curValue) =>
    if (curValue.isLower) stringBuilder append curValue.toUpper
    else stringBuilder append curValue.toLower).mkString
  }

  def main(args: Array[String]): Unit = {
    println(toggleOptimized("AbCdF"))
  }
}
