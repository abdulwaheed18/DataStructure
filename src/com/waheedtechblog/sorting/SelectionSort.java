package com.waheedtechblog.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Insertion Sort Algorithm
 * 
 * @author Abdul
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int[] ar = { 30, 10, 50, 20, 60, 40 };
		int length = ar.length;
		System.out.println("Initial Array: ");
		selectionSort.display(ar);
		selectionSort.selectionSort(ar, length);
		System.out.println("\nArray after sorting: ");
		selectionSort.display(ar);
	}

	public void selectionSort(int[] ar, int length) {
		for (int i = 0; i < length - 1; i++) {
			int minIndex = getMinIndex(ar, i + 1, length);
			if (ar[i] > ar[minIndex]) {
				swap(ar, i, minIndex);
			}
		}
	}

	private void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	private int getMinIndex(int[] ar, int startPoint, int length) {
		int minValue = ar[startPoint];
		int minIndex = startPoint;
		for (; startPoint <= length - 1; startPoint++) {
			if (minValue > ar[startPoint]) {
				minValue = ar[startPoint];
				minIndex = startPoint;
			}
		}
		return minIndex;
	}

	public void display(int[] ar) {
		String result = Arrays.stream(ar).mapToObj(String::valueOf).collect(Collectors.joining(", "));
		System.out.println(result);
	}
}

/**
 * Output:
 * 
 * Initial Array: 30, 10, 50, 20, 60, 40
 * 
 * Array after sorting: 10, 20, 30, 40, 50, 60
 */
