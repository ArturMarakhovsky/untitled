package practice03.homework;

import java.util.Scanner;

public class Task1FuelCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть відстань поїздки (км):");
        double distance = scanner.nextDouble();
        System.out.println("Введіть середню витрату на 100 км (л):");
        double fuelConsumption = scanner.nextDouble();
        System.out.println("Оберіть тип пального (1 - А-95, 2 - Дизель, 3 - Газ):");
        int fuelType = scanner.nextInt();
        if (distance <= 0 || fuelConsumption <= 0) {
            System.out.println("Помилка: відстань та витрата повинні бути більшими за 0");
        } else {
            double pricePerLiter = 0;
            String fuelname = "";

            switch (fuelType){
                case 1 -> {
                    pricePerLiter = 56.50;
                    fuelname = "Бензин А-95";
                }
                    case 2 -> {
                        pricePerLiter = 52.80;
                        fuelname = "Дизель";
                    }
                    case 3 -> {
                    pricePerLiter = 29.40;
                    fuelname = "Газ";
                }
                default -> {
                    System.out.println("Помилка: невідомий тип пального!");
                    scanner.close();
                    return;
                }

            }
            double neededfuel = distance * fuelConsumption / 100;
            double basecost = neededfuel * pricePerLiter;
            double discount = (basecost > 2000.0)
                    ? basecost * 0.05
                    : 0;
            double finalCost = (basecost >= 2000.0)
                    ? basecost * 0.95
                    : basecost;



            System.out.println();
            System.out.println("---------------- ЗВІТ ПОЇЗДКИ ----------------");
            System.out.println("Обране пальне:               " + fuelname
                    + " (" + pricePerLiter + " грн/л)");
            System.out.println("Необхідно пального:          " + neededfuel + " л");
            System.out.println("Базова вартість:             " + basecost + " грн");
            System.out.println("Знижка АЗС (5%):             " + discount + " грн");
            System.out.println("----------------------------------------------");
            System.out.println("Підсумкова сума до сплати:   " + finalCost + " грн");
            System.out.println("==============================================");
        }
    }




        }


