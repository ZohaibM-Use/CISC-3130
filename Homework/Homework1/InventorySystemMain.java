package Homework.Homework1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class InventorySystemMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ProductInventory productInventory = new ProductInventory();
        OrderManager orderManager = new OrderManager();

        int option = 1;
        while (option!=9){
            System.out.println("=== Menu System ===");
            System.out.println("1. Add Product\n" +
                    "2. Remove Product\n" +
                    "3. Find Product\n" +
                    "4. List All Products\n" +
                    "5. Create Order\n" +
                    "6. View Orders\n" +
                    "7. Process Order\n" +
                    "8. Generate Reports\n" +
                    "9. Exit");
            System.out.print("Choose an option: ");
            while (true) {
                try {
                    option = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input! Please enter a number: ");
                    sc.nextLine();
                }
            }
            System.out.println();

            switch (option){
                case 1: addProduct(sc, productInventory);
                break;
                case 2: removeProduct(sc, productInventory);
                break;
                case 3: findProduct(sc, productInventory);
                break;
                case 4: listAllProducts(sc, productInventory);
                break;
                case 5: createOrder(sc, orderManager);
                break;
                case 6: viewOrders(sc, orderManager);
                break;
                case 7: processOrder(sc, orderManager);
                break;
                case 8: generateReports(sc, productInventory);
                break;
                case 9: System.exit(0);
                break;
                default:
                    System.out.println("Invalid Option.");
            }
        }
    }

    public static void addProduct(Scanner sc, ProductInventory productInventory){
        String productId, name, category, supplier;
        double price;
        int quantity;

        System.out.println("Fill out fields to add new product");
        System.out.println("=======================================================");
        System.out.print("Product ID: ");
        productId = sc.nextLine();
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Category: ");
        category = sc.nextLine();
        System.out.print("Price: $");
        price = sc.nextDouble();
        while (price <= 0) {
            System.out.print("Price must be positive. Enter again: $");
            price = sc.nextDouble();
        }
        sc.nextLine();

        System.out.print("Quantity: ");
        quantity = sc.nextInt();
        while (quantity <= 0) {
            System.out.print("Quantity must be positive. Enter again: ");
            quantity = sc.nextInt();
        }
        sc.nextLine();

        System.out.print("Supplier: ");
        supplier = sc.nextLine();
        System.out.println("=======================================================");

        productInventory.addProduct(
                new Product(productId,name,category,price,quantity,supplier));

        System.out.printf("Current Inventory Value: $%,.2f%n", productInventory.getTotalInventoryValue());
        System.out.println();
    }

    public static void removeProduct(Scanner sc, ProductInventory productInventory){
        System.out.print("Product ID to remove: ");
        String productId = sc.nextLine();
        System.out.println(productInventory.removeProduct(productId));
        System.out.printf("Current Inventory Value: $%,.2f%n", productInventory.getTotalInventoryValue());
        System.out.println();
    }

    public static void findProduct(Scanner sc, ProductInventory productInventory) {
        boolean finishedFindingProduct = true;
        do {
            boolean keepLooking = true;
            System.out.println("=== Find Products Menu ===");
            System.out.println("1. Product ID\n" +
                    "2. All products in a category\n" +
                    "3. Low stock Products");
            System.out.print("Enter Option: ");
            int option;
            while (true) {
                try {
                    option = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input! Please enter a number: ");
                    sc.nextLine();
                }
            }

            switch (option) {
                case 1:
                    do {
                        System.out.print("Enter Product ID to search for: ");
                        Product p = productInventory.findProduct(sc.nextLine());
                        if (p != null) {
                            System.out.println("Product Found!");
                            System.out.println(p);
                        } else System.out.println("Product not found!");

                        System.out.print("Keep Looking? (Y/N)");
                        keepLooking = sc.nextLine().equalsIgnoreCase("y");
                        sc.nextLine();
                    } while (keepLooking);
                    break;
                case 2:
                    do {
                        System.out.print("Enter category to search for: ");
                        Vector<Product> productsByCategory = productInventory.getProductsByCategory(sc.nextLine());
                        if (!productsByCategory.isEmpty())
                            for (Product product : productsByCategory) System.out.println(product);
                        else System.out.println("No products in this category!");

                        System.out.println("Search for another category? (Y/N): ");
                        keepLooking = sc.nextLine().equalsIgnoreCase("y");
                        sc.nextLine();
                    } while (keepLooking);
                    break;
                case 3:
                    do {
                        System.out.print("Enter threshold for stock quantity: ");
                        int threshold = sc.nextInt();
                        sc.nextLine();
                        Vector<Product> lowStock = productInventory.getLowStockProducts(threshold);
                        for (Product product : lowStock) System.out.println(product);
                        System.out.print("Would you like to update stock on a product? (Y/N)");
                        String choice = sc.nextLine().toUpperCase();
                        if (choice.equals("Y")) {
                            System.out.print("Enter Product ID: ");
                            String productId = sc.nextLine();
                            System.out.print("Enter quantity change: ");
                            int quantity = sc.nextInt();
                            productInventory.updateStock(productId, quantity);
                        }
                        System.out.println("Enter another threshold? (Y/N): ");
                        keepLooking = sc.nextLine().equalsIgnoreCase("y");
                        sc.nextLine();
                    } while (keepLooking);
                    break;
                default:
                    System.out.println("Invalid Option.");
            }
            System.out.print("Return to Find Product Menu? (Y/N): ");
            finishedFindingProduct = sc.nextLine().equalsIgnoreCase("y");
            System.out.println();
        } while (finishedFindingProduct);
        System.out.println();
    }

    public static void listAllProducts(Scanner sc, ProductInventory productInventory){
        System.out.println("Currently " + productInventory.getTotalProducts() + " products " +
                "in inventory\n");
        productInventory.printAllProducts();
        System.out.printf("%nCurrent Inventory Value: $%,.2f%n", productInventory.getTotalInventoryValue());
        System.out.println();
    }

    public static void createOrder(Scanner sc, OrderManager orderManager){
        String productId, productName, orderId, customerName, orderDate;
        int quantity;
        double unitPrice;

        System.out.println("Enter the following fields for your order");
        System.out.println("=======================================================");
        System.out.print("Order ID: ");
        orderId = sc.nextLine();
        System.out.print("Customer Name: ");
        customerName = sc.nextLine();
        System.out.print("Order Date (YYYY-MM-DD): ");
        orderDate = sc.nextLine();
        Order order = new Order(orderId, customerName, orderDate);
        System.out.println("=======================================================");
        System.out.println();


        boolean addMore = true;
        do {
            System.out.println("Fill out the following fields for your item");
            System.out.println("=======================================================");
            System.out.print("Product ID: ");
            productId = sc.nextLine();
            System.out.print("Product Name: ");
            productName = sc.nextLine();

            System.out.print("Quantity: ");
            quantity = sc.nextInt();
            while (quantity <= 0) {
                System.out.print("Quantity must be positive. Enter again: ");
                quantity = sc.nextInt();
            }
            sc.nextLine();

            System.out.print("Unit Price: $");
            unitPrice = sc.nextDouble();
            while (unitPrice <= 0) {
                System.out.print("Unit price must be positive. Enter again: $");
                unitPrice = sc.nextDouble();
            }
            sc.nextLine();

            order.addItem(new OrderItem(productId, productName, quantity, unitPrice));

            System.out.print("Add another item? (y/n): ");
            addMore = sc.nextLine().equalsIgnoreCase("y");
            System.out.println();
        } while(addMore);
        System.out.println("=======================================================");

        orderManager.addOrder(order);
        System.out.println("Current Number of Orders: " + orderManager.getOrderCount());
        System.out.println();
    }

    public static void viewOrders(Scanner sc, OrderManager orderManager){
        boolean finishedViewing = true;
        do {
            System.out.println("=== View Order Menu ===");
            System.out.println("1. View All Orders\n" +
                    "2. View Pending Orders\n" +
                    "3. View Orders By Status\n" +
                    "4. View Orders By Customer Name");
            System.out.print("Choose option: ");
            int option;
            while (true) {
                try {
                    option = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input! Please enter a number: ");
                    sc.nextLine();
                }
            }

            switch (option) {
                case 1:
                    orderManager.printAllOrders();
                    break;
                case 2:
                    Vector<Order> pendingOrders = orderManager.getPendingOrders();
                    if (!pendingOrders.isEmpty())
                        for (Order order : pendingOrders) order.printOrder();
                    else
                        System.out.println("No Pending Orders!");
                    break;
                case 3:
                    String[] validStatuses = {"Pending", "Processing", "Shipped", "Delivered", "Cancelled"};
                    boolean validStatus = false;
                    String stat;

                    do {
                        System.out.print("Enter a status to view (Pending, Processing, Shipped, Delivered, Cancelled): ");
                        stat = sc.nextLine().trim();

                        validStatus = false;

                        for (String status : validStatuses) {
                            if (status.equalsIgnoreCase(stat)) {
                                validStatus = true;
                                stat = status;
                                break;
                            }
                        }

                        if (!validStatus) {
                            System.out.println("Invalid Status. Please enter a valid status.");
                        }

                    } while (!validStatus);

                    Vector<Order> statusOrders = orderManager.getOrdersByStatus(stat);

                    if (!statusOrders.isEmpty()) {
                        for (Order order : statusOrders) {
                            order.printOrder();
                        }
                    } else {
                        System.out.println("No Orders for that status!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Customer Name: ");
                    Vector<Order> customerOrders = orderManager.getOrdersByCustomer(sc.nextLine());
                    if (!customerOrders.isEmpty())
                        for (Order order : customerOrders) order.printOrder();
                    else
                        System.out.println("No Orders for that customer!");
                    break;
                default:
                    System.out.println("Invalid Option.");
            }
            System.out.print("Finished Viewing? (Y/N)");
            finishedViewing = !sc.nextLine().equalsIgnoreCase("Y");
            System.out.println();
        } while (finishedViewing);
        System.out.println();
    }

    public static void processOrder(Scanner sc, OrderManager orderManager){
        boolean finishedProcessing = true;
        do {
            System.out.println("=== Process Order Menu ===");
            System.out.println("1. Update status to Processing, Shipped, or Delivered\n" +
                    "2. Add an item to a Pending order\n" +
                    "3. Remove an item from a Pending order\n" +
                    "4. Cancel an order\n" +
                    "5. View total of specific order\n" +
                    "6. View revenue earned from delivered orders");
            System.out.print("Choose option: ");
            int option;
            while (true) {
                try {
                    option = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input! Please enter a number: ");
                    sc.nextLine();
                }
            }

            switch (option) {
                case 1:
                    System.out.print("Enter Order ID to update status: ");
                    Order changeStatus = orderManager.findOrder(sc.nextLine());
                    if (changeStatus != null) {
                        System.out.print("Enter new status of order " +
                                "(Processing, Shipped, or Delivered): ");
                        changeStatus.updateStatus(sc.nextLine());
                    }
                    else {
                        System.out.println("Order not found!");
                    }
                    break;
                case 2:
                    System.out.print("Enter Order ID of Pending Order: ");
                    Order addToPending = orderManager.findOrder(sc.nextLine());
                    if (addToPending != null &&
                            addToPending.getOrderStatus().equalsIgnoreCase("Pending")) {
                        System.out.println("Fill in fields for new item");
                        System.out.print("Product ID: ");
                        String productId = sc.nextLine();
                        System.out.print("Product Name: ");
                        String productName = sc.nextLine();

                        System.out.print("Quantity: ");
                        int quantity = sc.nextInt();
                        while (quantity <= 0) {
                            System.out.print("Quantity must be positive. Enter again: ");
                            quantity = sc.nextInt();
                        }
                        sc.nextLine();

                        System.out.print("Unit Price: $");
                        double unitPrice = sc.nextDouble();
                        while (unitPrice <= 0) {
                            System.out.print("Unit price must be positive. Enter again: $");
                            unitPrice = sc.nextDouble();
                        }
                        sc.nextLine();

                        addToPending.addItem(new OrderItem(productId, productName, quantity, unitPrice));
                    }
                    else {
                        System.out.println("Order not found or Order is not in Pending status!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Order ID of Pending Order: ");
                    Order removeFromPending = orderManager.findOrder(sc.nextLine());
                    if (removeFromPending != null &&
                            removeFromPending.getOrderStatus().equalsIgnoreCase("Pending")) {
                        System.out.print("Enter Product Id of item to remove: ");
                        removeFromPending.removeItem(sc.nextLine());
                    }
                    else {
                        System.out.println("Order not found or Order is not in Pending status!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Order ID of order to cancel: ");
                    orderManager.cancelOrder(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter Order ID order to view the total of: ");
                    Order viewTotal = orderManager.findOrder(sc.nextLine());
                    if (viewTotal != null) {
                        System.out.printf("Total: $%,.2f%n", viewTotal.calculateTotal());
                    }
                    else {
                        System.out.println("Order not found!");
                    }
                    break;
                case 6:
                    System.out.printf("Total Revenue earned from Delivered Orders: $%,.2f%n",
                            orderManager.getTotalRevenue());
                    break;
                default:
                    System.out.println("Invalid Option.");
            }
            System.out.print("Finished Processing? (Y/N): ");
            finishedProcessing = !sc.nextLine().equalsIgnoreCase("Y");
            System.out.println();
        } while (finishedProcessing);
        System.out.println();
    }

    public static void generateReports(Scanner sc, ProductInventory productInventory){
        System.out.println("=== Report Menu ===");
        System.out.println("1. Product Inventory Capacity Report\n" +
                "2. Vector vs ArrayList Comparison Report");
        System.out.print("Choose option: ");
        int option;
        while (true) {
            try {
                option = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter a number: ");
                sc.nextLine();
            }
        }

        switch (option){
            case 1: productInventory.printCapacityReport();
            break;
            case 2: VectorComparisonDemo report = new VectorComparisonDemo();
            break;
            default:
                System.out.println("Invalid Option.");
        }
        System.out.println();
    }
}