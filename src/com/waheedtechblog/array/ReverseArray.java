package com.waheedtechblog.array;

import java.util.Arrays;

/**
 * Class to reverse array with and without recursion
 * 
 * @author abdul@waheedtechhblog.com
 *
 */
public class ReverseArray {
	private static int[] arr;

	public static void main(String[] args) {

		arr = new int[] { 10, 7, 4, 3, 9, 34, 8 };

		System.out.println("Before reverse: " + Arrays.toString(arr));
		ReverseArray reverseArray = new ReverseArray();
		reverseArray.reverseArray();
		System.out.println("After reverse: " + Arrays.toString(arr));

		reverseArray.reverseRecursion(0, arr.length - 1);
		System.out.println("After reverse recursion: " + Arrays.toString(arr));

	}

	/**
	 * Reverse array without recursion
	 */
	private void reverseArray() {
		int first = 0, end = arr.length - 1;
		while (first <= end) {
			int temp = arr[first];
			arr[first] = arr[end];
			arr[end] = temp;
			first++;
			end--;
		}
	}

	/*
	 * Reverse array using recursion
	 */
	private void reverseRecursion(int first, int end) {
		if (first <= end) {
			int temp = arr[first];
			arr[first] = arr[end];
			arr[end] = temp;
			first++;
			end--;
			reverseRecursion(first, end);
		}

	}

}
