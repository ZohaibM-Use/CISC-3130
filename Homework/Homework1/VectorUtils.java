package Homework.Homework1;

import java.util.Vector;
import java.util.function.Predicate;

public class VectorUtils {

    //Swaps two elements in any Vector
    public static <T> void swap(Vector<T> vec, int index1, int index2){
        T temp = vec.get(index1);
        vec.set(index1, vec.get(index2));
        vec.set(index2, temp);
    }

    //Finds maximum element in Vector
    //Works with any type that implements Comparable
    public static <T extends Comparable<T>> T findMax(Vector<T> vec){
        T max = vec.get(0);
        for (T value: vec){
            if (value.compareTo(max)>0){
                max = value;
            }
        }
        return max;
    }

    //Counts occurrences of target in Vector
    //Uses equals() for comparison
    public static <T> int countMatches(Vector<T> vec, T target){
        int matches = 0;
        for (T value : vec ){
            if (value.equals(target)){
                matches++;
            }
        }
        return matches;
    }

    //Returns new Vector containing elements that match condition
    public static <T> Vector<T> filter(Vector<T> vec, Predicate<T> condition){
        Vector<T> filteredVec = new Vector<>();
        for (T value:vec){
            if(condition.test(value)){
                filteredVec.add(value);
            }
        }
        return filteredVec;
    }

    //Filters products by category
    public static Vector<Product> filterProducts(Vector<Product> vec, String category){
        Vector<Product> filteredProducts = new Vector<>();
        for (Product product:vec){
            if(product.getCategory().equals(category)){
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    //Returns sum as double
    public static <T extends Number> double sumNumbers(Vector<T> numbers){
        double total = 0.0;
        for (T value:numbers) total += value.doubleValue();
        return total;
    }

    //Calculates average
    public static <T extends Number> double averageNumbers(Vector<T> numbers){
        if(numbers.size() == 0) return 0.0;
        return sumNumbers(numbers) / numbers.size();
    }
}