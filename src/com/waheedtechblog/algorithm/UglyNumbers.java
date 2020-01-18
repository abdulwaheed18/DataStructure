package com.waheedtechblog.algorithm;


/**
 * Problem Statement:
 * https://www.geeksforgeeks.org/ugly-numbers/
 */
public class UglyNumbers {

    public static void main(String[] args) {
        int n = 150;
        System.out.println("Ugly number is : " + getUglyNumber(n));
    }

    static int getUglyNumber(int n) {
        int i = 1, count = 1;
        while (n > count) {
            i++;
            if (isUgly(i)) {
                count++;
            }
        }
        return i;
    }

    static boolean isUgly(int num) {
        num = divide(num, 2);
        num = divide(num, 3);
        num = divide(num, 5);
        return num == 1;
    }

    static int divide(int x, int y) {
        while (x % y == 0) {
            x = x / y;
        }
        return x;
    }
}

/**
 * Output:
 * Ugly number is : 5832
 *
 * Check dynamic programming section for same solution in DP
 */
