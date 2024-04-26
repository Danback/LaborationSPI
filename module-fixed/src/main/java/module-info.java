module com.laborationSPI.springboot.fixed {
    requires com.laborationSPI.springboot.api;
    exports com.laborationSPI.springboot.fixed;
    provides com.laborationSPI.springboot.api.CurrencyConverter with com.laborationSPI.springboot.fixed.FixedRateConverter;
}
