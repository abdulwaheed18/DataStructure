package com.waheedtechblog.sorting;

import java.util.Arrays;

/**
 * Bubble sort Algorithm
 * 
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class BubbleSortAlgorithm {

	public static void main(String[] args) {

		int[] ar = { 30, 10, 50, 20, 60, 40 };
		BubbleSortAlgorithm sortAlgorithm = new BubbleSortAlgorithm();
		System.out.println("Initial Array: ");
		sortAlgorithm.display(ar);
		sortAlgorithm.bubbleSort(ar);
		System.out.println("\nArray after sorting: ");
		sortAlgorithm.display(ar);

	}

	public void bubbleSort(int[] ar) {
		int length = ar.length;
		boolean swapped;
		for (int i = 0; i < length - 1; i++) {
			swapped = false;
			for (int j = 0; j < length - 1 - i; j++) {
				if (ar[j] > ar[j + 1]) {
					swap(ar, j, j + 1);
					swapped = true;
				}
			}
			// Optimized way, if Array is already sorted then it will run O(n) times instead
			// of O(n*2) times
			if (swapped == false) {
				break;
			}
		}
	}

	private void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	public void display(int[] ar) {
		Arrays.stream(ar).forEach(System.out::println);
	}
}

/**
 * Output
 * 
 * Initial Array: 30 10 50 20 60 40
 * 
 * Array after sorting: 10 20 30 40 50 60
 */
