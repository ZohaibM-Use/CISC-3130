# Vector-Based Inventory Management System

This Java project implements an **Inventory Management System** using **Vectors** and **Generics**. It allows users to manage products, create and process orders, and generate reports. The project emphasizes dynamic arrays (Vectors) and reusable generic methods.

---

## ⚙️ How to Compile & Run

**Compile all Java files:**
Run InventorySystemMain.java

---

## 📂 Classes Overview

### `GenericContainer<T>`
A generic wrapper around `Vector<T>` with utility methods:
- `add(T item)`, `get(int index)`, `remove(T item)`
- `size()`, `getAll()`, `clear()`, `contains(T item)`, `addAll(Vector<T> other)`

### `InventorySystemMain`
The main class with the **menu system**:
- Add, remove, find, and list products
- Create and manage orders
- Process orders (update status, cancel, view revenue)
- Generate reports (capacity report, Vector vs ArrayList comparison)

### `Product`
Represents a product in inventory:
- Attributes: `productId`, `name`, `category`, `price`, `quantityInStock`, `supplier`
- Implements `Comparable<Product>` for sorting by price
- Overrides `toString()`, `equals()`, and `hashCode()`

### `ProductInventory`
Manages `Product` objects in a `Vector`:
- Add, remove, find products
- Retrieve by category or low stock
- Update stock and calculate inventory value
- Print formatted tables and capacity reports
- Demonstrates legacy `Enumeration` usage

### `OrderItem`
Represents an individual item in an order:
- Attributes: `productId`, `productName`, `quantity`, `unitPrice`, `subtotal`
- Calculates subtotal
- Overrides `toString()` for formatted printing

### `Order`
Represents a customer order:
- Attributes: `orderId`, `customerName`, `orderDate`, `items`, `orderStatus`
- Add/remove/find items
- Update status (`Pending`, `Processing`, `Shipped`, `Delivered`, `Cancelled`)
- Calculate total order value and total quantity
- Print formatted order details

### `OrderManager`
Manages all `Order` objects:
- Add/find orders
- Retrieve by status or customer
- Cancel orders or calculate total revenue
- Print all orders and get pending orders

### `VectorUtils`
Utility class with **generic Vector operations**:
- `swap`, `findMax`, `countMatches`, `filter`
- Filter products by category
- Numeric methods: `sumNumbers`, `averageNumbers`

### `VectorComparisonDemo`
Compares **Vector** and **ArrayList** performance:
- Time to add 10,000 products
- Time to access 1,000 random elements
- Approximate memory usage
- Demonstrates synchronization overhead of Vectors

---

## 🎓 Lessons Learned

### Vectors
- Dynamic arrays, thread-safe, synchronized  
- Legacy features like `Enumeration` exist but `Iterator` is preferred  
- Useful methods: `add`, `get`, `remove`, `size`, `capacity`  

### Generics
- Reusable, type-safe methods and containers  
- Prevent runtime type errors  
- Simplifies collection operations like `swap`, `filter`, `sumNumbers`, `averageNumbers`  

### Overall
- Strong experience in object-oriented design  
- Deeper understanding of Java collections and generics  
- Awareness of performance trade-offs between `Vector` and `ArrayList`  

