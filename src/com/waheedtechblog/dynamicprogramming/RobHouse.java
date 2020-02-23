package com.waheedtechblog.dynamicprogramming;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 */
public class RobHouse {

    public static void main(String[] args) {
        int[] netWorthFirstHouse = {1, 2, 3, 1};
        System.out.println("Total amount you can rob from First house is: " + rob(netWorthFirstHouse));

        int[] netWorthSecondHouse = {2, 7, 9, 3, 1};
        System.out.println("Total amount you can rob from second house is: " + rob(netWorthSecondHouse));

    }

    public static int rob(int[] netWorth) {
        int totalHouse = netWorth.length;
        int[] dp = new int[totalHouse + 2];
        return robUtils(dp, netWorth, 0);
    }

    public static int robUtils(int[] dp, int[] netWorth, int currentHouse) {
        if (currentHouse >= netWorth.length) {
            return 0;
        }
        if (dp[currentHouse] == 0) {
            // rob the current house and calculate for rest house
            int stealHouse = netWorth[currentHouse] + robUtils(dp, netWorth, currentHouse + 2);
            //skip the current house
            int skipHouse = robUtils(dp, netWorth, currentHouse + 1);
            dp[currentHouse] = Math.max(stealHouse, skipHouse);
        }
        return dp[currentHouse];
    }
}

/**
 * Total amount you can rob from First house is: 4
 * Total amount you can rob from second house is: 12
 */
