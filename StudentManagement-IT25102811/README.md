# Student Management System — SE2012 Practical 2

## Structure
```
StudentManagement/
 ┣ models/
 ┃ ┣ Student.java
 ┃ ┗ Course.java
 ┣ services/
 ┃ ┗ EnrollmentManager.java
 ┣ mainapp/
 ┃ ┗ Main.java
 ┣ docs/              (generated JavaDoc HTML — open docs/index.html)
 ┗ README.md
```

## How to Compile
From the project root (the folder containing `models/`, `services/`, `mainapp/`):
```
javac models/*.java services/*.java mainapp/*.java
```

## How to Run
```
java mainapp.Main
```

## Menu Options
1. Add Student — enter an ID and name
2. Enroll Student in Course — enter a student ID plus a course code/title
3. List All Students — shows every student and their enrolled courses
4. Search Student by ID — linear search over the student array
5. Sort Students by Name — bubble sort, alphabetical, case-insensitive
6. Exit

## How to Generate JavaDoc
From the project root:
```
javadoc -d docs models/*.java services/*.java mainapp/*.java
```
Then open `docs/index.html` in a browser. (The `docs/` folder in this
submission was already generated this way — no need to regenerate unless
the code changes.)

## Design Notes
- Students are stored in a fixed-size array (`Student[100]`) inside `EnrollmentManager`, matching the practical's requirement.
- `EnrollmentManager` (in `services`) holds all business logic: adding, enrolling, searching, and sorting — keeping `Main` focused purely on the menu/UI loop.
- `Student.enroll(Course)` appends to an internal list of enrolled courses, and `Course` implements `equals()`/`hashCode()` by course code so a student can't be double-enrolled in the same course.
- Search uses linear search (`searchStudentById`); sort uses bubble sort (`sortStudentsByName`), exactly as specified in the practical brief.

## Verification
This submission was compiled with `javac` and run end-to-end (add, enroll,
list, search, sort, exit) with no errors. JavaDoc was generated with `javadoc`
with zero errors (only minor warnings for undocumented private fields, which
are not part of the public API).
