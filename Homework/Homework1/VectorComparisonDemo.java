package Homework.Homework1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class VectorComparisonDemo {
    int addProducts = 10_000;
    int randomAccess = 1_000;

    Vector<Product> vecProducts = new Vector<>();
    ArrayList<Product> arrlistProducts = new ArrayList<>();

    public VectorComparisonDemo() {
        //Prepare Products
        Product[] products = new Product[addProducts];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product("ID: " + i, "Name: " + i,
                    "Category: " + i % 5,
                    Math.round(Math.random() * 1000.0) / 100.0,
                    (i % 50) + 1, "Supplier: " + i % 3);
        }

        //Measure time to add
        long startVectorAdd = System.nanoTime();
        for (Product product : products) vecProducts.add(product);
        long endVectorAdd = System.nanoTime();

        long startArrayAdd = System.nanoTime();
        for (Product product : products) arrlistProducts.add(product);
        long endArrayAdd = System.nanoTime();

        //Measure time to random access
        Random rand = new Random();
        long startVectorAccess = System.nanoTime();
        for (int i=0; i<randomAccess; i++) vecProducts.get(rand.nextInt(addProducts));
        long endVectorAccess = System.nanoTime();

        long startArrayListAccess = System.nanoTime();
        for (int i = 0; i < randomAccess; i++) arrlistProducts.get(rand.nextInt(addProducts));
        long endArrayListAccess = System.nanoTime();

        //Memory usage
        Runtime runtime = Runtime.getRuntime();

        runtime.gc(); //Make memory calculation more accurate by collecting garbage
        long vecMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        Vector<Product> memoryVec = new Vector<>();
        for(Product product:products) memoryVec.add(product);
        runtime.gc();
        long vecMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long vecMemoryUsed = vecMemoryAfter - vecMemoryBefore;

        runtime.gc();
        long arrlistMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        ArrayList<Product> memoryArrlist = new ArrayList<>();
        for(Product product:products) memoryArrlist.add(product);
        runtime.gc();
        long arrlistMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long arrlistMemoryUsed = arrlistMemoryAfter - arrlistMemoryBefore;

        //Print Comparison Report
        System.out.println("==== Vector vs ArrayList Performance Comparison ====");
        System.out.println("Time to add 10,000 products");
        System.out.println("Vector: " + (endVectorAdd - startVectorAdd) + " ns");
        System.out.println("ArrayList: " + (endArrayAdd - startArrayAdd)  + " ns");

        System.out.println("\nTime to access 1,000 random elements");
        System.out.println("Vector: " + (endVectorAccess - startVectorAccess) + " ns");
        System.out.println("ArrayList: " + (endArrayListAccess - startArrayListAccess)  + " ns");

        System.out.println("\nApprox memory usage for storing 10,000 products");
        System.out.println("Vector: " + vecMemoryUsed / 1024 + " KB");
        System.out.println("ArrayList: " + arrlistMemoryUsed / 1024 + " KB");

        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("On average, ArrayLists are faster than Vectors. " +
                "ArrayLists should always be used over Vectors except in certain scenarios.\n" +
                "First, if the code you are working with is using legacy code. \n" +
                "Second, if you are trying to be thread safe. \n" +
                "However, there are now ways to be thread safe with ArrayLists as well.");
    }
}
