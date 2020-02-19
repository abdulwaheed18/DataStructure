package com.waheedtechblog.dynamicprogramming;

/**
 * 16.	You have a ladder of X steps. You can go up the ladder by taking either one or two steps each time. Write a
 * function to determine how many potential different combinations of one or two steps you could take to the top of the
 * ladder.
 */
public class LadderProblem {

    public static void main(String[] args) {
        int ladder = 4;
        int toalWays = stairs(ladder + 1, initializeSteps(ladder));
        System.out.println("Total ways : " + toalWays);

        // In more Generic ways where m can be 1 2 3 or specied number
        int m = 2;
        int ways = countWays(ladder+1,m);
        System.out.println("Total ways for m=" + m + " is: " + ways);
    }

    public static int[] initializeSteps(int totalSteps) {
        // 1+1 because ways(n) = fib(n+1)
        int[] mem = new int[totalSteps + 1 + 1];
        return mem;
    }

    // Its nothing bt dynamic programming for fib series̥
    public static int stairs(int steps, int[] mem) {
        if (mem[steps] != 0) {
            return mem[steps];
        }
        if (steps == 1 || steps == 2) return 1;
        return mem[steps] = stairs(steps - 1, mem) + stairs(steps - 2, mem);
    }

    public static int countWays(int n, int m)
    {
        int res[] = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<n; i++)
        {
            res[i] = 0;
            for (int j=1; j<=m && j<=i; j++)
                res[i] += res[i-j];
        }
        return res[n-1];
    }
}
