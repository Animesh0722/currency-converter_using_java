import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    
    private static Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 110.55);
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code");
        }

        double convertedAmount = amount * exchangeRates.get(toCurrency) / exchangeRates.get(fromCurrency);
        return convertedAmount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.print("Available currencies: ");
        for (String currency : exchangeRates.keySet()) {
            System.out.print(currency + " ");
        }
        System.out.println();

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the currency code you want to convert from: ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the currency code you want to convert to: ");
        String toCurrency = scanner.next().toUpperCase();

        try {
            double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
