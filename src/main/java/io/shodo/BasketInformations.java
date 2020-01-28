package io.shodo;

import java.util.HashMap;

/**
 * Created by thomas on 28/01/2020.
 * This class is a basket
 */
public class BasketInformations {

    // The product of the basket
    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    // The fact that the basket has promo code
    private static boolean codeDePromotion = false;

    public void addProductToBasket(String product, Integer price, boolean isPromoCode) {
        if (isPromoCode) {
            codeDePromotion = true;
        } else {
            map.put(product, price);
        }
    }

    public Long getBasketPrice(boolean inCents) {
        Integer v = 0;
        for (String s : map.keySet()) {
            v += map.get(s);
        }
        if (codeDePromotion) {
            v -= 100;
        }
        return inCents ? v * 100 : Long.valueOf(v);
    }

    public void resetBasket() {
        buyBasket();
        codeDePromotion = false;
    }

    public void buyBasket() {
        map.clear();
    }

    public boolean isBasketContains(String produit) {
        boolean found = false;
        for (String s : map.keySet()) {
            if (s == produit) found = true;
        }
        return found;
    }

    public void mixWithBasket(BasketInformations b) {
        map.putAll(b.map);
    }
}
