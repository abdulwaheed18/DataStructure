package com.waheedtechblog.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Single Source Shortest Path Problem
 * 
 * @author Abdul
 *
 */
public class ShortestPathUsingBFS {

	int V;
	LinkedList<Integer> vertex[];
	int[] parent = null;

	@SuppressWarnings("unchecked")
	ShortestPathUsingBFS(int V) {
		this.V = V;
		vertex = new LinkedList[V];

		for (int i = 0; i < V; i++) {
			vertex[i] = new LinkedList<>();
		}
	}

	public void add(int src, int dest) {
		vertex[src].add(dest);
	}

	public void getSSSPUsingBFS(int v) {
		boolean visited[] = new boolean[V];
		parent = new int[V];
		Queue<Integer> queues = new LinkedList<>();

		visited[v] = true;
		parent[v] = -1;
		queues.add(v);

		while (queues.size() != 0) {

			int poll = queues.poll();
			System.out.print(" " + poll);
			Iterator<Integer> iterator = vertex[poll].listIterator();
			while (iterator.hasNext()) {
				int value = iterator.next();
				if (visited[value] == false) {
					queues.add(value);
					visited[value] = true;
					parent[value] = poll;
				}
			}
		}
	}

	private void displayPath(int p) {
		if (p == -1)
			return;
		System.out.print(" " + p);
		displayPath(parent[p]);
	}

	public static void main(String[] args) {
		ShortestPathUsingBFS graph = new ShortestPathUsingBFS(6);
		graph.add(5, 0);
		graph.add(5, 2);
		graph.add(4, 0);
		graph.add(4, 1);
		graph.add(2, 3);
		graph.add(3, 1);

		System.out.println("BFS traversal");
		graph.getSSSPUsingBFS(5);

		System.out.println("\n\nPath from Source\n");
		graph.displayPath(1);

	}

}
