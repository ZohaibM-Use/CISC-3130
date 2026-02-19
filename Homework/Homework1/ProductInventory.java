package Homework.Homework1;

import java.util.Enumeration;
import java.util.Vector;

public class ProductInventory {
    Vector<Product> products = new Vector<>();

    //adds a product (check for duplicates by productId)
    void addProduct(Product product){
        if (products.contains(product)){
            System.out.println("Product already exists!");
            return;
        }
        products.add(product);
        System.out.println("New Product added!");
    }

    //removes product by ID, returns true if found
    boolean removeProduct(String productId){
        for (int i = 0; i < products.size(); i++){
            if((products.get(i).getProductId()).equals(productId)){
                products.remove(i);
                System.out.print(" Product removed = ");
                return true;
            }
        }
        System.out.print("Product removed = ");
        return false;
    }

    //finds and returns product, or null if not found
    Product findProduct(String productId){
        for (Product p: products){
            if(p.getProductId().equals(productId))
                return p;
        }
        return null;
    }

    //returns Vector of products in category
    Vector<Product> getProductsByCategory(String category){
        Vector<Product> productsByCategory = new Vector<>();

        for (Product p: products){
            if (p.getCategory().equals(category)){
                productsByCategory.add(p);
            }
        }
        return productsByCategory;
    }

    //returns products with quantity < threshold
    Vector<Product> getLowStockProducts(int threshold){
        Vector<Product> lowStockProducts = new Vector<>();

        for (Product p: products){
            if (p.getQuantityInStock() < threshold){
                lowStockProducts.add(p);
            }
        }
        return lowStockProducts;
    }

    //calculates total value (price × quantity for all products)
    double getTotalInventoryValue(){
        double totalValue = 0;

        for (Product p: products){
           totalValue += p.getQuantityInStock() * p.getPrice();
        }
        return totalValue;
    }

    //updates stock (can be positive or negative)
    void updateStock(String productId, int quantityChange){
        Product p = findProduct(productId);
        if (p != null) {
            p.setQuantityInStock(p.getQuantityInStock() + quantityChange);
            System.out.println("Product updated!");
        }
        else
            System.out.println("Product not found!");
        }

    //prints all products in a formatted table
    void printAllProducts(){
        System.out.printf("%-10s | %-20s | %-15s | %9s | %8s | %-15s%n",
                "ProductID", "Name", "Category", "Price", "Quantity", "Supplier");
        System.out.println("--------------------------------------------------------------------------------------------");
        products.forEach(p -> System.out.println(p));
    }

    //returns number of products
    int getTotalProducts(){
        return products.size();
    }

    //prints current size and capacity of the Vector
    void printCapacityInfo(){
        System.out.printf("Size: %d%n",products.size());
        System.out.printf("Capacity: %d%n",products.capacity());
    }

    //uses trimToSize() to reduce capacity to match size
    void optimizeCapacity(){
        products.trimToSize();
    }

    //ensures Vector has at least minCapacity
    void ensureCapacity(int minCapacity){
        products.ensureCapacity(minCapacity);
    }

    //prints detailed capacity information:
    void printCapacityReport(){
        printCapacityInfo();
        System.out.printf("Capacity utilization percentage: %.2f%%%n" +
                "Remaining Elements Before Resize: %d%n",
                ((double)products.size()/products.capacity())*100,
                products.capacity()-products.size());
    }

    //Uses Vector's elements() method to get Enumeration<Product>
    /*
    Enumeration is legacy because it is a part of JAVA's collections were introduced.
    It has been replaced by Iterator. Enumeration does not allow for safe removal while Iterator does.
    Enumeration should only be used when working with legacy code, nowadays Iterators are always used.
     */
    public void printProductsUsingEnumeration(){
        Enumeration<Product> p = products.elements();
        while (p.hasMoreElements()){
            Product prod = p.nextElement();
            System.out.println(prod);
        }
    }
}