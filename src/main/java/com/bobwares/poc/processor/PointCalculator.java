package com.bobwares.poc.processor;

public class PointCalculator {
    public int process(int amount) {
        if (amount <= 50 ) {
            return 0;
        }
        if (amount <= 100) {
            return (amount - 50) * 1;
        }
        return 50 + ((amount - 100) * 2);
    }
}
