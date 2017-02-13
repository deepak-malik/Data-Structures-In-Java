/**
 * Data-Structures-In-Java
 * StandardIterator.java
 */
package com.deepak.data.structures.Iterators;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <br> Problem Statement :
 * 
 * Implement a Standard Iterator for a collection, which
 * can loop through elements and consists of all operations
 * supported by a iterator
 * 
 * </br>
 * 
 * @author Deepak
 */
public class StandardIterator<T> implements Iterator<T> {

	/* This iterator works on list */
	private List<T> values;
	/* Index to keep track of current access */
	private int index;

	/**
	 * Constructor
	 * 
	 * @param values
	 */
	public StandardIterator(List<T> values) {
		this.values = values;
		this.index = 0;
	}

	/**
	 * Constructor with Comparator
	 * 
	 * @param values
	 * @param comparator
	 */
	public StandardIterator(List<T> values, Comparator<T> comparator) {
		Collections.sort(values, comparator);
		this.values = values;
		this.index = 0;
	}

	/**
	 * Method to check of next element exists 
	 */
	@Override
	public boolean hasNext() {
		return values.size() != index;
	}

	/**
	 * Method to get the next element in collection
	 */
	@Override
	public T next() {
		if (hasNext()) {
			return values.get(index++);
		} else {
			throw new NoSuchElementException("No elements left in collection!!");
		}
	}

	/**
	 * Method to remove element from the collection
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove not supported!!");
	}

}
