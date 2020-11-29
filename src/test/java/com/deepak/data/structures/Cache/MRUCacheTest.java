/**
 * Data-Structures-In-Java
 * MRUCacheTest.java
 */
package com.deepak.data.structures.Cache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for MRU cache
 * 
 * @author Deepak
 */
public class MRUCacheTest {

	/**
	 * Cache creation
	 */
	private MRUCache<Integer, Integer> cache;

	/**
	 * Setup MRU cache
	 */
	@Before
	public void setup() {
		cache = new MRUCache<>();
	}

	/**
	 * Test case for empty cache
	 */
	@Test
	public void testEmptyCache() {
		Assert.assertNull(cache.get(1));
	}

	/**
	 * Test case to check eviction doesn't happen
	 * when capacity is not increased
	 */
	@Test
	public void testDoesNotEvictWhenCapacityIsNotExceeded() {
		cache.setCapacity(5);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		Assert.assertEquals(cache.get(1).intValue(), 1);
		Assert.assertEquals(cache.get(2).intValue(), 2);
		Assert.assertEquals(cache.get(3).intValue(), 3);
		Assert.assertEquals(cache.get(4).intValue(), 4);
		Assert.assertEquals(cache.get(5).intValue(), 5);
	}

	/**
	 * Test case to check eviction happens 
	 * when capacity is exceeded 
	 */
	@Test
	public void testEvictCacheWhenCapacityIsExceeded() {
		cache.setCapacity(5);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.put(6, 6);
		Assert.assertNull(cache.get(5));
		Assert.assertEquals(6, cache.get(6).intValue());
		Assert.assertEquals(4, cache.get(4).intValue());
		Assert.assertEquals(3, cache.get(3).intValue());
		Assert.assertEquals(2, cache.get(2).intValue());
		Assert.assertEquals(1, cache.get(1).intValue());
		cache.put(7, 7);
		Assert.assertNull(cache.get(1));
		Assert.assertEquals(2, cache.get(2).intValue());
		Assert.assertEquals(3, cache.get(3).intValue());
		Assert.assertEquals(4, cache.get(4).intValue());
		Assert.assertEquals(6, cache.get(6).intValue());
		Assert.assertEquals(7, cache.get(7).intValue());
	}

	/**
	 * Test case to check eviction does not
	 * happen when a value is replaced for a key
	 */
	@Test
	public void testDoesNotEvictWhenKeyIsReplaced() {
		cache.setCapacity(5);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.put(1, 100);
		Assert.assertEquals(100, cache.get(1).intValue());
		Assert.assertEquals(2, cache.get(2).intValue());
		Assert.assertEquals(3, cache.get(3).intValue());
		Assert.assertEquals(4, cache.get(4).intValue());
		Assert.assertEquals(5, cache.get(5).intValue());
	}

	/**
	 * Test case to check eviction happens when
	 * capacity is lowered
	 */
	@Test
	public void testEvictionWhenCapacityIsLowered() {
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.setCapacity(1);
		Assert.assertEquals(1, cache.size());
	}

	/**
	 * Test case to check eviction does not
	 * happen when capacity is increased
	 */
	@Test
	public void testDoesNotEvictWhenCapacityIsIncreased() {
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.setCapacity(cache.getCapacity() + 1);
		Assert.assertEquals(5, cache.size());
		Assert.assertEquals(1, cache.get(1).intValue());
		Assert.assertEquals(2, cache.get(2).intValue());
		Assert.assertEquals(3, cache.get(3).intValue());
		Assert.assertEquals(4, cache.get(4).intValue());
		Assert.assertEquals(5, cache.get(5).intValue());
	}

}
