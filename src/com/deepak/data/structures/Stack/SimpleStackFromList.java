/**
 * Data-Structures-In-Java
 * SimpleStackFromList.java
 */
package com.deepak.data.structures.Stack;

import java.util.LinkedList;

/**
 * Class implementing simple stack based on the list
 * 
 * @author Deepak
 */
public class SimpleStackFromList {

	/**
	 * Linked list to hold items
	 */
	private LinkedList<Object> list = new LinkedList<>();

	/**
	 * Method to push a item on top of stack
	 * 
	 * @param item
	 */
	public void push(Object item) {
		list.addFirst(item);
	}

	/**
	 * Method to remove a item from top of stack
	 * 
	 * @return {@link Object}
	 */
	public Object pop() {
		return list.removeFirst();
	}

	/**
	 * Method to look up top item in stack
	 * 
	 * @return {@link Object}
	 */
	public Object peek() {
		return list.getFirst();
	}

	/**
	 * Method to check size of the stack
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Method to check if stack is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
