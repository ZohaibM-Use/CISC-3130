package Homework.Homework2;

import java.util.ArrayList;

public class ReportGenerator {

    //prints student info, courses, GPA
    void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em){
        Student student = sm.findStudent(studentId);
        if (student == null){
            System.out.println("Student does not exit!");
            return;
        }

        ArrayList<Enrollment> enrollmentsByStudent = em.getEnrollmentsByStudent(studentId);
        if (enrollmentsByStudent.isEmpty()){
            System.out.println("Student currently not enrolled in any courses!");
            return;
        }

        System.out.println("Student Info");
        System.out.printf("%-10S | %-10S | %-10S | %-30S | %-4S | %-20S | %-4S%n",
                "Student Id", "First Name", "Last Name", "Email", "GPA", "Major", "Year");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println(student);
        System.out.println();

        System.out.println("Courses");
        System.out.printf("%-13S | %-10S | %-11S | %-5S | %-12S%n",
                "Enrollment ID", "Student ID", "Course Code", "Grade", "Semester");
        System.out.println("------------------------------------------------------------");
        for (Enrollment enrollment : enrollmentsByStudent) System.out.println(enrollment);
        System.out.println();

        System.out.println("Current GPA: " + student.getGpa());
        System.out.println();
    }


    //prints course info, enrolled students, average grade
    void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em) {
        Course course = cm.findCourse(courseCode);
        if (course == null) {
            System.out.println("Course does not exist!");
            return;
        }

        ArrayList<Enrollment> studentsInCourse = em.getEnrollmentsByCourse(courseCode);
        if (studentsInCourse.isEmpty()){
            System.out.println("No students in this course!");
            return;
        }

        System.out.println("Course Info");
        System.out.printf("%-11S | %-30S | %-20S | %-7S | %-10S | %-30S%n",
                "Course Code", "Course Name", "Instructor", "Credits", "Max Enroll", "Prerequisites");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(course);
        System.out.println();

        double totalGpa = 0;
        int gradedStudents = 0;
        System.out.println("Students in Course");
        for (Enrollment enrollment : studentsInCourse){
            System.out.println(enrollment.getStudentId() + " ");
            if (enrollment.getGradePoints() != -1){
                totalGpa += enrollment.getGradePoints();
                gradedStudents++;
            }
        }
        System.out.println();

        double avg = totalGpa / gradedStudents;
        if (avg > 0) {
            System.out.printf("Average Grade: %.2f%n", avg);
        } else {
            System.out.println("Average Grade not available, grades not yet assigned.");
        }
    }


    //prints all students in major, average GPA
    void generateMajorReport(String major, StudentManager sm){
        ArrayList<Student> studentsInMajor = sm.getStudentsByMajor(major);
        if (studentsInMajor.isEmpty()){
            System.out.println("No Students In Major!");
            return;
        }

        System.out.println("Students In Major");
        System.out.printf("%-10S | %-10S | %-10S | %-30S | %-4S | %-20S | %-4S%n",
                "Student Id", "First Name", "Last Name", "Email", "GPA", "Major", "Year");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Student student : studentsInMajor) System.out.println(student);
        System.out.println();

        System.out.println("Average GPA in Major: " + sm.getAverageGpaByMajor(major));
        System.out.println();
    }


    //prints honor students
    void generateHonorRollReport(StudentManager sm, double minGpa) {
        ArrayList<Student> honorRollStudents = sm.getHonorStudents(minGpa);

        if (honorRollStudents.isEmpty()){
            System.out.println("No Honor Roll Students.");
            return;
        }

        System.out.printf("%-10S | %-10S | %-10S | %-30S | %-4S | %-20S | %-4S%n",
                "Student Id", "First Name", "Last Name", "Email", "GPA", "Major", "Year");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Student student : honorRollStudents) System.out.println(student);
        System.out.println();
    }
}