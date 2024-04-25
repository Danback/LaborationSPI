package com.laborationSPI.springboot.fixed;


import com.laborationSPI.springboot.api.CurrencyConverter;

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
        rates.put("SEK_USD", 0.1176);
        rates.put("SEK_EUR", 0.1);
        rates.put("SEK_JPY", 12.94);
    }

    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        String key = fromCurrency.toUpperCase() + "_" + toCurrency.toUpperCase();
        Double rate = rates.get(key);
        if (rate == null) {
            throw new IllegalArgumentException("Invalid currency code or exchange rate not available.");
        }
        return rate * amount;
    }
}