class BasketInformations:
    # The product of the basket
    map = {}

    # The fact that the basket has promo code
    code_de_promotion = False

    def add_product_to_basket(self, product, price, is_promo_code):
        if is_promo_code:
            BasketInformations.code_de_promotion = True
        else:
            BasketInformations.map[product] = price

    def get_basket_price(self, in_cents):
        v = 0
        for s in BasketInformations.map.values():
            v += s
        if BasketInformations.code_de_promotion:
            v -= 100
        return v * 100 if in_cents else Long(v)

    def reset_basket(self):
        self.buy_basket()
        BasketInformations.code_de_promotion = False

    def buy_basket(self):
        BasketInformations.map.clear()

    def is_basket_contains(self, produit):
        found = False
        for s in BasketInformations.map.keys():
            if s == produit:
                found = True
                break
        return found

    def mix_with_basket(self, b):
        BasketInformations.map.update(b.map)
