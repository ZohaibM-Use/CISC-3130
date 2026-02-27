# 🎓 Student Course Management System

## 📌 Overview
This project is a Java-based Student Course Management System designed to manage students, courses, and enrollments. The system allows users to perform operations such as adding students and courses, enrolling students, assigning grades, calculating GPA, and generating reports.

The program demonstrates object-oriented programming, custom data structures, and Java generics.

---

## 📂 Classes Description

### **Student**
Represents a student in the system.
- Attributes: studentId, firstName, lastName, email, GPA, major, year
- Responsibilities:
  - Store student data
  - Provide getters/setters
  - Display formatted output

---

### **Course**
Represents a course.
- Attributes: courseCode, courseName, credits, instructor, maxEnrollment, prerequisites
- Responsibilities:
  - Store course information
  - Manage prerequisites
  - Display course details

---

### **Enrollment**
Represents the relationship between a student and a course.
- Attributes: enrollmentId, studentId, courseCode, semester, grade
- Responsibilities:
  - Track student enrollment
  - Store grades
  - Convert grades to GPA points

---

### **StudentManager**
Handles all student operations.
- Responsibilities:
  - Add, remove, find students
  - Maintain student records

---

### **CourseManager**
Handles course-related operations.
- Responsibilities:
  - Add courses
  - Find courses
  - Manage prerequisites

---

### **EnrollmentManager**
Handles enrollment logic.
- Responsibilities:
  - Enroll students in courses
  - Assign grades
  - Calculate GPA
  - Retrieve enrollments by student or course
  - Middle-Man class that relates Students and Courses

---

### **GenericList<T>**
Custom implementation of a generic list using `ArrayList`.
- Responsibilities:
  - Add, remove, search items
  - Provide reusable list functionality
  - Demonstrate generics

---

### **GenericStack<T>**
Custom stack implementation (LIFO - Last In First Out).
- Responsibilities:
  - Push items onto the stack
  - Pop items from the stack
  - Peek at top element
- Use case:
  - Undo operations
  - Tracking recent actions

---

### **GenericQueue<T>**
Custom queue implementation (FIFO - First In First Out).
- Responsibilities:
  - Enqueue items
  - Dequeue items
  - Process items in order
- Use case:
  - Processing tasks or requests

---

### **Pair<K, V>**
Generic class that stores two related values.
- Responsibilities:
  - Store key-value pairs
- Use case:
  - Returning multiple values from a method
  - Mapping relationships

---

### **ArrayListUtils**
Utility class for working with ArrayLists.
- Responsibilities:
  - Provide helper methods (e.g., finding max value)
- Use case:
  - Supports GenericList operations

---

### **ReportGenerator**
Generates reports for students and courses.
- Responsibilities:
  - Generate student reports (student info + enrollments)
  - Generate course reports (course info + students + average grades)

---

### **StudentManagementSystemMain**
Provides a menu-driven interface.
- Responsibilities:
  - Handle user input
  - Call manager methods
  - Control program flow

---

## ▶️ How to Compile and Run

### **Compile**
