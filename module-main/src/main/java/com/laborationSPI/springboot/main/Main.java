package com.laborationSPI.springboot.main;

import java.util.*;
import com.laborationSPI.springboot.api.CurrencyConverter;


public class Main {
    public static void main(String[] args) {
        ServiceLoader<CurrencyConverter> serviceLoader = ServiceLoader.load(CurrencyConverter.class);
        List<CurrencyConverter> converterList = new ArrayList<>();
        serviceLoader.iterator().forEachRemaining(converterList::add);

        if (converterList.isEmpty()) {
            System.out.println("No converters found. Check your META-INF/services configuration.");
            return;
        } else {
            System.out.println("Available converters:");
            converterList.forEach(converter -> System.out.println(converter.getClass().getName()));
        }

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Choose a converter: 1 for fixed, 2 for variable");
                int choice = readInt(scanner);

                if (choice < 1 || choice > converterList.size()) {
                    System.out.println("Invalid choice. Please choose 1 or 2.");
                    continue;
                }

                CurrencyConverter converter = converterList.get(choice - 1);

                System.out.println("Enter the amount to convert:");
                double amount = readDouble(scanner);

                System.out.println("Enter the currency to convert from (USD, EUR, JPY, SEK):");
                String fromCurrency = scanner.next().toUpperCase();

                System.out.println("Enter the currency to convert to (USD, EUR, JPY, SEK):");
                String toCurrency = scanner.next().toUpperCase();

                double result = converter.convert(amount, fromCurrency, toCurrency);
                System.out.printf("Result: %.2f %s%n", result, toCurrency);

                System.out.println("Do you want to convert another amount? (yes/no)");
                if (!scanner.next().trim().equalsIgnoreCase("yes")) {
                    System.out.println("Goodbye!");
                    break;
                }
            }
        }
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Invalid input. Use numbers only.");
        }
        return scanner.nextInt();
    }

    private static double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println("Invalid input. Enter the amount as a number.");
        }
        return scanner.nextDouble();
    }
}
