class InvalidDistanceException extends Exception {
    public InvalidDistanceException(String message) {
        super(message);
    }
}

abstract class Transport {
    private String name;
    private double distance;

    public Transport(String name, double distance) throws InvalidDistanceException {
        if (distance <= 0) throw new InvalidDistanceException("Distance must be positive!");
        this.name = name;
        this.distance = distance;
    }

    public String getName() { return name; }
    public double getDistance() { return distance; }

    public abstract double calculateFare();
}

class Bus extends Transport {
    private static final double RATE = 5.0;

    public Bus(String name, double distance) throws InvalidDistanceException {
        super(name, distance);
    }

    public double calculateFare() {
        return getDistance() * RATE;
    }
}

class Train extends Transport {
    private static final double RATE = 3.0;

    public Train(String name, double distance) throws InvalidDistanceException {
        super(name, distance);
    }

    public double calculateFare() {
        return getDistance() * RATE;
    }
}

class Taxi extends Transport {
    private static final double BASE_FARE = 50.0;
    private static final double RATE = 10.0;

    public Taxi(String name, double distance) throws InvalidDistanceException {
        super(name, distance);
    }

    public double calculateFare() {
        return BASE_FARE + (getDistance() * RATE);
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        try {
            Transport t1 = new Bus("City Bus", 10);
            Transport t2 = new Train("Express Train", 50);
            Transport t3 = new Taxi("Yellow Taxi", 8);

            System.out.println(t1.getName() + " Fare: " + t1.calculateFare());
            System.out.println(t2.getName() + " Fare: " + t2.calculateFare());
            System.out.println(t3.getName() + " Fare: " + t3.calculateFare());

            Transport t4 = new Taxi("Faulty Taxi", -5); // triggers exception
        } catch (InvalidDistanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
