package com.waheedtechblog.graph;

import java.util.LinkedList;

public class GraphUsingAdjacencyList {

	static class Graph {
		int V;
		LinkedList<Integer> vertex[];

		@SuppressWarnings("unchecked")
		Graph(int V) {
			this.V = V;
			// number of Nodes/Vertices
			vertex = new LinkedList[V];

			// Create list for each vertices
			for (int i = 0; i < V; i++) {
				vertex[i] = new LinkedList<>();
			}
		}
	}

	static void addEdge(Graph graph, int src, int dest) {

		graph.vertex[src].add(dest);
		graph.vertex[dest].add(src);
	}

	static void printVertex(Graph graph) {

		for (int i = 0; i < graph.V; i++) {

			System.out.println("Adjustand Nodes for Vertex: " + i);
			for (Integer weight : graph.vertex[i]) {
				System.out.print(" " + weight);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {

		Graph graph = new Graph(6);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		addEdge(graph, 5, 1);

		printVertex(graph);

	}

}
