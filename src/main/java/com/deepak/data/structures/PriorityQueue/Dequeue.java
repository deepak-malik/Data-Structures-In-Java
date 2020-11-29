/**
 * Data-Structures-In-Java
 * Dequeue.java
 */
package com.deepak.data.structures.PriorityQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Dequeue is an ADT structure and adaption of queue, such that
 * elements can be inserted and removed from both the ends of the queue
 * It is implemented using doubly LiknedList implementation.
 * It also implements iterable interface to provide iterator over the 
 * elements from from to end. 
 * 
 * It throws :
 * 1. Null pointer exception when null item is inserted 
 * 2. No such element exception when remove is performed on empty queue
 * 3. UnSupported operation exception when iterator's remove method is invoked
 * 
 * @author Deepak
 */
public class Dequeue<Item> implements Iterable<Item> {

	private Node first, last;

	/**
	 * constructs the object.
	 */
	public Dequeue() {
		first = null;
		last = null;
	}

	/**
	 * checks to see if deque is empty.
	 * @return <code>true</code> if no elements present, 
	 *         <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		return first == null && last == null;
	}

	/**
	 * returns the number of elements in the deque.
	 * @return the size as int.
	 */
	@SuppressWarnings("unused")
	public int size() {
		int count = 0;
		for (Item item : this) {
			count++;
		}
		return count;
	}

	/**
	 * adds an element at the front of the queue.
	 * @param item element to be inserted, should be not null.
	 */
	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException("null values cannot be inserted.");
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		first.prev = null;
		if (last == null) 
			last = first;
		else
			oldFirst.prev = first;
	}

	/**
	 * removes an item from the front of the deque.
	 * @return an item at the front of the deque.
	 */
	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("no element exists on deque.");

		Item item = first.item;
		if (first == last)
			first = last = null;
		else {
			first = first.next;
			first.prev = null;
		}
		return item;
	}

	/**
	 * adds an item at the end of the deque.
	 * @param item item to be added at the end of the deque.
	 */
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException("null values cannot be inserted.");

		if (isEmpty())
			addFirst(item);
		else {
			Node oldLast = last;
			last = new Node();
			last.item = item;
			last.next = null;
			last.prev = oldLast;
			oldLast.next = last;
		}
	}

	/**
	 * removes an item at the end of the deque.
	 * @return item from the end.
	 */
	public Item removeLast() {
		if (isEmpty())
			throw new NoSuchElementException("no element exists on deque.");
		Item item = last.item;
		if (first == last)
			first = last = null;
		else { 
			last = last.prev;
			last.next = null;
		}
		return item;
	}

	/**
	 * returns an iterator over the elements in the deque 
	 * from front to end fashion.
	 * 
	 */
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}

	/**
	 * private structure used to represent each item in this
	 * data structure.
	 * @author Deepak
	 *
	 */
	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	/**
	 * An iterator implementation for Dequeue data structure.
	 * 
	 * @author Deepak
	 */
	private class DequeIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if(!hasNext())
				throw new NoSuchElementException("No element exists on deque");
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException("Remove operation not supported");
		}
	}

}