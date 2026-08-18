package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student with an id, a name, and a list of enrolled courses.
 */
public class Student {
    private String id;
    private String name;
    private List<Course> enrolledCourses;

    /**
     * Creates a new student with the given id and name.
     * @param id the unique student id
     * @param name the student's name
     */
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
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
     * Returns the list of courses this student is enrolled in.
     * @return list of enrolled courses
     */
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * Enrolls this student into the given course, if not already enrolled.
     * @param course the course to enroll in
     */
    public void enroll(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    /**
     * Returns a printable string representation of the student,
     * including id, name, and number of enrolled courses.
     * @return formatted string
     */
    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name
                + ", courses=" + enrolledCourses.size() + "]";
    }
}
