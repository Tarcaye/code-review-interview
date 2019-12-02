package io.shodo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasketInformationsTest {

    @BeforeEach
    void setUp() {
        new BasketInformations().resetBasket();
    }

    @Test
    void a_new_basket_is_empty() {
        assertThat(new BasketInformations().getBasketPrice(false)).isEqualTo(0L);
    }

    @Test
    void basket_should_contain_added_product() {
        BasketInformations basketInformations = new BasketInformations();
        basketInformations
                .addProductToBasket("Carrot", 1, false);
        assertThat(basketInformations.isBasketContains("Carrot")).isTrue();
    }

    @Test
    void basket_with_promo_code_have_100€_discount() {
        BasketInformations basketInformations = new BasketInformations();
        basketInformations.addProductToBasket(null, null, true);
        basketInformations.addProductToBasket("Shiitake", 100, false);
        assertThat(basketInformations.getBasketPrice(false)).isEqualTo(0L);
    }

    @Test
    void the_price_of_the_basket_is_the_sum_of_the_price_of_the_products() {
        BasketInformations basketInformations = new BasketInformations();
        basketInformations.addProductToBasket("Chocolate", 2, false);
        basketInformations.addProductToBasket("Shiitake", 100, false);
        assertThat(basketInformations.getBasketPrice(false)).isEqualTo(102L);
    }

    @Test
    void the_price_of_the_basket_in_cents_is_the_sum_of_the_price_of_the_products() {
        BasketInformations basketInformations = new BasketInformations();
        basketInformations.addProductToBasket("Chocolate", 2, false);
        basketInformations.addProductToBasket("Shiitake", 100, false);
        assertThat(basketInformations.getBasketPrice(true)).isEqualTo(10200L);
    }

    @Test
    void adding_two_baskets_is_the_sum_of_the_baskets() {
        BasketInformations basketToAdd = new BasketInformations();
        basketToAdd.addProductToBasket("Tofu", 20, false);
        basketToAdd.addProductToBasket("Water", 1000, false);

        BasketInformations basketInformations = new BasketInformations();
        basketInformations.addProductToBasket("Chocolate", 2, false);
        basketInformations.addProductToBasket("Shiitake", 100, false);
        basketInformations.mixWithBasket(basketToAdd);

        assertThat(basketInformations.getBasketPrice(false)).isEqualTo(1122L);
    }

    @Test
    @Disabled("To be fixed")
    void baskets_should_be_independent() {
        new BasketInformations()
                .addProductToBasket("Seitan", 1, false);
        assertThat(new BasketInformations().isBasketContains("Seitan")).isFalse();
    }

    @Test
    @Disabled("to be fixed")
    void basket_should_contain_added_product_even_when_names_are_not_the_same_instance() {
        BasketInformations basketInformations = new BasketInformations();
        basketInformations
                .addProductToBasket(new String("Tofu"), 1, false);
        assertThat(basketInformations.isBasketContains("Tofu")).isTrue();
    }

    @Test
    @Disabled("to be fixed")
    void can_contain_the_same_product_multiple_times() {
        BasketInformations basketInformations = new BasketInformations();
        basketInformations.addProductToBasket("Tofu", 20, false);
        basketInformations.addProductToBasket("Tofu", 20, false);
        assertThat(basketInformations.getBasketPrice(false)).isEqualTo(40L);
    }

    @Test
    @Disabled("to be fixed")
    void total_price_should_not_be_negative() {
        BasketInformations basketInformations = new BasketInformations();
        basketInformations.addProductToBasket("Tofu", 20, false);
        basketInformations.addProductToBasket(null, null, true);
        assertThat(basketInformations.getBasketPrice(false)).isEqualTo(0L);
    }
}