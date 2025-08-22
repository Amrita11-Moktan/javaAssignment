abstract class Payment {
    private double amount;

    public Payment(double amount) throws Exception {
        if (amount <= 0) throw new Exception("Amount must be positive!");
        this.amount = amount;
    }

    public double getAmount() { return amount; }
    public abstract void processPayment() throws Exception;
}

class CreditCard extends Payment {
    private String cardNumber;

    public CreditCard(double amount, String cardNumber) throws Exception {
        super(amount);
        if (cardNumber == null || cardNumber.isEmpty()) throw new Exception("Invalid card number!");
        this.cardNumber = cardNumber;
    }

    public void processPayment() throws Exception {
        System.out.println("Processed Credit Card payment of " + getAmount() + " using card " + cardNumber);
    }
}

class UPI extends Payment {
    private String upiId;

    public UPI(double amount, String upiId) throws Exception {
        super(amount);
        if (upiId == null || upiId.isEmpty()) throw new Exception("Invalid UPI ID!");
        this.upiId = upiId;
    }

    public void processPayment() throws Exception {
        System.out.println("Processed UPI payment of " + getAmount() + " using UPI ID " + upiId);
    }
}

class NetBanking extends Payment {
    private String accountNumber;

    public NetBanking(double amount, String accountNumber) throws Exception {
        super(amount);
        if (accountNumber == null || accountNumber.isEmpty()) throw new Exception("Invalid account number!");
        this.accountNumber = accountNumber;
    }

    public void processPayment() throws Exception {
        System.out.println("Processed NetBanking payment of " + getAmount() + " using account " + accountNumber);
    }
}

public class OnlinePayment {
    public static void main(String[] args) {
        try {
            Payment[] payments = {
                    new CreditCard(5000, "1234-5678-9876-5432"),
                    new UPI(2000, "alice@upi"),
                    new NetBanking(10000, "ACC123456")
            };

            for (Payment p : payments) {
                p.processPayment();
            }

            Payment invalid = new CreditCard(-100, "0000"); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
