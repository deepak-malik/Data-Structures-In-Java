## Vector Introduction

The _Vector_ class implements a growable array of objects. Like an array it contains components that can be accessed using an integer index. However, the size of a vector can grow or shrink as needed to accommodate addition and removal of elements. Each vector tries to optimize storage management by maintaining a _capacity_ and a _capacityIncrement_. The _capacity_ is always at least as large as the vector size; it is usually larger because as components are added to the vector, the vector's storage increases in chunks the size of _capacityIncrement_. An application can increase the capacity of a vector before inserting a large number of components; this reduces the amount of incremental reallocation.

**Synchronization :**
- Vector synchronizes on each individual operation. That's almost never what you want to do. Generally you want to synchronize a whole sequence of operations. Synchronizing individual operations is both less safe (if you iterate over a Vector, for instance, you still need to take out a lock to avoid anyone else changing the collection at the same time, which would cause a ConcurrentModificationException in the iterating thread) but also slower (why take out a lock repeatedly when once will be enough)?
- Vector also has a bunch of methods around enumeration and element retrieval which are different than the List interface, and developers (especially those who learned Java before 1.2) can tend to use them if they are in the code. Although Enumerations are faster, they don't check if the collection was modified during iteration, which can cause issues, and given that Vector might be chosen for its synchronization - with the attendant access from multiple threads, this makes it a particularly pernicious problem. Usage of these methods also couples a lot of code to Vector, such that it won't be easy to replace it with a different List implementation.

**Difference between ArrayList and Vector :**
- **Synchronization**
    - ArrayList is non-synchronized which means multiple threads can work on ArrayList at the same time. For e.g. if one thread is performing an add operation on ArrayList, there can be an another thread performing remove operation on ArrayList at the same time in a multithreaded environment while Vector is synchronized. This means if one thread is working on Vector, no other thread can get a hold of it. Unlike ArrayList, only one thread can perform an operation on vector at a time.
- **Resize** 
    - Both ArrayList and Vector can grow and shrink dynamically to maintain the optimal use of storage, however the way they resized is different. ArrayList grow by half of its size when resized while Vector doubles the size of itself by default when grows.
- **Performance** 
    - ArrayList gives better performance as it is non-synchronized. Vector operations gives poor performance as they are thread-safe, the thread which works on Vector gets a lock on it which makes other thread wait till the lock is released.
- **fail-fast** 
    - First let me explain what is fail-fast: If the collection (ArrayList, vector etc) gets structurally modified by any means, except the add or remove methods of iterator, after creation of iterator then the iterator will throw ConcurrentModificationException. Structural modification refers to the addition or deletion of elements from the collection. As per the Vector _javadoc_ the Enumeration returned by Vector is not fail-fast. On the other side the iterator and listIterator returned by ArrayList are fail-fast.
- **Who belongs to collection framework really?** 
    - The vector was not the part of collection framework, it has been included in collections later. It can be considered as Legacy code. There is nothing about Vector which List collection cannot do. Therefore Vector should be avoided. If there is a need of thread-safe operation make ArrayList synchronized as discussed in the next section of this post or use CopyOnWriteArrayList which is a thread-safe variant of ArrayList.

**Similarities :**
- Both Vector and ArrayList use growable array data structure.
- The iterator and listIterator returned by these classes (Vector and ArrayList) are fail-fast.
- They both are ordered collection classes as they maintain the elements insertion order.
- Vector & ArrayList both allows duplicate and null values.
- They both grows and shrinks automatically when overflow and deletion happens.

**When to use ArrayList and when to use vector?**
- It totally depends on the requirement. If there is a need to perform “thread-safe” operation the vector is your best bet as it ensures that only one thread access the collection at a time.
- Performance 
    - Synchronized operations consumes more time compared to non-synchronized ones so if there is no need for thread safe operation, ArrayList is a better choice as performance will be improved because of the concurrent processes
