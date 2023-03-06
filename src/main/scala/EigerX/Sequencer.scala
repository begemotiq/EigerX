package EigerX

import scala.annotation.tailrec
import scala.io.StdIn._
import scala.util.{Failure, Success, Try}

object Sequencer extends App {

  @tailrec
  def sequencer: (Int, Int) = {
    @tailrec
    def checkNum(numMax: Int, acc: Int): (Int, Int) = {
      println("write a number, if you want quit write 0")
      val numFromKeyboard = Try(
        readInt()
      ) // if user want to write not a num we will handle it
      numFromKeyboard match {
        case Failure(_) =>
          println("incorrect")
          checkNum(numMax, acc)
        case Success(numFromKeyboard) =>
          if (numFromKeyboard > numMax) checkNum(numFromKeyboard, 1)
          else if (numFromKeyboard != 0 && numFromKeyboard == numMax)
            checkNum(numMax, acc + 1)
          else if (numFromKeyboard != 0) checkNum(numMax, acc)
          else (numMax, acc)
      }
    }
    println("write a number, if you want quit write 0")
    val keyboardNum = Try(readInt())
    val quantity = 1
    keyboardNum match {
      case Failure(_) =>
        println("incorrect")
        sequencer
      case Success(keyboardNum) =>
        if (keyboardNum == 0) (0, 1) else checkNum(keyboardNum, quantity)
    }

  }

  println(sequencer)

}
