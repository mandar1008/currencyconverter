import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverterr {
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    private static final Map<String, String> countryNames = new HashMap<>();

    private static void initializeRates() {
        exchangeRates.put("USD", 0.012);  countryNames.put("USD", "United States Dollar");
        exchangeRates.put("EUR", 0.011);  countryNames.put("EUR", "Euro (European Union)");
        exchangeRates.put("GBP", 0.0097); countryNames.put("GBP", "British Pound Sterling");
        exchangeRates.put("AUD", 0.018);  countryNames.put("AUD", "Australian Dollar");
        exchangeRates.put("CAD", 0.016);  countryNames.put("CAD", "Canadian Dollar");
        exchangeRates.put("SGD", 0.016);  countryNames.put("SGD", "Singapore Dollar");
        exchangeRates.put("CHF", 0.011);  countryNames.put("CHF", "Swiss Franc");
        exchangeRates.put("JPY", 1.67);   countryNames.put("JPY", "Japanese Yen");
        exchangeRates.put("CNY", 0.089);  countryNames.put("CNY", "Chinese Yuan");
        exchangeRates.put("AED", 0.044);  countryNames.put("AED", "United Arab Emirates Dirham");
        exchangeRates.put("SAR", 0.045);  countryNames.put("SAR", "Saudi Riyal");
        exchangeRates.put("NZD", 0.019);  countryNames.put("NZD", "New Zealand Dollar");
        exchangeRates.put("HKD", 0.094);  countryNames.put("HKD", "Hong Kong Dollar");
        exchangeRates.put("ZAR", 0.22);   countryNames.put("ZAR", "South African Rand");
        exchangeRates.put("KRW", 15.0);   countryNames.put("KRW", "South Korean Won");
        exchangeRates.put("MYR", 0.057);  countryNames.put("MYR", "Malaysian Ringgit");
        exchangeRates.put("THB", 0.42);   countryNames.put("THB", "Thai Baht");
        exchangeRates.put("RUB", 0.90);   countryNames.put("RUB", "Russian Ruble");
        exchangeRates.put("BRL", 0.062);  countryNames.put("BRL", "Brazilian Real");
        exchangeRates.put("MXN", 0.21);   countryNames.put("MXN", "Mexican Peso");
    }

    public static double convertFromINR(double amount, String currencyCode) {
        if (exchangeRates.containsKey(currencyCode)) {
            return amount * exchangeRates.get(currencyCode);
        } else {
            System.out.println("Currency not available for conversion.");
            return 0;
        }
    }

    public static void main(String[] args) {
        initializeRates();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount in Indian Rupee: ");
        double amountInINR = scanner.nextDouble();

        System.out.println("Select the target currency code from the following list:");
        for (String currencyCode : exchangeRates.keySet()) {
            System.out.printf("%-5s - %s%n", currencyCode, countryNames.get(currencyCode));
        }

        System.out.print("Enter target currency code: ");
        String targetCurrency = scanner.next().toUpperCase();

        double convertedAmount = convertFromINR(amountInINR, targetCurrency);
        if (convertedAmount > 0) {
            System.out.printf("%.2f Indian Rupee = %.2f %s (%s)%n",
                    amountInINR,
                    convertedAmount,
                    targetCurrency,
                    countryNames.get(targetCurrency));
        }

        scanner.close();
    }
}
