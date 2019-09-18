package com.waheedtechblog.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Insertion sort Algorithm
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class InsertionSortAlgorithm {

	public static void main(String[] args) {
		InsertionSortAlgorithm sortAlgorithm = new InsertionSortAlgorithm();
		int[] ar = { 30, 10, 50, 20, 20, 60, 40 };
		int length = ar.length;
		System.out.println("Initial Array: ");
		sortAlgorithm.display(ar);
		sortAlgorithm.sortArray(ar, length);
		System.out.println("\nArray after sorting: ");
		sortAlgorithm.display(ar);

	}

	public void sortArray(int[] ar, int length) {

		int j = 0;
		for (int i = 1; i < length; i++) {
			j = i;
			while (j > 0) {
				if (ar[j - 1] > ar[j]) {
					swap(ar, j, j - 1);
				}
				j--;
			}
			// display(ar);
		}
	}

	private void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	public void display(int[] ar) {
		String result = Arrays.stream(ar).mapToObj(String::valueOf).collect(Collectors.joining(", "));
		System.out.println(result);
	}

}
