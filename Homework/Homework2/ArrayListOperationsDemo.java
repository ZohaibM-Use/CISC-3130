package Homework.Homework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class ArrayListOperationsDemo {

    ArrayListOperationsDemo() {
        Student s1 = new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2);
        Student s2 = new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3);
        Student s3 = new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2);
        Student s4 = new Student("S004", "Kimberly", "Alter", "KimAlt@example.com", 3.0, "English", 1);
        Student s5 = new Student("S005", "James", "Griff", "JGriff@example.com", 2.9, "Science", 4);

        System.out.println("===== Convert Array to ArrayList ===== ");
        Student [] studentsArray = {s1, s2, s3};
        ArrayList<Student> studentsArrayList = new ArrayList(Arrays.asList(studentsArray));
        System.out.println("Array before add/remove");
        for (Student student : studentsArray){
            System.out.println(student);
        }
        System.out.println("ArrayList before add/remove");
        for (Student student : studentsArrayList){
            System.out.println(student);
        }

        studentsArrayList.add(s4);
        studentsArrayList.add(s5);
        studentsArrayList.remove(s2);
        System.out.println("Array after add/remove");
        for (Student student : studentsArray){
            System.out.println(student);
        }
        System.out.println("ArrayList after add/remove");
        for (Student student : studentsArrayList){
            System.out.println(student);
        }

        System.out.println();
        System.out.println("===== ArrayList to Array =====");

        System.out.println("ArrayList Before Converting to Array");
        System.out.println(studentsArrayList);

        Student[] convertedStudentList = studentsArrayList.toArray(new Student[0]);
        System.out.println("ArrayList After Converting to Array");
        for (Student s : convertedStudentList) {
            System.out.println(s);
        }


        System.out.println();
        System.out.println("===== SubList Operations =====");
        List<Student> subListofStudents = studentsArrayList.subList(0,2);
        System.out.println("First element before modification to ArrayList");
        System.out.println(subListofStudents.get(0));
        studentsArrayList.set(0, s2);
        System.out.println("First element after modification to arraylist");
        System.out.println(subListofStudents.get(0));


        System.out.println();
        System.out.println("===== ArrayList Sorting =====");
        System.out.println("Sort by GPA in descending");
        Collections.sort(studentsArrayList, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });
        for (Student s : studentsArrayList) System.out.println(s);

        System.out.println("Sort by Last Name");
        Collections.sort(studentsArrayList, Comparator.comparing(Student :: getLastName));
        for (Student s : studentsArrayList) System.out.println(s);


        System.out.println();
        System.out.println("===== ArrayList Searching =====");
        System.out.println("indexOf() method returns index of element or -1 if not found");
        System.out.println("Student s1 index: " + studentsArrayList.indexOf(s1));
        System.out.println("contains() method checks if an element is found and returns a boolean value");
        System.out.println("Student s2 in the list: " + studentsArrayList.contains(s2));
        System.out.println("Collections.sorts() method works similar to indexOf() method by returning an index. Main difference is efficiency.");
        Collections.sort(studentsArrayList, Comparator.comparing(Student :: getStudentId));
        System.out.println("Student s5 index: " + Collections.binarySearch(
                studentsArrayList, s5, Comparator.comparing(
                        Student :: getStudentId)));


    }
}
