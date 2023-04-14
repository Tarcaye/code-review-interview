import unittest
from basket_informations import BasketInformations


class TestBasketInformations(unittest.TestCase):
    def setUp(self):
        self.basket = BasketInformations()

    def test_a_basket_should_cost_0_when_empty(self):
        self.assertEqual(self.basket.get_basket_price(False), 0)

    def test_1000_otherwise(self):
        self.basket.add_product_to_basket("product", 1000, False)
        self.assertEqual(self.basket.get_basket_price(False), 1000)