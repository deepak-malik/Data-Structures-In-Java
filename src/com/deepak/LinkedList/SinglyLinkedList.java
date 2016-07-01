package com.deepak.LinkedList;

public class SinglyLinkedList<E> {
	
	private Node<E> firstNode;
	private int size = 0;
	
	/**
	 * Main method to start the program and do some operations
	 * <p> Steps :
	 * 1. Create a new blank linked list of type of your choice (We will create integer)
	 * 2. Insert some elements in it. ex. 3, 6, 8, 2, and 7
	 * 3. Print the linked list </p>
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a linked list and insert elements in it
		SinglyLinkedList<Integer> iLinkedList = new SinglyLinkedList<>();
		iLinkedList.insert(3);
		iLinkedList.insert(6);
		iLinkedList.insert(8);
		iLinkedList.insert(2);
		iLinkedList.insert(7);
		
		// Print all the elements in the list
		System.out.println("Printing Elements in the list => ");
		System.out.println(iLinkedList.list());
		
		// Search element by index
		System.out.println("Searching Element at index => ");
		SinglyLinkedList<Integer>.Node<Integer> node = iLinkedList.searchByIndex(2);
		System.out.println(node.element);
		
		// Search by value
		System.out.println("\n");
		iLinkedList.searchByValue(8);
		
		// Delete the value from linked list and print size
		System.out.println("Size of Linked list => " + iLinkedList.size);
		iLinkedList.delete(null);
		System.out.println("Size of Linked list => " + iLinkedList.size);
	}
	
	/**
	 * Method to insert values in linked list
	 * @param iValue
	 */
	public void insert(E iValue) {
		if (null == firstNode) {
			firstNode = new Node<E>(iValue);
			size++;
		} else {
			Node<E> tempNode = firstNode;
			while (null != tempNode.nextNode) {
				tempNode = tempNode.nextNode;
			}
			Node<E> newNode = new Node<E>(iValue);
			newNode.nextNode = null;
			tempNode.nextNode = newNode;
			size++;
		}
	}
	
	/**
	 * Method to print the elements of linked list
	 * @return {@link String}
	 */
	public String list() {
		StringBuilder builder = new StringBuilder();
		Node<E> tempNode = firstNode;
		while (null != tempNode) {
			builder.append(tempNode.element).append("\n");
			tempNode = tempNode.nextNode;
		}
		return builder.toString();
	};
	
	/**
	 * Method to search an element by index
	 * @param index
	 * @return
	 */
	public Node<E> searchByIndex(int index) {
		if (index > size) {
			return null;
		}
		Node<E> tempNode = firstNode;
		for (int i = 0; i < index; i++) {
			tempNode = tempNode.nextNode;
		}
		return tempNode;
	}
	
	/**
	 * Method to find the index based on the value
	 * @param value
	 * @return
	 */
	public Node<E> searchByValue(E value) {
		Node<E> tempNode = firstNode;
		if (null == tempNode) {
			return null;
		}
		while (null != tempNode && tempNode.element != value) {
			tempNode = tempNode.nextNode;
		}
		return tempNode;
	}
	
	/**
	 * Method to return size of the linked list
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Method to delete the value from the linked list
	 * @param value
	 */
	public void delete(E value) {
		if (null == firstNode || null == value) {
			return;
		}
		if (firstNode.element == value) {
			firstNode = firstNode.nextNode;
			size--;
		} else {
			Node<E> currentNode = firstNode;
			Node<E> nextNode = currentNode.nextNode;
			while (null != currentNode) {
				if (currentNode.element == value) {
					currentNode = nextNode;
					size--;
					return;
				} else {
					currentNode = nextNode;
					nextNode = currentNode.nextNode;
				}
			}
		}
	}

	/**
	 * Node Class
	 * @author Deepak
	 *
	 * @param <T>
	 */
	public class Node<T> {

		T element;
		Node<T> nextNode;

		public Node(T iElement) {
			this.element = iElement;
		}

	}
}
