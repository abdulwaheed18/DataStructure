package com.waheedtechblog.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	int V;
	LinkedList<Integer> vertex[];

	@SuppressWarnings("unchecked")
	DFS(int V) {
		this.V = V;
		// number of Nodes/Vertices
		vertex = new LinkedList[V];

		// Create list for each vertices
		for (int i = 0; i < V; i++) {
			vertex[i] = new LinkedList<>();
		}
	}

	private void addEdge(int src, int dest) {
		vertex[src].add(dest);

	}

	private void DFSImplementation(int vertex) {

		boolean isVisited[] = new boolean[V]; 

		Stack<Integer> stack = new Stack<>();
		isVisited[vertex] = true;
		stack.push(vertex);

		while (stack.size() != 0) {
			int node = stack.pop();
			System.out.println(" " + node);

			Iterator<Integer> adjNode = this.vertex[node].listIterator();
			while (adjNode.hasNext()) {
				int n = adjNode.next();
				if (!isVisited[n]) {
					isVisited[n] = true;
					stack.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		DFS dfs = new DFS(4);

		dfs.addEdge(0, 1);
		dfs.addEdge(0, 2);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 0);
		dfs.addEdge(2, 3);
		dfs.addEdge(3, 3);

		dfs.DFSImplementation(2);

	}

}
