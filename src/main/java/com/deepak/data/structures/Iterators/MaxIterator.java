/**
 * Data-Structures-In-Java
 * MaxIterator.java
 */
package com.deepak.data.structures.Iterators;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <br> Problem Statement :
 * 
 * Implement a max iterator i.e. it always returns the next item in the list
 * bigger than the last item returned.
 * 
 * </br>
 * 
 * @author Deepak
 */
public class MaxIterator<T> implements Iterator<T> {

	/* Iterator and Comparator */
	private final Iterator<T> iterator;
	private final Comparator<T> comparator;
	/* Variables to store last item and next item */
	private T lastItem;
	private T nextItem;

	/**
	 * Constructor
	 * 
	 * @param iterator
	 * @param comparator
	 */
	public MaxIterator(Iterator<T> iterator, Comparator<T> comparator) {
		this.iterator = iterator;
		this.comparator = comparator;
	}

	/**
	 * Method to check if next element exists
	 */
	@Override
	public boolean hasNext() {
		/* If next item is not null, return true */
		if (nextItem != null) {
			return true;
		}
		/* Else go through the collection and find the next bigger element */
		while (nextItem == null && iterator.hasNext()) {
			T item = iterator.next();
			if (lastItem == null || comparator.compare(item, lastItem) > 0) {
				nextItem = item;
			}
		}
		/* Return true if exists */
		return nextItem != null;
	}

	/**
	 * Method to find next element
	 */
	@Override
	public T next() {
		/* If next element doesn't exists, throw exception */
		if (!hasNext()) {
			throw new NoSuchElementException("No element found in collection!!");
		}
		/* Else update the last item found */
		lastItem = nextItem;
		nextItem = null;
		return lastItem;
	}

	/**
	 * Method to remove the element
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove not supported!!");
	}

}
