package basic_implementation.input_output.medium

object MagicalNumber {
  def isNumberPrime(number: Int): Boolean = {
    val rez = (1 to number).foldLeft(0)((accumulator, curValue) =>
      if (number % curValue == 0) accumulator + 1 else accumulator)

    rez == 2
  }

  def calcDefaultValueImperative(str: String, chr: Char): Int = {
    var codePoint = chr.toString.codePointAt(0)
    var isPrime = false
    if (str.count(_ == chr) > 1) {
      while (!isPrime && codePoint > 0) {
        codePoint = codePoint - 1
        if (isNumberPrime(codePoint)) isPrime = true
        if (codePoint == 0) codePoint = -1
      }
    } else {
      while (!isPrime && codePoint < 256) {
        codePoint = codePoint + 1
        if (isNumberPrime(codePoint)) isPrime = true
        if (codePoint == 255) codePoint = -1
      }
    }

    codePoint
  }

  def calcDefaultValueFunctional(str: String, chr: Char): Int = {
    val codePoint = chr.toString.codePointAt(0)
    if (str.count(_ == chr) > 1) ((codePoint - 1) to 1 by -1).find(i => isNumberPrime(i)).getOrElse(-1)
    else ((codePoint + 1) to 255).find(i => isNumberPrime(i)).getOrElse(-1)
  }

  def mapSymbolToMagicMap(str: String): Map[Char, Int] = {
    str.foldLeft(Map.empty[Char, Int])((map, curVal) => {
      map + (curVal -> map.getOrElse(curVal, calcDefaultValueFunctional(str, curVal)))
    })
  }

  def mapSymbolFromMapToAlphabet(str: String): String = {
    val map = mapSymbolToMagicMap(str)
    str.foldLeft("")((accumulator, curChr) => accumulator + map(curChr).toChar.toString)
  }

  def main(args: Array[String]): Unit = {
    println(mapSymbolFromMapToAlphabet("AFREEN"))
  }
}
