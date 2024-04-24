package com.laborationSPI.springboot;

public class VariableRateConverter implements CurrencyConverter {
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return amount * (Math.random() * 5 + 5);
    }
}
