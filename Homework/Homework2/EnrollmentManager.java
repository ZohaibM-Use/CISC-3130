package Homework.Homework2;

import java.util.ArrayList;

public class EnrollmentManager {
    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    //creates enrollment
    void enrollStudent(String studentId, String courseCode, String semester) {
        String enrollmentId = String.format("E%03d", enrollments.size()+1);
        enrollments.add(new Enrollment(enrollmentId, studentId, courseCode, semester));
    }

    //removes enrollment
    boolean dropEnrollment(String enrollmentId) {
        return enrollments.removeIf(enrollment -> enrollment.getEnrollmentId().equalsIgnoreCase(enrollmentId));
    }

    //finds enrollment
    Enrollment findEnrollment(String enrollmentId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getEnrollmentId().equalsIgnoreCase(enrollmentId)) {
                return enrollment;
            }
        }
        System.out.println("Enrollment Not Found!");
        return null;
    }

    //returns student's enrollments
    ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) {
        ArrayList<Enrollment> enrollmentByStudent = new ArrayList<>();

        for (Enrollment enrollment : enrollments){
            if (enrollment.getStudentId().equalsIgnoreCase(studentId)){
                enrollmentByStudent.add(enrollment);
            }
        }
        return enrollmentByStudent;
    }

    //returns course enrollments
    ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) {
        ArrayList<Enrollment> enrollmentByCourse = new ArrayList<>();

        for (Enrollment enrollment : enrollments){
            if (enrollment.getCourseCode().equalsIgnoreCase(courseCode)){
                enrollmentByCourse.add(enrollment);
            }
        }
        return enrollmentByCourse;
    }

    //assigns grade to enrollment
    void assignGrade(String enrollmentId, String grade) {
        Enrollment e = findEnrollment(enrollmentId);
        if (e == null) {
            System.out.println("Enrollment not Found!");
            return;
        }

        String[] validGrades = {"A", "B", "C", "D", "F"};
        for (String valid : validGrades) {
            if (grade.equalsIgnoreCase(valid)) {
                e.setGrade(grade.toUpperCase());
                System.out.println("Grade Assigned!");
                return;
            }
        }
        System.out.println("Invalid Grade!");
    }

    //calculates GPA from enrollments
    double calculateStudentGpa(String studentId) {
        ArrayList<Enrollment> enrollmentByStudent = getEnrollmentsByStudent(studentId);
        if (enrollmentByStudent.isEmpty()){
            return -1.0;
        }

            double total = 0;
            double gradedEnrollments = 0;
            for (Enrollment enrollment : enrollmentByStudent){
                if (enrollment.getGradePoints()>=0) {
                    total += enrollment.getGradePoints();
                    gradedEnrollments++;
                }
            }
            double gpa = gradedEnrollments == 0 ? 0.0 : total / gradedEnrollments;
            gpa = Math.round(gpa * 100.0) / 100.0;
            return gpa;
    }

    //returns list of student IDs
    ArrayList<String> getStudentsInCourse(String courseCode) {
        ArrayList<Enrollment> enrollmentsByCourse = getEnrollmentsByCourse(courseCode);
        if (!enrollmentsByCourse.isEmpty()){
            ArrayList<String> studentsInCourse = new ArrayList<>();
            for (Enrollment enrollment : enrollmentsByCourse){
                studentsInCourse.add(enrollment.getStudentId());
            }
            return studentsInCourse;
        }
        return null;
    }

    //returns number of students in course
    int getEnrollmentCount(String courseCode) {
        ArrayList<String> studentsInCourse = getStudentsInCourse(courseCode);
        if (studentsInCourse != null){
            return studentsInCourse.size();
        }
        return 0;
    }

    //prints all enrollments
    void printAllEnrollments(){
        if (enrollments.isEmpty()){
            System.out.println("No Enrollments Currently!");
            return;
        }

        System.out.printf("%-13S | %-10S | %-11S | %-5S | %-12S%n",
                "Enrollment ID", "Student ID", "Course Code", "Grade", "Semester");
        System.out.println("------------------------------------------------------------");
        for (Enrollment enrollment : enrollments) System.out.println(enrollment);
    }
}