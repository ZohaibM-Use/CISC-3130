package Homework.Homework2;

import java.util.ArrayList;
import java.util.Collections;

public class GenericList <T> {
    ArrayList<T> items = new ArrayList<>();

    void add(T item) {
        if (item == null) {
            System.out.println("Item cannot be null.");
            return;
        }
        else items.add(item);
    }

    T get(int index) {
        if (index < 0 || index >= items.size()){
            System.out.println("Index out of bounds");
            return null;
        }
        return items.get(index);
    }

    boolean remove(T item) {
        if (item == null){
            System.out.println("Item cannot be null");
            return false;
        }
        return items.remove(item);
    }

    int size() { return items.size(); }

    boolean isEmpty() { return items.isEmpty(); }

    void clear() { items.clear(); }

    boolean contains(T item) { return items.contains(item); }

    ArrayList<T> getAll() {
        ArrayList<T> copy = new ArrayList<>();
        copy.addAll(items);
        return copy;
    }

    void addAll(ArrayList<T> other) { items.addAll(other); }

    <U extends T> void addAllFrom(GenericList<U> other) {
        for (U item : other.getAll()) add(item);
    }

    void sort() {
        if (!items.isEmpty() && items.get(0) instanceof Comparable){
            Collections.sort((ArrayList) items);
        }
        else
            System.out.println("Cannot sort since type does not implement Comparable.");
    }

    T findMax() {
        if (isEmpty()) return null;

        if (!(items.get(0) instanceof Comparable)) {
            System.out.println("Cannot find max since type does not implement Comparable.");
            return null;
        }

        return (T) ArrayListUtils.findMax((ArrayList)this.items);
    }
}