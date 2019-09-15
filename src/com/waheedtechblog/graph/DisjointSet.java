package com.waheedtechblog.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DisjointSet {

	static class Edge {
		int source;
		int destination;

		public Edge(int source, int destination) {
			this.source = source;
			this.destination = destination;
		}
	}

	int V;
	LinkedList<Edge> vertex[];
	List<Edge> edges = new ArrayList<>();

	@SuppressWarnings("unchecked")
	DisjointSet(int V) {
		this.V = V;
		// number of Nodes/Vertices
		vertex = new LinkedList[V];

		// Create list for each vertices
		for (int i = 0; i < V; i++) {
			vertex[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dest) {
		Edge edge = new Edge(src, dest);
		vertex[src].add(edge);
		edges.add(edge);
	}

	public void makeSets(int[] parent) {
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
	}

	public int find(int[] parent, int num) {
		if (parent[num] != num) {
			find(parent, parent[num]);
		}
		return num;
	}

	public void union(int[] parent, int x, int y) {
		int x_set_parent = find(parent, x);
		int y_set_parent = find(parent, y);
		// make x as parent of y
		parent[y_set_parent] = x_set_parent;
	}

	public void disjointSets(int[] parent) {
		// create a parent []

		// iterate through all the edges and keep making the sets
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			int x_set = find(parent, edge.source);
			int y_set = find(parent, edge.destination);

			// check if source vertex and destination vertex belongs to the same set
			// if in same set then cycle has been detected else combine them into one set
			if (x_set == y_set) {
				// do nothing
			} else
				union(parent, x_set, y_set);
		}
		printSets(parent);
	}

	public void printSets(int[] parent) {
		// Find different Sets
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < parent.length; i++) {
			if (map.containsKey(parent[i])) {
				ArrayList<Integer> list = map.get(parent[i]);
				list.add(i);// add vertex
				map.put(parent[i], list);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(parent[i], list);
			}
		}
		// Print the Different sets
		Set<Integer> set = map.keySet();
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			int key = iterator.next();
			System.out.println("Set Id: " + key + " elements: " + map.get(key));
		}
	}

	public static void main(String[] args) {
		int vertices = 6;
		DisjointSet graph = new DisjointSet(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(4, 5);

		int[] parent = new int[vertices];

		// makeset
		graph.makeSets(parent);

		graph.disjointSets(parent);

	}

}
