/**
 * Data-Structures-in-Java
 * BFSGraphs.java
 */
package com.deepak.data.structures.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Breadth First Search implemented for Graphs
 * 
 * <p> Algorithm : 
 * 	1. Push the root node in the Queue.
 * 	2. Loop until the Queue is empty.
 * 	3. Remove the Node from the Queue.
 * 	4. If the removed node has unvisited children, mark them as visited and insert the unvisited children in the Queue. 
 * </p>
 *  
 * @author Deepak
 */
public class BFSGraphs<T> {

	/**
	 * Method to perform Breadth First Search on a Graph
	 * @param root
	 * @param value
	 * @return {@link true}
	 */
	public static <T> boolean performBFS(GraphNode<T> root, T value) {
		if (root.getValue() == value) {
			System.out.println("GraphNode found. Root = " + root);
			return true; /* Value exists at root node */
		}

		/* Create a queue. Set root as visited. Add the root to queue */
		Queue<GraphNode<T>> queue = new ArrayDeque<>();
		root.setVisited(true);
		queue.add(root);

		/* Check if queue is not empty */
		while (queue.peek() != null) {
			/* Remove the first element from the queue */
			GraphNode<T> currentNode = queue.poll();
			/* Check for all of the neighbors */
			for (GraphNode<T> graphNode : currentNode.neighbors) {
				/* If the neighbor is unvisited, mark it as visited and add to the queue */
				if (!graphNode.isVisited()) {
					graphNode.setVisited(true);
					if (graphNode.getValue() == value) {
						System.out.println("GraphNode found = " + graphNode);
					}
					queue.add(graphNode);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Static class GraphNode
	 * 
	 * @author Deepak
	 *
	 * @param <E>
	 */
	public static class GraphNode<E> {

		private E value;
		private GraphNode<E> next;
		private GraphNode<E>[] neighbors;
		private boolean visited;

		/**
		 * Parameterized Constructor
		 * @param value
		 */
		public GraphNode(E value) {
			this.value = value;
		}

		/**
		 * Parameterized Constructor
		 * @param neighbors
		 */
		public GraphNode(GraphNode<E>[] neighbors) {
			this.neighbors = neighbors;
		}

		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}

		public GraphNode<E> getNext() {
			return next;
		}
		public void setNext(GraphNode<E> next) {
			this.next = next;
		}

		public GraphNode<E>[] getNeighbors() {
			return neighbors;
		}
		public void setNeighbours(GraphNode<E>[] neighbors) {
			this.neighbors = neighbors;
		}

		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean visited) {
			this.visited = visited;
		}

	}


}
