/**
 * Data-Structures-And-Algorithms-in-Java
 * LinkedListBasedQueue.java
 */
package com.deepak.data.structures.Queue;

import java.util.NoSuchElementException;

/**
 * Linked List based implementation of queue
 * @author Deepak
 */
public class LinkedListBasedQueue {

	/**
	 * Method to test queue implementation
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Creating a new LinkedList based queue.");
		LinkedListBasedQueue queue = new LinkedListBasedQueue();
		System.out.println("Size of Queue => " + queue.size());
		System.out.println("Is Queue Empty => " + queue.isEmpty());
		System.out.println("Inserting two items in Queue.");
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println("After Insertion, Size of Queue => " + queue.size());
		System.out.println("After Insertion, Is Queue Empty => " + queue.isEmpty());
		System.out.println("Removing an item from Queue.");
		queue.dequeue();
		System.out.println("After Removal, Size of Queue => " + queue.size());
		System.out.println("Top element on Queue => " + queue.peek());
	}

	/**
	 * Since in queue, we have to keep track of both the ends
	 * We need access to both head and tail node
	 */
	private Node head = null;
	private Node tail = null;

	/**
	 * Method to insert a item in the queue
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
	 * @return
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
	 * @return
	 */
	public Object peek() {
		if (head == null) {
			throw new NoSuchElementException("Cannot peek from empty Queue");
		}
		return head.item;
	}

	/**
	 * Method to check the size of the queue
	 * @return
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
	 * @return
	 */
	public boolean isEmpty() {
		return head == null;
	}


	/**
	 * Node class for LinkedList based queue
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
		 * @param item
		 * @param next
		 */
		public Node(Object item, Node next) {
			this.item = item;
			this.next = next;
		}

	}

}
