package Homework.Homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class ArrayListUtils {

    public static <T> void swap(ArrayList<T> list, int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static <T extends Comparable<T>> T findMax(ArrayList<T> list) {
        if (list == null || list.isEmpty()){
            return null;
        }

        T max = list.get(0);
        for (T value : list) {
            if (value.compareTo(max) > 0){
                max = value;
            }
        }
        return max;
    }

    public static <T> ArrayList<T> filter(ArrayList<T> list, Predicate<T> condition) {
        ArrayList<T> result = new ArrayList<>();

        if (list == null || condition == null){
            return null;
        }

        for (T value : list){
            if (condition.test(value)){
                result.add(value);
            }
        }

        return result;
    }

    public static <T> void reverse(ArrayList<T> list) {
        if (list == null || list.isEmpty()) return;
        Collections.reverse(list);
    }

    public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }

    public static <T extends Number> double sum(ArrayList<T> numbers) {
        double total = 0;
        for (T value : numbers){
            total += value.doubleValue();
        }
        return total;
    }

    public static <T extends Number> double average(ArrayList<T> numbers) {
        double total = sum(numbers);
        return total/numbers.size();
    }

    //Returns numbers greater than threshold
    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> numbers, T threshold){
        ArrayList<T> filteredList = new ArrayList<>();

        if (numbers == null || threshold == null) return filteredList;

        for (T value : numbers) {
            if (value.compareTo(threshold) > 0){
                filteredList.add(value);
            }
        }
        return filteredList;
    }

    //Wildcards

    //Can only read, cannot write (except null). Type is known.
    public static double sumNumbers(ArrayList<? extends Number> numbers) {
        double total = 0;
        for (Number number : numbers) {
            total+=number.doubleValue();
        }
        return total;
    }

    //Can only write
    public static void addNumbers(ArrayList<? super Integer> list) {
        for (int i=0; i<=5;i++){
            list.add(i);
        }
    }

    //ArrayList can be of any type so cannot add, only read as Object since every type extends from Obj
    public static void printList(ArrayList<?> list) {
        for (Object obj : list){
            System.out.println(obj);
        }
    }

    /*
    Use the <?> wildcard when you want to read data and don't care about the specific type. Impossible to add values.
    Use the <? extends T> when you want to read data of a specific type but do not need to add values.
    Use the <? super T> when you want to insert data and do not care about reading a specific type.
     */
}