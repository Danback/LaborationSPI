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
        int choice = 0;
        while (true) {
            try {
                System.out.println("Choose a converter: 1 for fixed, 2 för variable");
                choice = scanner.nextInt();
                if (choice < 1 || choice > converterList.size()) {
                    System.out.println("Invalid option. Please choose 1 or 2.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please use numbers only.");
                scanner.next();
            }
        }

        CurrencyConverter converter = converterList.get(choice - 1);

        double amount = 0;
        while (true) {
            try {
                System.out.println("Choose an amount to convert:");
                amount = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please use numbers only.");
                scanner.next();
            }
        }

        System.out.println("Choose a currency to convert from (USD, EUR, JPY):");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.println("Choose a currency to convert to (USD, EUR, JPY):");
        String toCurrency = scanner.next().toUpperCase();

        try {
            double result = converter.convert(amount, fromCurrency, toCurrency);
            System.out.printf("Result: %.2f %s%n", result, toCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong: " + e.getMessage());
        }
    }
}
