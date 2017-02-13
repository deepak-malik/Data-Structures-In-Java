/**
 * Data-Structures-In-Java
 * HoppingIterator.java
 */
package com.deepak.data.structures.Iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <br> Problem Statement :
 * 
 * Implement an iterator that hops specified number of times and then returns the next
 * element after the hop. Note: the iterator always returns the first element as
 * it is, and starts hopping only after the first element.
 *
 * Examples:
 *
 * If the original iterator returns: [1, 2, 3, 4, 5] in order, then the hopping
 * iterator will return [1, 3, 5] in order when the hop value is 1.
 *
 * If the original iterator returns: [1, 2, 3, 4, 5] in order, then the hopping
 * iterator will return [1, 4] in order when the hop value is 2.
 *
 * If the original iterator returns: [1, 2, 3, 4, 5] in order, then the hopping
 * iterator will return [1, 5] in order when the hop value is 3.
 * 
 * </br>
 * 
 * @author Deepak
 */
public class HoppingIterator<T> implements Iterator<T> {

	/* Iterator */
	private final Iterator<T> iterator;
	/* Variable to keep track of next item */
	private T nextItem;
	/* Number of hops needed */
	private final int numOfHops;
	/* Flag to check if it is first element */
	private boolean first;

	/**
	 * Constructor 
	 * 
	 * @param iterator
	 * @param numOfHops
	 */
	public HoppingIterator(Iterator<T> iterator, int numOfHops) {
		if (numOfHops < 0) {
			throw new IllegalArgumentException("Invalid value for number of hops!!");
		}
		this.iterator = iterator;
		this.numOfHops = numOfHops;
		nextItem = null;
		first = true;
	}

	/**
	 * Method to check of next element exists
	 */
	@Override
	public boolean hasNext() {
		/* If we already have next item, return true */
		if (nextItem != null) {
			return true;
		}
		/* If it is not first element, move till the next hop */
		if (!first) {
			for (int hop = 0; hop < numOfHops && iterator.hasNext(); hop++) {
				iterator.next();
			}
		}
		/* Now, if next element exits. move there and update first flag */
		if (iterator.hasNext()) {
			nextItem = iterator.next();
			first = false;
		}
		return nextItem != null;
	}

	/**
	 * Method to find next element in collection
	 */
	@Override
	public T next() {
		/* If no next element exits, collection has finished */
		if (!hasNext()) {
			throw new NoSuchElementException("No Element left in collection!!");
		}
		/* Else, find the next item, return it and set next item to null */
		T itemToReturn = nextItem;
		nextItem = null;
		return itemToReturn;
	}

	/**
	 * Method to remove the element
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove not supported!!");
	}

}
