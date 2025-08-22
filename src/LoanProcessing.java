abstract class Loan {
    private double amount;

    public Loan(double amount) throws Exception {
        if (amount <= 0) throw new Exception("Loan amount must be positive!");
        this.amount = amount;
    }

    public double getAmount() { return amount; }
    public abstract double calculateInterest();
}

class HomeLoan extends Loan {
    public HomeLoan(double amount) throws Exception { super(amount); }

    public double calculateInterest() { return getAmount() * 0.07; } // 7% interest
}

class CarLoan extends Loan {
    public CarLoan(double amount) throws Exception { super(amount); }

    public double calculateInterest() { return getAmount() * 0.08; } // 8% interest
}

class EducationLoan extends Loan {
    public EducationLoan(double amount) throws Exception { super(amount); }

    public double calculateInterest() { return getAmount() * 0.05; } // 5% interest
}

public class LoanProcessing {
    public static void main(String[] args) {
        try {
            Loan[] loans = {
                    new HomeLoan(500000),
                    new CarLoan(300000),
                    new EducationLoan(200000)
            };

            for (Loan l : loans) {
                System.out.println(l.getClass().getSimpleName() + " Interest: " + l.calculateInterest());
            }

            Loan invalid = new HomeLoan(-1000); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
