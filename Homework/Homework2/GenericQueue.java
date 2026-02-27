package Homework.Homework2;

import java.util.ArrayList;

/*
Queue is a linear data structure because it stores data sequentially
Follows First In First Out (FIFO) principle meaning it can only access the first element
All methods are O(1) in an efficient implementation.
ArrayList is not efficient because removing from the front requires shifting of all elements
This example - dequeue is O(n) since all elements need to shift after removing
A better alternative is to use LinkedLists to create a queue
Java has a queue import that has methods in O(1) -
The Queue import is an interface, ArrayDeque is the actual class that implements queue
 */
public class GenericQueue <T> {
    private ArrayList<T> queue = new ArrayList<>();

    //adds to back
    void enqueue(T item) { queue.add(item); }

    //removes and returns front
    T dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty.");
        }
        else
            return queue.remove(0);
    }

    //returns front without removing
    T peek() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty.");
        }
        else
            return queue.get(0);
    }

    //checks if empty
    boolean isEmpty() { return queue.isEmpty(); }

    //returns size
    int size() { return queue.size(); }
}