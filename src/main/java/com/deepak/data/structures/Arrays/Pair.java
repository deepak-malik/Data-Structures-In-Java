/**
 * Data-Structures-In-Java
 * Pair.java
 */
package com.deepak.data.structures.Arrays;

/**
 * Pair class 
 * 
 * @author Deepak
 *
 * @param <L>
 * @param <R>
 */
public class Pair<L, R> {

	/* Since pair is immutable, both L and R has to be final */
	public final L left;
	public final R right;

	/**
	 * Constructor
	 * 
	 * @param left
	 * @param right
	 */
	public Pair(final L left, final R right) {
		super();
		this.left = left;
		this.right = right;
	}

	/**
	 * Method to create a new Pair
	 * 
	 * @param left
	 * @param right
	 * @return {@link Pair<L, R>}
	 */
	public static <L, R> Pair<L, R> of(final L left, final R right) {
		return new Pair<>(left, right);
	}

	/**
	 * Method to get Left object 
	 * 
	 * @return {@link L}
	 */
	public L getLeft() {
		return left;
	}

	/**
	 * Method to get Right Object
	 * 
	 * @return {@link R}
	 */
	public R getRight() {
		return right;
	}

}
