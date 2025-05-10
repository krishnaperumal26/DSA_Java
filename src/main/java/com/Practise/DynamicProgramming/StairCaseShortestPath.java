package com.Practise.DynamicProgramming;

import java.util.Arrays;

//Problem: You are climbing the stairs. Given array A which tells the cost to climb that stair. What is the minimum cost to climb the top
public class StairCaseShortestPath {

    public static void main(String[] args) {
        int A[] = {10, 20, 5, 8, 15, 25, 10, 12};
        int N = A.length;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        dp[0] = A[0];
        dp[1] = A[1];
        minCost(A, N-1, dp);
        System.out.println("Minimum cost to climb the top is: " + dp[N-1]);
    }

    public static int minCost(int[] A, int N, int[] dp) {
        if(N==0 || N==1){
            return dp[N];
        }

        if(dp[N] != -1) {
            return dp[N];
        }
        int idx1 = N - 1;
        int idx2 = N - 2;
        if(dp[idx1] == -1) {
            dp[idx1] = minCost(A, idx1, dp) + A[idx1];
        }
        if(dp[idx2] == -1) {
            dp[idx2] = minCost(A, idx2, dp) + A[idx2];
        }
         //Cost to reach the top from N-1 and N-2
         //dp[N] = cost to reach the top from N
         //dp[N-1] = cost to reach the top from N-1
         //dp[N-2] = cost to reach the top from N-2
        dp[N] = Math.min(dp[idx1], dp[idx2]);
         return dp[N];
    }
}
