/**
 * Data-Structures-In-Java
 * CustomHashMap.java
 */
package com.deepak.data.structures.Hashing;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Custom HashMap implementation
 * Please go through this video for better understanding 
 * https://www.youtube.com/watch?v=c3RVW3KGIIE
 * 
 * TODO : Implementation of EntrySet and KeySet pending
 * @author Deepak
 *
 * @param <K>
 * @param <V>
 */
public class CustomHashMap<K, V> {

	/**
	 * Main method to test the HashMap
	 * @param args
	 */
	public static void main(String[] args) {
		CustomHashMap<String, Integer> map = new CustomHashMap<>();
		System.out.println("Creating a new Map, Size = " + map.size());
		System.out.println("Is Map Empty? => " + map.isEmpty());
		System.out.println("Adding a new Entry to Map.");
		map.put("Deepak Malik", 10);
		System.out.println("Is Map Empty? => " + map.isEmpty());
		System.out.println("Size of Map => " + map.size());
		System.out.println("Does Map contains Key (Deepak Malik)? => " + map.containsKey("Deepak Malik"));
		System.out.println("Does Map contains Key (Deepak)? => " + map.containsKey("Deepak"));
		System.out.println("Does Map contains Value (10)? => " + map.containsValue(10));
		System.out.println("Get the value associated with Key (Deepak Malik)? => " + map.get("Deepak Malik"));
		System.out.println("Capacity of Map => " + map.capacity());
		System.out.println("Clearing the Map.");
		map.clear();
		System.out.println("Size of the Map after clearing. => " + map.size());
	}

	/**
	 * Initial capacity of HashMap
	 */
	static final int INITIAL_CAPACITY = 16;

	/**
	 * Maximum capacity of HashMap
	 */
	static final int MAXIMUM_CAPACITY = 30;

	/**
	 * Default load factor for HashMap
	 */
	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	/**
	 * HashMap table. This is array of Entry<K, V>
	 */
	transient Entry<K, V>[] table;

	/**
	 * Entry Set of HashMap
	 */
	transient Set<Map.Entry<K, V>> entrySet;

	/**
	 * Size of HashMap
	 */
	transient int size;

	/**
	 * Number of operations done on HashMap
	 */
	transient int modCount;

	/**
	 * Threshold of HashMap
	 */
	int threshold;

	/**
	 * Load Factor of HashMap
	 */
	float loadFactor;

	/**
	 * Constructor based on initial capacity and load factor
	 * 1. Initial capacity should not be less then 0
	 * 2. If Initial capacity is greater then Max capacity, then initial capacity will be max capacity
	 * 3. Load factor should not be less then 0 and should be a number
	 * 4. Specify load factor and threshold
	 * 5. Create the table with calculated capacity
	 * 
	 * @param initialCapacity
	 * @param loadFactor
	 */
	@SuppressWarnings("unchecked")
	public CustomHashMap(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal initial capacity: " +
					initialCapacity);
		}
		if (initialCapacity > MAXIMUM_CAPACITY) {
			initialCapacity = MAXIMUM_CAPACITY;
		}
		if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
			throw new IllegalArgumentException("Illegal load factor: " +
					loadFactor);
		}
		this.loadFactor = loadFactor;
		threshold = (int) (initialCapacity * loadFactor);
		table = new Entry[initialCapacity];
		init();
	}

	/**
	 * Constructor based on initial capacity
	 * 1. Create a HashMap based on given capacity and default load factor 
	 * 
	 * @param initialCapacity
	 */
	public CustomHashMap(int initialCapacity) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * Default constructor
	 * 1. Create a HashMap based on default initial capacity and default load factor
	 */
	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		threshold = (int) (INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
		table = new Entry[INITIAL_CAPACITY];
		init();
	}

	/**
	 * Initialize HashMap
	 */
	void init() {}

	/**
	 * Method to calculate Hash of a given integer
	 * 
	 * @param h
	 * @return {@link int}
	 */
	private int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	/**
	 * Method to calculate index where a entry has to be placed in table
	 * 
	 * @param h
	 * @param length
	 * @return {@link int}
	 */
	private int indexFor(int h, int length) {
		return h & (length-1);
	}

	/**
	 * Method to calculate size of the HashMap
	 * @return {@link int}
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to check if HashMap is empty
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method to check Capacity of HashMap
	 * @return {@link int}
	 */
	public int capacity() {
		return table.length;
	}

	/**
	 * Method to clear the content of HashMap
	 * 1. Create a cloned table
	 * 2. Loop through each entry and make it null
	 * 3. Reset the size to initial 0
	 */
	public void clear() {
		modCount++;
		Entry<K, V>[] clonedTable = table;
		for (int i = 0; i < clonedTable.length; i++) {
			clonedTable[i] = null;
		}
		size = 0;
	}

	/**
	 * Method to get the Value from HashMap based on the Key
	 * 1. If key is null, then value is on 0th index
	 * 2. Else, check the hash for the given key and find the index
	 * 3. Loop through all the entries in index
	 * 4. If hash and key matches, we have found the match
	 * 5. Return the value
	 * @param key
	 * @return {@link V}
	 */
	public V get(Object key) {
		if (key == null) {
			return getForNullKey();
		} else {
			int hash = hash(key.hashCode());
			for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
				Object k;
				if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
					return e.value;
				}
			}
		}
		return null;
	}

	/**
	 * Method to get Value for null key
	 * 1. Loop through the entries at index 0
	 * 2. Return the value where 1st key is null
	 * @return {@link V}
	 */
	private V getForNullKey() {
		for (Entry<K, V> e = table[0]; e != null; e = e.next) {
			if (e.key == null) {
				return e.value;
			}
		}
		return null;
	}

	/**
	 * Method to check if HashMap contains the given key
	 * @param key
	 * @return {@link boolean}
	 */
	public boolean containsKey(Object key) {
		return getEntry(key) != null;
	}

	/**
	 * Method to return the entry associated with given key
	 * @param key
	 * @return {@link Entry<K, V>}
	 */
	final Entry<K, V> getEntry(Object key) {
		int hash = (key == null) ? 0 : hash(key.hashCode());
		for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
				return e;
			}
		}
		return null;
	}

	/**
	 * Method to check if HashMap contains given value
	 * @param value
	 * @return {@link boolean}
	 */
	public boolean containsValue(Object value) {
		Entry<K, V>[] clonedTable = table;
		for (int i = 0; i < clonedTable.length; i++) {
			for(Entry<K, V> e = table[i]; e != null; e = e.next) {
				if (e.value == null || value.equals(e.value)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Method to clone the HashMap
	 */
	@SuppressWarnings("unchecked")
	public Object clone() {
		CustomHashMap<K, V> result = null;
		try {
			result = (CustomHashMap<K, V>)super.clone();
		} catch (CloneNotSupportedException e) {

		}
		result.table = new Entry[table.length];
		result.entrySet = null;
		result.modCount = 0;
		result.size = 0;
		result.init();
		result.putAllForCreate((Map<? extends K, ? extends V>) this);
		return result;
	}

	/**
	 * Method to put all values while creating a HashMap
	 * @param m
	 */
	private void putAllForCreate(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			int hash = (entry.getKey() == null) ? 0 : hash(entry.getKey().hashCode());
			int i = indexFor(hash, table.length);
			for (Entry<K,V> e = table[i]; e != null; e = e.next) {
				Object k;
				if (e.hash == hash && ((k = e.key) == entry.getKey() || (entry.getKey() != null && entry.getKey().equals(k)))) {
					e.value = entry.getValue();
					return;
				}
			}
			createEntry(hash, entry.getKey(), entry.getValue(), i);
		}
	}

	/**
	 * Method to insert a key value pair in HashMap
	 * @param key
	 * @param value
	 * @return {@link V}
	 */
	public V put(K key, V value) {
		if (key == null) {
			return putForNullKey(value);
		} else {
			int hash = hash(key.hashCode());
			int index = indexFor(hash, table.length);
			for (Entry<K, V> e = table[index]; e != null; e = e.next) {
				Object k;
				if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
					V oldValue = e.value;
					e.value = value;
					return oldValue;
				}
			}
			modCount++;
			addEntry(hash, key, value, index);
		}
		return null;
	}

	/**
	 * Method to insert a value for null key
	 * @param value
	 * @return {@link V}
	 */
	private V putForNullKey(V value) {
		for (Entry<K, V> e = table[0]; e != null; e = e.next) {
			if (e.key == null) {
				V oldValue = e.value;
				e.value = value;
				return oldValue;
			}
		}
		modCount++;
		addEntry(0, null, value, 0);
		return null;
	}

	/**
	 * Method to add a entry to HashMap at any given index
	 * @param hash
	 * @param key
	 * @param value
	 * @param bucketIndex
	 */
	void addEntry(int hash, K key, V value, int bucketIndex) {
		Entry<K, V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
		if (size++ > threshold) {
			resize(2 * table.length);
		}
	}

	/**
	 * Method to create a entry in HashMap at any given index
	 * @param hash
	 * @param key
	 * @param value
	 * @param bucketIndex
	 */
	void createEntry(int hash, K key, V value, int bucketIndex) {
		Entry<K, V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
		size++;
	}

	/**
	 * Method to resize the current HashMap
	 * @param newCapacity
	 */
	@SuppressWarnings("unchecked")
	void resize(int newCapacity) {
		Entry<K, V>[] oldTable = table;
		int oldCapacity = oldTable.length;
		if (oldCapacity == MAXIMUM_CAPACITY) {
			threshold = Integer.MAX_VALUE;
			return;
		}
		Entry<K, V>[] newTable = new Entry[newCapacity];
		transfer(newTable);
		table = newTable;
		threshold = (int) (newCapacity * loadFactor);
	}

	/**
	 * Method to transfer the contents of a HashMap
	 * @param newTable
	 */
	void transfer(Entry<K, V>[] newTable) {
		Entry<K, V>[] src = table;
		int newCapacity = newTable.length;
		for (int j = 0; j < src.length; j++) {
			Entry<K, V> e = src[j];
			if (e != null) {
				src[j] = null;
				do {
					Entry<K, V> next = e.next;
					int i = indexFor(e.hash, newCapacity);
					e.next = newTable[i];
					newTable[i] = e;
					e = next;
				} while (e != null);
			}
		}
	}

	/**
	 * Static class Entry [This is a Node representation for LinkedList]
	 * @author Deepak
	 *
	 * @param <K>
	 * @param <V>
	 */
	static class Entry<K, V> {
		final int hash;
		final K key;
		V value;
		Entry<K, V> next;

		/**
		 * Constructor for creating a Entry
		 * @param hash
		 * @param key
		 * @param value
		 * @param next
		 */
		public Entry(int hash, K key, V value, Entry<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		/**
		 * HashCode implementation for entry
		 */
		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}

		/**
		 * Method to check if two objects are equal
		 */
		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (o instanceof Map.Entry) {
				Map.Entry<?,?> e = (Map.Entry<?,?>)o;
				if (Objects.equals(key, e.getKey()) &&
						Objects.equals(value, e.getValue()))
					return true;
			}
			return false;
		}

	}

}


