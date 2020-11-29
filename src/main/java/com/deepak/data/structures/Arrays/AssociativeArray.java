/**
 * Data-Structures-In-Java
 * AssociativeArray.java
 */
package com.deepak.data.structures.Arrays;

/**
 * Associative Arrays in Java :
 * 
 * Associative arrays are data structure, where keys are associated with some sort
 * of values. Though java does not support associative arrays, but same functionality
 * can be achieved through HashMap or HashTable. 
 * Below is the replica of HashMap just names as associative arrays.
 * 
 * @author Deepak
 */
public class AssociativeArray<K, V> {

	/* Table to hold key value pairs */
	private Entry<K, V>[] table;

	/* Variable to hold size of the map */
	private int size;

	/* Default table size */
	private static final int DEFAULT_TABLE_SIZE = 10;

	/**
	 * Constructor
	 */
	public AssociativeArray() {
		this(DEFAULT_TABLE_SIZE);
	}

	/**
	 * Constructor
	 * 
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public AssociativeArray(int size) {
		this.table = new Entry[size];
		this.size = 0;
	}

	/**
	 * Method to add/update a entry
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		boolean isNewEntry = true;
		/* Find the hash of the key and bucket it belongs to */
		int hash = key.hashCode();
		int bucket = getBucket(hash);
		Entry<K, V> entry = table[bucket];
		/* Loop through the entry of the associative array 
		 * and check if it's just a value update or a new key, value */
		while (entry != null) {
			if (entry.getHash() == hash && entry.getKey().equals(key)) {
				isNewEntry = false;
				entry.value = value;
			}
			entry = entry.next;
		}
		/* Create a new entry and push to array */
		if (isNewEntry) {
			Entry<K, V> newEntry = new Entry<>(key, value, hash);
			newEntry.next = table[bucket];
			table[bucket] = newEntry;
			size++;
		}
	}

	/**
	 * Method to find the value for a given key
	 * 
	 * @param key
	 * @return {@link V}
	 */
	public V get(K key) {
		/* Find hash code and bucket associated with key */
		int hash = key.hashCode();
		int bucket = getBucket(hash);
		/* Get all the entries on that column of bucket */
		Entry<K, V> entry = table[bucket];
		while (entry != null) {
			/* If hash and key matches, return the value */
			if (entry.getHash() == hash && entry.getKey() == key) {
				return entry.getValue();
			}
			entry = entry.next;
		}
		return null;
	}

	/**
	 * Method to get size of associative array
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to check if associative array is empty 
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method to get bucket based on the hash
	 * 
	 * @param hash
	 * @return {@link int}
	 */
	private int getBucket(int hash) {
		return (hash % table.length);
	}

	/**
	 * Static class Entry for associative array
	 * 
	 * @author Deepak
	 *
	 * @param <K>
	 * @param <V>
	 */
	public static class Entry<K, V> {

		/* Variables for key, value, hash and next entry */
		private final K key;
		private V value;
		private Entry<K, V> next;
		private int hash;

		/**
		 * Constructor
		 * 
		 * @param key
		 * @param value
		 * @param hash
		 */
		public Entry(K key, V value, int hash) {
			this.key = key;
			this.value = value;
			this.hash = hash;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public int getHash() {
			return hash;
		}

	}

}
