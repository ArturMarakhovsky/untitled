package practice03.homework;

import java.util.Scanner;

public class Task2DeliveryService {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть вагу відправлення (кг):");
        double weight = scanner.nextDouble();
        System.out.println("Введіть відстань транспортування (км):");
        int distance = scanner.nextInt();
        System.out.println("Оберіть пункт призначення (1 - Відділення, 2 - Поштомат, 3 - Кур'єр):");
        int deliveryType = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Чи є у вас карта Premium? (так/ні):");
        String premiumAnswer = scanner.nextLine();

        if (weight <= 0 || weight > 50.0) {
            System.out.println("Помилка: вага має бути більшою за 0 та не більшою за 50 кг!");
            scanner.close();
            return;
        }
        if (distance <= 0) {
            System.out.println("Помилка: відстань має бути більшою за 0 км!");
            scanner.close();
            return;
        }
        double baseTariff = switch (deliveryType) {
            case 1 -> 50.0;
            case 2 -> {
                if (weight > 15.0) {
                    System.out.println("Поштомат не приймає габаритні посилки (вага понад 15 кг)!");
                    yield -1.0;
                } else {
                    yield 60.0;
                }
            }
            case 3 -> 100.0;
            default -> -1.0;
        };

        if (baseTariff == -1.0) {
            if (deliveryType < 1 || deliveryType > 3) {
                System.out.println("Помилка: невідомий тип доставки!");
            }
            scanner.close();
            return;
        }

        String deliveryName = switch (deliveryType) {
            case 1 -> "Відділення";
            case 2 -> "Поштомат";
            default -> "Кур'єр";
        };
        double distanceSurcharge;
        if (distance <= 50) {
            distanceSurcharge = 0.0;
        } else if (distance <= 200) {
            distanceSurcharge = 35.0;
        } else {
            distanceSurcharge = 80.0;
        }
        double subtotal = baseTariff + distanceSurcharge;
        double total = premiumAnswer.equalsIgnoreCase("так") ? subtotal * 0.8 : subtotal;
        String status;
        if (premiumAnswer.equalsIgnoreCase("так")) {
            status = "Premium (-20%)";
        } else {
            status = "Стандартний";
        }
        System.out.println("--- НАКЛАДНА ДОСТАВКИ ---");
        System.out.println("Тип доставки: " + deliveryName);
        System.out.println("Базовий тариф: " + baseTariff + " грн");
        System.out.println("Доплата за відстань: " + distanceSurcharge + " грн");
        System.out.println("Сума до знижки: " + subtotal + " грн");
        System.out.println("Статус клієнта: " + status);
        System.out.println("РАЗОМ ДО СПЛАТИ: " + total + " грн");
        System.out.println("-------------------------");

        scanner.close();

    }
}
