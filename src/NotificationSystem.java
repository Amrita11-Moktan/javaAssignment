abstract class Notification {
    private String recipient;

    public Notification(String recipient) throws Exception {
        if (recipient == null || recipient.isEmpty()) throw new Exception("Recipient cannot be empty!");
        this.recipient = recipient;
    }

    public String getRecipient() { return recipient; }
    public abstract void send() throws Exception;
}

class EmailNotification extends Notification {
    private String subject;

    public EmailNotification(String recipient, String subject) throws Exception {
        super(recipient);
        if (subject == null || subject.isEmpty()) throw new Exception("Subject cannot be empty!");
        this.subject = subject;
    }

    public void send() {
        System.out.println("Email sent to " + getRecipient() + " with subject: " + subject);
    }
}

class SMSNotification extends Notification {
    private String message;

    public SMSNotification(String recipient, String message) throws Exception {
        super(recipient);
        if (message == null || message.isEmpty()) throw new Exception("Message cannot be empty!");
        this.message = message;
    }

    public void send() {
        System.out.println("SMS sent to " + getRecipient() + ": " + message);
    }
}

class PushNotification extends Notification {
    private String app;

    public PushNotification(String recipient, String app) throws Exception {
        super(recipient);
        if (app == null || app.isEmpty()) throw new Exception("App name cannot be empty!");
        this.app = app;
    }

    public void send() {
        System.out.println("Push notification sent to " + getRecipient() + " via app: " + app);
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        try {
            Notification[] notifications = {
                    new EmailNotification("alice@example.com", "Welcome!"),
                    new SMSNotification("9876543210", "Your OTP is 1234"),
                    new PushNotification("bob_user", "Messenger")
            };

            for (Notification n : notifications) {
                n.send();
            }

            Notification invalid = new EmailNotification("", "Test"); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
