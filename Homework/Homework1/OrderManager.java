package Homework.Homework1;

import java.util.Vector;

public class OrderManager {
    Vector<Order> orders = new Vector<>();

    //adds order
    void addOrder(Order order){
        for (Order O: orders){
            if(O.getOrderId().equals(order.getOrderId())){
                System.out.println("Order already exists!");
                return;
            }
        }
        orders.add(order);
        System.out.println("Order added!");
    }

    //finds order by ID
    Order findOrder(String orderId){
        for (Order order: orders){
            if(order.getOrderId().equals(orderId)){
                return order;
            }
        }
        return null;
    }

    //returns orders with specific status
    Vector<Order> getOrdersByStatus(String status){
        Vector<Order> statusOrders = new Vector<>();
        for (Order order: orders){
            if (order.getOrderStatus().equalsIgnoreCase(status)){
                statusOrders.add(order);
            }
        }
        return statusOrders;
    }

    //returns customer's orders
    Vector<Order> getOrdersByCustomer(String customerName){
        Vector<Order> customerOrders = new Vector<>();

        for (Order order: orders){
            if (order.getCustomerName().equalsIgnoreCase(customerName)){
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    //calculates total revenue from all delivered orders
    double getTotalRevenue(){
        Vector<Order> deliveredOrders = getOrdersByStatus("Delivered");

        double total = 0;

        for (Order order: deliveredOrders){
            total += order.calculateTotal();
        }
        return total;
    }

    //cancels order (updates status)
    void cancelOrder(String orderId){
        for (Order order: orders){
            if(order.getOrderId().equals(orderId)){
                order.updateStatus("Cancelled");
                System.out.println("Order cancelled");
                return;
            }
        }
        System.out.println("Order not found");
    }

    //prints all orders
    void printAllOrders(){
        if(!orders.isEmpty())
            for (Order order: orders) order.printOrder();
        else
            System.out.println("No Orders Created!");
    }

    //returns pending orders
    Vector<Order> getPendingOrders(){
        Vector<Order> pendingOrders = getOrdersByStatus("Pending");
        return pendingOrders;
    }

    //returns number of orders
    int getOrderCount(){ return orders.size(); }
}
