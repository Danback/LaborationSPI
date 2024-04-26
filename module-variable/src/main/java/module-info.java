module com.laborationSPI.springboot.variable {
    requires com.laborationSPI.springboot.api;
    exports com.laborationSPI.springboot.variable;
    provides com.laborationSPI.springboot.api.CurrencyConverter with com.laborationSPI.springboot.variable.VariableRateConverter;
}
