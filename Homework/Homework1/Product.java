package Homework.Homework1;

public class Product implements Comparable<Product> {
    private String productId;
    private String name;
    private String category;
    private double price;
    private int quantityInStock;
    private String supplier;

    //Constructors
    public Product(){
        this("N/a", "N/a","N/a",
                0.00, 0, "N/a");
    }

    public Product(String productId, String name, String category,
                   double price, int quantityInStock, String supplier){
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.supplier = supplier;
    }

    //Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    //Overrides
    @Override
    public String toString(){
        return String.format(
                "%-10s | %-20s | %-15s | $%,8.2f | %8d | %-15s",
                productId, name, category, price, quantityInStock, supplier
        );
    }

    @Override
    public boolean equals(Object obj){
    Product other = (Product) obj;
    return this.productId.equals(other.productId);
    }

    @Override
    public int hashCode() {
        return productId.hashCode();
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }
}