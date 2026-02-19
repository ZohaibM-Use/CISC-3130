package Homework.Homework1;

import java.util.Vector;

public class Order {
    private String orderId;
    private String customerName;
    private String orderDate;
    private Vector<OrderItem> items = new Vector<>();
    private String orderStatus;

    //Constructors

    public Order() {
        this("N/A", "N/A", "N/A");
    }

    public Order(String orderId, String customerName, String orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.orderStatus = "Pending";
    }

    //Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    //adds item to order
    void addItem(OrderItem item){
        for (OrderItem I: items){
            if(I.getProductId().equals(item.getProductId())){
                System.out.println("Item already exists!");
                return;
            }
        }
        items.add(item);
        System.out.println("Added Item!");
    }

    //removes item by productId
    boolean removeItem(String productId){
        for (int i = 0; i < items.size(); i++){
            if(items.get(i).getProductId().equals(productId)){
                items.remove(i);
                System.out.print("Removed = ");
                return true;
            }
        }
        System.out.print("Removed = ");
        return false;
    }

    //finds item in order
    OrderItem findItem(String productId){
        for (OrderItem item: items){
            if(item.getProductId().equals(productId)){
                System.out.println("Item found!");
                return item;
            }
        }
        System.out.println("Item not found!");
        return null;
    }

    //calculates total order value
    double calculateTotal(){
        double total = 0;
        for (OrderItem item: items){
            total += item.calculateSubtotal();
        }
        return total;
    }

    //returns total quantity of all items
    int getTotalItems(){
        int total = 0;
        for (OrderItem item: items){
            total += item.getQuantity();
        }
        return total;
    }

    //updates order status
    void updateStatus(String newStatus){
        String[] validStatuses = {"Pending", "Processing", "Shipped",
                "Delivered", "Cancelled"};
        for (String status: validStatuses){
            if (status.equalsIgnoreCase(newStatus)) {
                this.orderStatus = newStatus;
                System.out.println("Order Status Updated!");
                return;
            }
        }
        System.out.println("Invalid Status!");

    }

    //prints formatted order details
    void printOrder(){
        System.out.println("======================================");
        System.out.printf("Order ID: %s%n" +
                          "Customer Name: %s%n" +
                          "Order Date: %s%n" +
                          "Order Status: %S%n",
                          orderId, customerName, orderDate, orderStatus);
        System.out.println("======================================");

        System.out.printf("%-10s | %-15s | %-5s | %-9s%n",
                "Product ID", "Product Name", "Quantity", "Unit Price");
        System.out.println("--------------------------------------------------------");
        for (OrderItem item: items){
            System.out.println(item);
        }

        System.out.printf("Total for %d items: $%,.2f%n", getTotalItems(), calculateTotal());
        System.out.println("======================================");

    }

    //returns copy of items Vector
    Vector<OrderItem> getItems(){
        return new Vector<>(items);
    }
}