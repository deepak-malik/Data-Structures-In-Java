/**
 * Data-Structures-In-Java
 * CircularLinkedListTest.java
 */
package com.deepak.data.structures.LinkedList;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test cases for circular linked list
 * 
 * @author Deepak
 */
public class CircularLinkedListTest {

	/**
	 * Test case for insertion at head of linked list
	 */
	@Test
	public void testInsertionAtHead() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtBeginning(4);
		Assert.assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		list.insertAtBeginning(5);
		Assert.assertEquals("5", String.valueOf(list.searchByIndex(0).item));
		list.insertAtBeginning(9);
		Assert.assertEquals("9", String.valueOf(list.searchByIndex(0).item));
		list.insertAtBeginning(13);
		Assert.assertEquals("13", String.valueOf(list.searchByIndex(0).item));
	}

	/**
	 * Test case for insertion at tail of linked list
	 */
	@Test
	public void testInsertionAtTail() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		Assert.assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		list.insertAtTail(5);
		Assert.assertEquals("5", String.valueOf(list.searchByIndex(1).item));
		list.insertAtTail(9);
		Assert.assertEquals("9", String.valueOf(list.searchByIndex(2).item));
		list.insertAtTail(13);
		Assert.assertEquals("13", String.valueOf(list.searchByIndex(3).item));
	}

	/**
	 * Test case for insertion at middle of linked list
	 */
	@Test
	public void testInsertionAtMiddle() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		Assert.assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		list.insertAtTail(5);
		Assert.assertEquals("5", String.valueOf(list.searchByIndex(1).item));
		list.insertAtTail(9);
		Assert.assertEquals("9", String.valueOf(list.searchByIndex(2).item));
		list.insertAtPosition(13, 1);
		Assert.assertEquals("13", String.valueOf(list.searchByIndex(1).item));
		Assert.assertEquals("5", String.valueOf(list.searchByIndex(2).item));
		Assert.assertEquals("9", String.valueOf(list.searchByIndex(3).item));
	}

	/**
	 * Test case for checking the size of linked list
	 */
	@Test
	public void testSize() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		Assert.assertTrue(list.size() == 0);
		list.insertAtBeginning(3);
		Assert.assertTrue(list.size() != 0);
		Assert.assertTrue(list.size() == 1);
		list.insertAtTail(4);
		Assert.assertTrue(list.size() != 0);
		Assert.assertTrue(list.size() == 2);
	}

	/**
	 * Test case for checking if liked list is empty
	 */
	@Test
	public void testIsEmpty() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		Assert.assertTrue(list.isEmpty());
		list.insertAtBeginning(3);
		Assert.assertFalse(list.isEmpty());
	}

	/**
	 * Test case for searching a element by index
	 */
	@Test
	public void testSearchByIndex() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		list.insertAtTail(7);
		list.insertAtTail(13);
		list.insertAtTail(19);
		list.insertAtTail(21);
		Assert.assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		Assert.assertEquals("7", String.valueOf(list.searchByIndex(1).item));
		Assert.assertEquals("13", String.valueOf(list.searchByIndex(2).item));
		Assert.assertEquals("19", String.valueOf(list.searchByIndex(3).item));
		Assert.assertEquals("21", String.valueOf(list.searchByIndex(4).item));
	}

	/**
	 * Test case for searching a element by value
	 */
	@Test
	public void testSearchByValue() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtBeginning(4);
		list.insertAtBeginning(7);
		list.insertAtBeginning(13);
		list.insertAtBeginning(19);
		list.insertAtBeginning(21);
		Assert.assertEquals("4", String.valueOf(list.searchByValue(4).item));
		Assert.assertEquals("7", String.valueOf(list.searchByValue(7).item));
		Assert.assertEquals("13", String.valueOf(list.searchByValue(13).item));
		Assert.assertEquals("19", String.valueOf(list.searchByValue(19).item));
		Assert.assertEquals("21", String.valueOf(list.searchByValue(21).item));
	}

	/**
	 * Test case to delete element from head
	 */
	@Test
	@Ignore
	public void testDeleteFromHead() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtBeginning(4);
		list.insertAtBeginning(7);
		list.insertAtBeginning(13);
		list.insertAtBeginning(19);
		list.insertAtBeginning(21);
		Assert.assertEquals("21", String.valueOf(list.searchByIndex(0).item));
		list.deleteFromBeginning();
		Assert.assertEquals("7", String.valueOf(list.searchByIndex(0).item));
		list.deleteFromBeginning();
		Assert.assertEquals("13", String.valueOf(list.searchByIndex(0).item));
		Assert.assertTrue(list.size() == 3);
	}

	/**
	 * Test case to delete element from tail
	 */
	public void testDeleteFromTail() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		list.insertAtTail(7);
		list.insertAtTail(13);
		list.insertAtTail(19);
		list.insertAtTail(21);
		Assert.assertEquals("21", String.valueOf(list.searchByIndex(4).item));
		Assert.assertTrue(list.size() == 5);
		list.deleteFromBeginning();
		Assert.assertEquals("21", String.valueOf(list.searchByIndex(3).item));
		Assert.assertTrue(list.size() == 4);
	}

	/**
	 * Test case to delete element from middle
	 */
	public void testDeleteFromMiddle() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		list.insertAtTail(7);
		list.insertAtTail(13);
		list.insertAtTail(19);
		list.insertAtTail(21);
		Assert.assertEquals("13", String.valueOf(list.searchByIndex(2).item));
		list.deleteFromPosition(2);
		Assert.assertEquals("19", String.valueOf(list.searchByIndex(2).item));
		list.deleteFromPosition(2);
		Assert.assertEquals("21", String.valueOf(list.searchByIndex(2).item));
	}

}
