package Homework.Homework2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();

    //adds course
    void addCourse(Course course) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(course.getCourseCode())){
                System.out.println("Course Already Exists!");
                return;
            }
        }
        courses.add(course);
    }

    //finds course
    Course findCourse(String courseCode) {
        for (Course course : courses){
            if (course.getCourseCode().equalsIgnoreCase(courseCode)){
                return course;
            }
        }
        return null;
    }

    //returns instructor's courses
    ArrayList<Course> getCoursesByInstructor(String instructor){
        ArrayList<Course> coursesByInstructor = new ArrayList<>();

        for (Course course : courses){
            if (course.getInstructor().equalsIgnoreCase(instructor)){
                coursesByInstructor.add(course);
            }
        }
        return coursesByInstructor;
    }

    //returns courses student can take (not already enrolled, prerequisites met)
    ArrayList<Course> getAvailableCourses(String studentId,
                                          StudentManager studentManager, EnrollmentManager enrollmentManager){

        if (studentManager.findStudent(studentId) == null) return new ArrayList<>();

        // Courses student has already taken
        ArrayList<Enrollment> enrollmentByStudent = enrollmentManager.getEnrollmentsByStudent(studentId);
        ArrayList<String> coursesStudentHasTaken = new ArrayList<>();
        for (Enrollment enrollment : enrollmentByStudent){
            coursesStudentHasTaken.add(enrollment.getCourseCode().toUpperCase());
        }

        // Predicate to check availability
        Predicate<Course> canTake = course -> {
            if (coursesStudentHasTaken.contains(course.getCourseCode().toUpperCase())) {
                return false;
            }
            for (String prereq : course.getPrerequisites()) {
                if (!coursesStudentHasTaken.contains(prereq.toUpperCase())) {
                    return false;
                }
            }
            return true;
        };

        // Use filter utility
        return ArrayListUtils.filter(courses, canTake);
    }

    //prints all courses
    void printAllCourses() {
        if (courses.isEmpty()){
            System.out.println("No Courses Added!");
            return;
        }

        System.out.printf("%-11S | %-30S | %-20S | %-7S | %-10S | %-30S%n",
                "Course Code", "Course Name", "Instructor", "Credits", "Max Enroll", "Prerequisites");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        for (Course course : courses) System.out.println(course);
    }

    //returns number of courses
    int getTotalCourses() { return courses.size(); }
}
