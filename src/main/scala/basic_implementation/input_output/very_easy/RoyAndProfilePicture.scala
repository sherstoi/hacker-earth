package basic_implementation.input_output.very_easy

object RoyAndProfilePicture {
  def calcDimension(l: Int, w: Int, h: Int): String = {
    if (w > l && h > l) { if (w == h) { "ACCEPTED" } else { "CROP IT" } }
    else if (w < l || h < l) { "UPLOAD ANOTHER" }
    else { "UNKNOWN" }
  }

  def main(args: Array[String]): Unit = {
    println(calcDimension(12, 13, 12))
  }
}
