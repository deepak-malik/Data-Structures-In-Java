/**
 * Data-Structures-In-Java
 * SparseArray.java
 */
package com.deepak.data.structures.Arrays;

import com.deepak.data.structures.Utils.ArrayUtils;

/**
 * Sparse Arrays in Java :
 * 
 * Sparse Arrays maps Integers to Objects. Unlike a normal array of objects,
 * there can be gap in the indexes. It is intended to be more memory efficient
 * than mapping Integers to Objects in a HashMap, both because it avoids the
 * auto boxing of keys and it's data structure doesn't rely on an extra entry
 * object for mapping.
 * 
 * <p>Note that this container keeps its mappings in an array data structure,
 * using a binary search to find keys. The implementation is not intended to be 
 * appropriate for data structures that may contain large numbers of items. 
 * It is generally slower than a traditional HashMap, since lookups require a 
 * binary search and adds and removes require inserting and deleting entries 
 * in the array. For containers holding up to hundreds of items, the performance 
 * difference is not significant, less than 50%.</p>
 *
 * <p>To help with performance, the container includes an optimization when removing
 * keys: instead of compacting its array immediately, it leaves the removed entry marked
 * as deleted.  The entry can then be re-used for the same key, or compacted later in
 * a single garbage collection step of all removed entries.  This garbage collection will
 * need to be performed at any time the array needs to be grown or the the map size or
 * entry values are retrieved.</p>
 *   
 * @author Deepak
 */
public class SparseArray<T> {

	/* Define Object DELETED */
	private static final Object DELETED = new Object();
	/* Flag for garbage collection */
	private boolean garbage = false;
	/* Default Capacity */
	private static final int DEFAULT_CAPACITY = 10;

	/* Variables for keys, values and size */
	private int[] keys;
	private Object[] values;
	private int size;

	/**
	 * Constructor
	 */
	public SparseArray() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructor
	 * 
	 * @param initialCapacity
	 */
	public SparseArray(int initialCapacity) {
		if (initialCapacity == 0) {
			keys = new int[0];
			values = new Object[0];
		} else {
			values = new Object[initialCapacity];
			keys = new int[values.length];
		}
		size = 0;
	}

	/**
	 * Method to get the value associated with the key
	 * 
	 * @param key
	 * @return {@link T}
	 */
	public T get(int key) {
		return get(key, null);
	}

	/**
	 * Method to get the value associated with the key, 
	 * If not found, return default value specified
	 * 
	 * @param key
	 * @param valueIfKeyNotFound
	 * @return {@link T}
	 */
	@SuppressWarnings("unchecked")
	public T get(int key, T valueIfKeyNotFound) {
		int i = ArrayUtils.binarySearch(keys, size, key);
		if (i < 0 || values[i] == DELETED) {
			return valueIfKeyNotFound;
		} else {
			return (T) values[i];
		}
	}

	/**
	 * Method to add the key and value in sparse array
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, T value) {
		int i = ArrayUtils.binarySearch(keys, size, key);
		if (i >= 0) {
			values[i] = value;
		} else {
			i = ~i;
			if (i < size && values[i] == DELETED) {
				keys[i] = key;
				values[i] = value;
				return;
			}
			if (garbage && size >= keys.length) {
				performGC();
				i = ~ArrayUtils.binarySearch(keys, size, key);
			}
			keys = insert(keys, size, i, key);
			values = insert(values, size, i, value);
			size++;
		}
	}

	/**
	 * Method to delete a Key value pair for a key
	 * 
	 * @param key
	 */
	public void delete(int key) {
		int i = ArrayUtils.binarySearch(keys, size, key);
		if (i >= 0) {
			if (values[i] != DELETED) {
				values[i] = DELETED;
				garbage = true;
			}
		}
	}

	/**
	 * Method to remove a Key value pair for a key
	 * 
	 * @param key
	 */
	public void remove(int key) {
		delete(key);
	}

	/**
	 * Method to remove the value at index
	 * 
	 * @param index
	 */
	public void removeAt(int index) {
		if (values[index] != DELETED) {
			values[index] = DELETED;
			garbage = true;
		}
	}

	/**
	 * Method to get the key at index
	 * 
	 * @param index
	 * @return {@int key}
	 */
	public int keyAt(int index) {
		if (garbage) {
			performGC();
		}
		return keys[index];
	}

	/**
	 * Method to find the value at index
	 * 
	 * @param index
	 * @return {@link T}
	 */
	@SuppressWarnings("unchecked")
	public T valueAt(int index) {
		if (garbage) {
			performGC();
		}
		return (T) values[index];
	}

	/**
	 * Method to set the value at given index
	 * 
	 * @param index
	 * @param value
	 */
	public void setValueAt(int index, T value) {
		if (garbage) {
			performGC();
		}
		values[index] = value;
	}

	/**
	 * Method to clear
	 */
	public void clear() {
		int n = size;
		Object[] valArray = values;
		for (int i = 0; i < n; i++) {
			valArray[i] = null;
		}
		size = 0;
		garbage = false;
	}

	/**
	 * Method to find size of the array
	 * 
	 * @return {@link int}
	 */
	public int size() {
		if (garbage) {
			performGC();
		}
		return size;
	}

	/**
	 * Method to check if array is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method to perform GC
	 */
	private void performGC() {
		int n = size;
		int position = 0;
		int[] keyArray = keys;
		Object[] valArray = values;

		for (int i = 0; i < n; i++) {
			Object val = valArray[i];
			if (val != DELETED) {
				if (i != position) {
					keyArray[position] = keyArray[i];
					valArray[position] = val;
					valArray[i] = null;
				}
				position++;
			}
			garbage = false;
			size = position;
		}

	}

	/**
	 * Method to insert an element at a given index
	 * 
	 * @param array
	 * @param currentSize
	 * @param index
	 * @param element
	 * @return {@link Object[]}
	 */
	private Object[] insert(Object[] array, int currentSize, int index, T element) {
		assert currentSize <= array.length;
		if (currentSize + 1 <= array.length) {
			System.arraycopy(array, index, array, index + 1, currentSize - index);
			array[index] = element;
			return array;
		}
		Object[] newArray = new Object[currentSize * 2];
		System.arraycopy(array, 0, newArray, 0, index);
		newArray[index] = element;
		System.arraycopy(array, index, newArray, index + 1, array.length - index);
		return newArray;
	}

	/**
	 * Method to insert an integer at given index
	 * 
	 * @param array
	 * @param currentSize
	 * @param index
	 * @param element
	 * @return {@link int[]}
	 */
	private static int[] insert(int[] array, int currentSize, int index, int element) {
		assert currentSize <= array.length;
		if (currentSize + 1 <= array.length) {
			System.arraycopy(array, index, array, index + 1, currentSize - index);
			array[index] = element;
			return array;
		}
		int[] newArray = new int[currentSize * 2];
		System.arraycopy(array, 0, newArray, 0, index);
		newArray[index] = element;
		System.arraycopy(array, index, newArray, index + 1, array.length - index);
		return newArray;
	}

}
