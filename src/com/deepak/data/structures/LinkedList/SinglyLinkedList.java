/**
 * Data-Structures-in-Java
 */
package com.deepak.data.structures.LinkedList;

/**
 * Implementation of Singly linked list 
 * 
 * <br> Operations supported are
 * - Inserting a element in the list - This can be at beginning, at end or at a given position. 
 * - Traversing through linked list.
 * - Check if list is empty.
 * - Check the size of the list.
 * - Search a element by index.
 * - Search a element by value.
 * - Delete a element from the list - This can again be at beginning, at end or at given position.
 * - Converting a list to and from a Array.
 * - Reverse a linked list using iteration and recursion.
 * - Print elements in forward and reverse order
 * </br>
 * 
 * @author Deepak
 *
 * @param <E>
 */
public class SinglyLinkedList<E> {

	/* First Node is needed to keep track of head */
	private Node<E> firstNode;

	/* Size to keep track of number of elements in list 
	 * This needs to be increased by 1 when a element is added
	 * and needs to be reduced by 1 when a element is deleted */
	private int size = 0;

	/**
	 * Inserts a element into a linked list at head position.
	 * This does not require to traverse through entire list.
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

	}

	/**
	 * Inserts a element into a linked list at tail position.
	 * This needs traversal through entire list before insertion happens.
	 * 
	 * <br> Complexity :
	 * Since, traversal through entire list is involved here before
	 * new node gets inserted, and let's assume list has n elements, 
	 * so insertion at tail will take O(n) time
	 * </br>
	 * 
	 * @param value
	 */
	public void insertAtTail(E value) {

	}

	/**
	 * Inserts a element into a linked list at a given position.
	 * This needs traversal through the linked list till the given position.
	 * 
	 * <br> Complexity :
	 * This insertion can possibly happen at last node, means in worst case 
	 * we may have to traverse entire linked list. On an average case with 
	 * linked list having n elements, this will take n/2 time and after ignoring
	 * the constant term, complexity comes out to be O(n)
	 * </br>
	 * 
	 * @param value
	 * @param position
	 */
	public void insertAtPosition(E value, int position) {

	}

	/**
	 * Node class of a linked list
	 * This is needed since entire linked list is a collection 
	 * of nodes connected to each other through links
	 * 
	 * <br> We are keeping it generic so that it can be used with 
	 * Integer, String or something else </br>
	 * 
	 * <br> Each node contains a data item and pointer to next node.
	 * Since this is a Singly linked list and each node points in 
	 * one direction, we maintain only pointer to one (next) node </br>
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

	}

}
