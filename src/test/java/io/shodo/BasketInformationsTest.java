package io.shodo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BasketInformationsTest {

    @Test
    void a_new_basket_is_empty() {
        assertThat(new BasketInformations().getMap()).isEmpty();
    }

    @Test
    @Disabled("To be fixed")
    void baskets_should_be_independant() {
        new BasketInformations()
                .addProductToBasket("Seitan", 1, false);
        assertThat(new BasketInformations().getMap()).isEmpty();
    }
}