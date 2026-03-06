# Lab: Learning Linked Lists

## Overview

This lab focuses on implementing and understanding **linked lists** in Java.  
Linked lists are a fundamental data structure used to store collections of elements in a **sequence**, where each element (node) points to the next. Unlike arrays, linked lists allow **dynamic memory allocation** and efficient insertions or deletions at any position.

---

## Concepts Learned

1. **Node Structure**
   - Each node contains data and a reference to the next node.

2. **Head and Tail**
   - `head` points to the first node.
   - `tail` (optional) can point to the last node for faster appends.

3. **Operations**
   - **Append** – add a node at the end.
   - **Prepend** – add a node at the beginning.
   - **Delete** – remove a node by value or position.
   - **Find** – search for a node by value.
   - **Traversal** – visit each node to read or print its data.
   - **Size Calculation** – count the number of nodes.
   - **Aggregation** – perform calculations like sum, average, or concatenation across nodes.

4. **Singly Linked List**
   - Each node points only to the next node.
   - Efficient for sequential operations but slower for random access compared to arrays.

---

## Key Takeaways

- Linked lists provide **flexible memory usage** compared to arrays.
- Operations like **insertion and deletion** are efficient if you have a reference to the correct node.
- **Traversal is required** for most operations, which makes **random access slower** than arrays.
- Understanding **nodes and references** is essential for mastering more advanced data structures like **stacks, queues, and hash tables**.
