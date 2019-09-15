/**
 * 
 */
package com.waheedtechblog.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author AbdulWaheed18@gmail.com
 *
 */
public class KruskalAlgorithm {

	static class Edge implements Comparable<Edge> {
		int source;
		int destination;
		int weight;

		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	int V;
	ArrayList<Edge> allEdges = new ArrayList<>();

	public KruskalAlgorithm(int v) {
		V = v;
	}

	public void addEdge(int src, int dest, int weight) {
		Edge edge = new Edge(src, dest, weight);
		allEdges.add(edge);
	}

	public void makeSet(int[] parent) {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	public int find(int[] parent, int num) {
		if (parent[num] != num) {
			return find(parent, parent[num]);
		}
		return num;
	}

	public void union(int[] parent, int src, int dest) {
		int set_x = find(parent, src);
		int set_y = find(parent, dest);
		parent[set_y] = set_x;
	}

	public void KST(int[] parent) {

		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
		for (Edge edge : allEdges) {
			priorityQueue.add(edge);
		}

		ArrayList<Edge> mst = new ArrayList<>();
		int index = 0;
		while (index < V - 1) {

			Edge edge = priorityQueue.poll();
			int set_x = find(parent, edge.source);
			int set_y = find(parent, edge.destination);

			if (set_x == set_y) {
				// ignore else will create cyclic graph
			} else {
				mst.add(edge);
				index++;
				union(parent, set_x, set_y);
			}
		}

		System.out.println("Minimum Spanning Tree");
		printGraph(mst);

	}

	public void printGraph(ArrayList<Edge> edgeList) {
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			System.out.println("Edge-" + i + " source: " + edge.source + " destination: " + edge.destination
					+ " weight: " + edge.weight);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int vertices = 6;
		KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertices);
		kruskalAlgorithm.addEdge(0, 1, 4);
		kruskalAlgorithm.addEdge(0, 2, 3);
		kruskalAlgorithm.addEdge(1, 2, 1);
		kruskalAlgorithm.addEdge(1, 3, 2);
		kruskalAlgorithm.addEdge(2, 3, 4);
		kruskalAlgorithm.addEdge(3, 4, 2);
		kruskalAlgorithm.addEdge(4, 5, 6);

		int[] parent = new int[6];

		kruskalAlgorithm.makeSet(parent);
		kruskalAlgorithm.KST(parent);

	}

}
