package com.Practise.BackTracking;



//Problem: Given a maze of N*N, where the rat is at (0,0) and the destination is at (N-1,M-1).
//The rat can only move in 4 directions: up, down, left, right. Find all the paths to get cheese.
public class RatInMaze {
    public static void main(String[] args)
    {
        int[][] maze = {
                {0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
        };
        //0 - Free cell
        //1 - Blocked cell
        //The rat can only move in 4 directions: up, down, left, right.
        //2 - Visited cell

        //Cheese cell address
        int M = 5;
        int N = 6;
        boolean[][] path = new boolean[N][M];
        RatInMaze ratInMaze = new RatInMaze();
        ratInMaze.findPath(maze, M, N, 0, 0, path);
    }

    void findPath(int[][] maze, int M, int N, int i, int j, boolean[][] path) {
        if(i == N - 1 && j == M - 1) {
            path[i][j] = true;
            printPath(path);
            path[i][j] = false; // Backtrack
            maze[i][j] = 0; // Unmark the cell

            return;
        }

        if(i < 0 || i >= N || j < 0 || j >= M || maze[i][j] == 1 || path[i][j]) {
            return;
        }
        if(maze[i][j] == 0)
        {
            maze[i][j] = 2;
            path[i][j] = true;
            //Move Up
            findPath(maze, M, N, i - 1, j, path);
            //Move Left
            findPath(maze, M, N, i, j - 1, path);
            //Move Down
            findPath(maze, M, N, i + 1, j, path);
            //Move Right
            findPath(maze, M, N, i, j + 1, path);

            //Backtrack
            maze[i][j] = 0;
            path[i][j] = false;
        }

    }

    private void printPath(boolean[][] path) {
        for (boolean[] row : path) {
            for (boolean cell : row) {
                System.out.print(cell ? "1 " : "0 ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Pair{
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
