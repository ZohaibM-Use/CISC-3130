package Homework.Homework2;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListVsArrayDemo {
    ArrayListVsArrayDemo() {
        Student s1 = new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2);
        Student s2 = new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3);
        Student s3 = new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2);
        Student s4 = new Student("S004", "Kimberly", "Alter", "KimAlt@example.com", 3.0, "English", 1);
        Student s5 = new Student("S005", "James", "Griff", "JGriff@example.com", 2.9, "Science", 4);

        Student[] studentArray = new Student[3];
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArray[0] = s1;
        studentArray[1] = s2;
        studentArray[2] = s3;
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);

        System.out.println("Adding elements to Arrays vs ArrayLists");
        System.out.println("---------------------------------------");
        try {
            studentArray[3] = s4;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array at max capacity. Cannot add more elements.");
        }
        studentArrayList.add(s4);
        System.out.println("Array");
        for (Student student : studentArray) System.out.println(student);
        System.out.println("ArrayList");
        for (Student student : studentArrayList) System.out.println(student);

        System.out.println();
        System.out.println("Removing elements from Arrays vs ArrayLists");
        System.out.println("-------------------------------------------");
        studentArray[1] = null;
        studentArrayList.remove(s2);
        System.out.println("Array");
        for (Student student : studentArray) System.out.println(student);
        System.out.println("ArrayList");
        for (Student student : studentArrayList) System.out.println(student);

        System.out.println();
        System.out.println("Resize Arrays vs Arraylists");
        System.out.println("---------------------------");
        System.out.println("Array Size (Cannot Change without creating new array): " +
                studentArray.length);
        System.out.println("ArrayList Size is not fixed, can add as many elements as needed. Resizing is handled internally.");
        System.out.println("ArrayList size: " + studentArrayList.size());
        studentArrayList.add(s2);
        System.out.println("Size after adding an element: " + studentArrayList.size());
        studentArrayList.add(s5);
        System.out.println("Size after adding an element: " + studentArrayList.size());

        System.out.println();
        System.out.println("===== Comparison Report =====");
        final int TOTAL_STUDENTS = 10_000;
        final int RANDOM_ACCESS = 1_000;
        Random random = new Random();

        //Add to Array
        Student [] comparisonArray = new Student[TOTAL_STUDENTS];
        long startArrayAdd = System.nanoTime();
        for (int i = 0; i < TOTAL_STUDENTS; i++){
            comparisonArray[i] = new Student(
                    String.format("S%05d", i), "Student" + i,
                    "Last" + i, "email" + i + "@example.com",
                    Math.random() * 4, "Major" + (i%5), 1 + (i % 4));
        }
        long endArrayAdd = System.nanoTime();

        //Random access from Array
        long startArrayAccess = System.nanoTime();
        for (int i = 0; i < RANDOM_ACCESS; i++){
            int index = random.nextInt(TOTAL_STUDENTS);
            Student student = comparisonArray[index];
        }
        long endArrayAccess = System.nanoTime();

        //Add to ArrayList
        ArrayList<Student> comparisonArrayList = new ArrayList<>();
        long startArrayListAdd = System.nanoTime();
        for (int i = 0; i < TOTAL_STUDENTS; i++){
            comparisonArrayList.add(new Student(
                    String.format("S%05d", i), "Student" + i,
                    "Last" + i, "email" + i + "@example.com",
                    Math.random() * 4, "Major" + (i%5), 1 + (i % 4)));
        }
        long endArrayListAdd = System.nanoTime();

        //Random access from ArrayList
        long startArrayListAccess = System.nanoTime();
        for (int i = 0; i < RANDOM_ACCESS; i++){
            int index = random.nextInt(TOTAL_STUDENTS);
            Student student = comparisonArrayList.get(index);
        }
        long endArrayListAccess = System.nanoTime();

        //Comparison Report
        System.out.printf("Array Add Time: %.2f ms%n", (endArrayAdd-startArrayAdd) / 1_000_000.0);
        System.out.printf("Array Random Access Time: %.2f ms%n", (endArrayAccess - startArrayAccess) / 1_000_000.0);
        System.out.printf("ArrayList Add Time: %.2f ms%n", (endArrayListAdd - startArrayListAdd) / 1_000_000.0);
        System.out.printf("ArrayList Random Access Time: %.2f ms%n", (endArrayListAccess - startArrayListAccess) / 1_000_000.0);
        System.out.println();
        System.out.println("===== Summary =====");
        System.out.println("Arrays should be used when size is fixed and known in advance, performance is critical since Arrays are faster at accessing, \n" +
                "and when working with primitives since Arrays use less memory. \n" +
                "ArrayLists should be used in any other case: When working with unknown or dynamic sizing, for automatic resizing, \n" +
                "when working with objects, and when clean code is needed since ArrayLists have convenient built in methods.");
    }
}