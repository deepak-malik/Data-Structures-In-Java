/**
 * Data-Structures-In-Java
 * CustomBagLL.java
 */
package com.deepak.data.structures.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Custom bag implementation using a Linked List
 * 
 * @author Deepak
 *
 * @param <T>
 */
public class CustomBagLL<T> {

	public static void main(String[] args) {
		CustomBagLL<String> bag = new CustomBagLL<>();
		System.out.println(bag.isEmpty());
		bag.add("A");
		bag.add("C");
		bag.add("B");
		bag.add("B");
		bag.add("A");
		bag.add("B");
		System.out.println(bag.toString());
		bag.remove("C");
		System.out.println(bag.toString());
		bag.remove("A");
		System.out.println(bag.toString());
		System.out.println("Bag contains C : " + bag.contains("C"));
		System.out.println("Bag contains B : " + bag.contains("B"));
		System.out.println("Bag Size : " + bag.size());
		System.out.println("Bag Distinct Size : " + bag.distinctSize());
		System.out.println("Grab : " + bag.grab());
		Iterator<String> itr = bag.iterator();
		/* Starting to print from iterator */
		System.out.println();
		System.out.println("Printing from iterator : ");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	/* Head node */
	private Node<T> head;

	/**
	 * Constructor
	 */
	public CustomBagLL() {
		this.head = null;
	}

	/**
	 * Method to add a item 
	 * 
	 * @param item
	 */
	public void add(T item) {
		/* If bag is empty, make new item as head */
		if (isEmpty()) {
			Node<T> newNode = new Node<T>(item);
			head = newNode;
		} else {
			/* Have two pointers current and last */
			Node<T> current = head;
			Node<T> last = head;
			boolean found = false;
			while (current != null) {
				/* If that item is found, just increase the value */
				if (current.item == item) {
					current.incrementValue();
					found = true;
					break;
				}
				last = current;
				current = current.next;
			}
			/* If not found, create as a new node and push to last */
			if (!found) {
				Node<T> newNode = new Node<T>(item);
				last.next = newNode;
			}
		}
	}

	/**
	 * Method to remove a item
	 * 
	 * @param item
	 * @return {@link boolean}
	 */
	public boolean remove(T item) {
		/* If bag contains the item */
		if (contains(item)) {
			/* Have two pointers current and prev */
			Node<T> current = head;
			Node<T> prev = head;
			/* Keep going while current is not null */
			while (current != null) {
				if (current.item == item) {
					/* If item matches, check if it is a head or not */
					if (current == head) {
						/* If it's head, decrement the value and update head */
						current.decrementValue();
						if (current.value < 1) {
							head = head.next;
						}
						return true;
					} else {
						/* Decrement the value, check if this was the last
						 * entry of that type, it yes, delete the item */
						current.decrementValue();
						if (current.value < 1) {
							prev.next = current.next;
							current.next = null;
						}
						return true;
					}
				}
				/* Move to next set of items */
				prev = current;
				current = current.next;
			}
		}
		return false;
	}

	/**
	 * Method to clear the bag
	 */
	public void clear() {
		this.head = null;
	}

	/**
	 * Method to check if bag contains the item 
	 * 
	 * @param item
	 * @return {@link boolean}
	 */
	public boolean contains(T item) {
		Node<T> current = head;
		/* Start traversing and stop if item matches */
		while (current != null) {
			if (current.item == item) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/**
	 * Method to grab any random element
	 * 
	 * @return {@link T}
	 */
	public T grab() {
		/* Have a random index */
		Random random = new Random();
		int randomItemIndex = random.nextInt(distinctSize());
		Node<T> current = head;
		/* Move the pointer till we reach that random index */
		for (int i = 0; i < randomItemIndex; i++) {
			current = current.next;
		}
		return current.item;
	}

	/**
	 * Method to check size of the bag
	 * 
	 * @return {@link int}
	 */
	public int size() {
		Node<T> current = head;
		int size = 0;
		/* Keep traversing and track size of each entry */
		while (current != null) {
			size += current.value;
			current = current.next;
		}
		return size;
	}

	/**
	 * Method to get distinct size of the bag
	 * 
	 * @return {@link int}
	 */
	public int distinctSize() {
		Node<T> current = head;
		int counter = 0;
		/* Increment the counter only when a new element is seen */
		while (current != null) {
			counter++;
			current = current.next;
		}
		return counter;
	}

	/**
	 * Method to check if bag is empty
	 * 
	 * @return {@link boolean}
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 * Method to print the content of bag as string
	 */
	public String toString() {
		if (isEmpty()) {
			return "Bag is Empty";
		} else {
			/* Keep appending the elements to string */
			Node<T> current = head;
			String str = "Bag = ";
			while (current != null) {
				for (int i = 0; i < current.value; i++) {
					str += "{" + current.item + "}";
				}
				current = current.next;
			}
			return str;
		}
	}

	/**
	 * Method to get a iterator on bag
	 * 
	 * @return {@link Iterator<T>}
	 */
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			/* Keep a track of next item and value count for each item */
			private Node<T> nextItem = head;
			private int valueCount = 0;

			/**
			 * Method to check if bag has elements
			 */
			@Override
			public boolean hasNext() {
				/* If next item is head and it's not null, 
				 * we have more elements */
				if (nextItem == head && nextItem != null) {
					return true;
				} else if (nextItem != head && nextItem.next != null){
					return true;
				} else if (nextItem.value > valueCount + 1) {
					return true;
				}
				return false;
			}

			/**
			 * Method to get the next element
			 */
			@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException("No Element left in collection");
				}
				if (nextItem.value > valueCount) {
					/* We still have items of same type left */
					valueCount++;
				} else {
					/* Time to move to next item */
					nextItem = nextItem.next;
					valueCount = 0;
				}
				Node<T> itemToReturn = nextItem;
				if (itemToReturn != null) {
					return itemToReturn.item;
				} else {
					return null;
				}
			}

		};
	}

	/**
	 * Class Node for Bag
	 * 
	 * @author Deepak
	 *
	 * @param <E>
	 */
	public class Node<E> {

		/* Item, counter associated with item and next pointer */
		private E item;
		private int value;
		private Node<E> next;

		/**
		 * Constructor to create the Node
		 * 
		 * @param item
		 */
		public Node(E item) {
			this.item = item;
			this.value = 1;
			this.next = null;
		}

		/**
		 * Method to increment the value
		 */
		public void incrementValue() {
			value++;
		}

		/**
		 * Method to decrement the value
		 */
		public void decrementValue() {
			value--;
		}

		@Override
		public String toString() {
			return "Item : [" + this.item + "]";
		}

	}

}