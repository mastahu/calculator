package it.morfoza.calculator;

import org.springframework.stereotype.Component;

@Component
public class StandardCalculator implements Calculator {

    @Override
    public long add(long a, long b) {
        return a + b;
    }

    @Override
    public long subtract(long a, long b) {
        return a - b;
    }

    @Override
    public long multiply(long a, long b) {
        return a * b;
    }

    @Override
    public long divide(long a, long b) {
        return a / b;
    }
}
