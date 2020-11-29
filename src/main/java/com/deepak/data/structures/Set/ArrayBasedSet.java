/**
 * Data-Structures-And-Algorithms-in-Java
 * ArrayBasedSet.java
 */
package com.deepak.data.structures.Set;

/**
 * Class implementing Set based on Array
 * @author Deepak
 *
 * @param <T>
 */
public class ArrayBasedSet<T> {

	/**
	 * Array of object
	 */
	private Object arrayElements[];

	/**
	 * Variable to keep track of Set size
	 */
	private int size = 0;

	/**
	 * Default capacity of the Set
	 */
	private int DEFAULT_CAPACITY = 8;

	/**
	 * Constructor to create a new Set
	 * based on capacity
	 * @param capacity
	 */
	public ArrayBasedSet(int capacity) {
		arrayElements = new Object[capacity];
	}

	/**
	 * Constructor to create a new Set 
	 * based on elements
	 * @param elements
	 */
	public ArrayBasedSet(T[] elements) {
		arrayElements = elements;
		size = arrayElements.length;
	}

	/**
	 * Method to add a element to Set
	 * @param element
	 */
	public void addElement(T element) {
		if (!contains(element)) {
			if (size == arrayElements.length) {
				incrementArraySize();
			}
			arrayElements[size++] = element;
		}
	}

	/**
	 * Method to check if element exists in Stack
	 * @param element
	 * @return {@link boolean}
	 */
	public boolean contains(T element) {
		if (null == element) {
			for (int i = 0; i < size; i++) {
				if (null == arrayElements[i]) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(arrayElements[i])) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Method to check the size of Set
	 * @return {@link int}
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to check if Set is empty
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Method to clear all the elements in Set
	 */
	public void clear() {
		arrayElements = new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	/**
	 * toString implementation
	 */
	public String toString() {
		if (null == arrayElements || arrayElements.length == 0) {
			return "[EMPTY]";
		} else {
			String toStr = "[";
			for (int i = 0; i < arrayElements.length; i++) {
				toStr += arrayElements[i] + "”,";
			}
			toStr += "”]";
			return toStr;
		}
	}

	/**
	 * Method to increment the size when Set is full
	 */
	private void incrementArraySize() {
		Object[] tempArray = arrayElements;
		int tempSize = size * 2;
		arrayElements = new Object[tempSize];
		System.arraycopy(tempArray, 0, arrayElements, 0, size);
	}

}
