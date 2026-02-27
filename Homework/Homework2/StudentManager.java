package Homework.Homework2;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    //adds student (check for duplicate studentId)
    void addStudent(Student student){
        if (students.contains(student)) {
            System.out.println("Student already exists!");
            return;
        }
        students.add(student);
    }

    //removes student by ID
    boolean removeStudent(String studentId){
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            Student s = it.next();
            if(studentId.equalsIgnoreCase(s.getStudentId())){
                it.remove();
                return true;
            }
        }
        return false;
    }

    //finds student, returns null if not found
    Student findStudent(String studentId){
        for (Student student : students){
            if (student.getStudentId().equalsIgnoreCase(studentId)){
                return student;
            }
        }
        return null;
    }

    //returns students in major
    ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> studentsByMajor = new ArrayList<>();

        for (Student student : students){
            if (student.getMajor().equalsIgnoreCase(major))
                studentsByMajor.add(student);
        }
        return studentsByMajor;
    }

    //returns student by year
    ArrayList<Student> getStudentsByYear(int year){
        ArrayList<Student> studentsByYear = new ArrayList<>();

        for (Student student : students){
            if (student.getYear() == year)
                studentsByYear.add(student);
        }
        return studentsByYear;
    }

    //returns students with GPA >= minGpa
    ArrayList<Student> getHonorStudents(double minGpa){
        ArrayList<Student> honorStudents = new ArrayList<>();

        for (Student student : students){
            if (student.getGpa() >= minGpa)
                honorStudents.add(student);
        }
        return honorStudents;
    }

    //calculates average GPA of all students
    double getAverageGpa() {
        if (students.isEmpty()) return 0.0;

        double total = 0;
        for (Student student : students) {
            total += student.getGpa();
        }
        double avg = total / getTotalStudents();
        return Math.round(avg * 100.0)/ 100.0;
    }

    //calculates average GPA for major
    double getAverageGpaByMajor(String major) {
        ArrayList<Student> studentsByMajor = getStudentsByMajor(major);
        if (studentsByMajor.isEmpty()) return 0.0;

        double total = 0;
        for (Student student : studentsByMajor) {
            total += student.getGpa();
        }
        double avg = total / studentsByMajor.size();
        return Math.round(avg * 100.0)/ 100.0;
    }

    // prints all students in formatted table
    void printAllStudents() {
        if (students.isEmpty()){
            System.out.println("No Students Added!");
            return;
        }

        System.out.printf("%-10S | %-10S | %-10S | %-30S | %-4S | %-20S | %-4S%n",
                "Student Id", "First Name", "Last Name", "Email", "GPA", "Major", "Year");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Student student : students) System.out.println(student);
    }

    //returns number of students
    int getTotalStudents(){
        return students.size();
    }

    //returns list of all unique majors
    ArrayList<String> getAllMajors() {
        ArrayList<String> allMajors = new ArrayList<>();

        for (Student student : students){
            if (!(allMajors.contains(student.getMajor().toUpperCase())))
                allMajors.add(student.getMajor());
        }
        return allMajors;
    }
}