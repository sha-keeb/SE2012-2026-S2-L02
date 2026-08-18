/**
 * Entry point for Part 1 of the Student Management System.
 * Demonstrates the Student and Course classes before packages
 * and control structures are introduced in later parts.
 */
public class Main {

    /**
     * Program entry point. Creates a few sample students and courses
     * and prints them to verify the classes work correctly.
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        Student s1 = new Student("ST001", "Ama Perera");
        Student s2 = new Student("ST002", "Nimal Silva");

        Course c1 = new Course("SE2012", "Java Programming");
        Course c2 = new Course("IE1024", "Computer Organization & Architecture");

        System.out.println("--- Students ---");
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("--- Courses ---");
        System.out.println(c1);
        System.out.println(c2);
    }
}
