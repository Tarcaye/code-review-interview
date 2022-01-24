import {BasketInformations} from "../../src/world-company-remuneration/basket-informations";

describe("a basket should cost", () => {

    test("0 when empty", () => {
        expect(new BasketInformations().getBasketPrice(false)).toBe(0);
    });

    test("1000 otherwise", () => {
        let basketInformations = new BasketInformations();
        basketInformations.resetBasket()
        basketInformations.addProductToBasket("Toto", 1000) // Promo = false
        expect(basketInformations.getBasketPrice(false)).toBe(1000);
    });

});
