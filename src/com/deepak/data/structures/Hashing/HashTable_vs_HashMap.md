### HashTable v/s HashMap

Before this, I would suggest to go through the topic Iterator V/S Enumeration here.
There are some significant factors that makes both of these data structures different

#### 1. Synchronization or Thread Safety
```
- This is the most important difference between the two. 
- Hash tables are synchronized and thread safe whereas Hash maps are not.
```

#### 2. Null keys and Null values
```
- HashMap allows one null key and multiple null values, whereas hash table doesn't allow neither null values not null keys.
```

#### 3. Iterating the Values
```
- Values in hash map are iterated using an iterator, whereas in hash table values are iterated using enumerator.
- Only Vector other then hash table uses enumerator to iterate through elements. 
```

#### 4. Fail Fast Iterator
```
- Iterator in hash map is fail fast iterator, whereas enumerator for hash table is not.
- If hash table is structurally modified at any time after the iterator is created other then iterators own remove method, it will throw Concurrent Modification exception.
- Structural modification means adding or removing elements from the collection.
```

#### 5. Super class and Legacy
```
- HashTable is a subclass of Dictionary, which is now obsolete from JDK 1.7
```

#### 6. Performance
```
- HashMap is much faster and uses less memory because it is not synchronized. 
```

#### Similarities:
```
- Order of elements cannot be guaranteed, because both of these work based on the hashing logic. use Linked Hash map for that
- Both of them comes from Map interface.
- Both provides constant time for performance for put and get methods, assuming that objects are distributed uniformly.
- Both works on the principle of hashing
```

#### When to use?
```
Avoid using HashTable, as they are obsolete now, ConcurrentHashMap has replaced it.
Single threaded apps - use HashMap
```
 
