package com.waheedtechblog.graph;

import java.util.LinkedList;

public class DetectCyleInDirectedGraph {

	int V;
	LinkedList<Integer> vertex[];

	@SuppressWarnings("unchecked")
	DetectCyleInDirectedGraph(int V) {
		this.V = V;
		// number of Nodes/Vertices
		vertex = new LinkedList[V];

		// Create list for each vertices
		for (int i = 0; i < V; i++) {
			vertex[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dest) {
		vertex[src].add(dest);
	}

	private boolean isCyclicUtil(int node, boolean[] visited, boolean[] recstack) {

		// if already visted in stack
		if (recstack[node]) {
			return true;
		}

		if (visited[node]) {
			return false;
		}

		visited[node] = true;

		recstack[node] = true;
		LinkedList<Integer> neighbours = vertex[node];

		for (Integer neighbour : neighbours) {
			if (isCyclicUtil(neighbour, visited, recstack)) {
				return true;
			}
		}
		recstack[node] = false;
		return false;
	}

	public boolean isCyclic() {

		boolean[] visited = new boolean[V];
		boolean[] recstack = new boolean[V];

		for (int node = 0; node < V; node++) {
			if (isCyclicUtil(node, visited, recstack)) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		DetectCyleInDirectedGraph graph = new DetectCyleInDirectedGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic()) {
			System.out.println("Graph has cyclic loop");
		} else {
			System.out.println("No cyclic loop");
		}
	}

}
