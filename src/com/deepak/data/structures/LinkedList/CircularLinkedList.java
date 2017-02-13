/**
 * Data-Structures-In-Java
 * CircularLinkedList.java
 */
package com.deepak.data.structures.LinkedList;

/**
 * Implementation of Circular Linked List
 *
 * <br> Operations supported are :
 * 
 * 1. Inserting a element in the list - This can be at beginning, at end or at a given position.
 * 2. Traversing through linked list.
 * 3. Display a list.
 * 4. Delete an item at position.
 * 5. Delete an item at beginning.
 * 6. Search by index.
 * 7. Search by value.
 * 8. Get the size of the list.
 * 9. Check is list is empty.
 * 
 * </br>
 * 
 * @author Deepak
 */
public class CircularLinkedList<E> {

	/* Head is needed to keep track of first node */
	private Node<E> head;

	/* Size to keep track of number of elements in list. 
	 * This should be increased by 1 when a element is added
	 * and should be reduced by 1 when a element is deleted */
	private int size = 0;

	/**
	 * Inserts a element into a linked list at beginning.
	 * 
	 * @param value
	 */
	public void insertAtBeginning(E value) {
		Node<E> newNode = new Node<E>(value); 
		if (head == null) {
			head = newNode;
			head.next = head;
		} else {
			Node<E> temp = head;
			newNode.next = temp;
			head = newNode;
		}
		size++;
	}

	/**
	 * Inserts a element into a linked list at tail position.
	 * 
	 * @param value
	 */
	public void insertAtTail(E value) {
		Node<E> newNode = new Node<E>(value);
		if (null == head) { 
			/* When list is empty */
			head = newNode;
		} else {
			Node<E> temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		newNode.next = head;
		size++;
	}

	/**
	 * Inserts a element into a linked list at a given position.
	 * 
	 * @param value
	 * @param position
	 */
	public void insertAtPosition(E value, int position) {
		if (position < 0 || position > size) {
			throw new IllegalArgumentException("Position is Invalid");
		} 
		/* Conditions check passed, let's insert the node */
		Node<E> newNode = new Node<E>(value);
		Node<E> tempNode = head;
		Node<E> prevNode = null;
		for (int i = 0; i < position; i++) {
			if (tempNode.next == head) {
				break;
			}
			prevNode = tempNode;
			tempNode = tempNode.next;
		}
		prevNode.next = newNode;
		newNode.next = tempNode;
		size++;
	}

	/**
	 * Method to delete an element from the 
	 * beginning of the circular linked list
	 */
	public void deleteFromBeginning() {
		Node<E> temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = head.next;
		head = head.next;
		size--;
	}

	/**
	 * Method to delete an item from the circular
	 * linked list at a given position
	 * 
	 * @param position
	 */
	public void deleteFromPosition(int position) {
		if (position < 0 || position >= size) {
			throw new IllegalArgumentException("Position is Invalid");
		}
		Node<E> current = head, previous = head;
		for (int i = 0; i < position; i++) {
			if (current.next == head) {
				break;
			}
			previous = current;
			current = current.next;
		}
		if (position == 0) {
			deleteFromBeginning();
		} else {
			previous.next = current.next;
		}
		size--;
	}

	/**
	 * Method to find a node on a given index
	 * 
	 * @param index
	 * @return {@link Node<E>}
	 */
	public Node<E> searchByIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is Invalid");
		}
		Node<E> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * Method to find a node for a given value
	 * 
	 * @param index
	 * @return {@link Node<E>}
	 */
	public Node<E> searchByValue(E value) {
		Node<E> temp = head;
		while (null != temp && temp.item != value) {
			temp = temp.next;
		}
		if (temp.item == value) {
			return temp;
		}
		return null;
	}

	/**
	 * Method to check size of the circular linked list
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to check if circular linked list is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method to display the circular linked list
	 */
	public void display() {
		if (head == null) {
			System.out.println("List is Empty !!");
		} else {
			Node<E> temp = head;
			while (temp.next != head) {
				System.out.println("Data at Node = " + temp.item);
				temp = temp.next;
			}
			System.out.println("Data at Node = " + temp.item);
		}
		System.out.println();
	}


	/**
	 * Node class of a circular linked list
	 * This is needed since entire linked list is a collection 
	 * of nodes connected to each other through links
	 * 
	 * <br> We are keeping it generic so that it can be used with 
	 * Integer, String or something else </br>
	 * 
	 * <br> Each node contains a data item and pointer to next node.
	 * Since this is a Circular linked list and each node points in 
	 * one direction, we maintain only pointer to one (next) node. 
	 * Last node again points to the first node </br>
	 * 
	 * @author Deepak
	 *
	 * @param <T>
	 */
	public class Node<T> {

		/* Data item in the node */
		T item;

		/* Pointer to next node */
		Node<T> next;

		/* Constructor to create a node */
		public Node(T item) {
			this.item = item;
		}

		/* toString implementation to print just the data */
		@Override
		public String toString() {
			return "Data Item = " + item;
		}

	}

}
