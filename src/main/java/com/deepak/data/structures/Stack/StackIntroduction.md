## Stack Introduction

Stack is a logical data structure that can be logically thought as a linear structure and can be represented in real life as pile of plates or deck of cards. In this structure, insertion and deletion of items takes place only at one end called "_Top_" of the stack. The basic concept can be illustrated by thinking of your data set as a stack of plates or books where you can only take the top item off the stack in order to remove things from it.

The basic implementation of a stack is also called a **LIFO** (Last In First Out) to demonstrate the way it accesses data. There are basically three operations that can be performed on stacks . They are 1) inserting an item into a stack (_push_). 2) deleting an item from the stack (_pop_). 3) displaying the contents of the stack(_peek_).   

![push_pop](https://cloud.githubusercontent.com/assets/3439029/22179613/b78d8fd2-e00d-11e6-9f38-63628ad02f16.png)

All operations except size() can be performed in **O(1)** time. size() runs in at worst **O(N)**.  
It can be implemented using either Arrays, LinkedList or Queues.

There are various applications of Stack :  
- Converting a decimal number to binary number.
- Tower of Hanoi
- Expression evaluation and syntax parsing
- Conversion of Infix to Postfix
- QuickSort etc.
