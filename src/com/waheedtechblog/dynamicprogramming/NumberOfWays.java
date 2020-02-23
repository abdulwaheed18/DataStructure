package com.waheedtechblog.dynamicprogramming;

public class NumberOfWays {

    public static void main(String[] args) {
        int N = 5;
        int[] useNumbers = {1, 3, 4};
        num_ways(N, useNumbers);
    }

    public static void num_ways(int N, int[] useNumbers) {
        int[] dp = new int[N + 1];
        System.out.println("Total num of ways using Top Down approach: " + num_waysUtil(dp, N, useNumbers));
        dp = new int[N + 1];
        System.out.println("Total num of ways using Bottom up approach: " + num_waysUtil2(dp, N, useNumbers));
    }

    /**
     * Top down Approach
     *
     * @param dp
     * @param N
     * @param useNumbers
     * @return
     */
    public static int num_waysUtil(int[] dp, int N, int[] useNumbers) {
        if (N == 0 || N == 1 || N == 2)
            return 1;
        if (N == 3) {
            return 2;
        }
        if (dp[N] != 0) {
            return dp[N];
        } else {
            int ways1 = num_waysUtil(dp, N - useNumbers[0], useNumbers);
            int ways3 = num_waysUtil(dp, N - useNumbers[1], useNumbers);
            int ways4 = num_waysUtil(dp, N - useNumbers[2], useNumbers);
            return dp[N] = ways1 + ways3 + ways4;
        }
    }

    /**
     * Bottom up Approach
     */
    public static int num_waysUtil2(int[] dp, int N, int[] useNumbers) {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - useNumbers[0]] + dp[i - useNumbers[1]] + dp[i - useNumbers[2]];
        }
        return dp[N];
    }
}

/*
Total num of ways using Top Down approach: 6
Total num of ways using Bottom up approach: 6
 */
