/**
 * 
 */
package com.waheedtechblog.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Topological Sorting
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class TopologicalSort {

	int V;
	LinkedList<Integer> vertex[];

	@SuppressWarnings("unchecked")
	TopologicalSort(int V) {
		this.V = V;
		vertex = new LinkedList[V];

		for (int i = 0; i < V; i++) {
			vertex[i] = new LinkedList<>();
		}
	}

	public void add(int src, int dest) {
		vertex[src].add(dest);
	}

	private void recursiveSort(int v, boolean[] visited, Stack<Integer> stack) {
		// Mark current node as Visited
		visited[v] = true;
		Integer i;
		Iterator<Integer> it = vertex[v].listIterator();
		while (it.hasNext()) {
			i = it.next();
			// if node is not visted
			if (visited[i] == false) {
				recursiveSort(i, visited, stack);
			}
		}
		stack.push(v);
	}

	public void sortGraph(int totalVertex) {

		// boolean array to mark all visited Node
		boolean visited[] = new boolean[totalVertex];
		for (int i = 0; i < totalVertex; i++) {
			visited[i] = false;
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < totalVertex; i++) {
			// if Node is already not visited
			if (visited[i] == false)
				recursiveSort(i, visited, stack);
		}

		// Display
		while (stack.empty() == false) {
			System.out.print(" " + stack.pop());
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int graphSize = 6;
		TopologicalSort graph = new TopologicalSort(graphSize);
		graph.add(5, 0);
		graph.add(5, 2);
		graph.add(4, 0);
		graph.add(4, 1);
		graph.add(2, 3);
		graph.add(3, 1);

		graph.sortGraph(graphSize);
	}

}
