## Linked List

We already have arrays, what's the problem with it that we have to move with a new data structure??
- Arrays are fixed size data structure. Once created in memory we cannot cross that limit. Resizing can be done but there is no surety that we will have that much memory available later on. Arrays are contiguous block of memory. For ex. We created a array of initial size 10. Application is running and it has taken lot of memory. We got a need to increase the size of out array to 25 now. We don't have enough contiguous memory to create it. **Problem !!!!**  
- Array insertion and deletion may require adjustment in size. (Overhead)  
- The best part with Arrays is, each element can be accessed in a very efficient manner since index is known.

This is how a simple example of adding a new node to a linked list looks like,

![linked_list](https://cloud.githubusercontent.com/assets/3439029/22178994/1d5fc414-dffb-11e6-8177-7a5628c09b46.png)

Applications which can be better managed without using a contiguous memory based data structure, Linked lists are introduced.

So, a proper **definition** would be something : Linked list is a collection of objects (called Nodes) connected to each other in the memory. Each Node contains some data and pointer to some other Node. Last node points to null reference. Entry point to the linked list is called first node or head node. If list is empty, head will be null.  
Unlike arrays, nodes cannot be accessed using index. Also they don't take contiguous memory.
If we want to traverse through the list, we have to start from head and then check each element.

### Types of Linked List
- *Singly Linked List* - Provides access to list from the head node. Traversal is allowed only one way and there is no going back.
- *Doubly Linked List* - Provides access to list from head and tail nodes. Traversal is allowed from both the sides of the list.
- *Circular Linked List* - Provides access to list from the head node. But pointer of last node again points back to first node.

### Operations that can be performed on Linked Lists :
- Traversing through linked list
- Check if list is empty
- Check the size of the list
- Inserting a element in the list - *This can be at beginning, at end or at a given position*
- Search a element by index
- Search a element by value
- Delete a element from the list - *This can again be at beginning, at end or at given position*
- Converting a list to and from a Array 
- Reverse a linked list using iteration and recursion
- Print elements in forward and reverse order
