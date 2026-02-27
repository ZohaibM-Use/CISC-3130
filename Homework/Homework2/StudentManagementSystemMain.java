package Homework.Homework2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystemMain {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        CourseManager courseManager = new CourseManager();
        EnrollmentManager enrollmentManager = new EnrollmentManager();
        Scanner sc = new Scanner(System.in);

        //Sample data
        studentManager.addStudent(new Student("S001", "John", "Doe", "JDoe@example.com", 3.5, "English", 2));
        studentManager.addStudent(new Student("S002", "Lacy", "Freeman", "LacyF@example.com", 3.2, "Earth Science", 3));
        studentManager.addStudent(new Student("S003", "Henry", "Jolt", "HJolt@example.com", 3.6, "Earth Science", 4));
        studentManager.addStudent(new Student("S004", "Aisha", "Khan", "AKhan@example.com", 3.8, "Computer Science", 3));
        studentManager.addStudent(new Student("S005", "Michael", "Brown", "MBrown@example.com", 2.9, "Mathematics", 1));
        studentManager.addStudent(new Student("S006", "Sofia", "Garcia", "SGarcia@example.com", 3.7, "Biology", 2));
        studentManager.addStudent(new Student("S007", "David", "Lee", "DLee@example.com", 3.1, "Chemistry", 4));
        studentManager.addStudent(new Student("S008", "Emma", "Wilson", "EWilson@example.com", 3.9, "Physics", 3));
        studentManager.addStudent(new Student("S009", "Noah", "Martinez", "NMartinez@example.com", 2.8, "History", 1));
        studentManager.addStudent(new Student("S010", "Olivia", "Anderson", "OAnderson@example.com", 3.4, "Psychology", 2));

        courseManager.addCourse(new Course("CS101", "Intro to Computer Science", 3, "Dr. Smith", 40));
        courseManager.addCourse(new Course("MATH201", "Calculus I", 4, "Prof. Johnson", 35));
        courseManager.addCourse(new Course("ENG102", "English Literature", 3, "Dr. Brown", 25));
        courseManager.addCourse(new Course("CHEM110", "General Chemistry", 4, "Dr. Lee", 30));
        courseManager.addCourse(new Course("HIST210", "World History", 3, "Prof. Davis", 20));

        enrollmentManager.enrollStudent("S001", "BIO101", "Fall 2024");
        enrollmentManager.enrollStudent("S002", "CS101", "Fall 2024");
        enrollmentManager.enrollStudent("S003", "MATH201", "Fall 2024");
        enrollmentManager.enrollStudent("S004", "ENG102", "Fall 2024");
        enrollmentManager.enrollStudent("S005", "CHEM110", "Fall 2024");
        enrollmentManager.enrollStudent("S006", "HIST210", "Fall 2024");
        enrollmentManager.enrollStudent("S007", "CHEM110", "Fall 2024");
        enrollmentManager.enrollStudent("S008", "CS101", "Fall 2024");
        enrollmentManager.enrollStudent("S009", "BIO101", "Fall 2024");
        enrollmentManager.enrollStudent("S010", "MATH201", "Fall 2024");
        enrollmentManager.enrollStudent("S001", "CS101", "Fall 2024");
        enrollmentManager.enrollStudent("S002", "MATH201", "Fall 2024");
        enrollmentManager.enrollStudent("S003", "CHEM110", "Fall 2024");
        enrollmentManager.enrollStudent("S004", "HIST210", "Fall 2024");
        enrollmentManager.enrollStudent("S005", "ENG102", "Fall 2024");
        enrollmentManager.enrollStudent("S006", "BIO101", "Spring 2025");
        enrollmentManager.enrollStudent("S007", "CS101", "Spring 2025");
        enrollmentManager.enrollStudent("S008", "ENG102", "Spring 2025");

        int choice;
        do {
            choice = 0;
            System.out.println("===== Main Menu =====");
            System.out.println("1. Add Student\n" +
                    "2. Remove Student\n" +
                    "3. Find Student\n" +
                    "4. List All Students\n" +
                    "5. Add Course\n" +
                    "6. Enroll Student in Course\n" +
                    "7. Assign Grade\n" +
                    "8. Calculate Student GPA\n" +
                    "9. Generate Reports\n" +
                    "10. Exit");
            System.out.println();
            while (true) {
                System.out.print("Choose an option: ");
                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice >= 1 && choice <= 10) { break; }
                    else {
                        System.out.println("Choose an option from the menu!");
                        System.out.println();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!");
                    System.out.println();
                    sc.nextLine();
                }
            }

            switch (choice){
               case 1 -> addStudent(sc, studentManager);
               case 2 -> removeStudent(sc, studentManager, enrollmentManager);
               case 3 -> findStudent(sc, studentManager, enrollmentManager);
               case 4 -> listAllStudents(sc, studentManager);
               case 5 -> addCourse(sc, courseManager);
               case 6 -> enrollStudentInCourse(sc, studentManager, courseManager, enrollmentManager);
               case 7 -> assignGrade(sc, studentManager, enrollmentManager);
               case 8 -> calculateStudentGpa(sc, enrollmentManager, studentManager);
               case 9 -> generateReports(sc, studentManager, enrollmentManager, courseManager);
            }
        } while (choice != 10);
    }

    public static void addStudent(Scanner sc, StudentManager studentManager) {
        String continueAdding = "Y";
        do {
            String studentId, firstName, lastName, email, major;
            double gpa;
            int year;

            System.out.println("Enter the following student details to add a new student to the system: ");

            System.out.print("Student ID: ");
            studentId = sc.nextLine();

            System.out.print("First Name: ");
            firstName = sc.nextLine();

            System.out.print("Last Name: ");
            lastName = sc.nextLine();

            System.out.print("Email: ");
            email = sc.nextLine();

            while (true) {
                System.out.print("GPA (4.0 scale): ");
                try {
                    gpa = sc.nextDouble();
                    if (gpa >= 0.0 && gpa <= 4.0){
                        sc.nextLine();
                        break;
                    }
                    System.out.println("Enter a valid GPA between 0.0 and 4.0!");
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number between 0.0 and 4.0!");
                    sc.nextLine();
                }
            }

            System.out.print("Major: ");
            major = sc.nextLine();

            while (true) {
                System.out.print("Year (1-4): ");
                try {
                    year = sc.nextInt();
                    if (year >= 1 && year <= 4) {
                        sc.nextLine();
                        break;
                    }
                    System.out.println("Enter a valid year between 1 and 4!");
                } catch (InputMismatchException e) {
                    System.out.println("Must be a number between 1 and 4!");
                    sc.nextLine();
                }
            }

            studentManager.addStudent(new Student(studentId, firstName, lastName, email, gpa, major, year));

            while (true) {
                System.out.print("Add another student (Y/N)? ");
                continueAdding = sc.nextLine().trim().toUpperCase();
                if (continueAdding.equals("Y") || continueAdding.equals("N")) break;
                System.out.println("Please enter Y or N!");
            }

        } while (continueAdding.equalsIgnoreCase("y"));
        System.out.println();
    }

    public static void removeStudent(Scanner sc, StudentManager studentManager,
                                     EnrollmentManager enrollmentManager) {
        String continueRemoving = "Y";
        do {
            System.out.print("Enter Student ID of Student to remove: ");
            String studentId = sc.nextLine();
            boolean removed = studentManager.removeStudent(studentId);
            if (removed) {
                ArrayList<Enrollment> enrollmentByStudent = enrollmentManager.getEnrollmentsByStudent(studentId);
                for (Enrollment e : enrollmentByStudent) {
                    enrollmentManager.dropEnrollment(e.getEnrollmentId());
                }
                System.out.println("Student and all related information removed from system.");
            } else
                System.out.println("Student Not Found!");

            while (true) {
                System.out.print("Remove another student (Y/N)? ");
                continueRemoving = sc.nextLine().trim().toUpperCase();
                if (continueRemoving.equals("Y") || continueRemoving.equals("N")) break;
                System.out.println("Please enter Y or N!");
            }

        } while (continueRemoving.equalsIgnoreCase("y"));
        System.out.println();
    }

    public static void findStudent(Scanner sc, StudentManager studentManager,
                                   EnrollmentManager enrollmentManager) {
        String continueFinding = "Y";
        do {
            System.out.print("Enter Student ID of Student to find: ");
            String studentId = sc.nextLine();
            Student found = studentManager.findStudent(studentId);

            if (found == null) {
                System.out.println("Student Not Found!");
            } else {
                System.out.println();
                System.out.println("Student");
                System.out.printf("%-10S | %-10S | %-10S | %-30S | %-4S | %-20S | %-4S%n",
                        "Student Id", "First Name", "Last Name", "Email", "GPA", "Major", "Year");
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                System.out.println(found);
                System.out.println();

                System.out.println("Student Enrollment");
                System.out.printf("%-13S | %-10S | %-11S | %-5S | %-12S%n",
                        "Enrollment ID", "Student ID", "Course Code", "Grade", "Semester");
                System.out.println("------------------------------------------------------------");
                ArrayList<Enrollment> enrollmentByStudent = enrollmentManager.getEnrollmentsByStudent(studentId);
                for (Enrollment e : enrollmentByStudent){
                    System.out.println(e);
                }
            }

            while (true) {
                System.out.print("Find another student (Y/N)? ");
                continueFinding = sc.nextLine().trim().toUpperCase();
                if (continueFinding.equals("Y") || continueFinding.equals("N")) break;
                System.out.println("Please enter Y or N!");
            }

        } while (continueFinding.equalsIgnoreCase("y"));
        System.out.println();
    }

    public static void listAllStudents(Scanner sc, StudentManager studentManager){
        studentManager.printAllStudents();
        System.out.println();
        System.out.print("Press enter once finished viewing.");
        sc.nextLine();
        System.out.println();
    }

    public static void addCourse(Scanner sc, CourseManager courseManager){
        int option;
        System.out.println("=== Add Course Menu ===");
        System.out.println("1. Add New Course\n" +
                "2. Add prerequisites to an existing course");
        System.out.println();
        while (true) {
            System.out.print("Enter Option: ");
            try {
                option = sc.nextInt();
                sc.nextLine();
                if (option >= 1 && option <= 2) { break; }
                else {
                    System.out.println("Choose an option from the menu!");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a number!");
                System.out.println();
                sc.nextLine();
            }
        }

        switch (option){
            case 1 -> {
                String continueAdding = "Y";
                do {
                    String courseCode, courseName, instructor;
                    int credits, maxEnrollment;
                    System.out.println("Enter the following information to add a new course");

                    System.out.print("Course Code: ");
                    courseCode = sc.nextLine();

                    System.out.print("Course Name: ");
                    courseName = sc.nextLine();

                    while (true) {
                        System.out.print("Credits: ");
                        try {
                            credits = sc.nextInt();
                            if (credits <= 0) {
                                System.out.println("Credits must be positive!");
                            }   else {
                                sc.nextLine();
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a number!");
                            sc.nextLine();
                        }
                    }

                    System.out.print("Instructor: ");
                    instructor = sc.nextLine();

                    while (true) {
                        System.out.print("Max Number of Enrollments: ");
                        try {
                            maxEnrollment = sc.nextInt();
                            if (maxEnrollment <= 0) {
                                System.out.println("Max enrollment must be positive!");
                            } else {
                                sc.nextLine();
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a number!");
                            sc.nextLine();
                        }
                    }

                    courseManager.addCourse(new Course(courseCode, courseName, credits, instructor, maxEnrollment));

                    while (true){
                        System.out.print("Add Another Course (Y/N)? ");
                        continueAdding = sc.nextLine().trim().toUpperCase();
                        if (continueAdding.equals("Y") || continueAdding.equals("N")) break;
                        System.out.println("Please enter Y or N!");
                    }

                } while (continueAdding.equalsIgnoreCase("Y"));
                System.out.println();
            }
            case 2 -> {
                String continueAdding = "Y";
                do {
                    System.out.print("Enter Course Code of course to add prerequisites to: ");
                    String courseCode = sc.nextLine();
                    Course course = courseManager.findCourse(courseCode);

                    if (course == null) {
                        System.out.println("Course does not exist!");
                    } else {
                        while (true) {
                            System.out.print("Enter Course Code to add as a prerequisite (Press enter at any time to stop): ");
                            String addPrereqCourse = sc.nextLine().toUpperCase();

                            if (addPrereqCourse.isBlank()) break;

                            if (courseManager.findCourse(addPrereqCourse) == null) {
                                System.out.println("Course does not exist in the system.");
                                continue;
                            }

                            if (addPrereqCourse.equals(course.getCourseCode())) {
                                System.out.println("A course cannot be its own prerequisite!");
                                continue;
                            }

                            course.addPrerequisite(addPrereqCourse);
                        }
                    }

                    while (true){
                        System.out.print("Add Prerequisites to another Course (Y/N)? ");
                        continueAdding = sc.nextLine().trim().toUpperCase();
                        if (continueAdding.equals("Y") || continueAdding.equals("N")) break;
                        System.out.println("Please enter Y or N!");
                    }

                } while (continueAdding.equalsIgnoreCase("y"));
                System.out.println();
            }
            default -> System.out.println("Invalid Option");
        }
    }

    public static void enrollStudentInCourse(Scanner sc, StudentManager studentManager,
                                             CourseManager courseManager, EnrollmentManager enrollmentManager){
        String continueAdding = "Y";
        do {
            String studentId, courseCode, semester;
            System.out.println("Enter the following details for enrollment");

            while (true) {
                System.out.print("Enter the Student Id of student to add: ");
                studentId = sc.nextLine();
                if (studentManager.findStudent(studentId) == null) {
                    System.out.println("Student does not exist, try again.");
                } else break;
            }

            while (true) {
                System.out.print("Enter the Course you want to add the student to: ");
                courseCode = sc.nextLine();
                if (courseManager.findCourse(courseCode) == null) {
                    System.out.println("Course does not exist, try again.");
                } else break;
            }

            System.out.print("Enter the semester (e.g. Fall 2026): ");
            semester = sc.nextLine();

            enrollmentManager.enrollStudent(studentId, courseCode, semester);
            System.out.println("Enrollment Created. Head over to option 7 to assign grade.");

            while (true){
                System.out.print("Add another enrollment (Y/N)? ");
                continueAdding = sc.nextLine().trim().toUpperCase();
                if (continueAdding.equals("Y") || continueAdding.equals("N")) break;
                System.out.println("Please enter Y or N!");
            }

        } while (continueAdding.equalsIgnoreCase("y"));
        System.out.println();
    }

    public static void assignGrade(Scanner sc, StudentManager studentManager,
                                   EnrollmentManager enrollmentManager) {
        String continueAssign = "Y";
        do {
            String studentId, courseCode, enrollmentId, grade;
            int index;

            while (true) {
                System.out.print("Enter the Student Id of student: ");
                studentId = sc.nextLine().trim().toUpperCase();
                if (studentManager.findStudent(studentId) == null) {
                    System.out.println("Student does not exist, try again.");
                } else break;
            }

            System.out.println();
            ArrayList<Enrollment> enrollmentByStudent = enrollmentManager.getEnrollmentsByStudent(studentId);
            if (enrollmentByStudent.isEmpty()){
                System.out.println("Student is not currently enrolled in any courses");
                break;
            }
            ArrayList<String> courseCodes = new ArrayList<>();
            System.out.println("Student is currently enrolled in the following course(s):");
            for (Enrollment e : enrollmentByStudent) {
                System.out.print(e.getCourseCode() + "\n");
                courseCodes.add(e.getCourseCode());
            }

            System.out.println();
            while (true) {
                System.out.print("Enter the Course Code of course to assign grade: ");
                courseCode = sc.nextLine().trim().toUpperCase();
                index = courseCodes.indexOf(courseCode);
                if (index == -1) {
                    System.out.println("Course code doesn't exist, try again.");
                } else break;
            }

            enrollmentId = enrollmentByStudent.get(index).getEnrollmentId();
            while (true) {
                System.out.print("Enter a grade (A, B, C, D, F): ");
                grade = sc.nextLine().trim().toUpperCase();
                if ("A,B,C,D,F".contains(grade)) break;
                System.out.println("Invalid grade, try again.");
            }
            enrollmentManager.assignGrade(enrollmentId, grade);

            while (true){
                System.out.print("Assign another grade (Y/N)? ");
                continueAssign = sc.nextLine().trim().toUpperCase();
                if (continueAssign.equals("Y") || continueAssign.equals("N")) break;
                System.out.println("Please enter Y or N!");
            }

        } while (continueAssign.equalsIgnoreCase("y"));
        System.out.println();
    }

    public static void calculateStudentGpa(Scanner sc, EnrollmentManager enrollmentManager,
                                           StudentManager studentManager){
        String continueCalculating = "Y";
        do {
            String studentId;
            Student student;
            while (true) {
                System.out.print("Enter the Student ID of student: ");
                studentId = sc.nextLine();
                student = studentManager.findStudent(studentId);
                if (student != null) break;
                System.out.println("Student does not exist, enter a valid Student ID.");
            }
            double gpa = enrollmentManager.calculateStudentGpa(studentId);
            if (gpa == -1) {
                System.out.println("Student is not enrolled.");
            } else if (gpa == 0.0){
                System.out.println("Student courses have not been graded yet.");
            }else {
                student.setGpa(gpa);
                System.out.printf("Calculated GPA: %.2f%n", gpa);
            }

            while (true){
                System.out.print("Calculate GPA of another student (Y/N)? ");
                continueCalculating = sc.nextLine().trim().toUpperCase();
                if (continueCalculating.equals("Y") || continueCalculating.equals("N")) break;
                System.out.println("Please enter Y or N!");
            }

        } while (continueCalculating.equalsIgnoreCase("y"));
        System.out.println();
    }

    public static void generateReports(Scanner sc, StudentManager sm,
                                       EnrollmentManager em, CourseManager cm){
        System.out.println();
        ReportGenerator reports = new ReportGenerator();
        int option;
        System.out.println("=== Reports Menu ===");
        System.out.println("1. Generate Student Report\n" +
                "2. Generate Course Report\n" +
                "3. Generate Major Report\n" +
                "4. Generate Honor Roll Report\n");
        while (true) {
            System.out.print("Enter Option: ");
            try {
                option = sc.nextInt();
                sc.nextLine();
                if (option >= 1 && option <= 4) { break; }
                else {
                    System.out.println("Choose an option from the menu!");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a number!");
                System.out.println();
                sc.nextLine();
            }
        }

        switch (option){
            case 1 -> {
                    System.out.print("Enter Student ID of student: ");
                    String studentId = sc.nextLine().trim().toUpperCase();
                    System.out.println();
                    reports.generateStudentReport(studentId, sm, em);
                    System.out.print("Press enter when finished viewing");
                    sc.nextLine();
            }
            case 2 -> {
                System.out.print("Enter Course Code of course: ");
                String courseCode = sc.nextLine().trim().toUpperCase();
                System.out.println();
                reports.generateCourseReport(courseCode, cm, em);
                System.out.print("Press enter when finished viewing");
                sc.nextLine();
            }
            case 3 -> {
                System.out.print("Enter a Major: ");
                String major = sc.nextLine();
                System.out.println();
                reports.generateMajorReport(major, sm);
                System.out.print("Press enter when finished viewing");
                sc.nextLine();
            }
            case 4 -> {
                System.out.print("Enter a Minimum GPA to be considered an Honor Student: ");
                double mingpa = sc.nextDouble();
                System.out.println();
                sc.nextLine();
                reports.generateHonorRollReport(sm, mingpa);
                System.out.print("Press enter when finished viewing");
                sc.nextLine();
            }
        }
    }
}
