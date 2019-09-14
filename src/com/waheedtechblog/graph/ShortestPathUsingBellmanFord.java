package com.waheedtechblog.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Shortest Path Using Bellman-ford Algorithms
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class ShortestPathUsingBellmanFord {

	public void shortestDistance(int totalNodes, List<Edge> edges, Node sourceNode) {
		// keep source Node be 0 for comparision
		sourceNode.distance = 0;

		// This will always be TotalNodes -1
		for (int i = 0; i < totalNodes - 1; i++) {
			// Iterate all nodes
			for (Edge edge : edges) {
				int distance = edge.fromNode.distance + edge.weight;
				if (edge.toVertex.distance > distance) {
					edge.toVertex.distance = distance;
					edge.toVertex.parent = edge.fromNode;
				}
			}
		}

		// to check if any negative weight cycle exist;
		for (int i = 0; i < totalNodes - 1; i++) {
			// Iterate all nodes
			for (Edge edge : edges) {
				int distance = edge.fromNode.distance + edge.weight;
				if (edge.toVertex.distance > distance) {
					System.err.println("Graph contains negative weight cycle ");
					return;
				}
			}
		}
	}

	public void shortestPath(Node node) {
		if (node.distance == 0) {
			System.out.print(" " + node.name);
			return;
		}
		System.out.print(" " + node.name);
		shortestPath(node.parent);
	}

	public static void main(String[] args) {

		int totalNodes = 5;
		// Create total Nodes
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");

		// Lets add their edges with weight

		Edge edge1 = new Edge(10, nodeA, nodeC);
		nodeA.addEdges(edge1);
		Edge edge2 = new Edge(17, nodeA, nodeB);
		nodeA.addEdges(edge2);
		Edge edge3 = new Edge(1, nodeB, nodeD);
		nodeB.addEdges(edge3);
		Edge edge4 = new Edge(5, nodeC, nodeB);
		nodeC.addEdges(edge4);
		Edge edge5 = new Edge(9, nodeC, nodeD);
		nodeC.addEdges(edge5);
		Edge edge6 = new Edge(11, nodeC, nodeE);
		nodeC.addEdges(edge6);
		Edge edge7 = new Edge(6, nodeD, nodeE);
		nodeD.addEdges(edge7);

		List<Edge> edges = new ArrayList<>();
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);
		edges.add(edge6);
		edges.add(edge7);

		ShortestPathUsingBellmanFord bellmanFord = new ShortestPathUsingBellmanFord();
		bellmanFord.shortestDistance(totalNodes, edges, nodeA);

		System.out.println("==========  Minimum Distance using Bellman-ford Algorithms  =============");

		System.out.println("Minimum distance from A to B is: " + nodeB.getDistance());
		System.out.println("Minimum distance from A to C is: " + nodeC.getDistance());
		System.out.println("Minimum distance from A to D is: " + nodeD.getDistance());
		System.out.println("Minimum distance from A to E is: " + nodeE.getDistance());

		System.out.println("\n========== Path Taken  =============");
		System.out.println("Shortest Path from B to A is: ");
		bellmanFord.shortestPath(nodeB);

		System.out.println("\nShortest Path from C to A is: ");
		bellmanFord.shortestPath(nodeC);

		System.out.println("\nShortest Path from D to A is: ");
		bellmanFord.shortestPath(nodeD);

		System.out.println("\nShortest Path from E to A is: ");
		bellmanFord.shortestPath(nodeE);

	}

	static class Node implements Comparable<Node> {

		// name of the node
		private String name;
		// distance from source
		private int distance = Integer.MAX_VALUE;
		// is node visited previously
		private boolean visited = false;
		// parent Node of this Node
		private Node parent;

		// Edge which are connected to this Edge
		private List<Edge> edges;

		public Node(String name) {
			this.name = name;
			edges = new ArrayList<>();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public List<Edge> getEdges() {
			return edges;
		}

		public void setEdges(List<Edge> edges) {
			this.edges = edges;
		}

		public void addEdges(Edge edge) {
			this.edges.add(edge);
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.distance, node.getDistance());
		}

	}

	static class Edge {
		private int weight;

		private Node fromNode;
		private Node toVertex;

		public Edge(int weight, Node fromNode, Node toVertex) {
			this.weight = weight;
			this.fromNode = fromNode;
			this.toVertex = toVertex;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public Node getFromNode() {
			return fromNode;
		}

		public void setFromNode(Node fromNode) {
			this.fromNode = fromNode;
		}

		public Node getToVertex() {
			return toVertex;
		}

		public void setToVertex(Node toVertex) {
			this.toVertex = toVertex;
		}
	}
}


/**
 * Output:
 * 
 * ==========  Minimum Distance using Bellman-ford Algorithms  =============
Minimum distance from A to B is: 15
Minimum distance from A to C is: 10
Minimum distance from A to D is: 16
Minimum distance from A to E is: 21

========== Path Taken  =============
Shortest Path from B to A is: 
 B C A
Shortest Path from C to A is: 
 C A
Shortest Path from D to A is: 
 D B C A
Shortest Path from E to A is: 
 E C A
 * 
 */
