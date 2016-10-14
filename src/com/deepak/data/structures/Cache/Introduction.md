## Caching Introduction

Caching is a technique of storing the data in a temporary place since fetching the original data over API call can be expensive. From cache, we can retrieve it faster. Cache is made of pool of entries, which are copy of real data. Each entry is associated with a tag (key identifier) which is used for retrival. 

Lets assume we have some products in the backend and each of the product has a product id which is unique.  
Here are some of the terms used with caching,  

**Cache Hit**  
When client invokes the request to view product details, we first check the cache if details of that product are available in cache. If a entry is found with the tag requested, we fetch the details from the cache. This is called cache hit i.e requested value is available in cache. Percentage of cache hit is called hit ratio or hit rate.  

**Cache Miss**  
On the contrary, when tag is not found in the cache, it is called as cache miss. In this case call to backend is made and cache is updated so that next time we can avoid cache miss in future.  
If we encounter cache miss, there are two possible scenarios that can happen :  
- We have enough free space in the cache since cache hasn't reached its limit, so the object that caused cache miss will be fetched from backend and will be inserted in the cache.  
- There is no free space in the cache since cache has reached its capacity, so the object that caused the cache miss will be fetched from backend and we have to decide which object can be evicted (deleted) now to make free space for new one. This is done by replacement policy which will be discussed later.  
Below diagram shows the concept of cache hit and cache miss,  

![cache-hit-ratio-latency-graph](https://cloud.githubusercontent.com/assets/3439029/19374486/c270bd1a-9180-11e6-8df4-66fd7aab4a8e.png)

**Storage Cost**  
When a cache miss happens, data is fetched from backend and stored in cache. But how much space is needed to store this new object. The cost associated with this operation is called storage cost.  

**Retrival Cost**  
When we have to load the data, we must know how much cost is associated with it. It is called retrival cost.  

**Invalidation**  
Objects are stored in the cache for very long time, but in the meantime it is very much possible that actual data changes in backend. So, we need to invalidate the current cache at regular interval of time so that new updated data can be populated in cache.  

**Replacement policy**  
When cache miss happens, it ejects some objects to make space for new entries. We have to select some objects for deletion at this point of time. Policy which decides which elements will be replaced is called replacement policy. For example, a cache entry that is not going to be used for the next 10 seconds will be replaced by an entry that is going to be used within the next 2 seconds.  

_Below are some of the caching algorithms (Replacement policy),_  

**1. Least frequently used cache (_LFU_)**  
- This cache keeps a track how often a entry is fetched from cache by keeping a counter against each entry. When time for eviction comes, entries with least number in counter will be deleted. This is not that good since keeping a track of extra counter is a overhead.  

**2. Least recently used cache (_LRU_)**  
- This cache removes the least recently used item from the cache i.e the one which is not used for longest time. Web browser uses this technique for caching. New items are placed on top of cache and when limit exceeds, items from bottom of the list are removed. So, when a new item is accessed it is placed on top of the list. This means, items which are frequently accessed tends to remain in the cache. There are 2 ways to implement this i.e either using Arrays or Linked List. 
There are some improved versions of LRU as well normally known as LRU 2 and 2Q.  

**3. Least recently used cache 2 (_LRU 2_)**  
- This cache add entry to it when a element is accessed twice in a row. When cache becomes full it removes the element which has second most recent access. Because of need to track two most recently accessed items, there is an overhead involved. This also needs to keep track of elements which are accessed one time, so that they can be added to cache when accessed twice.  

**4. Two Queues**  
- Two queues add entries to cache as and when they are accessed. If a entry is accessed twice, it is moved to a bigger cache. This is called two queue cache because it is maintained by two different queues. First queue (small one) is generally kept 1/3rd of the size of second queue. It provides advantage of LRU2 cache and reduce the effort of maintaining the track of two items.  

**5. Adaptive replacement cache (_ARC_)**  
- Sometimes it is said that this cache balances out between LFU and LRU, but that's not 100% true. In this cache, 2 lists are maintained. First list contains the entries that are seen just once recently, whereas second list contains the entries which are seen atleast twice recently. So, first list maintains _"recency"_ and second list maintains _"frequency"_. This is fast and considered one of the best replacement algorithm.  

**6. Most recently used cache (_MRU_)**  
- Unlike LRU, this cache removes the most recently accessed element from the cache first when cache becomes full. This is because accessing resources is highly unpredictable. It works on the theory that if a element is accessed just now, it won't be accesed for some time now and the one's which were accessed last, it's there turn now. So this removes the item which is most recently used.  
ex. You are standing at a bus stop and checking the entries of buses based on the route number. So, if you have seen a bus of route 16 entering the stop just now, it is very unlikely to see another bus of route number 16 very soon.  

**7. First in first out (_FIFO_)**  
- This is first in first out cache, and is implemented using a queue. This queue keeps the most recently accessed entry at the back and least recently at the front. When cache becomes full or we have to make space for the new entry, we remove the entry that is at the front. 
Accessed Just Now **> > > > > >** Accessed some time back.  

**8. Second Chance**  
- This works on the same concept as FIFO works, i.e it keeps the track of entries in the queue. But when cache becomes full, instead of removing the first entry blindly, this checks if there is a bit set to the entry. This bit is set based on the fact if this entry was accessed earlier as well. For ex. If a entry is accessed once bit can have 0, or if it is accessed more then once, bit can have value as 1. So if this cache finds the bit associated with a entry as 1, it knows that is entry was accessed twice before and it moves it back to the queue instead of removing it. This can be implemented using a circular list.  

**9. Simple time based**  
- This works based on the time. Entries in the cache remains for some specific amount of time. When that time limit hits, this cache invalidates all the entries and populate the cache again with fresh data.  

