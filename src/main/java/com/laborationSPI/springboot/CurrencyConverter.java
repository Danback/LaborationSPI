package com.laborationSPI.springboot;

public interface CurrencyConverter {
    double convert(double amount, String fromCurrency, String toCurrency);
}

