/**
 * Data-Structures-In-Java
 * DoublyLinkedList.java
 */
package com.deepak.data.structures.LinkedList;

/**
 * Implementation of Doubly linked list 
 * 
 * <br> Operations supported are :
 * - Inserting a element in the list - This can be at beginning, at end or at a given position. 
 * - Traversing through linked list. - This can happen in any direction with doubly linked list
 * - Check the size of the list.
 * - Check if list is empty.
 * - Search an element by index.
 * - Search an element by value.
 * - Delete an element from the list - This can again be at beginning, at end or at given position.
 * - Converting a Array from linked list.
 * </br>
 * 
 * @author Deepak
 *
 * @param <E>
 */
public class DoublyLinkedList<E> {

	/* Head is needed to keep track of first node */
	private Node<E> head;

	/* Tail is needed to keep track of last node */
	private Node<E> tail;

	/* Size to keep track of number of elements in list. 
	 * This should be increased by 1 when a element is added
	 * and should be reduced by 1 when a element is deleted */
	private int size = 0;

	/**
	 * Inserts a element into a linked list at head position.
	 * This does not require traversal through entire list.
	 * 
	 * <br> Complexity :
	 * Since there is no traversal involved here, and insertion
	 * always happens at the head, this can be done in constant 
	 * time. Hence, complexity comes out to be O(1) 
	 * </br>
	 * 
	 * @param value
	 */
	public void insertAtHead(E value) {
		Node<E> newNode = new Node<E>(value);
		if (null == head) { 
			/* If list is empty */
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
			tail = newNode;
			size++;
		} else {
			newNode.next = head;
			newNode.prev = null;
			head.prev = newNode;
			head = newNode;
			size++;
		}
	}

	/**
	 * Inserts a element into a linked list at tail position.
	 * This does not needs traversal through entire list before insertion happens.
	 * 
	 * <br> Complexity :
	 * Since, traversal through entire list is NOT involved here before
	 * new node gets inserted, and let's assume list has n elements, 
	 * so insertion at tail will take O(1) time
	 * </br>
	 * 
	 * @param value
	 */
	public void insertAtTail(E value) {
		Node<E> newNode = new Node<E>(value);
		if (null == tail) { 
			/* If list is empty */
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
			tail = newNode;
			size++;
		} else {
			tail.next = newNode;
			newNode.next = null;
			newNode.prev = tail;
			tail = newNode;
			size++;
		}
	}

	/**
	 * Inserts a element into a linked list at a given position.
	 * This needs traversal through the linked list till the given position.
	 * 
	 * <br> Complexity :
	 * This insertion can possibly happen at last node, means we will have complexity
	 * as O(1) as explained above. 
	 * we may have to traverse entire linked list. On an average case with 
	 * linked list having n elements, this will take n/2 time and after ignoring
	 * the constant term, complexity comes out to be O(n)
	 * </br>
	 * 
	 * @param value
	 * @param position
	 */
	public void insertAtPosition(E value, int position) {
		if (position < 0 || position > size) {
			throw new IllegalArgumentException("Position is Invalid");
		} 
		/* Conditions check passed, let's insert the node */
		if (position == 0) { 
			/* Insertion should happen at head */
			insertAtHead(value);
		} else if (position == size -1) { 
			/* Insertion should happen at tail */
			insertAtTail(value);
		} else { 
			/* Insertion is happening somewhere in middle */
			Node<E> currentNode = head;
			for (int i = 0; i < position; i++) {
				currentNode = currentNode.next;
			}
			Node<E> previousNode = currentNode.prev;
			/* Insertion of new node will happen in 
			 * between previous node and current node */
			Node<E> newNode = new Node<E>(value);
			newNode.next = currentNode;
			newNode.prev = previousNode;
			previousNode.next = newNode;
			currentNode.prev = newNode;
			size++;
		}
	}

	/**
	 * Traverse the linked list in forward direction and print the items
	 */
	public void traverseForward() {
		Node<E> temp = head;
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.next;
		}
	}

	/**
	 * Traverse the linked list in backward direction and print the items
	 */
	public void traverseBackward() {
		Node<E> temp = tail;
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.prev;
		}
	}

	/**
	 * Returns the size of the linked list
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true, if linked list is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the Node containing data item after searching
	 * for a given index. If invalid index is passed, proper
	 * exception is thrown. 
	 *  
	 * @param index
	 * @return {@link Node<E>}
	 */
	public Node<E> searchByIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index passed while searching for a value");
		} 
		/* Validation passed, let's search for value using the index */
		Node<E> temp = head;
		for (int i = 0; i < index; i++) { 
			/* Start from 0 and go till one less then index 
			 * because we are jumping to next node inside the loop */
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * Returns the node containing data item after searching 
	 * for a given value. If there are multiple same values
	 * in linked list, first one will be returned.
	 * 
	 * @param value
	 * @return {@link Node<E>}
	 */
	public Node<E> searchByValue(E value) { 
		/* Traverse through each node until this value is found */
		Node<E> temp = head;
		while (null != temp.next && temp.item != value) {
			temp = temp.next;
		}
		if (temp.item == value) {
			return temp;
		}
		return null;
	}

	/**
	 * Delete's the element present at head node
	 */
	public void deleteFromHead() {
		/* If list is empty, return */
		if (null == head) { 
			return;
		}
		Node<E> temp = head;
		head = temp.next;
		head.prev = null;
		size--;
	}

	/**
	 * Delete's the element present at tail node
	 */
	public void deleteFromTail() {
		/* If list is empty, return */
		if (null == tail) { 
			return;
		}
		Node<E> temp = tail;
		tail = temp.prev;
		tail.next = null;
		size--;
	}

	/**
	 * Delete's the element present at given position
	 * 
	 * @param position
	 */
	public void deleteFromPosition(int position) {
		if (position < 0 || position >= size) {
			throw new IllegalArgumentException("Position is Invalid");
		} 
		/* Conditions check passed, let's delete the node */
		Node<E> nodeToBeDeleted = head;
		for (int i = 0; i < position; i++) {
			nodeToBeDeleted = nodeToBeDeleted.next;
		}
		Node<E> previousNode = nodeToBeDeleted.prev;
		Node<E> nextNode = nodeToBeDeleted.next;
		previousNode.next = nextNode;
		nextNode.prev = previousNode;
		size--;
	}

	/**
	 * Returns a array containing each element 
	 * from the list from start to end
	 * 
	 * @return
	 */
	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Node<E> x = head; x != null; x = x.next) {
			result[i++] = x.item;
		}
		return result;
	}

	/**
	 * Node class of a linked list
	 * This is needed since entire linked list is a collection 
	 * of nodes connected to each other through links
	 * 
	 * <br> We are keeping it generic so that it can be used with 
	 * Integer, String or something else </br>
	 * 
	 * <br> Each node contains a data item, a pointer to next node
	 * and pointer to previous node. 
	 * Since this is a Doubly linked list and each node points in 
	 * both directions i.e forward and backward. 
	 * We maintain two pointers, one to next node and one to previous node </br>
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

		/* Pointer to previous node */
		Node<T> prev;

		/* Constructor to create a node */
		public Node(T item) {
			this.item = item;
		}

		/* toString implementation to print just the data */
		@Override
		public String toString() {
			return String.valueOf(item);
		}

	}

}
