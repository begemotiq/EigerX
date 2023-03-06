package EigerX

object Prices extends App {

  val products: Seq[String] = Seq("cheese", "soda", "crisps")
  val productPrices: Seq[Double] =
    Seq(321.29, 99.9, 124.51).filter(x => x > 1 & x < 1000)
  val productSold: Seq[String] = Seq("soda", "cheese", "crisps")
  val soldPrice: Seq[Double] =
    Seq(101.1, 321.99, 124.51).filter(x => x > 1 & x < 1000)

  if (
    products.lengthCompare(productPrices) != 0 ||
    productSold.lengthCompare(soldPrice) != 0
  ) throw new Exception("Not Enough Products or Prices")

  if (
    products.isEmpty || productSold.isEmpty || productSold.length > 99 || products.length > 99
  ) throw new Exception("Too much products")

  def priceCheck(
      products: List[String],
      productPrices: List[Double],
      productSold: List[String],
      soldPrice: List[Double]
  ): Int = {
    val productPriceMap = products.zip(productPrices).toMap
    val soldPriceProductMap = productSold.zip(soldPrice).toMap

    soldPriceProductMap
      .map(x =>
        productPriceMap.get(x._1) match {
          case Some(value) => x._2 == value
          case None        => false
        }
      )
      .count(_ == false)

  }
}
