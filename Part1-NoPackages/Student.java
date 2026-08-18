/**
 * Represents a student with an id and a name.
 * Used by the Student Management System (Part 1 - no packages).
 */
public class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the student ID.
     * @return student id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the student name.
     * @return student name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a printable string representation of the student.
     * @return formatted string with id and name
     */
    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name + "]";
    }
}
