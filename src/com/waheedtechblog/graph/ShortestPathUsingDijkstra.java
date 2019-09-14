package com.waheedtechblog.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Dijkstra Algorithms Implementation
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class ShortestPathUsingDijkstra {

	public void shortestDistance(Node node) {

		// Elements of the priority queue (PQ) are ordered according to the natural
		// ordering,
		PriorityQueue<Node> queue = new PriorityQueue<>();
		// Current Node is 0
		node.distance = 0;

		// Add node to PQ
		queue.add(node);
		node.visited = true;

		while (!queue.isEmpty()) {
			// fetch min distance
			Node sourceNode = queue.poll();

			for (Edge edge : sourceNode.edges) {
				Node neighbourNode = edge.toVertex;
				if (neighbourNode.visited == false) {
					int distance = sourceNode.distance + edge.weight;
					if (distance < neighbourNode.distance) {
						queue.remove(neighbourNode);
						neighbourNode.distance = distance;
						neighbourNode.parent = sourceNode;
						queue.add(neighbourNode);
					}
				}
			}
			sourceNode.visited = true;
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

		// Create total Nodes
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");

		// Lets add their edges with weight

		nodeA.addEdges(new Edge(10, nodeA, nodeC));
		nodeA.addEdges(new Edge(17, nodeA, nodeB));
		nodeB.addEdges(new Edge(1, nodeB, nodeD));
		nodeC.addEdges(new Edge(5, nodeC, nodeB));
		nodeC.addEdges(new Edge(9, nodeC, nodeD));
		nodeC.addEdges(new Edge(11, nodeC, nodeE));
		nodeD.addEdges(new Edge(6, nodeD, nodeE));

		ShortestPathUsingDijkstra dijkstra = new ShortestPathUsingDijkstra();
		dijkstra.shortestDistance(nodeA);

		System.out.println("==========  Minimum Distance  =============");

		System.out.println("Minimum distance from A to B is: " + nodeB.getDistance());
		System.out.println("Minimum distance from A to C is: " + nodeC.getDistance());
		System.out.println("Minimum distance from A to D is: " + nodeD.getDistance());
		System.out.println("Minimum distance from A to E is: " + nodeE.getDistance());

		System.out.println("\n========== Path Taken  =============");
		System.out.println("Shortest Path from B to A is: ");
		dijkstra.shortestPath(nodeB);

		System.out.println("\nShortest Path from C to A is: ");
		dijkstra.shortestPath(nodeC);

		System.out.println("\nShortest Path from D to A is: ");
		dijkstra.shortestPath(nodeD);

		System.out.println("\nShortest Path from E to A is: ");
		dijkstra.shortestPath(nodeE);

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
 * Output
 * 
 * ========== Minimum Distance ============= 
 * Minimum distance from A to B is: 15
 * Minimum distance from A to C is: 10 
 * Minimum distance from A to D is: 16
 * Minimum distance from A to E is: 21
 * 
 * ========== Path Taken ============= 
 * Shortest Path from B to A is: B C A
 * Shortest Path from C to A is: C A 
 * Shortest Path from D to A is: D B C A
 * Shortest Path from E to A is: E C A
 * 
 * 
 * 
 */
