/**
 * Data-Structures-in-Java
 * DFSGraphs.java
 */
package com.deepak.data.structures.Graph;

import java.util.Stack;

/**
 * Depth First Search implemented for graphs
 * <p> Algorithm :
 * 	1. Push the root element to Stack
 * 	2. Loop until stack is empty
 * 	3. Peek the node from the Stack
 * 	4. If the node has unvisited child nodes, get those nodes, push to Stack and mark as visited
 * 	5. If the node does not have any unvisited child node, pop it from the Stack.   
 * </p>
 * 
 * @author Deepak
 */
public class DFSGraphs {

	/**
	 * Method to perform Depth First Search on a Graph
	 * @param root
	 * @param value
	 * @return {@link boolean}
	 */
	public static <T> boolean performDFS(GraphNode<T> root, T value) {
		if (root.getValue() == value) {
			System.out.println("GraphNode found. Root = " + root);
			return true; /* Value exists at root node */
		}

		/* Create a Stack. Set root as visited. Add the root to stack */
		Stack<GraphNode<T>> stack = new Stack<>();
		root.setVisited(true);
		stack.add(root);

		/* Check if stack is not empty */
		while (stack.peek() != null) {
			/* Remove the first element from the stack */
			GraphNode<T> currentNode = stack.pop();
			/* Check for all of the neighbors */
			for (GraphNode<T> graphNode : currentNode.getNeighbors()) {
				/* If the neighbor is unvisited, mark it as visited and add to the stack */
				if (!graphNode.isVisited()) {
					graphNode.setVisited(true);
					if (graphNode.getValue() == value) {
						System.out.println("GraphNode found = " + graphNode);
					}
					stack.push(graphNode);
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
