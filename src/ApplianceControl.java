abstract class Appliance {
    private String name;
    private boolean state;

    public Appliance(String name) throws Exception {
        if (name == null || name.isEmpty()) throw new Exception("Appliance name cannot be empty!");
        this.name = name;
        this.state = false; // initially off
    }

    public String getName() { return name; }
    public boolean getState() { return state; }

    protected void setState(boolean state) { this.state = state; }

    public abstract void turnOn() throws Exception;
    public abstract void turnOff() throws Exception;
}

class Fan extends Appliance {
    public Fan(String name) throws Exception { super(name); }

    public void turnOn() throws Exception {
        if (getState()) throw new Exception(getName() + " is already ON!");
        setState(true);
        System.out.println(getName() + " turned ON");
    }

    public void turnOff() throws Exception {
        if (!getState()) throw new Exception(getName() + " is already OFF!");
        setState(false);
        System.out.println(getName() + " turned OFF");
    }
}

class Light extends Appliance {
    public Light(String name) throws Exception { super(name); }

    public void turnOn() throws Exception {
        if (getState()) throw new Exception(getName() + " is already ON!");
        setState(true);
        System.out.println(getName() + " turned ON");
    }

    public void turnOff() throws Exception {
        if (!getState()) throw new Exception(getName() + " is already OFF!");
        setState(false);
        System.out.println(getName() + " turned OFF");
    }
}

class AC extends Appliance {
    public AC(String name) throws Exception { super(name); }

    public void turnOn() throws Exception {
        if (getState()) throw new Exception(getName() + " is already ON!");
        setState(true);
        System.out.println(getName() + " turned ON");
    }

    public void turnOff() throws Exception {
        if (!getState()) throw new Exception(getName() + " is already OFF!");
        setState(false);
        System.out.println(getName() + " turned OFF");
    }
}

public class ApplianceControl  {
    public static void main(String[] args) {
        try {
            Appliance[] appliances = {
                    new Fan("Ceiling Fan"),
                    new Light("Room Light"),
                    new AC("Air Conditioner")
            };

            for (Appliance a : appliances) {
                a.turnOn();
                a.turnOff();
            }

            appliances[0].turnOff(); // will throw exception (Fan already OFF)
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
