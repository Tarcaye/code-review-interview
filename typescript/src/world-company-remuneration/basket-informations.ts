const K = "K";

/**
 * Created by thomas on 02/12/2019.
 * This class is a basket
 */

export class BasketInformations {
    // The product of the basket
    static map: Map<string, number> = new Map<string, number>()

    addProductToBasket(product: string, price: number) {
        BasketInformations.map.set(product, price)
    }

    getBasketPrice(inCents: boolean): Number {
        var v = 0;
        for (let s of Array.from(BasketInformations.map.values())) {
            v += s;
        }
        return inCents ? new Number(v * 100) : Number(v)
    }

    resetBasket() {
        this.buyBasket();
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
