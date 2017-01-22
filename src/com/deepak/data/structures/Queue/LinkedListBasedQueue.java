/**
 * Data-Structures-In-Java
 * LinkedListBasedQueue.java
 */
package com.deepak.data.structures.Queue;

import java.util.NoSuchElementException;

/**
 * Linked List based implementation of queue
 * 
 * @author Deepak
 */
public class LinkedListBasedQueue {

	/**
	 * Since in queue, we have to keep track of both the ends
	 * We need access to both head and tail node
	 */
	private Node head = null;
	private Node tail = null;

	/**
	 * Method to insert a item in the queue
	 * 
	 * @param item
	 */
	public void enqueue(Object item) {
		Node newNode = new Node(item, null);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
	}

	/**
	 * Method to remove the item from the queue
	 * 
	 * @return {@link object}
	 */
	public Object dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Cannot dequeue from empty Queue");
		}
		Object item = head.item;
		if (tail == head) {
			tail = null;
		}
		head = head.next;
		return item;
	}

	/**
	 * Method to check the first item from the queue
	 * 
	 * @return {@link object}
	 */
	public Object peek() {
		if (head == null) {
			throw new NoSuchElementException("Cannot peek from empty Queue");
		}
		return head.item;
	}

	/**
	 * Method to check the size of the queue
	 * 
	 * @return {@link int}
	 */
	public int size() {
		int count = 0;
		for (Node node = head; node != null; node = node.next) {
			count++;
		}
		return count;
	}

	/**
	 * Method to check if queue is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Node class for LinkedList based queue
	 * 
	 * @author Deepak
	 */
	class Node {

		/**
		 * Item in the node
		 */
		private Object item;

		/**
		 * Pointer to next node
		 */
		private Node next;

		/**
		 * Constructor to create a new node
		 * 
		 * @param item
		 * @param next
		 */
		public Node(Object item, Node next) {
			this.item = item;
			this.next = next;
		}

	}

}
