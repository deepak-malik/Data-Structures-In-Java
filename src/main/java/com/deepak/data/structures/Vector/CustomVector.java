/**
 * Data-Structures-In-Java
 * CustomVector.java
 */
package com.deepak.data.structures.Vector;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * Implementation of Vector
 * 
 * @author Deepak
 */
public class CustomVector<T> {

	/* Array to hold elements */
	private Object[] elements;

	/* Size of vector */
	private int size;

	/* Variable for capacity increment when array gets full */
	private int capacityIncrement;

	/* Default capacity */
	private final static int DEFAULT_CAPACITY = 10;

	/**
	 * Constructor
	 */
	public CustomVector() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructor
	 * 
	 * @param capacity
	 */
	public CustomVector(int capacity) {
		this(capacity, 0);
	}

	/**
	 * Constructor
	 * 
	 * @param capacity
	 * @param capacityIncrement
	 */
	public CustomVector(int capacity, int capacityIncrement) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		} 
		this.elements = new Object[capacity];
		this.capacityIncrement = capacityIncrement;
	}

	/**
	 * Method to return current capacity of vector
	 * 
	 * @return {@link int}
	 */
	public synchronized int capacity() {
		return elements.length;
	}

	/**
	 * Method to return current size of vector
	 * 
	 * @return {@link int}
	 */
	public synchronized int size() {
		return size;
	}

	/**
	 * Method to check if vector is empty
	 * 
	 * @return {@link int}
	 */
	public synchronized boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Method to return enumeration of elements
	 * 
	 * @return {@link Enumeration}
	 */
	public Enumeration<T> elements() {
		return new Enumeration<T>() {
			int count = 0;

			public boolean hasMoreElements() {
				return count < size;
			}

			public T nextElement() {
				synchronized (CustomVector.this) {
					if (count < size) {
						return elementData(count++);
					}
				}
				throw new NoSuchElementException("Vector Enumeration");
			}
		};
	}

	/**
	 * Method to check if vector contains the object
	 * 
	 * @param o
	 * @return {@link boolean}
	 */
	public synchronized boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	/**
	 * Method to check the index of a given object
	 * 
	 * @param o
	 * @return {@link int}
	 */
	public synchronized int indexOf(Object o) {
		return indexOf(o, 0);
	}

	/**
	 * Method to find the index of a given object
	 * 
	 * @param o
	 * @param index
	 * @return {@link int}
	 */
	private synchronized int indexOf(Object o, int index) {
		/* If object is null, return the first index of null value */
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Method to find element at given index
	 * 
	 * @param index
	 * @return {@link T}
	 */
	public synchronized T elementAt(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException(index + " >= " + size);
		}
		return elementData(index);
	}

	/**
	 * Method to find the first element
	 * 
	 * @return {@link T} 
	 */
	public synchronized T firstElement() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return elementData(0);
	}

	/**
	 * Method to find the last element
	 * 
	 * @return {@link T}
	 */
	public synchronized T lastElement() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return elementData(size - 1);
	}

	/**
	 * Method to set the element at a given index
	 * 
	 * @param object
	 * @param index
	 */
	public synchronized void setElementAt(T object, int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException(index + " >= " + size);
		}
		elements[index] = object;
	}

	/**
	 * Method to remove the element at a given index
	 * 
	 * @param index
	 */
	public synchronized void removeElementAt(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException(index + " >= " + size);
		} else if (index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		int j = size - index - 1;
		if (j > 0) {
			System.arraycopy(elements, index + 1, elements, index, j);
		}
		size--;
		elements[size] = null;
	}

	/**
	 * Method to insert element at a given index 
	 * 
	 * @param element
	 * @param index
	 */
	public synchronized void insertElementAt(T element, int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException(index + " >= " +
					size);
		}
		ensureCapacity(size + 1);
		System.arraycopy(elements, index, elements, index + 1, size - index);
		elements[index] = element;
		size++;
	}

	/**
	 * Method to add element to vector
	 * 
	 * @param element
	 */
	public synchronized void addElement(T element) {
		ensureCapacity(size + 1);
		elements[size++] = element;
	}

	/**
	 * Method to get a element at given index 
	 * 
	 * @param index
	 * @return {@link T}
	 */
	public synchronized T get(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return elementData(index);
	}

	/**
	 * Method to ensure capacity
	 * 
	 * @param newSize
	 */
	private void ensureCapacity(int newSize) {
		if (newSize >= capacity()) {
			/* If capacity increment is given, use that else double the size */
			if (capacityIncrement > 0) {
				elements = Arrays.copyOf(elements, capacity() + capacityIncrement);
			} else {
				elements = Arrays.copyOf(elements, size * 2);
			}
		}
	}

	/**
	 * Method to return a type casted value at given index
	 * 
	 * @param index
	 * @return {@link T}
	 */
	@SuppressWarnings("unchecked")
	T elementData(int index) {
		return (T) elements[index];
	}

}
