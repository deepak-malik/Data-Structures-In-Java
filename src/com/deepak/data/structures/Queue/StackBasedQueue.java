/**
 * Data-Structures-In-Java
 * StackBasedQueue.java
 */
package com.deepak.data.structures.Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implement a queue based on the stack 
 * 
 * @author Deepak
 *
 * @param <T>
 */
public class StackBasedQueue<T> {

	/* Two stacks for the implementation */
	private Stack<T> stack1 = null;
	private Stack<T> stack2 = null;

	/**
	 * Default Constructor
	 */
	public StackBasedQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	/**
	 * Method to peek from the queue
	 * 
	 * @return {@link T}
	 */
	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack Underflow!!");
		}
		if (stack2.isEmpty()) {
			moveStack1ToStack2();
		}
		return stack2.peek();
	}

	/**
	 * Method to enqueue a element
	 * 
	 * @param item
	 */
	public void enqueue(T item) {
		stack1.push(item);
	}

	/**
	 * Method to dequeue an element
	 * 
	 * @return {@link T}
	 */
	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack Underflow!!");
		}
		if (stack2.isEmpty()) {
			moveStack1ToStack2();
		}
		return stack2.pop();
	}

	/**
	 * Method to display elements from the queue
	 */
	public void display() {
		if (!stack1.isEmpty()) {
			System.out.println(Arrays.toString(stack1.toArray()));
		}
		if (!stack2.isEmpty()) {
			System.out.println(Arrays.toString(stack2.toArray()));
		}
	}

	/**
	 * Method to return size of the queue
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return stack1.size() + stack2.size();
	}

	/**
	 * Method to check if queue is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	/**
	 * Method to move elements from stack 1 to stack 2
	 */
	private void moveStack1ToStack2() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}

}
