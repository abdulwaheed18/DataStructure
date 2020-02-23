package com.waheedtechblog.algorithm;

/**
 * Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.
 */
public class DivisionWithoutDivModMulOperator {

    public static void main(String[] args) {

        int num = 453;
        int den = 7;
        System.out.println("Quotient of num/den is: " + divide(num, den));

    }

    public static int divide(int x, int y) {
        int quotient = 0;
        while (x > y) {
            x = x - y;
            quotient++;
        }
        return quotient;
    }
}
