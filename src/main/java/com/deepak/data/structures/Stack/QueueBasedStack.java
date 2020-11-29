/**
 * Data-Structures-In-Java
 * QueueBasedStack.java
 */
package com.deepak.data.structures.Stack;

import java.util.LinkedList;

/**
 * Queue based stack implementation
 * 
 * @author Deepak
 *
 * @param <T>
 */
public class QueueBasedStack<T> {

	/* We will use only one queue */
	private LinkedList<T> queue = null;

	/**
	 * Default Constructor
	 */
	public QueueBasedStack() {
		queue = new LinkedList<>();
	}

	/**
	 * Method to push an item on stack
	 * 
	 * @param item
	 */
	public void push(T item) {
		queue.add(item);
		int size = queue.size();
		while (size > 1) {
			queue.add(queue.remove());
			size--;
		}
	}

	/**
	 * Method to pop an item from stack
	 * 
	 * @return {@link T}
	 */
	public T pop() {
		return queue.remove();
	}

	/**
	 * Method to peek an item from stack
	 * 
	 * @return {@link T}
	 */
	public T peek() {
		return queue.peek();
	}

	/**
	 * Method to return size of stack
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return queue.size();
	}

	/**
	 * Method to check if stack is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}


}
