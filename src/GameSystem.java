class InvalidCharacterException extends Exception {
    public InvalidCharacterException(String message) {
        super(message);
    }
}

abstract class Character {
    private String name;
    private int health;
    private String weapon;

    public Character(String name, int health, String weapon) throws InvalidCharacterException {
        if (health <= 0) throw new InvalidCharacterException("Health must be positive!");
        if (weapon == null || weapon.isEmpty()) throw new InvalidCharacterException("Weapon cannot be null or empty!");
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public String getWeapon() { return weapon; }

    public abstract void attack();
}

class Warrior extends Character {
    public Warrior(String name, int health, String weapon) throws InvalidCharacterException {
        super(name, health, weapon);
    }

    public void attack() {
        System.out.println(getName() + " swings a " + getWeapon() + " with strength!");
    }
}

class Mage extends Character {
    public Mage(String name, int health, String weapon) throws InvalidCharacterException {
        super(name, health, weapon);
    }

    public void attack() {
        System.out.println(getName() + " casts a spell using " + getWeapon() + "!");
    }
}

class Archer extends Character {
    public Archer(String name, int health, String weapon) throws InvalidCharacterException {
        super(name, health, weapon);
    }

    public void attack() {
        System.out.println(getName() + " shoots an arrow with " + getWeapon() + "!");
    }
}

public class GameSystem {
    public static void main(String[] args) {
        try {
            Character c1 = new Warrior("Thor", 100, "Hammer");
            Character c2 = new Mage("Merlin", 80, "Staff");
            Character c3 = new Archer("Robin", 90, "Bow");

            c1.attack();
            c2.attack();
            c3.attack();

            Character c4 = new Warrior("InvalidHero", -10, ""); // triggers exception
            c4.attack();

        } catch (InvalidCharacterException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
