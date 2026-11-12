package practice08;



class Circle {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            System.out.println("Некорректный радиус. Установлено значение 1.0");
            this.radius = 1.0;
        } else {
            this.radius = radius;
        }
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[r=" + radius +
                ", S=" + getArea() +
                ", C=" + getCircumference() + "]";
    }
}

class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height > 0 ? height : 1.0;
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    public double getTotalSurfaceArea() {
        return 2 * super.getArea() + super.getCircumference() * height;
    }

    @Override
    public String toString() {
        return "Cylinder[base=" + super.toString() +
                ", h=" + height +
                ", V=" + getVolume() +
                ", TotalArea=" + getTotalSurfaceArea() + "]";
    }
}

class Cone extends Circle {
    private double height;

    public Cone(double radius, double height) {
        super(radius);
        this.height = height > 0 ? height : 1.0;
    }

    public double getSlantHeight() {
        return Math.sqrt(getRadius() * getRadius() + height * height);
    }

    public double getVolume() {
        return super.getArea() * height / 3.0;
    }

    public double getTotalSurfaceArea() {
        return super.getArea() + Math.PI * getRadius() * getSlantHeight();
    }

    @Override
    public String toString() {
        return "Cone[base=" + super.toString() +
                ", h=" + height +
                ", l=" + getSlantHeight() +
                ", V=" + getVolume() +
                ", TotalArea=" + getTotalSurfaceArea() + "]";
    }
}

public class Task1GeometryInheritance {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Cylinder cylinder = new Cylinder(5.0, 10.0);
        Cone cone = new Cone(3.0, 4.0);

        System.out.println("=============== ГЕОМЕТРІЯ ТІЛ ОБЕРТАННЯ ================");
        System.out.println("Базове коло:");
        System.out.println(circle);

        System.out.println("Циліндр (успадковано від Circle):");
        System.out.println(cylinder);

        System.out.println("Конус (успадковано від Circle):");
        System.out.println(cone);

        System.out.println("========================================================");
    }
}

