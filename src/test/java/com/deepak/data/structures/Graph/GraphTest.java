/**
 * Data-Structures-in-Java
 * GraphTest.java
 */
package com.deepak.data.structures.Graph;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.deepak.data.structures.Graph.BFSGraphs.BFSGraphNode;
import com.deepak.data.structures.Graph.DFSGraphs.DFSGraphNode;

/**
 * Test cases for Graphs and associated Algorithms
 *  
 * @author Deepak
 */
public class GraphTest {

	/**
	 * Method to test graph creation
	 */
	@Test
	public void testGraphCreation() {
		Graph<Integer> graph = new Graph<>();
		graph.addVertex(7);
		graph.addVertex(1);
		graph.addEdge(7, 1);
		graph.addVertex(12);
		graph.addEdge(1, 12);
		graph.addVertex(21);
		graph.addEdge(12, 21);
		graph.addVertex(14);
		graph.addEdge(21, 14);
		graph.printGraph();
	}

	/**
	 * Method to test Breadth First Search
	 */
	@Test
	public void testBFS() {
		/* Create the nodes for the graph */
		BFSGraphNode<String> nodeA = new BFSGraphNode<>("A");
		BFSGraphNode<String> nodeB = new BFSGraphNode<>("B");
		BFSGraphNode<String> nodeC = new BFSGraphNode<>("C");
		BFSGraphNode<String> nodeD = new BFSGraphNode<>("D");
		BFSGraphNode<String> nodeE = new BFSGraphNode<>("E");
		BFSGraphNode<String> nodeF = new BFSGraphNode<>("F");
		BFSGraphNode<String> nodeG = new BFSGraphNode<>("G");
		BFSGraphNode<String> nodeH = new BFSGraphNode<>("H");

		/* Set the neighbors to those nodes */
		nodeA.setNeighbors(Arrays.asList(nodeB, nodeD, nodeG));
		nodeB.setNeighbors(Arrays.asList(nodeE, nodeF));
		nodeC.setNeighbors(Arrays.asList(nodeE, nodeH));
		nodeD.setNeighbors(Arrays.asList(nodeA, nodeE));
		nodeE.setNeighbors(Arrays.asList(nodeB, nodeC));
		nodeF.setNeighbors(Arrays.asList(nodeB, nodeG));
		nodeG.setNeighbors(Arrays.asList(nodeA, nodeF));
		nodeH.setNeighbors(Arrays.asList(nodeC));

		/* perform BFS */
		Assert.assertTrue(BFSGraphs.performBFS(nodeA, "D"));
	}

	/**
	 * Method to test Depth First Search Algorithm
	 */
	@Test
	public void testDFS() {
		/* Create nodes for the graph */
		DFSGraphNode<String> nodeA = new DFSGraphNode<>("A");
		DFSGraphNode<String> nodeB = new DFSGraphNode<>("B");
		DFSGraphNode<String> nodeC = new DFSGraphNode<>("C");
		DFSGraphNode<String> nodeD = new DFSGraphNode<>("D");
		DFSGraphNode<String> nodeE = new DFSGraphNode<>("E");
		DFSGraphNode<String> nodeF = new DFSGraphNode<>("F");
		DFSGraphNode<String> nodeG = new DFSGraphNode<>("G");
		DFSGraphNode<String> nodeH = new DFSGraphNode<>("H");

		/* Set neighbors to those nodes */
		nodeA.setNeighbors(Arrays.asList(nodeB, nodeD, nodeG));
		nodeB.setNeighbors(Arrays.asList(nodeE, nodeF));
		nodeC.setNeighbors(Arrays.asList(nodeE, nodeH));
		nodeD.setNeighbors(Arrays.asList(nodeA, nodeE));
		nodeE.setNeighbors(Arrays.asList(nodeB, nodeC));
		nodeF.setNeighbors(Arrays.asList(nodeB, nodeG));
		nodeG.setNeighbors(Arrays.asList(nodeA, nodeF));
		nodeH.setNeighbors(Arrays.asList(nodeC));

		/* Perform DFS */
		Assert.assertTrue(DFSGraphs.performDFS(nodeA, "D"));
	}

}
