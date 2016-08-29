/**
 * Data-Structures-And-Algorithms-in-Java
 * ArrayBasedQueue.java
 */
package com.deepak.data.structures.Queue;

import java.util.NoSuchElementException;

/**
 * Implementation of array based queue
 * @author Deepak
 */
public class ArrayBasedQueue {

	/**
	 * Method to test queue implementation
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Creating a new Array based queue.");
		ArrayBasedQueue queue = new ArrayBasedQueue(10);
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
	 * Array of objects
	 */
	private Object[] array;

	/**
	 * Size of queue
	 */
	int size = 0;

	/**
	 * Since it is a queue, we need track of both head and tail
	 * Initial values to be 0
	 */
	int head = 0;
	int tail = 0;

	/**
	 * Constructor to create new array based queue
	 * @param capacity
	 */
	public ArrayBasedQueue(int capacity) {
		array = new Object[capacity];
	}

	/**
	 * Method to push a new item in queue
	 * We will deal only with tail while adding new item
	 * @param item
	 */
	public void enqueue(Object item) {
		if (size == array.length) {
			throw new IllegalStateException("Cannot add to full queue");
		} 
		array[tail] = item;
		tail = (tail + 1) % array.length;
		size++;
	}

	/**
	 * Method to pop a item from queue
	 * We will deal only with head while deleting a element
	 * @return
	 */
	public Object dequeue() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot remove from empty queue");
		}
		Object item = array[head];
		array[head] = null;
		head = (head + 1) % array.length;
		size--;
		return item;
	}

	/**
	 * Method to check the top item in queue
	 * @return
	 */
	public Object peek() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot peek from empty queue");
		}
		return array[size - 1];
	}

	/**
	 * Method to check size of queue
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to check if queue is empty
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

}
