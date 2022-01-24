const K = "K";

/**
 * Created by thomas on 02/12/2019.
 * This class is a basket
 */

export class BasketInformations {
    // The product of the basket
    static map: Map<string, number> = new Map<string, number>()

    // The fact that the basket has promo code
    static codeDePromotion: boolean = false


    addProductToBasket(product: string, price: number, promoCode: boolean = false) {
        if (promoCode) {
            BasketInformations.codeDePromotion = true
        } else {
            BasketInformations.map.set(product, price)
        }
    }

    getBasketPrice(inCents: boolean): Number {
        var v = 0;
        for (let s of Array.from(BasketInformations.map.values())) {
            v += s;
        }
        if (BasketInformations.codeDePromotion) {
            v -= 100;
        }
        return inCents ? new Number(v * 100) : Number(v)
    }

    resetBasket() {
        this.buyBasket();
        BasketInformations.codeDePromotion = false;
    }

    buyBasket() {
        BasketInformations.map.clear();
    }

    isBasketContains(produit: string): boolean {
        var found: boolean = false;
        for (let s of Array.from(BasketInformations.map.keys())) {
            if (s == produit) found = true;
        }
        return found;
    }


    mixWithBasket(b: BasketInformations) {
        for (let [s,z] of Array.from(BasketInformations.map)) {
            BasketInformations.map.set(s,z)
        }
    }
}
