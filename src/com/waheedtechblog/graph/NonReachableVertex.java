package com.waheedtechblog.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

/**
 * Count total number of non reachable nodes
 * <p>
 * Problem Statement:
 * https://www.geeksforgeeks.org/count-number-non-reachable-nodes/
 */
public class NonReachableVertex {

    int v;
    List<Integer>[] vertex;
    int notReachableNode;

    NonReachableVertex(int v) {
        this.v = v;
        this.notReachableNode = v;
        vertex = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            vertex[i] = new LinkedList<>();
        }
    }

    public void add(int src, int dest) {
        vertex[src].add(dest);
        vertex[dest].add(src);
    }

    public int getTotalNonReachableNodes(int vertex) {

        boolean[] isVisited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(vertex);
        isVisited[vertex] = true;
        notReachableNode--;
        while (!q.isEmpty()) {
            int node = q.poll();

            System.out.print(node + " ");

            ListIterator<Integer> integerListIterator = this.vertex[node].listIterator();
            while (integerListIterator.hasNext()) {
                int n = integerListIterator.next();
                if (!isVisited[n]) {
                    isVisited[n] = true;
                    notReachableNode--;
                    q.add(n);
                }
            }
        }
        return notReachableNode;
    }

    public static void main(String[] args) {
        NonReachableVertex nonReachableVertex = new NonReachableVertex(5);
        nonReachableVertex.add(0, 1);
        nonReachableVertex.add(0, 2);
        nonReachableVertex.add(1, 2);
        nonReachableVertex.add(3, 4);
        //nonReachableVertex.add(1, 4);

        int count = nonReachableVertex.getTotalNonReachableNodes(2);
        System.out.println("\nNon reachable node is : " + count);
    }
}

/**
 * Output:
 * 2 0 1
 * Non reachable node is : 2
 */
