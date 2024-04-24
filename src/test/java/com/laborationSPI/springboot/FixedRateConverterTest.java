package com.laborationSPI.springboot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FixedRateConverterTest {
    private FixedRateConverter converter;

    @BeforeEach
    void setUp() {
        converter = new FixedRateConverter();
    }

    @Test
    void testConvert_validCurrencies() {
        assertEquals(850, converter.convert(100, "USD", "SEK"), 0.01);
        assertEquals(110, converter.convert(100, "EUR", "USD"), 0.01); // Justerat till rätt förväntat värde
    }


    @Test
    void testConvert_invalidCurrencies() {
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(100, "USD", "XYZ");
        });
    }
}
