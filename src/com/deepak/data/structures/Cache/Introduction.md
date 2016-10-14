## Caching Introduction

Caching is a technique of storing the data in a temporary place since fetching the original data over API call can be expensive. From cache, we can retrieve it faster. Cache is made of pool of entries, which are copy of real data. Each entry is associated with a tag (key identifier) which is used for retrival. 

Here are some of the terms used with caching,  
Lets assume we have some products in the backend and each of the product has a product id which is unique.
**Cache Hit**  
When client invokes the request to view product details, we first check the cache if details of that product are available in cache. If a entry is found with the tag requested, we fetch the details from the cache. This is called cache hit i.e requested value is available in cache. Percentage of cache hit is called hit ratio or hit rate.  
**2. Cache Miss**  
On the contrary, when tag is not found in the cache, it is called as cache miss. In this case call to backend is made and cache is updated so that next time we can avoid cache miss in future.  
If we encounter cache miss, there are two possible scenarios that can happen :  
- We have enough free space in the cache since cache hasn't reached its limit, so the object that caused cache miss will be fetched from backend and will be inserted in the cache.  
- There is no free space in the cache since cache has reached its capacity, so the object that caused the cache miss will be fetched from backend and we have to decide which object can be evicted (deleted) now to make free space for new one. This is done by replacement policy which will be discussed later.  
Below diagram shows the concept of cache hit and cache miss,  

![cache-hit-ratio-latency-graph](https://cloud.githubusercontent.com/assets/3439029/19374486/c270bd1a-9180-11e6-8df4-66fd7aab4a8e.png)

**3. Storage Cost**    
**4. Retrival Cost**    
**5. Invalidation**   
**6. Replacement policy**  






