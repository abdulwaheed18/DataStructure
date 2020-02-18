package com.waheedtechblog.algorithm;

/**
 * CHeck whether num is palindrome or not
 */
public class PallindromeNumber {

    public static void main(String[] args) {
        PallindromeNumber pallindrome = new PallindromeNumber();
        int num1 = 123411;
        if (pallindrome.isPalindrome(num1))
            System.out.println(num1 + " is pallindrome");
        else
            System.out.println(num1 + " is not pallindrome");

        System.out.println("=====Using Second method=======");
        if (pallindrome.isPallindrome2(num1))
            System.out.println(num1 + " is pallindrome");
        else
            System.out.println(num1 + " is not pallindrome");
    }

    public boolean isPalindrome(int num) {
        int temp = num;
        int rem = 0;
        int finalValue = 0;
        while (temp > 0) {
            rem = temp % 10;
            finalValue = (finalValue * 10) + rem;
            temp = temp / 10;
        }
        return num == finalValue;
    }

    /**
     * Without using extra spacces
     *
     * @param num
     * @return
     */
    public boolean isPallindrome2(int num) {
        int divisior = 1;
        while (num / divisior >= 10) {
            divisior = divisior * 10;
        }
        while (num != 0) {
            int leading = num/divisior;
            int trailing = num %10;
            if(leading !=trailing)
                return false;
            num = (num % divisior ) /10;
            divisior = divisior /100;
        }
        return true;
    }
}
