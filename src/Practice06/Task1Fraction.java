package Practice06;

public class Task1Fraction {


        private int numerator;
        private int denominator;

        public void setValues(int num, int den) {

            if (den == 0) {
                System.out.println("Помилка: знаменник не може дорівнювати 0!");
                numerator = num;
                denominator = 1;
                return;
            }

            if (den < 0) {
                numerator = -num;
                denominator = -den;
            } else {
                numerator = num;
                denominator = den;
            }
        }

        private int gcd(int a, int b) {

            a = Math.abs(a);
            b = Math.abs(b);

            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }

            return a;
        }

        public void simplify() {

            int divisor = gcd(numerator, denominator);

            numerator = numerator / divisor;
            denominator = denominator / divisor;
        }

        public double toDecimal() {
            return (double) numerator / denominator;
        }

        public void add(int otherNum, int otherDen) {

            numerator = numerator * otherDen + otherNum * denominator;
            denominator = denominator * otherDen;

            simplify();
        }

        public void printFraction() {

            if (denominator == 1) {
                System.out.println(numerator);
            } else {
                System.out.println(numerator + "/" + denominator);
            }
        }

        public static void main(String[] args) {

            System.out.println("=== КАЛЬКУЛЯТОР ЗВИЧАЙНИХ ДРОБІВ ===");

            Task1Fraction fr = new Task1Fraction();

            fr.setValues(8, 12);

            System.out.print("Дріб 1: ");
            fr.printFraction();

            fr.simplify();

            System.out.print("Після скорочення: ");
            fr.printFraction();

            System.out.println("Десятковий вигляд: " + fr.toDecimal());

            System.out.println();

            System.out.println("Додаємо дріб 3/4 до 2/3...");

            fr.add(3, 4);

            System.out.print("Результат додавання: ");
            fr.printFraction();

            System.out.println("Десятковий вигляд: " + fr.toDecimal());
        }
    }

