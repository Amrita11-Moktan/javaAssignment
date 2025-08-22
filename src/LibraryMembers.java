
class BorrowLimitException extends Exception {
    public BorrowLimitException(String message) {
        super(message);
    }
}

abstract class LibraryMember {
    private String name;
    private int borrowedBooks;

    public LibraryMember(String name) {
        this.name = name;
        this.borrowedBooks = 0;
    }

    public String getName() { return name; }
    public int getBorrowedBooks() { return borrowedBooks; }

    protected void incrementBorrowed() { borrowedBooks++; }

    public abstract void borrowBook() throws BorrowLimitException;
}

class Student extends LibraryMember {
    private static final int LIMIT = 3;

    public Student(String name) {
        super(name);
    }

    public void borrowBook() throws BorrowLimitException {
        if (getBorrowedBooks() >= LIMIT)
            throw new BorrowLimitException("Student limit reached: " + LIMIT);
        incrementBorrowed();
        System.out.println(getName() + " borrowed a book. Total: " + getBorrowedBooks());
    }
}

class Teacher extends LibraryMember {
    private static final int LIMIT = 5;

    public Teacher(String name) {
        super(name);
    }

    public void borrowBook() throws BorrowLimitException {
        if (getBorrowedBooks() >= LIMIT)
            throw new BorrowLimitException("Teacher limit reached: " + LIMIT);
        incrementBorrowed();
        System.out.println(getName() + " borrowed a book. Total: " + getBorrowedBooks());
    }
}

class Guest extends LibraryMember {
    private static final int LIMIT = 1;

    public Guest(String name) {
        super(name);
    }

    public void borrowBook() throws BorrowLimitException {
        if (getBorrowedBooks() >= LIMIT)
            throw new BorrowLimitException("Guest limit reached: " + LIMIT);
        incrementBorrowed();
        System.out.println(getName() + " borrowed a book. Total: " + getBorrowedBooks());
    }
}

public class LibraryMembers  {
    public static void main(String[] args) {
        try {
            LibraryMember s = new Student("Alice");
            LibraryMember t = new Teacher("Bob");
            LibraryMember g = new Guest("Charlie");

            s.borrowBook();
            s.borrowBook();
            s.borrowBook();
            s.borrowBook(); // exceeds limit

        } catch (BorrowLimitException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
