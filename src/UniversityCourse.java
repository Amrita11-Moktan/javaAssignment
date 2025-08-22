abstract class Course {
    private String courseCode;
    private int credits;

    public Course(String courseCode, int credits) throws Exception {
        if (courseCode == null || courseCode.isEmpty()) throw new Exception("Course code cannot be empty!");
        if (credits <= 0) throw new Exception("Credits must be positive!");
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public String getCourseCode() { return courseCode; }
    public int getCredits() { return credits; }

    public abstract int calculateWorkload();
}

class TheoryCourse extends Course {
    public TheoryCourse(String courseCode, int credits) throws Exception {
        super(courseCode, credits);
    }

    public int calculateWorkload() {
        return getCredits() * 2; // 2 hours per credit
    }
}

class LabCourse extends Course {
    public LabCourse(String courseCode, int credits) throws Exception {
        super(courseCode, credits);
    }

    public int calculateWorkload() {
        return getCredits() * 3; // 3 hours per credit
    }
}

public class UniversityCourse {
    public static void main(String[] args) {
        try {
            Course theory = new TheoryCourse("CS101", 3);
            Course lab = new LabCourse("CS101 Lab", 2);

            System.out.println(theory.getCourseCode() + " Workload: " + theory.calculateWorkload() + " hrs");
            System.out.println(lab.getCourseCode() + " Workload: " + lab.calculateWorkload() + " hrs");

            Course invalid = new TheoryCourse("CS102", -1); // throws exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
