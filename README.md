# Student Management System — Practical 02

Java coursework exploring classes, package organization, student enrollment, searching, sorting, and JavaDoc.

## Repository guide

| Folder | Contents |
| --- | --- |
| [Part1-NoPackages/](Part1-NoPackages/) | Introductory version with `Student`, `Course`, and `Main` in the default package |
| [StudentManagement-IT25102811/](StudentManagement-IT25102811/) | Packaged application and its documentation |
| [StudentManagement-IT25102811/docs/](StudentManagement-IT25102811/docs/) | Generated JavaDoc reference |

The packaged application separates data models (`models`), enrollment operations (`services`), and the console entry point (`mainapp`).

## Requirements

JDK 17+ or the Java version required by your module. Verify `java -version` and `javac -version` before building.

## Build and run

Run from the repository root. Each version uses a separate output directory.

### Introductory version

```sh
javac -d build/part1 Part1-NoPackages/Student.java Part1-NoPackages/Course.java Part1-NoPackages/Main.java
java -cp build/part1 Main
```

### Packaged version

```sh
javac -d build/part2 StudentManagement-IT25102811/models/Student.java StudentManagement-IT25102811/models/Course.java StudentManagement-IT25102811/services/EnrollmentManager.java StudentManagement-IT25102811/mainapp/Main.java
java -cp build/part2 mainapp.Main
```

## Generate JavaDoc

```sh
javadoc -d build/javadoc StudentManagement-IT25102811/models/Student.java StudentManagement-IT25102811/models/Course.java StudentManagement-IT25102811/services/EnrollmentManager.java StudentManagement-IT25102811/mainapp/Main.java
```

Open `build/javadoc/index.html` in a browser. Existing committed JavaDoc is preserved in the application’s `docs/` folder.

## Coursework context

This repository is a fork of the SLIIT practical repository. Its original repository name is retained for coursework traceability.
