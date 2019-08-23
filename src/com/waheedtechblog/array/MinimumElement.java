package com.waheedtechblog.array;

/**
 * Search an element in sorted and rotated array in o(log n) time complexity.
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class MinimumElement {

	public static void main(String[] args) {

		int arr[] = { 16, 19, 21, 25, 3, 5, 8, 10 };
		System.out.println("Element at index : " + find(arr, 10));
	}

	public static int find(int[] arr, int n) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;

		while (low <= high) {

			mid = low + ((high - low) / 2);

			if (arr[mid] == n)
				return mid;

			// right part is sorted
			if (arr[mid] <= high) {

				if (n > arr[mid] && n <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				// Left part is sorted
				if (arr[low] <= n && n < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

}
