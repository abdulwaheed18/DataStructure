package com.waheedtechblog.array;

import java.util.Arrays;
import java.util.stream.Stream;

public class WaveFormSortArray {

	private void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	public void sortWave(int[] ar) {

		for (int i = 0; i < ar.length - 1; i += 2) {
			swap(ar, i, i + 1);
		}
	}

	public void display(int[] ar) {
		Arrays.stream(ar).forEach(e -> System.out.print(e + " "));
	}

	public static void main(String[] args) {
		WaveFormSortArray sortArray = new WaveFormSortArray();
		int[] ar = { 10, 30, 50, 70, 20, 40, 60, 80 };
		System.out.println("Array before Sorting");
		sortArray.display(ar);

		System.out.println("\nArray after Sorting");
		Arrays.sort(ar);
		sortArray.display(ar);

		sortArray.sortWave(ar);
		System.out.println("\nArray after wave sort");
		sortArray.display(ar);
	}
}

/**
 * 
 * Array before Sorting
 *  10 30 50 70 20 40 60 80 
 *  Array after Sorting 
 *  10 20 30 40 50 60 70 80 
 *  Array after wave sort 
 *  20 10 40 30 60 50 80 70
 */
