package com.Practise.Graphs;

//Problem: You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
//Given 2 towns find whether you can reach the first town from the second without repeating any edge.
//B C : query to find whether B is reachable from C.
//Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
//There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
//NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
public class CheckDestinationReachableFromSource {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
        int C = 5;
        System.out.println(isReachable(A, B, C));
    }

    static boolean isReachable(int[] A, int B, int C) {
        while (C != B && C != 0) {
            C = A[C - 1];
        }
        return C == B;
    }
}
