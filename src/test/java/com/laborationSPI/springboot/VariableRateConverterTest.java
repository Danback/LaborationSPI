package com.laborationSPI.springboot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class VariableRateConverterTest {

    @Test
    void testConvert_randomness() {
        VariableRateConverter converter = new VariableRateConverter();
        double result1 = converter.convert(100, "USD", "EUR");
        double result2 = converter.convert(100, "USD", "EUR");
        assertFalse(result1 == result2);
    }
}
