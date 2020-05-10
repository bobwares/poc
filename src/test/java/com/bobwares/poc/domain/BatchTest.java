package com.bobwares.poc.domain;

import com.bobwares.poc.test.ResourceLoader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BatchTest {

    @Test
    public void test() {
        List<Purchase> purchaseList = new ArrayList<>();

        final Purchase purchase = Purchase.builder().customerId("1").amount(50).build();
        purchaseList.add(purchase);

        final Batch purchases = Batch.builder().purchases(purchaseList).build();
        assertAll(
                () -> assertEquals(1, purchases.getPurchases().size()),
                () -> assertEquals(50, purchases.getPurchases().get(0).getAmount())
        );
    }
    @Test
    public void testDeserialization() {
        final Batch purchases = ResourceLoader.load("purchases.json", Batch.class);

        assertAll(
                () -> assertEquals(1, purchases.getPurchases().size()),
                () -> assertEquals(50, purchases.getPurchases().get(0).getAmount())
        );
    }
}