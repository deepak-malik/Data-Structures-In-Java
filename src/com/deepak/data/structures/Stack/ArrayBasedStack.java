/**
 * Data-Structures-And-Algorithms-in-Java
 * ArrayBasedStack.java
 */
package com.deepak.data.structures.Stack;

import java.util.NoSuchElementException;

/**
 * Class implementing Stack based on Array
 */
public class ArrayBasedStack {

	/**
	 * Sample implementation of stack
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayBasedStack stack = new ArrayBasedStack(5);
		System.out.println("Creating a fresh Stack");
		System.out.println("Size of Stack => " + stack.size());
		System.out.println("Is Stack Empty => " + stack.isEmpty());
		System.out.println("Inserting two items in Stack.");
		stack.push(10);
		stack.push(20);
		System.out.println("After Insertion, Size of Stack => " + stack.size());
		System.out.println("After Insertion, Is Stack Empty => " + stack.isEmpty());
		System.out.println("Removing an item from Stack.");
		stack.pop();
		System.out.println("After Removal, Size of Stack => " + stack.size());
		System.out.println("Top element on Stack => " + stack.peek());
	}

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
	 * @param capacity
	 */
	public ArrayBasedStack(int capacity) {
		array = new Object[capacity];
	}

	/**
	 * Method to push a item on top of stack
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
	 * @return {@link Object}
	 */
	public Object pop() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot delete from a empty Stack");
		}
		Object result = array[size - 1];
		array[size--] = null;
		return result;
	}

	/**
	 * Method to look up top item in stack
	 * @return {@link Object}
	 */
	public Object peek() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot peek from a empty Stack");
		}
		return array[size - 1];
	}

	/**
	 * Method to check size of the stack
	 * @return {@link int}
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to check if stack is empty
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size == 0;
	}

}
