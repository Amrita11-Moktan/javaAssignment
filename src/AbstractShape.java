abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) throws Exception {
        if (radius <= 0) throw new Exception("Invalid radius!");
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) throws Exception {
        if (length <= 0 || width <= 0) throw new Exception("Invalid dimensions!");
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}

public class AbstractShape {
    public static void main(String[] args) {
        try {
            Shape s1 = new Circle(5);
            Shape s2 = new Rectangle(4, 6);

            System.out.println("Circle Area: " + s1.calculateArea());
            System.out.println("Rectangle Area: " + s2.calculateArea());

            Shape s3 = new Circle(-3); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
