package practice04.homework;

import java.util.Scanner;

public class Task1RangeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== АНАЛІЗАТОР ДІАПАЗОНУ ЧИСЕЛ ===:");
       int n;
        do {
           System.out.println(" Введіть число N:");
           n = scanner.nextInt();
           if (n <= 0) {
               System.out.println("Помилка: N має бути більшим за 0!");
           }

       }while (n <= 0);

        int totalsum = 0;
        int evensum = 0;
        int oddsum = 0;
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 1; i <= n; i++) {
            totalsum += i;
            if (i % 2 == 0) {
                evensum += i;
                evenCount++;

            }else {
                oddsum += i;
                oddCount++;
            }
        }
        double average = (double) totalsum / n;
        average = Math.round(average * 100.0) / 100.0;


        System.out.println();
        System.out.println("--- РЕЗУЛЬТАТИ ДЛЯ ДІАПАЗОНУ [1 .. " + n + "] ---");
        System.out.println("Загальна сума чисел: " + totalsum);
        System.out.println("Сума парних чисел: " + evensum + "(кількість:"  + evenCount + "));");
        System.out.println("Сума непарних чисел: " + oddsum + " (кількість: " + oddCount + "));");
        System.out.println("Середнє арифметичне:" + average);
        System.out.println("=========================================");





    }
}
