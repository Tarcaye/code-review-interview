package io.shodo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasketInformationsTest {

    @Test
    void a_new_basket_is_empty() {
        assertThat(new BasketInformations().getBasketPrice(false)).isEqualTo(0L);
    }

    @Test
    @Disabled("To be fixed")
    void baskets_should_be_independant() {
        new BasketInformations()
                .addProductToBasket("Seitan", 1, false);
        assertThat(new BasketInformations().isBasketContains("Seitan")).isFalse();
    }

    @Test
    void basket_should_contain_added_product() {
        BasketInformations basketInformations = new BasketInformations();
        basketInformations
                .addProductToBasket("Carrot", 1, false);
        assertThat(basketInformations.isBasketContains("Carrot")).isTrue();
    }

    @Test
    @Disabled("to be fixed")
    void basket_should_contain_added_product_even_when_names_are_not_the_same_instance() {
        BasketInformations basketInformations = new BasketInformations();
        basketInformations
                .addProductToBasket(new String("Tofu"), 1, false);
        assertThat(basketInformations.isBasketContains("Tofu")).isTrue();
    }
}