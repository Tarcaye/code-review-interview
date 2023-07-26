import scala.collection.mutable.HashMap

class BasketInformations {
  // The product of the basket
  val map: HashMap[String, Int] = HashMap()

  def addProductToBasket(product: String, price: Int): Unit = {
    map += (product -> price)
  }

  def getBasketPrice(inCents: Boolean): Long = {
    var v: Int = 0
    for (s <- map.values) {
      v += s
    }
    if (inCents) {
      v * 100
    } else {
      v.toLong
    }
  }

  def resetBasket(): Unit = {
    buyBasket()
  }

  def buyBasket(): Unit = {
    map.clear()
  }

  def isBasketContains(produit: String): Boolean = {
    var found = false
    for (s <- map.keys) {
      if (s == produit) {
        found = true
      }
    }
    found
  }

  def mixWithBasket(b: BasketInformations): Unit = {
    map ++= b.map
  }
}
