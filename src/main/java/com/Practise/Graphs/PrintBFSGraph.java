package com.Practise.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Problem: Given a graph, print the BFS traversal of the graph.
public class PrintBFSGraph {
    public static void main(String[] args) {
        // Initialize the graph as an adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>()); // Add an empty list for each node
        }

        // Add edges to the graph (undirected graph)
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(4).add(2);
        graph.get(4).add(3);
        graph.get(4).add(4);

        int n = graph.size(); // Number of nodes in the graph
        boolean[] visited = new boolean[n]; // Track visited nodes
        ArrayList<Integer> bfs = new ArrayList<>(); // Store BFS traversal result
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Start BFS from node 1
        int startingNode = 1; // Starting node for BFS
        queue.add(startingNode); // Add the starting node to the queue
        visited[startingNode] = true; // Mark the starting node as visited

        // Perform BFS traversal
        while (queue.size() != 0) {
            int node = queue.poll(); // Dequeue a node
            bfs.add(node); // Add the node to the BFS result

            // Traverse all adjacent nodes
            for (Integer child : graph.get(node)) {
                if (!visited[child]) { // If the node is not visited
                    queue.add(child); // Enqueue the node
                    visited[child] = true; // Mark the node as visited
                }
            }
        }

        // Print the BFS traversal result
        System.out.println("BFS Traversal: " + bfs);
    }
}