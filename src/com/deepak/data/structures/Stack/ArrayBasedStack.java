/**
 * Data-Structures-in-Java
 * ArrayBasedStack.java
 */
package com.deepak.data.structures.Stack;

import java.util.NoSuchElementException;

/**
 * Array based implementation of stack
 * 
 * @author Deepak
 */
public class ArrayBasedStack {

	/**
	 * Array of objects representing Stack
	 */
	private Object[] array;

	/**
	 * Size of Stack
	 */
	private int size = 0;

	/**
	 * Constructor to create a new Stack
	 * 
	 * @param capacity
	 */
	public ArrayBasedStack(int capacity) {
		array = new Object[capacity];
	}

	/**
	 * Method to push a item on top of stack
	 * 
	 * @param item
	 */
	public void push(Object item) {
		if (size == array.length) {
			throw new IllegalStateException("Cannot insert on full Stack");
		}
		array[size++] = item;
	}

	/**
	 * Method to remove a item from top of stack
	 * 
	 * @return {@link Object}
	 */
	public Object pop() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot delete from a empty Stack");
		}
		Object result = array[0];
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return result;
	}

	/**
	 * Method to look up top item in stack
	 * 
	 * @return {@link Object}
	 */
	public Object peek() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot peek from a empty Stack");
		}
		return array[0];
	}

	/**
	 * Method to check size of the stack
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to check if stack is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size == 0;
	}

}
