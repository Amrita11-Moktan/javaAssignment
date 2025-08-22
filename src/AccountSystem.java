class InvalidAccountException extends Exception {
    public InvalidAccountException(String message) {
        super(message);
    }
}

abstract class Account {
    private String username;
    private String password;

    public Account(String username, String password) throws InvalidAccountException {
        if (username == null || username.isEmpty())
            throw new InvalidAccountException("Username cannot be null or empty!");
        if (password == null || password.length() < 4)
            throw new InvalidAccountException("Password must be at least 4 characters long!");
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public abstract void login() throws InvalidAccountException;
}

class GoogleAccount extends Account {
    public GoogleAccount(String username, String password) throws InvalidAccountException {
        super(username, password);
    }

    public void login() throws InvalidAccountException {
        if (!getUsername().endsWith("@gmail.com"))
            throw new InvalidAccountException("Google account must use a Gmail address!");
        System.out.println("Google login successful for " + getUsername());
    }
}

class FacebookAccount extends Account {
    public FacebookAccount(String username, String password) throws InvalidAccountException {
        super(username, password);
    }

    public void login() throws InvalidAccountException {
        if (!getUsername().contains("@"))
            throw new InvalidAccountException("Facebook account must have a valid email!");
        System.out.println("Facebook login successful for " + getUsername());
    }
}

class TwitterAccount extends Account {
    public TwitterAccount(String username, String password) throws InvalidAccountException {
        super(username, password);
    }

    public void login() throws InvalidAccountException {
        if (getUsername().length() < 3)
            throw new InvalidAccountException("Twitter username must be at least 3 characters!");
        System.out.println("Twitter login successful for " + getUsername());
    }
}

public class AccountSystem {
    public static void main(String[] args) {
        try {
            Account g = new GoogleAccount("alice@gmail.com", "pass123");
            Account f = new FacebookAccount("bob@yahoo.com", "abcd1234");
            Account t = new TwitterAccount("charlie", "tweet");

            g.login();
            f.login();
            t.login();

            Account g2 = new GoogleAccount("invalidUser", "1234");
            g2.login(); // triggers exception

        } catch (InvalidAccountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
