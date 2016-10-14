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

2. Least recently used cache (_LRU_)  
3. Least recently used cache 2 (_LRU 2_)  
4. Two Queues  
5. Adaptive replacement cache (_ARC_)  
6. Most recently used cache (_MRU_)  
7. First in first out (_FIFO_)  
8. Second Chance  
9. Clock  
10. Simple time based  
