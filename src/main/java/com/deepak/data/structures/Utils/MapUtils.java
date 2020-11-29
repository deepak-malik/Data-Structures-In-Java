/**
 * Data-Structures-In-Java
 * MapUtils.java
 */
package com.deepak.data.structures.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Utilities for Maps
 * 
 * @author Deepak
 */
public class MapUtils {

	/**
	 * Method to check if a map is empty
	 * 
	 * @param map
	 * @return {@link boolean}
	 */
	public static <K, V> boolean isEmpty(Map<K, V> map) {
		if (map == null || map.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method to invert a map i.e keys becomes values and vice versa
	 * 
	 * @param map
	 * @return {@link Map<V, K>}
	 */
	public static <K, V> Map<V, K> invert(Map<K, V> map) {
		if (map != null) {
			Map<V, K> returnValue = new HashMap<>();
			for (Entry<K, V> entry : map.entrySet()) {
				if (entry != null) {
					returnValue.put(entry.getValue(), entry.getKey());
				}
			}
			return returnValue;
		}
		return null;
	}

	/**
	 * Method to sort a map based on the comparator
	 * 
	 * @param map
	 * @param comparator
	 * @return {@link Map<K, V>}
	 */
	public static <K, V> Map<K, V> sortedMap(Map<K, V> map, Comparator<K> comparator) {
		if (map != null && comparator != null) {
			Map<K, V> returnValue = new HashMap<>();
			List<K> list = new ArrayList<>();
			for (K key : map.keySet()) {
				list.add(key);
			}
			Collections.sort(list, comparator);
			for (int i = 0; i < list.size(); i++) {
				K key = list.get(i);
				returnValue.put(key, map.get(key));
			}
			return returnValue;
		}
		return null;
	}

	/**
	 * Method to convert a Map to Properties i.e Key=Value
	 * 
	 * @param map
	 * @return {@link List<String>}
	 */
	public static <K, V> List<String> toProperties(Map<K, V> map) {
		if (map != null) {
			List<String> propertiesList = new ArrayList<>();
			for (Entry<K, V> entry : map.entrySet()) {
				propertiesList.add(String.valueOf(entry.getKey()) 
						+ "=" + String.valueOf(entry.getValue()));
			}
			return propertiesList;
		}
		return null;
	}

	/**
	 * Method to convert a map to unmodifiable map
	 * 
	 * @param map
	 * @return {@link Map<K, V>}
	 */
	public static <K, V> Map<K, V> unmodifiableMap(Map<K, V> map) {
		if (map != null) {
			final Map<K, V> returnValue = new HashMap<>();
			for (Entry<K, V> entry : map.entrySet()) {
				final K key = entry.getKey();
				final V value = entry.getValue();
				returnValue.put(key, value);
			}
		}
		return null;
	}

	/**
	 * Method to check if a Map contains a key
	 * 
	 * @param map
	 * @param key
	 * @return {@link boolean}
	 */
	public static <K, V> boolean containsKey(Map<K, V> map, K key) {
		if (map != null) {
			for (K k : map.keySet()) {
				if (k.equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Method to check if map contains a value
	 * 
	 * @param map
	 * @param value
	 * @return {@link boolean}
	 */
	public static <K, V> boolean containsValue(Map<K, V> map, V value) {
		if (map != null) {
			for (V v : map.values()) {
				if (v.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

}
