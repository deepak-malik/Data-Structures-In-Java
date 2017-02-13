/**
 * Data-Structures-In-Java
 * MRUCache.java
 */
package com.deepak.data.structures.Cache;

import java.util.HashMap;

/**
 * Custom implementation of MRU cache
 * NOTE : Only the eviction differs in LRU and MRU
 * 
 * @author Deepak
 */
public class MRUCache<K, V> {

	/**
	 * HashMap for cache
	 */
	private HashMap<K, Node<K, V>> cache = new HashMap<>();

	/**
	 * Nodes for head and tail
	 */
	private Node<K, V> head, tail;

	/**
	 * Capacity of cache
	 */
	private int capacity;

	/**
	 * Default capacity of cache
	 */
	private static final int DEFAULT_CAPACITY = 100;

	/**
	 * Default Constructor
	 */
	public MRUCache() {
		setCapacity(DEFAULT_CAPACITY);
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param capacity
	 */
	public MRUCache(int capacity) {
		setCapacity(capacity);
	}

	/**
	 * Method to get the value associated 
	 * with key from cache
	 * 
	 * @param key
	 * @return {@link V}
	 */
	public V get(K key) {
		/* If cache does not contains key, return null */
		if (!cache.containsKey(key)) {
			return null;
		}
		/* If key exists, get the key and return the value */
		Node<K, V> node = cache.get(key);
		/* Since this node is least recently used now, move it to the end.
		 * When eviction will happen, this will be the last entry to be removed.
		 * Removal will happen at tail. */
		moveNodeToLast(node);
		return node.getValue();
	}

	/**
	 * Method to add the key value pair to cache
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		/* If cache contains the key, find that key value pair, 
		 * Since this is a map and only key is same. Value can be different.
		 * Replace this current value and push this node to end as we have
		 * accessed it already */
		if (cache.containsKey(key)) {
			Node<K, V> existing = cache.get(key);
			existing.setValue(value);
			moveNodeToLast(existing);
			return;
		}
		/* If cache has reached the capacity,
		 * evict the MRU node and remove it from cache */
		Node<K, V> newNode;
		if (cache.size() == capacity) {
			newNode = evict();
			cache.remove(newNode.getKey());
		} else {
			newNode = new Node<>();
		}
		/* Create this new node, set key and values.
		 * Add this node to appropriate place and put in cache */
		newNode.setKey(key);
		newNode.setValue(value);
		addNewNode(newNode);
		cache.put(key, newNode);
	}

	/**
	 * Method to set capacity for cache
	 * 
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		/* Check if capacity is valid */
		checkCapacity(capacity);
		/* Now, start from the end and begin evicting 
		 * until we meet the new capacity. Remove 
		 * entries from cache as well */
		for (int i = cache.size(); i > capacity; i--) {
			Node<K, V> evicted = evict();
			cache.remove(evicted.getKey());
		}
		this.capacity = capacity;
	}

	/**
	 * Method to check the size of cache
	 * 
	 * @return {@link int}
	 */
	public int size() {
		return cache.size();
	}

	/**
	 * Method to get the capacity of cache
	 * 
	 * @return {@link int}
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Method to add a new node
	 * 
	 * @param node
	 */
	private void addNewNode(Node<K, V> node) {
		/* If cache is empty, both head and tail
		 * points to same new node */
		if (cache.isEmpty()) {
			head = tail = node;
			return;
		}
		/* Else, append the new node to tail and 
		 * update the position of tail */
		tail.setNext(node);
		node.setPrevious(tail);
		node.setNext(null);
		tail = node;
	}

	/**
	 * Method to evict the entry from cache
	 * 
	 * @return {@link Node<K, V>}
	 */
	private Node<K, V> evict() {
		/* If cache is empty, nothing to evict */
		if (head == null) {
			throw new AssertionError("Cannot evict from an empty cache!!");
		}
		/* Evict the tail, update next and evicted node */
		Node<K, V> evicted = tail;
		tail = evicted.getPrevious();
		tail.setNext(null);
		evicted.setNext(null);
		return evicted;
	}

	/**
	 * Method to check capacity 
	 * 
	 * @param capacity
	 */
	private void checkCapacity(int capacity) {
		/* Invalid capacity if less then 0 */
		if (capacity <= 0) {
			throw new IllegalArgumentException("Invalid Capacity. Should be positive!!");
		}
	}

	/**
	 * Method to move node to last
	 * 
	 * @param node
	 */
	private void moveNodeToLast(Node<K, V> node) {
		/* If node is already at last, nothing to process */
		if (tail == node) {
			return;
		}
		/* Update previous and next nodes */
		Node<K, V> previous = node.getPrevious();
		Node<K, V> next = node.getNext();
		if (previous != null) {
			previous.setNext(next);
		}
		if (next != null) {
			next.setPrevious(previous);
		}
		/* Update head and tail position */
		if (head == node) {
			head = next;
		}
		tail.setNext(node);
		node.setPrevious(tail);
		node.setNext(null);
		tail = node;
	}

	/**
	 * Class Node for MRU cache
	 * 
	 * @author Deepak
	 *
	 * @param <T>
	 * @param <U>
	 */
	public static class Node<T, U> {

		/* Variables to store key, value and pointers to next and previous nodes */
		private Node<T, U> previous;
		private Node<T, U> next;
		private T key;
		private U value;

		/**
		 * Default Constructor
		 */
		public Node() {}

		/**
		 * Parameterized Constructor
		 * 
		 * @param previous
		 * @param next
		 * @param key
		 * @param value
		 */
		public Node(Node<T, U> previous, Node<T, U> next, T key, U value) {
			this.previous = previous;
			this.next = next;
			this.key = key;
			this.value = value;
		}

		public Node<T, U> getPrevious() {
			return previous;
		}
		public void setPrevious(Node<T, U> previous) {
			this.previous = previous;
		}

		public Node<T, U> getNext() {
			return next;
		}
		public void setNext(Node<T, U> next) {
			this.next = next;
		}

		public T getKey() {
			return key;
		}
		public void setKey(T key) {
			this.key = key;
		}

		public U getValue() {
			return value;
		}
		public void setValue(U value) {
			this.value = value;
		}

	}

}
