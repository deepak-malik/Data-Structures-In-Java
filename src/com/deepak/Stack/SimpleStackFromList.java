/**
 * Data-Structures-And-Algorithms-in-Java
 * SimpleStackFromList.java
 */
package com.deepak.Stack;

import java.util.LinkedList;

/**
 * Class implementing simple stack based on the list
 * @author Deepak
 */
public class SimpleStackFromList {

	/**
	 * Sample implementation of stack
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleStackFromList stack = new SimpleStackFromList();
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
	 * Linked list to hold items
	 */
	private LinkedList<Object> list = new LinkedList<>();

	/**
	 * Method to push a item on top of stack
	 * @param item
	 */
	public void push(Object item) {
		list.addFirst(item);
	}

	/**
	 * Method to remove a item from top of stack
	 * @return {@link Object}
	 */
	public Object pop() {
		return list.removeFirst();
	}

	/**
	 * Method to look up top item in stack
	 * @return {@link Object}
	 */
	public Object peek() {
		return list.getFirst();
	}

	/**
	 * Method to check size of the stack
	 * @return {@link int}
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Method to check if stack is empty
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
