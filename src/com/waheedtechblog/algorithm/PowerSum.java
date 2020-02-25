package com.waheedtechblog.algorithm;

/**
 * Find the number of ways that a given integer, , can be expressed as the sum of the  powers of unique, natural numbers.
 * <p>
 * For example, if  and , we have to find all combinations of unique squares adding up to . The only solution is .
 * HackerRank: https://www.hackerrank.com/challenges/the-power-sum/problem
 * Explaination can be found over here : https://www.youtube.com/watch?v=tGKS6R7QS1A
 */
public class PowerSum {

    private static boolean isDebugEnabled = true;
    private static int counter = 0;

    public static void main(String[] args) {
        int X = 100, N = 2;
        int result = powerSum(X, N);
        System.out.println("Result: " + result);
    }

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        return powerSum(X, N, 1);

    }

    static int powerSum(int X, int N, int num) {
        if (isDebugEnabled) {
            System.out.println("Steps " + ++counter + ": X=" + X + ", N: " + N + ", num: " + num);
        }
        int var = (int) Math.pow(num, N);
        if (var < X)
            return powerSum(X, N, num + 1) + powerSum(X - var, N, num + 1);
        if (var == X) {
            System.out.println("When var ==X, var: " + var + ": X=" + X + ", N: " + N + ", num: " + num);
            return 1;
        }

        else
            return 0;
    }
}
