module com.laborationSPI.springboot.fixed {
    requires com.laborationSPI.springboot.api;
    provides com.laborationSPI.springboot.api.CurrencyConverter with com.laborationSPI.springboot.fixed.FixedRateConverter;
}