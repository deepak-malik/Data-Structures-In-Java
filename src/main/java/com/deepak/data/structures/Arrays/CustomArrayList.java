/**
 * Data-Structures-In-Java
 * CustomArrayList.java
 */
package com.deepak.data.structures.Arrays;

import java.util.Arrays;

/**
 * Custom implementation of ArrayList
 * This is generic, so can support any type.
 * 
 * @author Deepak
 *
 * @param <T>
 */
public class CustomArrayList<T> {

	/**
	 * Variable to hold initial capacity of array list
	 * Marked as final
	 */
	private static final int INITIAL_CAPACITY = 10;

	/**
	 * Array of objects to hold data
	 */
	private Object elementData[] = {};

	/**
	 * Variable to hold size of list
	 */
	private int size = 0;

	/**
	 * Default Constructor
	 */
	public CustomArrayList() {
		elementData = new Object[INITIAL_CAPACITY];
	}

	/**
	 * Method to add a element
	 * 
	 * @param element
	 */
	public void add(T element) {
		/* If we have reached the capacity i.e array of elements is full, 
		 * increase the size of the array i.e ensure capacity */
		if (size == elementData.length) {
			ensureCapacity();
		}
		/* Add the element and increase the size */
		elementData[size++] = element;
	}

	/**
	 * Method to fetch the element from list based on given index
	 * 
	 * @param index
	 * @return {@link T}
	 */
	@SuppressWarnings("unchecked")
	public T get(int index) {
		/* Check for invalid index */
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index passed !!");
		}
		/* Type cast and return the value present at index */
		return (T)elementData[index];
	}

	/**
	 * Method to remove the element at a given index
	 * 
	 * @param index
	 * @return {@link Object}
	 */
	public Object remove(int index) {
		/* Check for invalid index */
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index passed !!");
		}
		/* Find element to be removed */
		Object removedElement = elementData[index];
		/* Starting from the index till last, move
		 * each element to the left and decrease the size of list */
		for (int i = index; i < size; i++) {
			elementData[i] = elementData[i + 1];
		}
		size--;
		return removedElement;
	}

	/**
	 * Convert list of array of objects
	 * 
	 * @return {@link Object[]}
	 */
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

	/**
	 * Method to check if list contains the element
	 * 
	 * @param element
	 * @return {@link boolean}
	 */
	public boolean contains(T element) {
		/* Element should not be null */
		if (element == null) {
			throw new IllegalArgumentException("Invalid input. Cannot be null !!");
		}
		/* Compare the element with each entry */
		for (Object object : elementData) {
			if (object != null && object.equals(element)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to check the size of list
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to check if list is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method to clear the list
	 */
	public void clearAll() {
		/* Create the element data again and set size to 0 */
		elementData = new Object[INITIAL_CAPACITY];
		size = 0;
	}

	/**
	 * Method to display the elements in the list 
	 */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.println("Index = " + i + ", Element = " + elementData[i]);
		}
	}

	/**
	 * Method to ensure capacity. i.e increase capacity
	 * once we have reached the limit
	 */
	private void ensureCapacity() {
		int newIncreasedCapacity = elementData.length * 2;
		elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
	}

}
