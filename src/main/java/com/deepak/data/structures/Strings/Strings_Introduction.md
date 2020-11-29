## Strings Introduction

- Strings are basically sequence of characters stored in a memory. 
- They are immutable in java i.e you cannot change the string object itself but you can change the reference of the object. 
- Java provides a String class to create a manipulate strings. These are objects backed up by char array.
- When a string is created, it's value is cached in string pool and then stored in Heap. 
- Below is the example of creation of string using, both literal and object. When it's created using literals, it's value is cached but when created using the new object, it does not get's cached, until we explicitly asks to cache it.

```java
String s1 = "Hello"; // New string creation using literals.
String s2 = "Hello";
String s3 = new String("Hello"); // This value is not cached in the string pool
System.out.println(s1 == s2); // Prints True
System.out.println(s1 == s3); // Prints False
```

- To make s2 and s3 point to same reference, we have to invoke the API **intern()** of String class. This API will ensure that string gets cached in the string pool.

```java
String s3 = new String("Hello").intern();
```
<img width="614" alt="screen shot 2017-02-12 at 11 51 43 am" src="https://cloud.githubusercontent.com/assets/3439029/22865449/c407fafa-f119-11e6-89ca-04d45abe425b.png">

- Strings are marked as final in java, i.e once a value is assigned to the string, it cannot change. 
- For ex., the method toUpperCase() constructs and returns a new String instead of modifying the its existing content.
- Moreover, Strings are thread safe as well in java.

**StringBuffer and StringBuilder :**

- As explained earlier, Strings are immutable because String literals with same content share the same storage in the string common pool. Modifying the content of one String directly may cause adverse side-effects to other Strings sharing the same storage.
- JDK provides two classes to support mutable strings: StringBuffer and StringBuilder (in core package java.lang) . A StringBuffer or StringBuilder object is just like any ordinary object, which are stored in the heap and not shared, and therefore, can be modified without causing adverse side-effect to other objects.
- StringBuilder class was introduced in JDK 1.5. It is the same as StringBuffer class, except that StringBuilder is not synchronized for multi-thread operations. However, for single-thread program, StringBuilder, without the synchronization overhead, is more efficient.

**StringTokenizer**

- Very often, you need to break a line of texts into tokens delimited by white spaces. The java.util.StringTokenizer class supports this.

**String API's :** 

```java
- Below are some basic API's. All are not covered here, 
    1. charAt()
        - returns the character located at the specified index.
    2. equalsIgnoreCase()
        - determines the equality of two Strings, ignoring their case (upper or lower case doesn't matters with this function.
    3. length()
        - returns the number of characters in a String.
    4. replace()
        - replaces occurrences of character with a specified new character.
    5. substring()
        - returns a part of the string. This method has two forms,
            - public String substring(int begin);
            - public String substring(int begin, int end); 
    6. toLowerCase()
        - returns string with all uppercase characters converted to lowercase
    7. valueOf()
        - used to convert primitive data types into Strings.
    8. toString()
        - returns the string representation of the object used to invoke this method. 
        - toString() is used to represent any Java Object into a meaningful string representation
    9. trim()
        - returns a string from which any leading and trailing white spaces has been removed
```
