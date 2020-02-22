package com.waheedtechblog.string;

/**
 * Program to find Largest Common Substring
 *
 * Watch this video to understand the logic behind the program
 */
public class LargestCommonSubstring {

    public static void main(String[] args) {
        String X = "waheedtechblog.com";
        String Y = "https://github.com/abdulwaheed18";
        System.out.println("Largest Common SubString is : " + largestCommonSubstring(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }

    static int largestCommonSubstring(char[] X, char[] Y, int m, int n) {
        //create a DP matrix
        int[][] dp = new int[m + 1][n + 1];

        int largestLength = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    largestLength = Math.max(largestLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return largestLength;
    }
}
/*
Largest Common SubString is : 6
 */
