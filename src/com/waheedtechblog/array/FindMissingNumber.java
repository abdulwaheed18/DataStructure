package com.waheedtechblog.array;

import java.util.*;
import java.util.stream.*;

/**
 * You are given an integer array containing 1 to n but one of the number from 1
 * to n in the array is missing. You need to provide optimum solution to find
 * the missing number. Number can not be repeated in the arry.
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class FindMissingNumber {

	public static void main(String[] args) {

		int[] arr1 = { 7, 5, 6, 1, 4, 2 };
		System.out.println("Missing Number : " + findMissingNumber(arr1));

		int[] arr2 = { 5, 3, 1, 2 };
		System.out.println("Missing number : " + findMissingNumber(arr2));

	}

	public static int findMissingNumber(int[] ar) {

		int n = ar.length + 1;
		int ExpectingSum = n * (n + 1) / 2;
		IntStream stream = Arrays.stream(ar);
		int totalSum = stream.sum();
		return ExpectingSum - totalSum;
	}

}
