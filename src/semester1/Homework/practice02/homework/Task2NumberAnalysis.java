package semester1.Homework.practice02.homework;

public class Task2NumberAnalysis {
    static void main() {
        int number = 742;
        int hundreds = 7;
        int tens = 4;
        int units = 2;
        double suma = hundreds + tens + units;
        double dobutok = hundreds * tens * units;
        double reservednumber = units * 100 + tens * 10 + hundreds;
        boolean isSumEven = suma % 2 == 0;

        System.out.println("Початкове число:  " +number);
        System.out.println("Розряди:                 Сотні = " + hundreds + ", Десятки = " + tens + ", Одиниці = " + units);
        System.out.println("Сума цифр:               " +suma);
        System.out.println("Добуток цифр:            " +dobutok);
        System.out.println("Перевернуте число:       " +reservednumber);
        System.out.println("Чи є сума цифр парною?   " + isSumEven) ;
    }
}
