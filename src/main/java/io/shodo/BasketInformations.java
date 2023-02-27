package src.main.java.io.shodo;

import java.util.HashMap;

/**
 * Created by thomas on 02/12/2019.
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
}
