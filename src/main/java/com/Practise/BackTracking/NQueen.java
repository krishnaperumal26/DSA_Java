package com.Practise.BackTracking;

//Given NxN matrix, print all valid possibilities of placing N queen in given matrix. Also Queen should not be able to attack each other in row, column and diagonal.
public class NQueen {
    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        int N = 4; // Size of the chessboard
        int[][] matrix = new int[N][N]; // Initialize the chessboard with 0s
        nQueen.solveNQueen(matrix, 0);
    }

    public void solveNQueen(int[][] matrix, int row)
    {
        // If all queens are placed successfully, print the solution
        if (row == matrix.length) {
            printMatrix(matrix);
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < matrix.length; col++) {
            if (isSafe(matrix, row, col)) {
                matrix[row][col] = 1; // Place the queen
                solveNQueen(matrix, row + 1); // Recur to place the next queen
                matrix[row][col] = 0; // Backtrack and remove the queen
            }
        }
    }

    boolean isSafe(int[][] matrix, int row, int col) {

        for(int i=0;i<row;i++){
            if(matrix[i][col]==1){
                return false;
            }
        }
        // Check upper right diagonal
        int i = row, j = col, n = matrix.length;
        while(i>=0 && j<n)
        {
            if(matrix[i][j]==1){
                return false;
            }
            i--;
            j++;
        }

        //Check upper left diagonal
        i = row;
        j = col;
        while(i>=0 && j>=0)
        {
            if(matrix[i][j]==1){
                return false;
            }
            i--;
            j--;
        }


        return true;
    }
    void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

//TC: O(N^2) for N queens, as we need to check each cell in the matrix for safety.
//SC: O(N^2) for the matrix, as we need to store the positions of the queens in the matrix.