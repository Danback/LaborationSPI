package com.laborationSPI.springboot;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<CurrencyConverter> converters = ServiceLoader.load(CurrencyConverter.class);
        List<CurrencyConverter> converterList = new ArrayList<>();
        converters.forEach(converterList::add);

        if (converterList.isEmpty()) {
            System.out.println("No converters found. Check your META-INF/services configuration.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = 0;
            while (true) {
                try {
                    System.out.println("Choose a converter: 1 for fixed, 2 for variable");
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > converterList.size()) {
                        System.out.println("Invalid choice. Please choose 1 or 2.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Use numbers only.");
                    scanner.next();
                }
            }

            CurrencyConverter converter = converterList.get(choice - 1);

            double amount = 0;
            while (true) {
                try {
                    System.out.println("Enter the amount to convert:");
                    amount = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Enter the amount as a number.");
                    scanner.next();
                }
            }

            System.out.println("Enter the currency to convert from (USD, EUR, JPY, SEK):");
            String fromCurrency = scanner.next().toUpperCase();

            System.out.println("Enter the currency to convert to (USD, EUR, JPY, SEK):");
            String toCurrency = scanner.next().toUpperCase();


            try {
                double result = converter.convert(amount, fromCurrency, toCurrency);
                System.out.printf("Result: %.2f %s%n", result, toCurrency);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }


            System.out.println("Do you want to convert another amount? (yes/no)");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
