package com.laborationSPI.springboot.api;

public interface CurrencyConverter {
    double convert(double amount, String fromCurrency, String toCurrency);
}

