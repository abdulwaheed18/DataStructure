package com.waheedtechblog.search;

public class BinarySearch {

	public int binarySearch(int[] ar, int low, int high, int value) {

		if (low < high) {
			int mid = low + (high - low) / 2;
			if (ar[mid] == value)
				return mid;
			else if (ar[mid] < value) {
				return binarySearch(ar, mid + 1, high, value);
			} else {
				return binarySearch(ar, low, mid - 1, value);
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;
		int result = search.binarySearch(arr, 0, n - 1, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);

	}

}
