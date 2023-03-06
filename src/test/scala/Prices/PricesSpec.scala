package Prices

import EigerX.Prices.priceCheck
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class PricesSpec extends AnyFreeSpec with Matchers {

  "Check Price" - {
    "first case" in {
      priceCheck(
        List("eggs", "coke", "fanta", "crisps", "bread"),
        List(2.12, 3.41, 2.99, 1.99, 1.00),
        List("coke", "crisps", "bread"),
        List(3.41, 3.99, 1.1)
      ) should be(2)
    }
    "second case" in {
      priceCheck(
        List("eggs", "coke", "fanta", "crisps", "bread"),
        List(2.12, 3.41, 2.99, 1.99, 1.00),
        List("coke", "crisps", "bread"),
        List(3.41, 1.99, 1.0)
      ) should be(0)
    }
    "case from task" in {
      priceCheck(
        List("rice", "sugar", "wheat", "cheese"),
        List(16.89, 56.92, 20.89, 345.99),
        List("rice", "cheese"),
        List(18.99, 400.89)
      ) should be(2)
    }
  }
}
