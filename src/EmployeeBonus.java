class Employeess {
    private String name;
    private double salary;

    public Employeess(String name, double salary) throws Exception {
        if (salary < 0) throw new Exception("Salary cannot be negative!");
        if (name == null || name.isEmpty()) throw new Exception("Name cannot be empty!");
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    public double calculateBonus() { return 0; }
}

class PermanentEmployee extends Employeess {
    public PermanentEmployee(String name, double salary) throws Exception {
        super(name, salary);
    }

    public double calculateBonus() {
        return getSalary() * 0.10;
    }
}

class ContractEmployee extends Employeess {
    public ContractEmployee(String name, double salary) throws Exception {
        super(name, salary);
    }

    public double calculateBonus() {
        return getSalary() * 0.05;
    }
}

public class EmployeeBonus {
    public static void main(String[] args) {
        try {
            Employeess[] employees = {
                    new PermanentEmployee("Alice", 50000),
                    new ContractEmployee("Bob", 30000)
            };

            for (Employeess emp : employees) {
                System.out.println(emp.getName() + " Bonus: " + emp.calculateBonus());
            }

            Employeess invalidEmployee = new PermanentEmployee("Charlie", -1000); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
