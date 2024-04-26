module com.laborationSPI.springboot.main {
    requires com.laborationSPI.springboot.api;
    requires com.laborationSPI.springboot.fixed;
    requires com.laborationSPI.springboot.variable;
    uses com.laborationSPI.springboot.api.CurrencyConverter;
}