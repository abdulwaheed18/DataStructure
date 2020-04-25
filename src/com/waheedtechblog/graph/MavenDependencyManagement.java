package com.waheedtechblog.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Techgig question
 * Company : UiPath
 *
 * Given Input in the format of 2,[[1,0]] where first digit is totalNumber of modules of maven and next are dependency modules.
 * we need to check is there any cyclic dependency present which can turn into maven build failure
 *
 * As per above input, there is no issue in mvn build as there is 1 is just dependent on 0
 *
 * 2,[[1,0][0,1]]
 * 1 is dependent on 0 and 0 is on 1 so it will be failure
 */
public class MavenDependencyManagement {

    private final int totalModules;
    private final List<List<Integer>> dependency;

    public MavenDependencyManagement(int totalModules) {
        this.totalModules = totalModules;
        dependency = new ArrayList<>(totalModules);

        for (int i = 0; i < totalModules; i++)
            dependency.add(new LinkedList<>());
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println("input : " + input);

        int totalModules = Integer.parseInt(input.substring(0, 1));
        MavenDependencyManagement dependencyManagement = new MavenDependencyManagement(totalModules);

        String modules = input.substring(2);
        dependencyManagement.splitAndAdd(modules, dependencyManagement);
        System.out.println("Maven build success ?: " + !dependencyManagement.isMavenDependency());
    }

    private void addDependency(int source, int dest) {
        dependency.get(source).add(dest);
    }

    private void splitAndAdd(String modules, MavenDependencyManagement dependencyManagement) {
        boolean isFirstSet = false;
        int src = 0, dest = 0;
        for (char ch : modules.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!isFirstSet) {
                    src = Character.getNumericValue(ch);
                    isFirstSet = true;
                } else {
                    dest = Character.getNumericValue(ch);
                    dependencyManagement.addDependency(src, dest);
                    System.out.println("Pushing: " + src + ", " + dest);
                    isFirstSet = false;
                }
            }
        }
    }

    private boolean isMavenDependency() {

        boolean[] visited = new boolean[totalModules];
        boolean[] recStack = new boolean[totalModules];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < totalModules; i++)
            if (isMavenDependency(i, visited, recStack))
                return true;

        return false;
    }


    private boolean isMavenDependency(int i, boolean[] visited,
                                 boolean[] recStack) {
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = dependency.get(i);

        for (Integer c : children)
            if (isMavenDependency(c, visited, recStack))
                return true;
        recStack[i] = false;
        return false;
    }
}

/**
 * 2,[[1,0][0,1]]
 * input : 2,[[1,0][0,1]]
 * Pushing: 1, 0
 * Pushing: 0, 1
 * Maven build success ?: false
 */
