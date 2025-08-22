abstract class Vehicle {
    private String model;
    private int speed;

    public Vehicle(String model, int speed) throws Exception {
        if (speed < 0) throw new Exception("Speed cannot be negative!");
        this.model = model;
        this.speed = speed;
    }

    public String getModel() { return model; }
    public int getSpeed() { return speed; }
}

class Car extends Vehicle {
    public Car(String model, int speed) throws Exception {
        super(model, speed);
    }
}

class Bike extends Vehicle {
    public Bike(String model, int speed) throws Exception {
        super(model, speed);
    }
}

public class VehicleInheritance {
    public static void main(String[] args) {
        try {
            Vehicle v1 = new Car("Tesla", 120);
            Vehicle v2 = new Bike("Yamaha", 80);

            System.out.println(v1.getModel() + " Speed: " + v1.getSpeed());
            System.out.println(v2.getModel() + " Speed: " + v2.getSpeed());

            Vehicle v3 = new Bike("Honda", -50); // will throw exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
