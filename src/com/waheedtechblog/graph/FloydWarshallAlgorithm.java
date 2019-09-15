package com.waheedtechblog.graph;

/**
 * Implementation of FloydWarshall Algorithms
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class FloydWarshallAlgorithm {

	public static final int INF_VALUE = 99999;

	public int[][] floydAlgorithm(int[][] graph) {
		int V = graph.length;

		int dist[][] = new int[V][V];
		/*
		 * Initialize the solution matrix same as input graph matrix. Or we can say the
		 * initial values of shortest distances are based on shortest paths considering
		 * no intermediate vertex.
		 */
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				dist[i][j] = graph[i][j];

		// should be less than vertex -1
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		return dist;
	}

	public void displayGraph(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j] == INF_VALUE) {
					System.out.print("   " + "INF");
				} else {
					System.out.print("   " + graph[i][j]);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		FloydWarshallAlgorithm floydWarshallAlgorithm = new FloydWarshallAlgorithm();

		int graph[][] = { { 0, 8, INF_VALUE, 1 }, { INF_VALUE, 0, 1, INF_VALUE }, { 4, INF_VALUE, 0, INF_VALUE },
				{ INF_VALUE, 2, 9, 0 } };

		System.out.println("=============  Initial Graph ===============");
		floydWarshallAlgorithm.displayGraph(graph);

		graph = floydWarshallAlgorithm.floydAlgorithm(graph);
		System.out.println("=============  Final Graph =================");
		floydWarshallAlgorithm.displayGraph(graph);
	}

}
