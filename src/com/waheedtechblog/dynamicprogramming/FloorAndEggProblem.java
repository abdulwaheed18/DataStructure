package com.waheedtechblog.dynamicprogramming;

import org.omg.CORBA.INTERNAL;

import java.time.LocalDateTime;

public class FloorAndEggProblem {

    public static void main(String[] args) {

        // case 1 : floors  = 10, eggs =2;
        int floors = 35, eggs = 2;
        System.out.println("Started time : " + LocalDateTime.now());
        System.out.println("Minimum num of attempt required : " + eggDrop(eggs, floors));
        System.out.println("Completed time : " + LocalDateTime.now());

        System.out.println("\n\n==========Using Dynamic Programming....===============");
        System.out.println("Started time : " + LocalDateTime.now());
        System.out.println("Minimum num of attempt required : " + eggDropDp(eggs, floors));
        System.out.println("Completed time : " + LocalDateTime.now());
    }

    /**
     * This Solution will work for lower floors but time consumption will increase as we increase the floors,
     * Below problem can be done more efficiently via Dynamic Programming .
     *
     * @param eggs
     * @param floors
     * @return
     */
    static int eggDrop(int eggs, int floors) {

        /**
         * if no floor then no trial needed else js 1 fr 1 floor
         */
        if (floors == 0 || floors == 1) {
            return floors;
        }

        // if there is one egg then we try from all the floors starting from bottom
        if (eggs == 1) {
            return floors;
        }

        int minAttempt = Integer.MAX_VALUE;
        int res;
        for (int x = 1; x <= floors; x++) {
            res = Math.max(eggDrop(eggs - 1, x - 1), eggDrop(eggs, floors - x));
            if (res < minAttempt)
                minAttempt = res;
        }
        return minAttempt + 1;
    }

    static int eggDropDp(int eggs, int floors) {

        int[][] eggFloor = new int[eggs + 1][floors + 1];
        int res;

        // whatever the eggs count is, if floor is 1 or 0 then min attempt should be 1 or 0
        for (int i = 1; i <= eggs; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        //if there is only egg then minAttempt will be num of floors
        for (int i = 1; i <= floors; i++) {
            eggFloor[1][i] = i;
        }


        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    res = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
                    if (res < eggFloor[i][j])
                         eggFloor[i][j] = res;
                }
            }
        }
        return eggFloor[eggs][floors];
    }
}
/**
 *
 * Output:
 * Started time : 2020-01-18T16:47:59.979
 * Minimum num of attempt required : 8
 * Completed time : 2020-01-18T16:49:37.629
 *
 *
 * ==========Using Dynamic Programming....===============
 * Started time : 2020-01-18T16:49:37.629
 * Minimum num of attempt required : 8
 * Completed time : 2020-01-18T16:49:37.629
 *
 * Process finished with exit code 0
 */
