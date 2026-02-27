package Homework.Homework2;

import java.util.ArrayList;

/*
Stack is a linear data structure because it stores data sequentially
Follows Last In First Out (LIFO) principle meaning it can only access top(last) element
All methods operate in O(1) since you are accessing 1 element (top of stack)
Java's stack import is legacy but the concept of a stack is not (widely used)
 */
public class GenericStack <T>{
    private ArrayList<T> stack = new ArrayList<>();

    //adds to top
    void push(T item) { stack.add(item); }

    //removes and returns top
    T pop() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        else
            return stack.remove(size()-1);
    }

    // returns top without removing
    T peek() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        else
            return stack.get(size()-1);
    }

    //checks if empty
    boolean isEmpty() { return stack.isEmpty(); }

    //returns size
    int size() { return stack.size(); }

    //clears stack
    void clear() { stack.clear(); }
}