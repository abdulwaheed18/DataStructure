package com.waheedtechblog.array;

public class SecondHighestElement {

	public static void main(String[] args) {
		int[] arr1 = { 7, 5, 6, 1, 4, 2 };
		System.out.println("Second Max Value is : " + findSecondLargetElement(arr1));

	}

	public static int findSecondLargetElement(int[] arr) {
		int max =Integer.MIN_VALUE, secondmax = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				secondmax = max;
				max = arr[i];
			} else if (arr[i] > secondmax) {
				secondmax = arr[i];
			}
		}
		return secondmax;
	}

}
