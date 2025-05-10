package com.Practise.DynamicProgramming;

import java.util.Arrays;

//Problem: You are climbing the stairs. It takes N steps to reach the top. In how many different ways can you climb to the top?
public class StairCase {
    public static void main(String[] args) {
        int N = 55007; // Number of steps
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);

        System.out.println("Number of ways to climb " + N + " steps: " + countWays(N, dp));
    }

    static int countWays(int N, int[] dp) {
        if (N <= 1) {
            return 1;
        }
        int idx1 = N - 1;
        int idx2 = N - 2;
        if(dp[idx1]==-1){
            dp[idx1] = countWays(idx1, dp);
        }

        if(dp[idx2]==-1){
            dp[idx2] = countWays(idx2, dp);
        }
        return dp[idx1] + dp[idx2];
    }
}
