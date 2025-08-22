class InvalidPolicyException extends Exception {
    public InvalidPolicyException(String message) {
        super(message);
    }
}

abstract class InsurancePolicy {
    private String policyHolder;
    private int age;
    private double coverageAmount;

    public InsurancePolicy(String policyHolder, int age, double coverageAmount) throws InvalidPolicyException {
        if (age <= 0) throw new InvalidPolicyException("Age must be positive!");
        if (coverageAmount <= 0) throw new InvalidPolicyException("Coverage amount must be positive!");
        this.policyHolder = policyHolder;
        this.age = age;
        this.coverageAmount = coverageAmount;
    }

    public String getPolicyHolder() { return policyHolder; }
    public int getAge() { return age; }
    public double getCoverageAmount() { return coverageAmount; }

    public abstract double calculatePremium();
}

class HealthInsurance extends InsurancePolicy {
    public HealthInsurance(String policyHolder, int age, double coverageAmount) throws InvalidPolicyException {
        super(policyHolder, age, coverageAmount);
    }

    public double calculatePremium() {
        return getCoverageAmount() * 0.05 + (getAge() * 10);
    }
}

class LifeInsurance extends InsurancePolicy {
    public LifeInsurance(String policyHolder, int age, double coverageAmount) throws InvalidPolicyException {
        super(policyHolder, age, coverageAmount);
    }

    public double calculatePremium() {
        return getCoverageAmount() * 0.04 + (getAge() * 15);
    }
}

class TravelInsurance extends InsurancePolicy {
    public TravelInsurance(String policyHolder, int age, double coverageAmount) throws InvalidPolicyException {
        super(policyHolder, age, coverageAmount);
    }

    public double calculatePremium() {
        return getCoverageAmount() * 0.03 + (getAge() * 5);
    }
}

public class InsuranceSystems{
    public static void main(String[] args) {
        try {
            InsurancePolicy p1 = new HealthInsurance("Alice", 30, 200000);
            InsurancePolicy p2 = new LifeInsurance("Bob", 40, 500000);
            InsurancePolicy p3 = new TravelInsurance("Charlie", 25, 100000);

            System.out.println(p1.getPolicyHolder() + " Premium: " + p1.calculatePremium());
            System.out.println(p2.getPolicyHolder() + " Premium: " + p2.calculatePremium());
            System.out.println(p3.getPolicyHolder() + " Premium: " + p3.calculatePremium());

            InsurancePolicy p4 = new LifeInsurance("Eve", -5, 300000); // triggers exception
        } catch (InvalidPolicyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
