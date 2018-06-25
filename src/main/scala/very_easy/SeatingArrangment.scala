package very_easy

object SeatingArrangment {
  // stream approach
  val windowSeats: Stream[Int] = 1 #:: windowSeats.zipWithIndex.scanLeft(6)((a, b) => if (b._2 % 2 == 0) { a + 1 } else { a + 5 })
  val aisleSeats: Stream[Int] = 3 #:: aisleSeats.zipWithIndex.scanLeft(4)((a, b) => if (b._2 % 2 != 0) { a + 1 } else { a + 5 })
  val middleSeats: Stream[Int] = 2 #:: middleSeats.scanLeft(5)((a, b) => a + 3)

  // non stream approach...
  def generateWindowSeat(limitSeatsNumber: Int): List[Int] = {
    List.fill(limitSeatsNumber)(0).zipWithIndex.scanLeft(1)((a, b) => if (b._2 % 2 != 0) { a + 1 } else { a + 5 })
  }

  def generateMiddleSeat(limitSeatsNumber: Int): List[Int] = {
    List.fill(limitSeatsNumber)(0).scanLeft(2)((a, b) => a + 3)
  }

  def mapWeights(startFrom: Int, endTo: Int, addFrom: Int): Map[Int, Int] = {
    var map = Map.empty[Int, Int]
    var minusVal = addFrom
    for (i <- startFrom to endTo) {
      map += (i -> minusVal)
      minusVal = minusVal - 2
    }

    map
  }

  def mapWeightsFunctional(startEle: Int, endEle: Int, startSubsEle: Int, valueToSubs: Int): Map[Int, Int] = {
    var value = startSubsEle + valueToSubs
    (startEle to endEle).foldLeft(Map.empty[Int, Int])((map, key) => { value = value - valueToSubs; map + (key -> value) })
  }

  def findInterval(randNum: Int): (Int, Int) = {
    val remain = (randNum / 13) + 1
    val max = remain * 12

    (max - 11, max)
  }

  def findOppositeElement(digit: Int): Int = {
    val interval = findInterval(digit)
    val matchMap = mapWeightsFunctional(interval._1, interval._2, 11, 2)
    matchMap(digit) + digit
  }

  def identifySeatType(digit: Int): String = {
    if (windowSeats.contains(digit)) {"Window"}
    else if(middleSeats.contains(digit)) {"Middle"}
    else {"Aisle"}
  }

  def main(args: Array[String]): Unit = {
    val seat = 36
    println("Opposite for " + seat + "-" + findOppositeElement(36))
    println("Seat type - " + identifySeatType(36))
  }

}