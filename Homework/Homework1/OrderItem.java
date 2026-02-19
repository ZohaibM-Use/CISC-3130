package Homework.Homework1;

public class OrderItem {
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    //Constructors
    public OrderItem() {
        this("N/A", "N/A", 0, 0.0, 0.0);
    }

    public OrderItem(String productId, String productName,
                     int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderItem(String productId, String productName,
                     int quantity, double unitPrice, double subtotal) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    //Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    //toString Override
    @Override
    public String toString() {
        return String.format(
                "%-10s | %-15s | %-8d | $%-8.2f",
                productId, productName, quantity, unitPrice
        );
    }

    //calculates and updates subtotal
    double calculateSubtotal(){
        this.subtotal = this.quantity * this.unitPrice;
        return this.subtotal;
    }
}
