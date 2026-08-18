/**
 * Represents a course with a code and a title.
 * Used by the Student Management System (Part 1 - no packages).
 */
public class Course {
    private String code;
    private String title;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    /**
     * Returns the course code.
     * @return course code
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the course title.
     * @return course title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns a printable string representation of the course.
     * @return formatted string with code and title
     */
    @Override
    public String toString() {
        return "Course[code=" + code + ", title=" + title + "]";
    }
}
