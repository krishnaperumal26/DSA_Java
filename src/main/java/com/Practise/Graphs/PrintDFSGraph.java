package com.Practise.Graphs;

import java.util.ArrayList;

// Problem: Given a graph, print the DFS traversal of the graph.
public class PrintDFSGraph {
    public static void main(String[] args) {
        // Initialize the graph as an adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            graph.add(new ArrayList<>()); // Add an empty list for each node
        }

        // Add edges to the graph (undirected graph)
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(1);
        graph.get(2).add(5);
        graph.get(2).add(6);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(7);
        graph.get(4).add(3);
        graph.get(4).add(8);
        graph.get(5).add(2);
        graph.get(6).add(2);
        graph.get(7).add(3);
        graph.get(7).add(8);
        graph.get(8).add(4);
        graph.get(8).add(7);

        int n = graph.size(); // Number of nodes in the graph
        boolean[] visited = new boolean[n]; // Track visited nodes
        ArrayList<Integer> dfs = new ArrayList<>(); // Store DFS traversal result

        int node = 5; // Starting node for DFS
        visited[node] = true; // Mark the starting node as visited
        dfs.add(node); // Add the starting node to the DFS result

        // Traverse all adjacent nodes of the starting node
        for (Integer it : graph.get(node)) {
            if (!visited[it]) { // If the node is not visited
                dfsTraversal(graph, visited, dfs, it); // Perform DFS on the node
            }
        }

        // Print the DFS traversal result
        System.out.println("DFS Traversal: " + dfs);
    }

    /**
     * Recursive function to perform DFS traversal.
     *
     * @param graph   The adjacency list representation of the graph.
     * @param visited Array to track visited nodes.
     * @param dfs     List to store the DFS traversal result.
     * @param node    The current node being visited.
     */
    public static void dfsTraversal(ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> dfs, int node) {
        visited[node] = true; // Mark the current node as visited
        dfs.add(node); // Add the current node to the DFS result

        // Traverse all adjacent nodes of the current node
        for (Integer child : graph.get(node)) {
            if (!visited[child]) { // If the node is not visited
                dfsTraversal(graph, visited, dfs, child); // Perform DFS on the node
            }
        }
    }
}