package mainapp;

import models.Course;
import models.Student;
import services.EnrollmentManager;

import java.util.Scanner;

/**
 * Entry point for the Student Management System. Presents a menu-driven
 * console interface that allows the user to add students, enroll them in
 * courses, list all students, search by id, sort by name, and exit.
 */
public class Main {

    private static final int MAX_STUDENTS = 100;

    /**
     * Program entry point. Runs the main menu loop.
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnrollmentManager manager = new EnrollmentManager(MAX_STUDENTS);

        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent(scanner, manager);
                    break;
                case "2":
                    enrollStudent(scanner, manager);
                    break;
                case "3":
                    listStudents(manager);
                    break;
                case "4":
                    searchStudent(scanner, manager);
                    break;
                case "5":
                    manager.sortStudentsByName();
                    System.out.println("Students sorted by name.\n");
                    break;
                case "6":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-6.\n");
            }
        }

        scanner.close();
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Enroll Student in Course");
        System.out.println("3. List All Students");
        System.out.println("4. Search Student by ID");
        System.out.println("5. Sort Students by Name");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Prompts the user for student details and adds a new student.
     * @param scanner the Scanner reading console input
     * @param manager the EnrollmentManager storing student data
     */
    private static void addStudent(Scanner scanner, EnrollmentManager manager) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        boolean added = manager.addStudent(new Student(id, name));
        if (added) {
            System.out.println("Student added successfully.\n");
        } else {
            System.out.println("Cannot add student: storage is full.\n");
        }
    }

    /**
     * Prompts the user for a student ID and course details, then enrolls
     * the student in that course.
     * @param scanner the Scanner reading console input
     * @param manager the EnrollmentManager handling enrollment logic
     */
    private static void enrollStudent(Scanner scanner, EnrollmentManager manager) {
        System.out.print("Enter student ID to enroll: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter course code: ");
        String code = scanner.nextLine().trim();
        System.out.print("Enter course title: ");
        String title = scanner.nextLine().trim();

        boolean success = manager.enrollStudent(id, new Course(code, title));
        if (success) {
            System.out.println("Student enrolled successfully.\n");
        } else {
            System.out.println("No student found with ID: " + id + "\n");
        }
    }

    /**
     * Lists all students currently stored, including their enrolled courses.
     * @param manager the EnrollmentManager storing student data
     */
    private static void listStudents(EnrollmentManager manager) {
        Student[] students = manager.getStudents();
        int count = manager.getStudentCount();

        if (count == 0) {
            System.out.println("No students found.\n");
            return;
        }

        System.out.println("--- Student List ---");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
            for (Course c : students[i].getEnrolledCourses()) {
                System.out.println("    -> " + c);
            }
        }
        System.out.println();
    }

    /**
     * Prompts the user for a student ID and searches for that student.
     * @param scanner the Scanner reading console input
     * @param manager the EnrollmentManager providing the search operation
     */
    private static void searchStudent(Scanner scanner, EnrollmentManager manager) {
        System.out.print("Enter student ID to search: ");
        String id = scanner.nextLine().trim();

        Student found = manager.searchStudentById(id);
        if (found != null) {
            System.out.println("Found: " + found + "\n");
        } else {
            System.out.println("No student found with ID: " + id + "\n");
        }
    }
}
