package EigerX

import scala.annotation.tailrec
import scala.math.abs

object Recursion extends App {

  def digitSummer(digit: Long): String = {
    @tailrec
    def sum(digit: Long, acc: Long, digits: List[Long]): String = {
      if (digit % 10 == 0)
        s"${abs(acc)} ${digits.reverse.mkString("(=", "+", ")")}"
      else sum(digit / 10, acc + (digit % 10), digits :+ abs(digit % 10))

    }
    sum(digit, 0L, List.empty)
  }

  println(digitSummer(123456789))

}
