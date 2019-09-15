package com.waheedtechblog.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Prism Algorithm, Tried with different logic and good part it is working
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class PrismAlgorithm2 {

	public ArrayList<Edge> prismAlgorithm(int totalNodes, Node source) {

		ArrayList<Edge> mst = new ArrayList<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(source.edges);
		int totalEdge = 0;

		// MST will always be subset of given graph having
		while (pq.size() > 0 && totalEdge < totalNodes - 1) {
			// will fetch edge having less weight
			Edge edge = pq.poll();
			// add it to MST
			mst.add(edge);
			// Add all edges of neighbour edges to queues
			pq.addAll(edge.toVertex.edges);
			// remove the current edge now
			pq.remove(edge);
			totalEdge++;
		}
		return mst;
	}

	public void printMstGraph(ArrayList<Edge> mst) {
		System.out.println("Minimum Spanning Tree");
		for (Edge edge : mst) {
			System.out.println("From '" + edge.fromNode.name + "' - '" + edge.toVertex.name + "' is " + edge.weight);
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

	static class Edge implements Comparable<Edge> {
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

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) {

		int totalNodes = 6;

		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		Edge edge1 = new Edge(7, nodeA, nodeB);
		nodeA.addEdges(edge1);
		Edge edge2 = new Edge(7, nodeB, nodeA);
		nodeB.addEdges(edge2);

		Edge edge3 = new Edge(6, nodeB, nodeD);
		nodeB.addEdges(edge3);
		Edge edge4 = new Edge(6, nodeD, nodeB);
		nodeD.addEdges(edge4);

		Edge edge7 = new Edge(5, nodeD, nodeF);
		nodeD.addEdges(edge7);
		Edge edge8 = new Edge(5, nodeF, nodeD);
		nodeF.addEdges(edge8);

		Edge edge9 = new Edge(2, nodeF, nodeE);
		nodeF.addEdges(edge9);
		Edge edge10 = new Edge(2, nodeE, nodeF);
		nodeE.addEdges(edge10);

		Edge edge11 = new Edge(2, nodeD, nodeE);
		nodeD.addEdges(edge11);
		Edge edge12 = new Edge(2, nodeE, nodeD);
		nodeE.addEdges(edge12);

		Edge edge13 = new Edge(3, nodeC, nodeE);
		nodeC.addEdges(edge13);
		Edge edge14 = new Edge(3, nodeE, nodeC);
		nodeE.addEdges(edge14);

		Edge edge15 = new Edge(4, nodeD, nodeC);
		nodeD.addEdges(edge15);
		Edge edge16 = new Edge(4, nodeC, nodeD);
		nodeC.addEdges(edge16);

		Edge edge17 = new Edge(3, nodeC, nodeB);
		nodeC.addEdges(edge17);
		Edge edge18 = new Edge(3, nodeB, nodeC);
		nodeB.addEdges(edge18);

		Edge edge19 = new Edge(8, nodeA, nodeC);
		nodeA.addEdges(edge19);
		Edge edge20 = new Edge(8, nodeC, nodeA);
		nodeC.addEdges(edge20);

		PrismAlgorithm2 algorithm = new PrismAlgorithm2();
		ArrayList<Edge> mst = algorithm.prismAlgorithm(totalNodes, nodeA);

		algorithm.printMstGraph(mst);
	}

}
