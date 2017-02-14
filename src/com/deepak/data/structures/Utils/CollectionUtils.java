/**
 * Data-Structures-In-Java
 * CollectionUtils.java
 */
package com.deepak.data.structures.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Utilities for collections i.e List
 * 
 * @author Deepak
 */
public class CollectionUtils {

	/**
	 * Method to check if list is empty
	 * 
	 * @param list
	 * @return {@link boolean}
	 */
	public static <T> boolean isEmpty(List<T> list) {
		return list == null || list.size() == 0;
	}

	/**
	 * Method to sort the list with no comparator
	 * 
	 * @param list
	 * @return {@link List<T>}
	 */
	public static <T> List<T> sort(List<T> list) {
		list.sort(null);
		return list;
	}

	/**
	 * Method to sort the list with custom comparator
	 * 
	 * @param list
	 * @param comparator
	 * @return {@link List<T>}
	 */
	public static <T> List<T> sort(List<T> list, Comparator<T> comparator) {
		list.sort(comparator);
		return list;
	}

	/**
	 * Method to perform a binary search
	 * 
	 * @param list
	 * @param element
	 * @param comparator
	 * @return {@link T}
	 */
	public static <T> T binarySearch(List<T> list, T element, Comparator<T> comparator) {
		if (list.isEmpty()) {
			return null;
		}
		int low = 0;
		int high = list.size() - 1;
		while (high > low) {
			int mid = (low + high) / 2;
			if (list.get(mid) == element) {
				return element;
			} else if (comparator.compare(list.get(mid), element) > 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return null;
	}

	/**
	 * Method to reverse the list
	 * 
	 * @param list
	 * @return {@link List<T>}
	 */
	public static <T> List<T> reverse(List<T> list) {
		if (list != null && list.size() > 0) {
			List<T> updatedList = new ArrayList<>();
			for (int i = list.size() - 1; i >= 0; i--) {
				updatedList.add(list.get(i));
			}
			return updatedList;
		}
		return null;
	}

	/**
	 * Method to shuffle the list
	 * 
	 * @param list
	 * @return {@link List<T>}
	 */
	public static <T> List<T> shuffle(List<T> list) {
		if (list != null && list.size() > 0) {
			List<T> updatedList = new ArrayList<>();
			final int[] ints = new Random().ints(0, list.size()).distinct().limit(list.size()).toArray();
			for (int i = 0; i < ints.length; i++) {
				updatedList.add(list.get(i));
			}
			return updatedList;
		}
		return null;
	}

	/**
	 * Method to swap elements at two indexes
	 * 
	 * @param list
	 * @param minIndex
	 * @param maxIndex
	 * @return {@link List<T>}
	 */
	public static <T> List<T> swap(List<T> list, int minIndex, int maxIndex) {
		if (list != null && list.size() > 2 && maxIndex > minIndex) {
			T elementAtMinIndex = list.get(minIndex);
			T elementAtMaxIndex = list.get(maxIndex);
			list.add(minIndex, elementAtMaxIndex);
			list.add(maxIndex, elementAtMinIndex);
			return list;
		}
		return null;
	}

	/**
	 * Method to fill the list with the given element
	 * 
	 * @param list
	 * @param element
	 * @return {@link List<T>}
	 */
	public static <T> List<T> fill(List<T> list, T element) {
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				list.add(i, element);
			}
			return list;
		}
		return null;
	}

	/**
	 * Method to find the minimum from the list
	 * 
	 * @param list
	 * @param comparator
	 * @return {@link T}
	 */
	public static <T> T min(List<T> list, Comparator<T> comparator) {
		return null;
	}

	public static <T> T max(List<T> list, Comparator<T> comparator) {
		return null;
	}

	public static <T> List<T> rotate(List<T> list, int n) {
		return null;
	}
	
}
