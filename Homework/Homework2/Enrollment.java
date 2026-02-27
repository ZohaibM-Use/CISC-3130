package Homework.Homework2;

public class Enrollment {
    private String enrollmentId, studentId, courseCode,
    grade, //"A", "B", "C", "D", "F", or null if not graded yet
    semester; //e.g., "Fall 2024", "Spring 2024"

    //Constructors
    public Enrollment() {
        this("N/A", "N/A", "N/A", "N/A");
    }

    public Enrollment(String enrollmentId, String studentId, String courseCode, String semester) {
        this.studentId = studentId.toUpperCase();
        this.courseCode = courseCode.toUpperCase();
        this.semester = semester;
        this.grade = null;
        this.enrollmentId =enrollmentId.toUpperCase();
    }

    public Enrollment(String enrollmentId, String studentId,
                      String courseCode, String grade, String semester) {
        this.enrollmentId = enrollmentId.toUpperCase();
        this.studentId = studentId.toUpperCase();
        this.courseCode = courseCode.toUpperCase();
        this.grade = (grade == null) ? null : grade.toUpperCase();
        this.semester = semester;
    }

    //Getters and Setters
    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId.toUpperCase();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId.toUpperCase();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode.toUpperCase();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = (grade == null) ? null : grade.toUpperCase();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    //converts letter grade to points (A=4.0, B=3.0, C=2.0, D=1.0, F=0.0)
    public double getGradePoints() {
        if (grade == null) {
            return -1;
        }

        return switch (grade.toUpperCase()) {
            case "A" -> 4.0;
            case "B" -> 3.0;
            case "C" -> 2.0;
            case "D" -> 1.0;
            case "F" -> 0.0;
            default -> -1;
        };
    }

    //returns true if grade is A, B, C, or D
    public boolean isPassing() {
        return grade != null && !grade.equalsIgnoreCase("F");
    }

    @Override
    public String toString() {
        return String.format("%-13S | %-10S | %-11S | %-5S | %-12s",
                enrollmentId, studentId, courseCode, grade, semester);
    }
}
