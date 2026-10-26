package practice05;

import java.util.Scanner;

public class Task1DailySales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        double[] sales = new double[7];

        double total = 0;

        System.out.println("=== ФІНАНСОВИЙ ЗВІТ КАВ'ЯРНІ ЗА ТИЖДЕНЬ ===");

        for (int i = 0; i < sales.length; i++) {
            System.out.print("Введіть виторг за " + days[i] + " (грн): ");
            sales[i] = scanner.nextDouble();
            total += sales[i];
        }

        double average = total / sales.length;

        double maxSale = sales[0];
        double minSale = sales[0];

        String bestDay = days[0];
        String worstDay = days[0];

        for (int i = 1; i < sales.length; i++) {

            if (sales[i] > maxSale) {
                maxSale = sales[i];
                bestDay = days[i];
            }

            if (sales[i] < minSale) {
                minSale = sales[i];
                worstDay = days[i];
            }
        }

        System.out.println();
        System.out.println("----- ПІДСУМКИ -----");

        System.out.println("Загальний тижневий виторг: " + total + " грн");
        System.out.println("Середній виторг на день: " + average + " грн");

        System.out.println("Найкращий день: " + bestDay + " (" + maxSale + " грн)");
        System.out.println("Найгірший день: " + worstDay + " (" + minSale + " грн)");

        System.out.println();
        System.out.println("Дні з виторгом вище середнього:");

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > average) {
                System.out.println("- " + days[i] + ": " + sales[i] + " грн");
            }
        }
        scanner.close();

    }


}
