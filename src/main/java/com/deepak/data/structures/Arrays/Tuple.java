/**
 * Data-Structures-In-Java
 * Tuple.java
 */
package com.deepak.data.structures.Arrays;

/**
 * Tuple class is an extension of Pair
 * NOTE : Tuple can have any number of elements.
 * We are implementing this class as a Triplet for now
 * 
 * @author Deepak
 *
 * @param <L>
 * @param <M>
 * @param <R>
 */
public class Tuple<L, M , R> {

	/* Since Tuple as well is a immutable data structure,
	 * All the elements are marked as final */
	private final L left;
	private final M middle;
	private final R right;

	/**
	 * Constructor
	 * 
	 * @param left
	 * @param middle
	 * @param right
	 */
	public Tuple(L left, M middle, R right) {
		super();
		this.left = left;
		this.middle = middle;
		this.right = right;
	}

	/**
	 * Method to create a new Tuple
	 * 
	 * @param left
	 * @param middle
	 * @param right
	 * @return {@link Tuple<L, M, R>}
	 */
	public static <L, M, R> Tuple<L, M, R> of(final L left, final M middle, final R right) {
		return new Tuple<L, M, R>(left, middle, right);
	}

	/**
	 * Method to get Left
	 * 
	 * @return {@link L}
	 */
	public L getLeft() {
		return left;
	}

	/**
	 * Method to get Middle
	 * 
	 * @return {@link M}
	 */
	public M getMiddle() {
		return middle;
	}

	/**
	 * Method to get Right
	 * 
	 * @return {@link R}
	 */
	public R getRight() {
		return right;
	}

}
