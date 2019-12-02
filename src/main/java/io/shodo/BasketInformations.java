package io.shodo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thomas on 02/12/2019.
 * This class is a basket
 */
public class BasketInformations {

    private Map<String, Integer> products = new HashMap<>();

    private boolean codeDePromotion = false;

    public void addProductToBasket(String product, Integer price, boolean isPromoCode) {
        if (isPromoCode) {
            codeDePromotion = true;
        } else {
            products.put(product, price);
        }
    }

    public Long getBasketPrice(boolean inCents) {
        Integer v = 0;
        for (String s : products.keySet()) {
            v += products.get(s);
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
        products.clear();
    }

    public boolean isBasketContains(String produit) {
        boolean found = false;
        for (String s : products.keySet()) {
            if (s == produit) found = true;
        }
        return found;
    }

    public void mixWithBasket(BasketInformations b) {
        products.putAll(b.products);
    }
}
