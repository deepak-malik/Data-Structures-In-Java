### Iterator v/s Enumeration

Below are some significant differences between the two,

1. Both of these allows to traverse through the collection of elements. 
2. Both Iterator and Enumeration are interfaces, found in java.util package
    - Iterator has 3 methods, 
        - hasNext()
        - next()
        - remove()
    - Enumeration has 2 methods, 
        - hasMoreElements()
        - nextElement()
3. Iterator differs from Enumeration because iterator allows the caller to remove the elements while traversing through the collection. Enumeration doesn't have remove method. Enumeration is a legacy class and not all data structures supports it. for ex. Vector supports enumeration but a array list doesn't. On the other hand iterator is a standard class for traversal of elements.
4. Enumeration is older and exists from JDK 1.0, whereas iterator was introduced later.
5. Functionality of enumeration interface is duplicated in Iterator with some extra features on top of it.
6. Enumeration acts as read only interface, because it has methods only to traverse the elements. Whereas, iterator can modify the collection too, because remove method exits in it.
7. Iterator is more secure and safe, because it does not allow any other thread to modify the collection if one thread is working on the collection already. Iterator will throw ConcurrentModification Exception in this use case. 

#### When to use?

1. Use enumeration when only reading of elements is associated. 
