package io.shodo;

import java.util.HashMap;

/**
 * Created by thomas on 28/01/2020.
 * This class is a basket
 */
public class BasketInformations {

    // The product of the basket
    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public void addProductToBasket(String product, Integer price) {
            map.put(product, price);
    }

    public Long getBasketPrice(boolean inCents) {
        Integer v = 0;
        for (String s : map.keySet()) {
            v += map.get(s);
        }
        return inCents ? v * 100 : Long.valueOf(v);
    }

    public void resetBasket() {
        buyBasket();
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
