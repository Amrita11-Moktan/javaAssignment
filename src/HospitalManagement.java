abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws Exception {
        if (name == null || name.isEmpty()) throw new Exception("Name cannot be null or empty!");
        if (age <= 0) throw new Exception("Invalid age!");
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String specialization) throws Exception {
        super(name, age);
        if (specialization == null || specialization.isEmpty())
            throw new Exception("Specialization cannot be null or empty!");
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
}

class Patient extends Person {
    private String disease;

    public Patient(String name, int age, String disease) throws Exception {
        super(name, age);
        if (disease == null || disease.isEmpty())
            throw new Exception("Disease cannot be null or empty!");
        this.disease = disease;
    }

    public String getDisease() { return disease; }
}

public class  HospitalManagement{
    public static void main(String[] args) {
        try {
            Doctor d = new Doctor("Dr. Smith", 45, "Cardiology");
            Patient p = new Patient("John Doe", 30, "Flu");

            System.out.println(d.getName() + " (" + d.getSpecialization() + ")");
            System.out.println(p.getName() + " diagnosed with " + p.getDisease());

            Patient p2 = new Patient("", 25, "Fever"); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
