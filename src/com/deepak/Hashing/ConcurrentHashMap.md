## Concurrent HashMap in Java

- ConcurrentHashMap is introduced as an alternative of Hashtable and provided all functions supported by Hashtable with an additional feature called "concurrency level".

- Concurrent HashMap allows multiple readers to read concurrently without any blocking. 
This is achieved by partitioning Map into different parts based on concurrency level and locking only a portion of Map during updates. Default concurrency level is 16, and accordingly Map is divided into 16 part and each part is governed with a different lock. This means, 16 thread can operate on Map simultaneously until they are operating on different part of Map. 

- This makes ConcurrentHashMap high performance despite keeping thread-safety intact.
Concurrent HashMap is thread safe i.e code can be accessed by a single thread at a time and it does not allow null keys or values.

#### Important concepts
- Since ConcurrentHashMap implementation doesn't lock whole Map, there is chance of read overlapping with update operations like put() and remove(). In that case result returned by get() method will reflect most recently completed operation from there start.

#### When to use?
- ConcurrentHashMap is best suited when you have multiple readers and few writers. If writers out number reader, or writer is equal to reader, than performance of ConcurrentHashMap effectively reduces to synchronized map or Hashtable. 

- Performance of CHM drops, because you got to lock all portion of Map, and effectively each reader will wait for another writer, operating on that portion of Map. 

- ConcurrentHashMap is a good choice for caches, which can be initialized during application start up and later accessed my many request processing threads.
 
- As javadoc states, CHM is also a good replacement of Hashtable and should be used whenever possible, keeping in mind, that CHM provides slightly weeker form of synchronization than Hashtable.

- Below table shows comparison of HashMap, Hashtable and ConcurrentHashMap,

<img width="588" alt="screen shot 2016-07-04 at 3 11 34 pm" src="https://cloud.githubusercontent.com/assets/3439029/16570432/bffc35f4-41f9-11e6-9ebf-e6873c2dc660.png">

#### ConcurrentHashMap issue with Long while using in a multi-threaded environment is shown below, 
Lets say I have a ConcurrentHashMap called ordersMap which holds name of some cities and orders from those cities, 

```java
static Map<String, Long> ordersMap = new ConcurrentHashMap<>();
```

In my main method, I will put some cities with 0 orders initially. I have a service with two threads, 
which will call a method to update the count of orders. 

```java
public static void main(String[] args) throws InterruptedException {
	ordersMap.put("Delhi", 0l);
	ordersMap.put("London", 0l);
	ordersMap.put("New York", 0l);
	ordersMap.put("Sydney", 0l);

	// Executor service with 2 threads
	ExecutorService service = Executors.newFixedThreadPool(2);
		
	// Submitting two tasks to service
	service.submit(new Runnable() {
		@Override
		public void run() {
			processOrders();
		}
	});
		
	service.submit(new Runnable() {
		@Override
		public void run() {
			processOrders();
		}
	});

	// Waiting for 1 second and then shutting down the service
	service.awaitTermination(1, TimeUnit.SECONDS);
	service.shutdown();
	System.out.println(ordersMap);
}
``` 

Let's implement processOrders() method,

```java
static void processOrders() {
	for (String city : ordersMap.keySet()) {
		for (int i = 0; i < 50; i++) {
			Long oldOrder = ordersMap.get(city);
			ordersMap.put(city, oldOrder + 1);
		}
	}
}
```

If you will run it once with two threads, most probably it will give you 100 for each of the city. 
Something like this
```
{Delhi=100, New York=100, London=100, Sydney=100}
```
But let's run it under some stress. I will run it from terminal for some time (maybe 10-15 runs)

<img width="740" alt="screen shot 2016-07-04 at 3 26 43 pm" src="https://cloud.githubusercontent.com/assets/3439029/16570539/d68af86c-41fb-11e6-9ead-8dc2e5bce303.png">

Here is the output, as we can see values are not consistent. 

<img width="354" alt="screen shot 2016-07-04 at 3 26 27 pm" src="https://cloud.githubusercontent.com/assets/3439029/16570544/e35d3014-41fb-11e6-9cb5-aae2fdcd628f.png">

Lets change our map to use AtomicLong instead of Long, 

```java
static Map<String, AtomicLong> ordersMap = new ConcurrentHashMap<>();
```

Put Values in Map, 
```java
ordersMap.put("Delhi", new AtomicLong());
ordersMap.put("London", new AtomicLong());
ordersMap.put("New York", new AtomicLong());
ordersMap.put("Sydney", new AtomicLong());
```

and change implementation of processOrders() method, 
```java
static void processOrders() {
	for (String city : ordersMap.keySet()) {
		for (int i = 0; i < 50; i++) {
			ordersMap.get(city).getAndIncrement();
		}
	}
}
```

Run the program again and observe the output, 

<img width="379" alt="screen shot 2016-07-04 at 3 27 00 pm" src="https://cloud.githubusercontent.com/assets/3439029/16570553/4cc9fdde-41fc-11e6-87b3-28a064a4fe55.png">

Complete program is [here](../Hashing/ConcurrentHashMapImplementation.java)