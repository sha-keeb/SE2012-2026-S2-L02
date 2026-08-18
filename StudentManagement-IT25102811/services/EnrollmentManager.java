package services;

import models.Course;
import models.Student;

/**
 * Handles the business logic for the Student Management System:
 * storing students in a fixed-size array, enrolling students in courses,
 * searching by id, and sorting by name.
 */
public class EnrollmentManager {

    private Student[] students;
    private int studentCount;

    /**
     * Creates an EnrollmentManager backed by a fixed-size array.
     * @param capacity the maximum number of students that can be stored
     */
    public EnrollmentManager(int capacity) {
        this.students = new Student[capacity];
        this.studentCount = 0;
    }

    /**
     * Adds a new student to the array, if there is space available.
     * @param student the student to add
     * @return true if the student was added, false if the array is full
     */
    public boolean addStudent(Student student) {
        if (studentCount >= students.length) {
            return false;
        }
        students[studentCount] = student;
        studentCount++;
        return true;
    }

    /**
     * Enrolls the student with the given id into the given course.
     * @param id the id of the student to enroll
     * @param course the course to enroll the student in
     * @return true if the student was found and enrolled, false otherwise
     */
    public boolean enrollStudent(String id, Course course) {
        Student student = searchStudentById(id);
        if (student == null) {
            return false;
        }
        student.enroll(course);
        return true;
    }

    /**
     * Finds a student by ID using linear search.
     * @param id the student id to search for
     * @return the matching Student, or null if not found
     */
    public Student searchStudentById(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                return students[i];
            }
        }
        return null;
    }

    /**
     * Sorts the currently stored students alphabetically by name
     * using the bubble sort algorithm. Sorting is done in place.
     */
    public void sortStudentsByName() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (students[j].getName().compareToIgnoreCase(students[j + 1].getName()) > 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Returns the array of students currently stored (only the first
     * studentCount entries are valid).
     * @return the underlying student array
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * Returns the number of students currently stored.
     * @return the current student count
     */
    public int getStudentCount() {
        return studentCount;
    }
}
