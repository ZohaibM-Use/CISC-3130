package Homework.Homework1;

import java.util.Vector;

//A wrapper around Vector<T> that adds some utility methods
public class GenericContainer <T> {
    Vector<T> items = new Vector<>();

    //adds item
    void add(T item){
        items.add(item);
    }

    //gets item
    T get(int index){
        return items.get(index);
    }

    //removes item
    boolean remove(T item){
        return items.remove(item);
    }

    //returns size
    int size(){
        return items.size();
    }

    //returns copy of all items
    Vector<T> getAll(){
        return new Vector<>(items);
    }

    //clears container
    void clear(){
        items.clear();
    }

    //checks if contains item
    boolean contains(T item){
       return items.contains(item);
    }

    //adds all from another vector
    void addAll(Vector<T> other){
        items.addAll(other);
    }
}
