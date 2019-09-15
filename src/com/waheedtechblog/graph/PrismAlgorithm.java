package com.waheedtechblog.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TODO Not showing expected response. WIll look into it again
 * 
 * Prism Algorithm
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class PrismAlgorithm {

	public void prismAlgorithm(Node sourceNode) {
		sourceNode.distance = 0;
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceNode);
		while (priorityQueue.size() != 0) {

			Node currentVertex = priorityQueue.poll();
			for (Edge edge : currentVertex.edges) {
				Node destVertex = edge.toVertex;
				if (destVertex.visited == false) {
					int distance = currentVertex.distance + edge.weight;
					if (destVertex.distance > distance) {
						priorityQueue.remove(destVertex);
						destVertex.distance = distance;
						destVertex.parent = currentVertex;
						priorityQueue.add(destVertex);
					}
				}
			}
			currentVertex.visited = true;
		}
	}

	public void printSpanningTree(List<Node> nodes) {

		System.out.println("Minimum Spanning Tree PATH");
		for (Node node : nodes) {
			System.out.println("From '" + node.parent.name + "' - '" + node.name + "' is " + node.distance);
		}

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

	public static void main(String[] args) {
		// Create total Nodes
		/*
		 * Node nodeA = new Node("A"); Node nodeB = new Node("B"); Node nodeC = new
		 * Node("C"); Node nodeD = new Node("D"); Node nodeE = new Node("E");
		 * 
		 * // Lets add their edges with weight
		 * 
		 * 
		 * 
		 * nodeA.addEdges(new Edge(10, nodeA, nodeC)); nodeA.addEdges(new Edge(17,
		 * nodeA, nodeB)); nodeB.addEdges(new Edge(1, nodeB, nodeD)); nodeC.addEdges(new
		 * Edge(5, nodeC, nodeB)); nodeC.addEdges(new Edge(9, nodeC, nodeD));
		 * nodeC.addEdges(new Edge(11, nodeC, nodeE)); nodeD.addEdges(new Edge(6, nodeD,
		 * nodeE));
		 */

		/*
		 * List<Node> nodes = new ArrayList<>(); nodes.add(nodeE); nodes.add(nodeB);
		 * nodes.add(nodeC); nodes.add(nodeD);
		 */
		// skipping A as A is source Node so there will be no Vertex/Node

		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		nodeA.addEdges(new Edge(4, nodeA, nodeB));
		nodeA.addEdges(new Edge(3, nodeA, nodeC));
		nodeB.addEdges(new Edge(1, nodeB, nodeC));
		nodeB.addEdges(new Edge(2, nodeB, nodeD));
		nodeC.addEdges(new Edge(4, nodeC, nodeD));
		nodeD.addEdges(new Edge(2, nodeD, nodeE));
		nodeE.addEdges(new Edge(6, nodeE, nodeF));

		List<Node> nodes = new ArrayList<>();
		nodes.add(nodeE);
		nodes.add(nodeB);
		nodes.add(nodeC);
		nodes.add(nodeD);
		nodes.add(nodeF);
		// skipping A as A is source Node so there will be no Vertex/Node

		PrismAlgorithm algorithm = new PrismAlgorithm();
		algorithm.prismAlgorithm(nodeA);

		algorithm.printSpanningTree(nodes);

	}

}
