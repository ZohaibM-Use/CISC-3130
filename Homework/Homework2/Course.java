package Homework.Homework2;

import java.util.ArrayList;

public class Course {
    private String courseCode, courseName, instructor;
    private int credits, maxEnrollment;
    private ArrayList<String> prerequisites = new ArrayList<>();

    //Constructors


    public Course() {
        this ("N/A", "N/A", 0, "N/A", 0);
    }

    public Course(String courseCode, String courseName, int credits,
                  String instructor, int maxEnrollment) {
        this.courseCode = courseCode.toUpperCase();
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
        this.maxEnrollment = maxEnrollment;
    }

    //Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode.toUpperCase();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public void addPrerequisite(String courseCode){
        if (courseCode != null && !courseCode.isBlank()) {
            prerequisites.add(courseCode.toUpperCase());
        }
    }

    public ArrayList<String> getPrerequisites(){
        return new ArrayList<>(prerequisites);
    }

    public boolean hasPrerequisite(String courseCode) {
        if (courseCode == null || courseCode.isBlank()) return false;
        return prerequisites.contains(courseCode.toUpperCase());
    }

    //Override
    @Override
    public String toString() {
        String prereqString = prerequisites.isEmpty() ? "No Prerequisites" : String.join(", ", prerequisites);
        return String.format("%-11S | %-30s | %-20s | %-7d | %-10d | %-30S",
                courseCode, courseName, instructor, credits, maxEnrollment, prereqString);
    }
}
