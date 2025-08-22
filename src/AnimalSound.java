abstract class Animal {
    private String name;

    public Animal(String name) throws Exception {
        if (name == null || name.isEmpty()) throw new Exception("Name cannot be empty!");
        this.name = name;
    }

    public String getName() { return name; }
    public abstract void makeSound();
}

class Dog extends Animal {
    public Dog(String name) throws Exception { super(name); }
    public void makeSound() { System.out.println(getName() + " says Woof"); }
}

class Cat extends Animal {
    public Cat(String name) throws Exception { super(name); }
    public void makeSound() { System.out.println(getName() + " says Meow"); }
}

class Cow extends Animal {
    public Cow(String name) throws Exception { super(name); }
    public void makeSound() { System.out.println(getName() + " says Moo"); }
}

public class AnimalSound {
    public static void playSound(Animal animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {
        try {
            Animal dog = new Dog("Rex");
            Animal cat = new Cat("Whiskers");
            Animal cow = new Cow("Bessie");

            playSound(dog);
            playSound(cat);
            playSound(cow);

            Animal invalid = new Dog(""); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
