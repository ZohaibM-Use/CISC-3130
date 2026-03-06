package Labs.Lab2;

public class LinkedListStarter {

    // Student class
    static class Student {
        private String name;
        private String studentId;
        private double gpa;

        public Student() {
            this("N/A", "N/A", 0.0);
        }

        public Student(String name, String studentId, double gpa) {
            this.name = name;
            this.studentId = studentId;
            this.gpa = gpa;
        }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public String getStudentId() { return studentId; }

        public void setStudentId(String studentId) { this.studentId = studentId; }

        public double getGpa() { return gpa; }

        public void setGpa(double gpa) { this.gpa = gpa; }

        @Override
        public String toString() {
            return this.name + " " + this.studentId + " " + this.gpa;
        }
    }



    // Node class for linked list
    static class Node {
        Student student;
        Node next;

        public Node(Student student) {
            this.student = student;
            this.next = null;
        }

        public Node(Student student, Node next) {
            this.student = student;
            this.next = next;
        }
    }



    // StudentLinkedList class
    static class StudentLinkedList {
        private Node head;
        private int size;

        public StudentLinkedList() {
            this.head = null;
            this.size = 0;
        }

        public void append(Student student) {
            // Add student to the end of the list
            if (this.head == null){
                this.head = new Node(student);
            } else {
                Node lastNode = this.head;
                while (lastNode.next != null) {
                    lastNode = lastNode.next;
                }

                lastNode.next = new Node(student);
            }
            this.size++;
        }

        public void prepend(Student student) {
            // Add student to the beginning of the list
            if (this.head == null) {
                this.head = new Node(student);
            } else {
                Node tempHead = this.head;
                this.head = new Node(student, tempHead);
            }
            this.size++;
        }

        // TODO: Implement delete method
        public boolean delete(String studentId) {
            // Remove student by ID, return true if found and removed
            if (this.head == null){
                return false;
            }

            Node currentNode = this.head;
            if (currentNode.student.getStudentId().equalsIgnoreCase(studentId)){
                this.head = currentNode.next;
                this.size--;
                return true;
            }

            Node previousNode = null;
            while(currentNode != null){
                Student student = currentNode.student;
                if (student.getStudentId().equalsIgnoreCase(studentId)){
                    previousNode.next = currentNode.next;
                    this.size--;
                    return true;
                }
                else {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
            return false;
        }

        // TODO: Implement find method
        public Student find(String studentId) {
            // Find and return student by ID, or null if not found
            if (this.head == null){
                return null;
            }
            Node currentNode = this.head;
            while (currentNode != null){
                Student student = currentNode.student;
                if (student.getStudentId().equalsIgnoreCase(studentId)){
                    return student;
                }
                currentNode = currentNode.next;
            }

            return null;
        }

        //Print all Students in list
        public void printAll() {
            Node currentNode = this.head;
            if (currentNode == null){
                System.out.println("No Students");
            }

            while (currentNode != null){
                Student student = currentNode.student;
                System.out.println(student);
                currentNode = currentNode.next;
            }
        }

        // TODO: Implement getAverageGPA method
        public double getAverageGPA() {
            // Calculate and return the average GPA
            if (this.head == null) {
                return 0.0;
            }
            double total = 0.0;
            Node currentNode = this.head;
            while (currentNode != null){
                Student student = currentNode.student;
                total += student.getGpa();
                currentNode = currentNode.next;
            }
            return total/getSize();
        }

        // TODO: Implement getSize method
        public int getSize() {
            // Return the number of students
            return size;
        }
    }

    // Test your implementation here
    public static void main(String[] args) {
        // TODO: Create a StudentLinkedList
        StudentLinkedList linkedList = new StudentLinkedList();
        linkedList.printAll();
        System.out.println("After appending");
        linkedList.append(new Student("John", "S001", 3.2));
        linkedList.append(new Student("Lacy", "S002", 2.6));
        linkedList.append(new Student("Gran", "S003", 3.4));
        linkedList.printAll();
        System.out.println("After Prepend");
        linkedList.prepend(new Student("Kacy", "S004", 3.9));
        linkedList.printAll();
        System.out.println("Finding S003");
        System.out.println(linkedList.find("S003"));
        System.out.println("Deleting a student");
        linkedList.delete("S003");
        linkedList.printAll();
        System.out.println("GPA of students");
        System.out.println(linkedList.getAverageGPA());

        // TODO: Add some students
        // TODO: Test all your methods

        System.out.println("Lab 2: Student Roster Using Linked Lists");
        System.out.println("Complete the TODO items above!");
    }
}
