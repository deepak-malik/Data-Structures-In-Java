package com.deepak.data.structures.Hashing;

import java.util.Map;
import java.util.Objects;

public class CustomHashTable<K, V> {

	/**
	 * This is a node representation of Linked List
	 * @author Deepak
	 *
	 * @param <K>
	 * @param <V>
	 */
	static class Entry<K, V> {
		final int hash;
		final K key;
		V value;
		Entry<K, V> next;

		/**
		 * Constructor for creating a entry
		 * @param hash
		 * @param key
		 * @param value
		 * @param next
		 */
		public Entry(int hash, K key, V value, Entry<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		/**
		 * HashCode implementation for entry
		 */
		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}

		/**
		 * Method to check if two objects are equal
		 */
		public final boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if (o instanceof Map.Entry) {
				Map.Entry<?,?> e = (Map.Entry<?,?>)o;
				if (Objects.equals(key, e.getKey()) &&
						Objects.equals(value, e.getValue())) {
					return true;
				}
			}
			return false;
		}

	}

}
