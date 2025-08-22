abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) throws Exception {
        if (baseSalary < 0) throw new Exception("Salary cannot be negative!");
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public abstract double calculateSalary();
}

class Manager extends Employee {
    public Manager(String name, double baseSalary) throws Exception {
        super(name, baseSalary);
    }
    public double calculateSalary() {
        return getBaseSalary() + 5000;
    }
}

class Developer extends Employee {
    public Developer(String name, double baseSalary) throws Exception {
        super(name, baseSalary);
    }
    public double calculateSalary() {
        return getBaseSalary() + 2000;
    }
}

public class Employees {
    public static void main(String[] args) {
        try {
            Employee e1 = new Manager("Alice", 40000);
            Employee e2 = new Developer("Bob", 30000);

            System.out.println(e1.getName() + " Salary: " + e1.calculateSalary());
            System.out.println(e2.getName() + " Salary: " + e2.calculateSalary());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
