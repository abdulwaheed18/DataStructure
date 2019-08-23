package com.waheedtechblog.array;

/**
 * You are given an integer array containing 1 to n but one of the number from 1
 * to n in the array is missing. You need to provide optimum solution to find
 * the missing number. Number can not be repeated in the arry.
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class SmallestLargestElement {

	public static void main(String[] args) {

		int[] arr = { 7, 5, 6, 1, 4, 2, 9, 10, 20, 15 };
		int smallest = arr[0], largest = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest)
				largest = arr[i];
			else if (arr[i] < smallest)
				smallest = arr[i];
		}

		System.out.println("Smallest element: " + smallest);
		System.out.println("Largest element:" + largest);

	}

}
