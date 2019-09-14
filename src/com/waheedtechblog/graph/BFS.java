package com.waheedtechblog.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	int V;
	LinkedList<Integer> vertex[];

	@SuppressWarnings("unchecked")
	BFS(int V) {
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

	private void BFSImplementation(int vertex) {

		boolean isVisited[] = new boolean[V]; 

		Queue<Integer> queues = new LinkedList<>();

		isVisited[vertex] = true;
		queues.add(vertex);

		while (queues.size() != 0) {
			int node = queues.poll();
			System.out.println(" " + node);

			Iterator<Integer> adjNode = this.vertex[node].listIterator();
			while (adjNode.hasNext()) {
				int n = adjNode.next();
				if (!isVisited[n]) {
					isVisited[n] = true;
					queues.add(n);
				}
			}
		}

	}

	public static void main(String[] args) {
		BFS bfs = new BFS(4);

		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);

		bfs.BFSImplementation(2);

	}

}
