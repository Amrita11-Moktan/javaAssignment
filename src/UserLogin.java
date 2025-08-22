abstract class User {
    private String username;
    private String password;

    public User(String username, String password) throws Exception {
        if (username == null || username.isEmpty()) throw new Exception("Username cannot be empty!");
        if (password == null || password.isEmpty()) throw new Exception("Password cannot be empty!");
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public abstract void login(String password) throws Exception;
}

class Admin extends User {
    public Admin(String username, String password) throws Exception {
        super(username, password);
    }

    public void login(String password) throws Exception {
        if (!getPassword().equals(password)) throw new Exception("Admin login failed: incorrect password!");
        System.out.println("Admin " + getUsername() + " logged in successfully.");
    }
}

class Editor extends User {
    public Editor(String username, String password) throws Exception {
        super(username, password);
    }

    public void login(String password) throws Exception {
        if (!getPassword().equals(password)) throw new Exception("Editor login failed: incorrect password!");
        System.out.println("Editor " + getUsername() + " logged in successfully.");
    }
}

class Viewer extends User {
    public Viewer(String username, String password) throws Exception {
        super(username, password);
    }

    public void login(String password) throws Exception {
        if (!getPassword().equals(password)) throw new Exception("Viewer login failed: incorrect password!");
        System.out.println("Viewer " + getUsername() + " logged in successfully.");
    }
}

public class UserLogin {
    public static void main(String[] args) {
        try {
            User[] users = {
                    new Admin("admin1", "pass123"),
                    new Editor("editor1", "edit123"),
                    new Viewer("viewer1", "view123")
            };

            for (User u : users) {
                u.login(u.getPassword()); // correct login
            }

            users[0].login("wrongpass"); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
