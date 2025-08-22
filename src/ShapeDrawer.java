abstract class Shapes {
    private String name;

    public Shapes(String name) throws Exception {
        if (name == null || name.isEmpty()) throw new Exception("Shape name cannot be empty!");
        this.name = name;
    }

    public String getName() { return name; }
    public abstract void draw();
}

class Oval extends Shapes {
    private double radius;

    public Oval(double radius) throws Exception {
        super("Circle");
        if (radius <= 0) throw new Exception("Invalid radius!");
        this.radius = radius;
    }

    public void draw() { System.out.println(getName() + " drawn with radius " + radius); }
}

class Square extends Shapes {
    private double side;

    public Square(double side) throws Exception {
        super("Square");
        if (side <= 0) throw new Exception("Invalid side!");
        this.side = side;
    }

    public void draw() { System.out.println(getName() + " drawn with side " + side); }
}

class Triangle extends Shapes {
    private double base, height;

    public Triangle(double base, double height) throws Exception {
        super("Triangle");
        if (base <= 0 || height <= 0) throw new Exception("Invalid dimensions!");
        this.base = base;
        this.height = height;
    }

    public void draw() { System.out.println(getName() + " drawn with base " + base + " and height " + height); }
}

public class ShapeDrawer {
    public static void main(String[] args) {
        try {
            Shapes[] shapes = {
                    new Oval(5),
                    new Square(4),
                    new Triangle(3, 6)
            };

            for (Shapes s : shapes) {
                s.draw();
            }

            Shapes invalid = new Oval(-2); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
