package com.laborationSPI.springboot;

import java.util.HashMap;
import java.util.Map;

public class FixedRateConverter implements CurrencyConverter {
    private Map<String, Double> rates = new HashMap<>();

    public FixedRateConverter() {

        rates.put("USD_SEK", 8.5);
        rates.put("EUR_SEK", 10.0);
        rates.put("USD_EUR", 0.9);
        rates.put("EUR_USD", 1.1);
        rates.put("USD_JPY", 110.0);
        rates.put("JPY_USD", 0.0091);
        rates.put("EUR_JPY", 130.0);
        rates.put("JPY_EUR", 0.0077);
    }

    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        String key = fromCurrency.toUpperCase() + "_" + toCurrency.toUpperCase();
        Double rate = rates.get(key);
        if (rate == null) {
            throw new IllegalArgumentException("Currency not available.");
        }
        return rate * amount;
    }
}