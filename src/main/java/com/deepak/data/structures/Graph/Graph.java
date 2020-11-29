/**
 * Data-Structures-in-Java
 * Graph.java
 */
package com.deepak.data.structures.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

/**
 * Custom implementation of Graph Data Structure
 * 
 * @author Deepak
 */
public class Graph<T> {

	/**
	 * Map to store adjacent edges associated with a vertex
	 */
	private HashMap<Vertex<T>, ArrayList<Edge<T>>> adjacencyList = null;

	/**
	 * Map to store connected components i.e a vertex connected to other
	 */
	private HashMap<Vertex<T>, Vertex<T>> connectedComponents = null;

	/**
	 * Default constructor
	 */
	public Graph() {
		adjacencyList = new HashMap<>();
		connectedComponents = new HashMap<>();
	}

	/**
	 * Method to add a new vertex
	 * @param element
	 * @return {@link Vertex<T>}
	 */
	public Vertex<T> addVertex(T element) {
		if (null == element) {
			throw new NullPointerException("Element cannot be null !!");
		}
		Vertex<T> newVertex = findVertex(element);
		if (null == newVertex) {
			newVertex = new Vertex<T>(element);
			adjacencyList.put(newVertex, new ArrayList<>());
			connectedComponents.put(newVertex, newVertex);
		}
		return newVertex;
	}

	/**
	 * Method to add a edge when two elements are given
	 * @param firstElement
	 * @param secondElement
	 * @return {@link Edge<T>}
	 */
	public Edge<T> addEdge(T firstElement, T secondElement) {
		if (null == firstElement || null == secondElement) {
			throw new NullPointerException("Elements cannot be null !!");
		}
		Vertex<T> firstVertex = findVertex(firstElement);
		if (null == firstVertex) {
			firstVertex = addVertex(firstElement);
		}
		Vertex<T> secondVertex = findVertex(secondElement);
		if (null == secondVertex) {
			secondVertex = addVertex(secondElement);
		}
		Edge<T> edge = new Edge<>(firstVertex, secondVertex);

		ArrayList<Edge<T>> list = adjacencyList.get(firstVertex);
		list.add(edge);
		adjacencyList.put(firstVertex, list);

		list = adjacencyList.get(secondVertex);
		list.add(edge);
		adjacencyList.put(secondVertex, list);

		if (!firstVertex.equals(secondVertex)) {
			unionComponents(firstVertex, secondVertex);
		}
		return edge;
	}

	/**
	 * Method to print the graph
	 */
	public void printGraph() {
		System.out.println("Graph");
		for (Vertex<T> vertex : adjacencyList.keySet()) {
			System.out.println("\n[" + vertex.toString() + "] --> ");
			ArrayList<Edge<T>> edges = adjacencyList.get(vertex);
			if (null != edges) {
				for (Edge<T> edge : edges) {
					if (edge.getFirstVertex().equals(vertex)) {
						System.out.println(edge.getSecondVertex().toString());
					} else {
						System.out.println(edge.getFirstVertex().toString());
					}
				}
			}
		}
	}

	/**
	 * Method to find a vertex when a element is given
	 * @param element
	 * @return {@link Vertex<T>}
	 */
	private Vertex<T> findVertex(T element) {
		if (null == element) {
			throw new NullPointerException("Element cannot be null !!");
		}
		HashSet<Vertex<T>> vertexSet = getAllComponents();
		for (Vertex<T> vertexFromSet : vertexSet) {
			Vertex<T> foundVertex = performBFS(vertexFromSet, element);
			if (null != foundVertex) {
				return foundVertex;
			}
		}
		return null;
	}

	/**
	 * Method to get all the components i.e all vertices
	 * @return {@link HashSet<Vertex<T>>}
	 */
	private HashSet<Vertex<T>> getAllComponents() {
		HashSet<Vertex<T>> setOfVertex = new HashSet<>();
		for (Vertex<T> vertex : connectedComponents.keySet()) {
			setOfVertex.add(findComponent(vertex));
		}
		return setOfVertex;
	}

	/**
	 * Method to find a component when a vertex is given
	 * @param vertex
	 * @return {@link Vertex<T>}
	 */
	private Vertex<T> findComponent(Vertex<T> vertex) {
		Vertex<T> currVertex = vertex;
		while (!currVertex.equals(connectedComponents.get(currVertex))) {
			currVertex = connectedComponents.get(currVertex);
		}
		return currVertex;
	}

	/**
	 * Method to connect two vertices
	 * @param firstVertex
	 * @param secondVertex
	 */
	private void unionComponents(Vertex<T> firstVertex, Vertex<T> secondVertex) {
		connectedComponents.put(findComponent(firstVertex), findComponent(secondVertex));
	}

	/**
	 * Method to perform a Breadth First Search
	 * @param rootVertex
	 * @param element
	 * @return {@link Vertex<T>}
	 */
	private Vertex<T> performBFS(Vertex<T> rootVertex, T element) {
		if (null == rootVertex || null == element) {
			throw new NullPointerException("Either root vertex or search element is null !!");
		}
		if (!adjacencyList.containsKey(rootVertex)) {
			throw new IllegalArgumentException("Search Failed : Invalid root vertex !!");
		}
		setAllVisitedFalse();

		Queue<Vertex<T>> queue = new ArrayDeque<>();
		queue.add(rootVertex);
		rootVertex.setVisited(true);

		while (!queue.isEmpty()) {
			Vertex<T> vertexToBeProcessed = queue.remove();
			if (vertexToBeProcessed.getData().equals(element)) {
				return vertexToBeProcessed;
			}
			ArrayList<Edge<T>> edgesConnectedToVertex = adjacencyList.get(vertexToBeProcessed);
			if (null == edgesConnectedToVertex) {
				continue;
			}
			for (Edge<T> edge : edgesConnectedToVertex) {
				Vertex<T> adjacentVertex = edge.getAdjacentVertex(vertexToBeProcessed);
				if (!adjacentVertex.isVisited()) {
					adjacentVertex.setVisited(true);
					queue.add(adjacentVertex);
				}
			}
		}
		return null;
	}

	/**
	 * Method to set all visited vertices as false
	 */
	private void setAllVisitedFalse() {
		for (Vertex<T> vertex : adjacencyList.keySet()) {
			vertex.setVisited(false);
		}
	}

	/**
	 * Static class Vertex
	 * @author Deepak
	 *
	 * @param <T>
	 */
	public static class Vertex<T> {

		private T data;
		private boolean visited;
		private Vertex<T> parent;

		/**
		 * Parameterized Constructor
		 * @param data
		 */
		public Vertex(T data) {
			this.data = data;
			visited = false;
			parent = null;
		}

		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}

		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public Vertex<T> getParent() {
			return parent;
		}
		public void setParent(Vertex<T> parent) {
			this.parent = parent;
		}

		public boolean equals(Vertex<T> vertex) {
			return data.equals(vertex.getData());
		}

		/**
		 * toString implementation
		 */
		public String toString() {
			return data.toString();
		}

	}

	/**
	 * Static class Edge
	 * @author Deepak
	 *
	 * @param <T>
	 */
	public static class Edge<T> {

		private Vertex<T> firstVertex;
		private Vertex<T> secondVertex;

		/**
		 * Parameterized Constructor
		 * @param firstVertex
		 * @param secondVertex
		 */
		public Edge(Vertex<T> firstVertex, Vertex<T> secondVertex) {
			if (null == firstVertex || null == secondVertex) {
				throw new NullPointerException("Can't create Edge, one of the Vertex is null !!");
			}
			this.firstVertex = firstVertex;
			this.secondVertex = secondVertex;
		}

		public Vertex<T> getFirstVertex() {
			return firstVertex;
		}
		public void setFirstVertex(Vertex<T> firstVertex) {
			this.firstVertex = firstVertex;
		}

		public Vertex<T> getSecondVertex() {
			return secondVertex;
		}
		public void setSecondVertex(Vertex<T> secondVertex) {
			this.secondVertex = secondVertex;
		}

		/**
		 * Method to get the adjacent vertex
		 * @param vertex
		 * @return {@link Vertex<T>}
		 */
		public Vertex<T> getAdjacentVertex(Vertex<T> vertex) {
			if (vertex == firstVertex) {
				return secondVertex;
			} else if (vertex == secondVertex) {
				return firstVertex;
			} else {
				return null;
			}
		}

		/**
		 * Method to check if 2 vertices of a edge are same i.e self loop
		 * @param edge
		 * @return {@link boolean}
		 */
		public boolean equals(Edge<T> edge) {
			if (firstVertex == edge.getFirstVertex() && secondVertex == edge.getSecondVertex()) {
				return true;
			} else if (firstVertex == edge.getSecondVertex() && secondVertex == edge.getFirstVertex()) {
				return true;
			}
			return false;
		}

		/**
		 * toString method
		 */
		public String toString() {
			return firstVertex.toString() + "," + secondVertex.toString();
		}

	}

}
