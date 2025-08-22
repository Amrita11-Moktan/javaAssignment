class Calculator {
    private String owner;

    public Calculator(String owner) throws Exception {
        if (owner == null || owner.isEmpty()) throw new Exception("Owner name cannot be empty!");
        this.owner = owner;
    }

    public String getOwner() { return owner; }

    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }

    public int subtract(int a, int b) { return a - b; }
    public double subtract(double a, double b) { return a - b; }

    public int multiply(int a, int b) { return a * b; }
    public double multiply(double a, double b) { return a * b; }

    public int divide(int a, int b) throws Exception {
        if (b == 0) throw new Exception("Division by zero!");
        return a / b;
    }
    public double divide(double a, double b) throws Exception {
        if (b == 0) throw new Exception("Division by zero!");
        return a / b;
    }
}

public class Calculators {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator("Alice");
            System.out.println("Owner: " + calc.getOwner());
            System.out.println("Add: " + calc.add(10, 20));
            System.out.println("Subtract: " + calc.subtract(50, 15));
            System.out.println("Multiply: " + calc.multiply(5, 4));
            System.out.println("Divide: " + calc.divide(20, 5));
            System.out.println("Divide: " + calc.divide(10, 0)); // exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

