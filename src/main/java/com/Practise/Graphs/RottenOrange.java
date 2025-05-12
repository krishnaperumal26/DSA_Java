package com.Practise.Graphs;

//Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
//Each cell can have three values:
//The value 0 representing an empty cell.
//The value 1 representing a fresh orange.
//The value 2 representing a rotten orange.
//Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
//Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}


public class RottenOrange {
    public static void main(String[] args) {
        // Input matrix representing the grid of oranges
        int[][] A = {
                {2, 1, 1},
                {1, 0, 1},
                {0, 1, 1}
        };

        int n = A.length; // Number of rows in the matrix
        int m = A[0].length; // Number of columns in the matrix
        int[][] vis = new int[n][m]; // Visited array to track processed cells
        Queue<Pair> queue = new LinkedList<>(); // Queue to perform BFS
        int NoOfFreshOrange = 0; // Count of fresh oranges

        // Traverse the matrix to find rotten oranges and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 2) {
                    queue.add(new Pair(i, j, 0)); // Add rotten orange to the queue
                    vis[i][j] = 2; // Mark as visited
                } else {
                    vis[i][j] = 0; // Mark as unvisited
                }
                if (A[i][j] == 1) {
                    NoOfFreshOrange++; // Count fresh oranges
                }
            }
        }

        // Direction arrays to check adjacent cells (top, left, bottom, right)
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};
        int time = 0; // Variable to track the time elapsed
        int NoOfRottenOrange = 0; // Count of oranges that became rotten

        // Perform BFS to rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int r = queue.peek().row; // Current row
            int c = queue.peek().col; // Current column
            int t = queue.peek().time; // Time elapsed for the current cell
            time = Math.max(time, t); // Update the maximum time
            queue.remove(); // Remove the processed cell from the queue

            // Check all adjacent cells
            for (int i = 0; i < 4; i++) {
                int checkRow = r + delrow[i]; // Adjacent row
                int checkCol = c + delcol[i]; // Adjacent column

                // Check if the adjacent cell is valid and contains a fresh orange
                if (checkRow >= 0 && checkRow < n && checkCol >= 0 && checkCol < m && vis[checkRow][checkCol] == 0 && A[checkRow][checkCol] == 1) {
                    queue.add(new Pair(checkRow, checkCol, t + 1)); // Add the cell to the queue
                    vis[checkRow][checkCol] = 2; // Mark as visited (rotten)
                    NoOfRottenOrange++; // Increment the count of rotten oranges
                }
            }
        }

        // Check if all fresh oranges have been rotten
        if (NoOfRottenOrange == NoOfFreshOrange) {
            System.out.println(time); // Print the time taken to rot all oranges
        } else {
            System.out.println(-1); // Print -1 if not all oranges can be rotten
        }
    }
}

// Time Complexity: O(N * M) for traversing the matrix
// Space Complexity: O(N * M) for the queue and visited array