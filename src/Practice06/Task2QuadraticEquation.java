package Practice06;


    import java.util.Scanner;

    public class Task2QuadraticEquation {

        private double a;
        private double b;
        private double c;

        public void setCoefficients(double a, double b, double c) {

            if (a == 0) {
                System.out.println("Увага: коефіцієнт a не може дорівнювати 0!");
                this.a = 1.0;
            } else {
                this.a = a;
            }

            this.b = b;
            this.c = c;
        }

        public double getDiscriminant() {
            return b * b - 4 * a * c;
        }

        public double getRoot1() {
            return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
        }

        public double getRoot2() {
            return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
        }

        public void printSolution() {

            double d = getDiscriminant();

            System.out.println();
            System.out.println("Рівняння:");
            System.out.println(a + "x² + " + b + "x + " + c + " = 0");

            System.out.println("Дискримінант D = " + d);

            if (d > 0) {

                System.out.println("Рівняння має два дійсні корені:");
                System.out.println("x1 = " + getRoot1());
                System.out.println("x2 = " + getRoot2());

            } else if (d == 0) {

                System.out.println("Рівняння має один дійсний корінь:");
                System.out.println("x = " + getRoot1());

            } else {

                System.out.println("Рівняння не має дійсних коренів.");
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            Task2QuadraticEquation equation = new Task2QuadraticEquation();

            System.out.println("=== РОЗВ'ЯЗУВАЧ КВАДРАТНИХ РІВНЯНЬ ===");

            System.out.print("Введіть a: ");
            double a = sc.nextDouble();

            System.out.print("Введіть b: ");
            double b = sc.nextDouble();

            System.out.print("Введіть c: ");
            double c = sc.nextDouble();

            equation.setCoefficients(a, b, c);

            equation.printSolution();

            sc.close();
        }
    }

