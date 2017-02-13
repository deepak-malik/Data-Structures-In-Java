/**
 * Data-Structures-In-Java
 * MapUtilsTest.java
 */
package com.deepak.data.structures.Utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Map utility functions
 * 
 * @author Deepak
 */
public class MapUtilsTest {

	/**
	 * Test case to check if map is empty
	 */
	@Test
	public void testIsEmpty() {
		Map<String, String> map = new HashMap<>();
		Assert.assertTrue(MapUtils.isEmpty(map));
		map.put("A", "B");
		Assert.assertFalse(MapUtils.isEmpty(map));
	}

	/**
	 * Test case to check inversion of map
	 */
	@Test
	public void testInvertMap() {
		Map<String, String> map = new HashMap<>();
		Assert.assertTrue(MapUtils.isEmpty(map));
		map.put("A", "B");
		map.put("M", "N");
		map.put("X", "Y");
		Map<String, String> updatedMap = MapUtils.invert(map);
		/* Keys and values are inverted now. Searching by values */
		Assert.assertEquals(updatedMap.get("B"), "A");
		Assert.assertEquals(updatedMap.get("N"), "M");
		Assert.assertEquals(updatedMap.get("Y"), "X");
	}

	/**
	 * Test case to check sorting of map
	 */
	@Test
	public void testSortedMap() {
		Map<String, String> map = new HashMap<>();
		Assert.assertTrue(MapUtils.isEmpty(map));
		map.put("C", "Cat");
		map.put("B", "Ball");
		map.put("A", "Apple");
		MyComparator<String> comparator = new MyComparator<>();
		Map<String, String> updatedMap = MapUtils.sortedMap(map, comparator);
		for (String key : updatedMap.keySet()) {
			/* Since map is sorted now, A should reach on top */
			Assert.assertEquals(key, "A");
			break;
		}
	}

	/**
	 * Method to test conversion of map to properties
	 */
	@Test
	public void testToProperties() {
		Map<String, String> map = new HashMap<>();
		Assert.assertTrue(MapUtils.isEmpty(map));
		map.put("A", "Apple");
		map.put("B", "Ball");
		map.put("C", "Cat");
		List<String> properties = MapUtils.toProperties(map);
		Assert.assertEquals(properties.get(0), "A=Apple");
		Assert.assertEquals(properties.get(1), "B=Ball");
		Assert.assertEquals(properties.get(2), "C=Cat");
	}

	/**
	 * Method to test contains key
	 */
	@Test
	public void testContainsKey() {
		Map<String, String> map = new HashMap<>();
		Assert.assertTrue(MapUtils.isEmpty(map));
		map.put("A", "Apple");
		map.put("B", "Ball");
		map.put("C", "Cat");
		Assert.assertTrue(MapUtils.containsKey(map, "B"));
		Assert.assertTrue(MapUtils.containsKey(map, "C"));
		Assert.assertFalse(MapUtils.containsKey(map, "D"));
	}

	/**
	 * Method to test contains value
	 */
	@Test
	public void testContainsValue() {
		Map<String, String> map = new HashMap<>();
		Assert.assertTrue(MapUtils.isEmpty(map));
		map.put("A", "Apple");
		map.put("B", "Ball");
		map.put("C", "Cat");
		Assert.assertTrue(MapUtils.containsValue(map, "Ball"));
		Assert.assertTrue(MapUtils.containsValue(map, "Cat"));
		Assert.assertFalse(MapUtils.containsValue(map, "Dog"));
	}

	/**
	 * Comparator class which just handles string as of now.
	 * This will sort strings in alphabetical order
	 * 
	 * @author Deepak
	 *
	 * @param <T>
	 */
	public class MyComparator<T> implements Comparator<T> {

		@Override
		public int compare(final T o1, final T o2) {
			if (o1 instanceof String && o2 instanceof String) {
				return o1.toString().compareTo(o2.toString());
			}
			return 0;
		}

	}

}
