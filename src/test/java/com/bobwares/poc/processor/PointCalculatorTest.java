package com.bobwares.poc.processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointCalculatorTest {

    @Test
    public void test() {
        PointCalculator pointCalculator = new PointCalculator();
        int amount = 50;
        int total = pointCalculator.process(amount);
        assertEquals(0, total);

        amount = 75;
        total = pointCalculator.process(amount);
        assertEquals(25, total);


        amount = 100;
        total = pointCalculator.process(amount);
        assertEquals(50, total);

        amount = 120;
        total = pointCalculator.process(amount);
        assertEquals(90, total);

        amount = 400;
        total = pointCalculator.process(amount);
        assertEquals(650, total);
    }

}
