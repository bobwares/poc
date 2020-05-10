package com.bobwares.poc.domain;

import org.junit.jupiter.api.Test;
import com.bobwares.poc.test.ResourceLoader;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    @Test
    public void test() {
        final Purchase purchase = Purchase.builder().customerId("1").amount(50).build();
        assertAll(
                () -> assertEquals("1", purchase.getCustomerId()),
                () -> assertEquals(50, purchase.getAmount())
        );
    }
    @Test
    public void testDeserialization() {
        final Purchase purchase = ResourceLoader.load("purchase.json", Purchase.class);

        assertAll(
                () -> assertEquals("1", purchase.getCustomerId()),
                () -> assertEquals(50, purchase.getAmount())
        );
    }
}