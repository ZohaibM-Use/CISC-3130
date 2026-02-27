# Student Course Management System

## Overview
This project is a Java-based Student Course Management System designed to manage students, courses, and enrollments. The system allows users to perform operations such as adding students and courses, enrolling students, assigning grades, calculating GPA, and generating reports.

The program demonstrates object-oriented programming, custom data structures, and Java generics.

---

## ⚙️ How to Compile & Run

**Compile all Java files:**
Run InventorySystemMain.java

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

## 🎓 Lessons Learned

#### ArrayLists
- **Dynamic sizing:** Unlike arrays, `ArrayList` automatically grows and shrinks as elements are added or removed, which is ideal for managing students, courses, and enrollments without predefining a fixed size.  
- **Convenience methods:** Methods such as `.add()`, `.remove()`, `.contains()`, `.get()`, and `.size()` simplify operations that would require manual index management with arrays.  
- **Iteration:** `for-each` loops or iterators allow safe and clean traversal of elements.  
- **Integration with objects:** ArrayLists can store custom objects, enabling features like filtering students by major, listing enrollments, and managing courses with prerequisites.

#### Generics
- **Type safety:** Generics (e.g., `GenericList<T>`, `GenericStack<T>`, `GenericQueue<T>`, `Pair<K,V>`) ensure that collections store only the expected type, preventing runtime errors such as `ClassCastException`.  
- **Reusability:** One generic class can work with multiple data types, reducing code duplication and increasing flexibility.  
- **Flexibility for utility classes:** Generic utility classes like `ArrayListUtils` allow operations (like finding a maximum element) to work across different object types implementing `Comparable`.  
- **Cleaner code:** Generics eliminate the need for casting objects when retrieving them from collections, improving readability and maintainability.

### ArrayList vs Arrays
- **Size:** Arrays are fixed in size, while ArrayLists can dynamically grow or shrink.
- **Flexibility:** ArrayLists provide built-in methods such as `add()`, `remove()`, `contains()`, and `size()`, whereas arrays require manual management.
- **Performance:** Arrays can be slightly faster due to no method overhead, but ArrayLists provide convenience at a small performance cost.
- **Usability:** ArrayLists simplify many operations that would require loops and manual checks with arrays.

### Queue
- Queue is a **linear data structure** because it stores data sequentially.  
- Follows **First In First Out (FIFO)** principle, meaning only the first element can be accessed or removed next.  
- All operations can be **O(1)** in an efficient implementation.  
- Using an `ArrayList` for a queue is **not efficient** because removing from the front requires shifting all elements.  
  - In such a case, `dequeue` is **O(n)** since all elements need to shift after removing.  
  - A better alternative is to use a **LinkedList** to implement a queue.  
- Java provides a **Queue interface** and an **ArrayDeque** class that implements it efficiently with **O(1)** operations.  

### Stack
- Stack is a **linear data structure** because it stores data sequentially.  
- Follows **Last In First Out (LIFO)** principle, meaning only the top (last) element can be accessed or removed next.  
- All stack operations are **O(1)** since only the top element is accessed.  
- Java’s `Stack` class is considered **legacy**, but the **concept of a stack** is widely used in programming.
 

