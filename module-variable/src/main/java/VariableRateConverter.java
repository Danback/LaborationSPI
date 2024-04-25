import com.laborationSPI.springboot.api.CurrencyConverter;

public class VariableRateConverter implements CurrencyConverter {
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return amount * (Math.random() * 5 + 5);
    }
}
