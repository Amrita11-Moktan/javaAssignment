class InvalidIncomeException extends Exception {
    public InvalidIncomeException(String message) {
        super(message);
    }
}

abstract class TaxPayer {
    private String name;
    private double income;

    public TaxPayer(String name, double income) throws InvalidIncomeException {
        if (income < 0) throw new InvalidIncomeException("Income cannot be negative!");
        this.name = name;
        this.income = income;
    }

    public String getName() { return name; }
    public double getIncome() { return income; }

    public abstract double calculateTax();
}

class Individual extends TaxPayer {
    public Individual(String name, double income) throws InvalidIncomeException {
        super(name, income);
    }
    public double calculateTax() { return getIncome() * 0.10; }
}

class Business extends TaxPayer {
    public Business(String name, double income) throws InvalidIncomeException {
        super(name, income);
    }
    public double calculateTax() { return getIncome() * 0.25; }
}

class Freelancer extends TaxPayer {
    public Freelancer(String name, double income) throws InvalidIncomeException {
        super(name, income);
    }
    public double calculateTax() { return getIncome() * 0.15; }
}

public class TaxCalculation {
    public static void main(String[] args) {
        try {
            TaxPayer p1 = new Individual("Alice", 50000);
            TaxPayer p2 = new Business("XYZ Pvt Ltd", 200000);
            TaxPayer p3 = new Freelancer("Bob", 80000);

            System.out.println(p1.getName() + " Tax: " + p1.calculateTax());
            System.out.println(p2.getName() + " Tax: " + p2.calculateTax());
            System.out.println(p3.getName() + " Tax: " + p3.calculateTax());

            TaxPayer p4 = new Individual("Eve", -1000);
        } catch (InvalidIncomeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
