package Prices

import EigerX.Recursion.digitSummer
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class Recursion extends AnyFreeSpec with Matchers {

  "Check summer" - {
    "task case" in { digitSummer(2347623) should be("27 (=2+3+4+7+6+2+3)") }
    "case with negative digit" in { digitSummer(-987656781) should be("57 (=9+8+7+6+5+6+7+8+1)")}
  }

}
