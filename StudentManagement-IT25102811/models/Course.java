package models;

import java.util.Objects;

/**
 * Represents a course with a code and a title.
 */
public class Course {
    private String code;
    private String title;

    /**
     * Creates a new course with the given code and title.
     * @param code the unique course code
     * @param title the course title
     */
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
     * @return formatted string
     */
    @Override
    public String toString() {
        return "Course[code=" + code + ", title=" + title + "]";
    }

    /**
     * Two courses are considered equal if they have the same course code.
     * @param obj the object to compare with
     * @return true if the courses have the same code
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        return code.equalsIgnoreCase(other.code);
    }

    /**
     * Returns a hash code consistent with equals(), based on the course code.
     * @return hash code for this course
     */
    @Override
    public int hashCode() {
        return Objects.hash(code.toLowerCase());
    }
}
