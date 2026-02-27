package Homework.Homework2;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String studentId, firstName, lastName, email, major;
    private double gpa; //grade point average (0.0 to 4.0)
    private int year; //(1 = Freshman, 2 = Sophomore, 3 = Junior, 4 = Senior)

    //Constructors
    public Student() {
        this("N/A", "N/A", "N/A", "N/A", 0.0, "N/A", 0);
    }

    public Student(String studentId, String firstName, String lastName,
                   String email, double gpa, String major, int year) {
        this.studentId = studentId.toUpperCase();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.year = year;
    }

    //Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId.toUpperCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    //Overrides
    @Override
    public String toString() {
        return String.format("%-10s | %-10s | %-10s | %-30s | %-4.2f | %-20s | %2d",
                studentId, firstName, lastName, email, gpa, major, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Student other)) return false;
        return Objects.equals(this.studentId, other.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public int compareTo(Student other) {
        if (this.getStudentId().equals(other.getStudentId())) {
            return 0;
        }
        return Double.compare(this.getGpa(), other.getGpa());
    }
}