Choosing the right data structure : 

Data structure is the way how data is stored in the computer. Developer should choose data structure very wisely else system will not perform well.
Below are the bunch of DS and reasons when to use which one.

1. Array
- Data Structure used to store similar kind of elements in contiguous memory. Can be used in below cases, 
    a) Fast element access is needed (Can be done using the index)
    b) When number of elements i.e size of array is known before hand
    c) When iterating through all the elements in sequence is needed
    d) When less memory has to be used. (Arrays take less memory as compared to LinkedList)

2. Singly Linked List
- Data Structure used to store data in nodes, and nodes are connected to each other pointing in one direction. Can be used in below cases,
    a) When constant time of insertion and deletion is needed (On head)
    b) When data dynamically grows
    c) When random elements are not needed to be accessed
    d) When insertion is needed at any point in the list

3. Doubly Linked List
- Data Structure used to store data in nodes, and those nodes are connected to each other pointing in both the directions. Can be used in below cases,
    a) It's easier to delete the node from doubly linked list
    b) Can be iterated in reverse order without recursion
    c) Insert or remove from doubly linked list is faster.

4. Circular Linked List
- Data Structure used to store data in nodes, and nodes point to next node in one direction except the last node, which again points to first node. Can be used in below cases,
    a) Develop the buffer memory
    b) Represent a deck of cards in a game
    c) Browser cache which allows to hit the back button
    d) MRU list (Most recently used list)
    e) Undo functionality in photoshop or word

5. Stack
- Data Structure which stores the data in LIFO form i.e LAST IN FIRST OUT. Think of a stack of plates. Can be used in below cases,
    a) Expression evaluation and syntax parsing
    b) Finding the correct path in maze using back tracking
    c) Runtime memory management
    d) Recursion function

6. Queue
- Data structure which stores the data in FIFO form i.e FIRST IN FIRST OUT. Think of a queue outside movie theatre. Can be used in below cases,
    a) When order is needed
    b) When processing is needed in FIFO order
    c) If we want to add or remove, both ends, queue can be used or double ended queue

7. Binary Tree
- A tree data structure where each node has atmost 2 childs. Can be used in below cases, 
    a) Find name in the phone book
    b) Sorted traversal of the tree
    c) Find the next closest element
    d) Find all elements less then or greater then certain value

8. Binary Search Tree (BST)
- A tree data strucutre, in which root node is equal to or greater then the root node of left subtree and less then or equal to root node of right sub tree.
    a) They are memory efficient
    b) To be used when data needs to be sorted
    c) Search can be done on range of values
    d) Height balancing helps in reducing the run time


9. B Tree
- B-tree is a tree data structure that keeps data sorted and allows searches, sequential access, insertions, and deletions in logarithmic time. The developer can use B-Tree in the following use cases.
    a) File systems.
    b) Database operations.

10. Red Black Tree
- Red–black tree is a binary search tree with an extra bit of data per node, its color, which can be either red or black. The developer can use Red-Black Tree in the following use cases.
    a) Java Tree Map and C++ map implemented using Red Block Tree.
    b)Computational Geometry Data structures.
    c) Scheduler applications.

11. Splay Tree
- A splay tree is a self-adjusting binary search tree with the additional property that recently accessed elements are quick to access again. The developer can use Splay Tree in the following use cases.
    a) When the developer wants access the recent data easily.
    b) Allow duplicate items.
    c) Simple implementation and take less memory.
    d) When the application deals with a lot of data, use the splay tree.

12. AVL Tree
- AVL tree, the shape of the tree is constrained at all times such that the tree shape is balanced. The height of the tree never exceeds O(log n). The developer can use AVL Tree in the following use cases.
    a) When the developer wants to control the tree height outside -1 to 1 range.
    b) Fast looking element.

13. Minimum Spanning Tree
- A spanning tree of that graph is a subgraph that is a tree and connects all the vertices together. A minimum spanning tree (MST) or minimum weight spanning tree is then a spanning tree with weight less than or equal to the weight of every other spanning tree. The developer can use Minimum Spanning Tree in the following use cases.
    a) Describe financial markets.
    b) Handwriting recognition of mathematical expressions.
    c) Image registration and segmentation.
    d) Constructing trees for broadcasting in computer networks.

14. Trie
- A Trie (digital tree and sometimes radix tree or prefix tree), is an ordered tree data structure that is used to store a dynamic set or associative array where the keys are usually strings. The developer can use Trie in the following use cases.
    a) Fixed dictionary and want to look up quickly.
    b) Require less storage for a large dictionary.
    c) Matching sentences during string matching.
    d) Predictable O(k) lookup time where k is the size of the key.
    e) Lookup can take less than k time if it’s not there.
    f) Supports ordered traversal.
    g) No need for a hash function.
    h) Deletion is straightforward.

15. Heap
- A heap is a specialized tree-based abstract data type that satisfies the heap property. The developer can use Heap in the following use cases.
    a) Implement Priority Queue.
    b) whenever the developer want quick access to the largest (or smallest) item.
    c) Good for selection algorithms (finding the min or max).
    d) Operations tend to be faster than for a binary tree.
    e) Heap sort sorting methods being in-place and with no quadratic worst-case scenarios.
    f) Graph algorithms are using heaps as internal traversal data structures, run time will be reduced by polynomial order.

16. Hashing
- Hash table is a data structure used to implement an associative array, a structure that can map keys to values. The developer can use Hash table in the following use cases.
    a) Constant time operation.
    b) Inserts are generally slow, reads are faster than trees.
    c) Hashing is used so that searching a database can be done more efficiently.
    d) Internet routers use hash tables to route the data from one computer to another.
    e) Internet search engine uses hash function effectively.

17. Graph
- The graph is an abstract data type that is meant to implement the graph and directed graph concepts from mathematics. The developer can use Graph in the following use cases.
    a) Networks have many uses in the practical side of graph theory.
    b) Finding the shortest path between the cities.
    c) Solve maze game.
    d) Find the optimized route between the cities.

18. Matrix
- Matrix is a data structure which store the data using rows and columns. The developer can use Matrix in the following use cases.
    a) Matrix arithmetic in graphic processing algorithms.
    b) Represent the graph.
    c) Represent quadratic forms and linear algebra solution.

