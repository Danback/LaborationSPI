module com.laborationSPI.springboot.variable {
    requires com.laborationSPI.springboot.api;
    provides com.laborationSPI.springboot.api.CurrencyConverter with com.laborationSPI.springboot.variable.VariableRateConverter;
}