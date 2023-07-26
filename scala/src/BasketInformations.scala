import scala.collection.mutable.HashMap

class BasketInformations {
  // The product of the basket
  val map: HashMap[String, Int] = HashMap()

  // The fact that the basket has promo code
  private var codeDePromotion: Boolean = false

  def addProductToBasket(product: String, price: Int, isPromoCode: Boolean): Unit = {
    if (isPromoCode) {
      codeDePromotion = true
    } else {
      map += (product -> price)
    }
  }

  def getBasketPrice(inCents: Boolean): Long = {
    var v: Int = 0
    for (s <- map.values) {
      v += s
    }
    if (codeDePromotion) {
      v -= 100
    }
    if (inCents) {
      v * 100
    } else {
      v.toLong
    }
  }

  def resetBasket(): Unit = {
    buyBasket()
    codeDePromotion = false
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
