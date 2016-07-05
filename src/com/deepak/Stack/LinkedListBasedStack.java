/**
 * Data-Structures-And-Algorithms-in-Java
 * LinkedListBasedStack.java
 */
package com.deepak.Stack;

import java.util.NoSuchElementException;

/**
 * Class implementing Stack based on LinkedList
 * @author Deepak
 */
public class LinkedListBasedStack {

	/**
	 * Sample implementation of stack
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListBasedStack stack = new LinkedListBasedStack();
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
	 * Top node of the Stack
	 */
	private Node top = null;

	/**
	 * Method to push a item on the stack
	 * @param item
	 */
	public void push(Object item) {
		top = new Node(item, top);
	}

	/**
	 * Method to remove a item from the stack
	 * @return {@link Object}
	 */
	public Object pop() {
		if (top == null) {
			throw new IllegalStateException("Cannot pop from a empty stack");
		}
		Object result = peek();
		top = top.next;
		return result;
	}

	/**
	 * Method to find out top element on Stack
	 * @return {@link Object}
	 */
	public Object peek() {
		if (top == null) {
			throw new NoSuchElementException("Cannot peek from a empty stack");
		}
		return top.item;
	}

	/**
	 * Method to find size of the Stack
	 * @return {@link int}
	 */
	public int size() {
		int size = 0;
		for (Node node = top; node != null; node = node.next) {
			size++;
		}
		return size;
	}

	/**
	 * Method to check if Stack is Empty
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Node class for Stack
	 * @author Deepak
	 */
	private class Node {

		private Object item;
		private Node next;

		/**
		 * Constructor for creating a new Node
		 * @param item
		 * @param next
		 */
		public Node(Object item, Node next) {
			this.item = item;
			this.next = next;
		}

	}

}


