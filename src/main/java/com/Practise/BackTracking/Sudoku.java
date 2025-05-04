package com.Practise.BackTracking;

// Sudoku Solver using Backtracking
public class Sudoku {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        int[][] matrix = new int[][] {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
//         Imagine Index order
//        x = {
//            {0, 1, 2, 3, 4, 5, 6, 7, 8},
//            {9, 10, 11, 12, 13, 14, 15, 16, 17},
//            {18, 19, 20, 21, 22, 23, 24, 25, 26},
//            {27, 28, 29, 30, 31, 32, 33, 34, 35},
//            {36, 37, 38, 39, 40, 41, 42, 43, 44},
//            {45, 46, 47, 48, 49, 50, 51, 52, 53},
//            {54, 55, 56, 57,58 ,59 ,60 ,61 ,62},
//            {63 ,64 ,65 ,66 ,67 ,68 ,69 ,70 ,71},
//            {72 ,73 ,74 ,75 ,76 ,77 ,78 ,79 ,80}
//        }
        // Solve the Sudoku puzzle starting from the first cell.
        sudoku.sudokuSolver(matrix, 0);
        System.out.println("End");
    }

    void sudokuSolver(int[][] matrix, int x) {
        // If all cells are processed, print the solved Sudoku grid.
        if (x == 81) {
            System.out.println("Sudoku solved:");
            printSudoku(matrix);
            return;
        }
        // Calculate the row and column indices from the cell index.
        int row = x / 9;
        int col = x % 9;
        // If the current cell is already filled, move to the next cell.
        if (matrix[row][col] != 0) {
            sudokuSolver(matrix, x + 1);
        } else {
            // Try placing numbers 1 to 9 in the current cell.
            for (int i = 1; i <= 9; i++) {
                if (isValid(matrix, row, col, i)) {
                    matrix[row][col] = i;// Place the number.
                    sudokuSolver(matrix, x + 1);// Recur for the next cell.
                    matrix[row][col] = 0; // Backtrack by resetting the cell.
                }
            }
        }
    }

    boolean isValid(int[][] matrix, int row, int col, int num) {
        // Check the row and column for duplicates.
        for (int i = 0; i < 9; i++) {
            if (matrix[row][i] == num || matrix[i][col] == num) {
                return false;
            }
        }
        // Check the 3x3 subgrid for duplicates.
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (matrix[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    void printSudoku(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

