package com.waheedtechblog.array;

/**
 * FInd minimum element in sorted and rotated array
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class FindMinimumElement {

	public static void main(String[] args) {
		int arr[] = { 16, 19, 21, 25, 3, 5, 8, 10 };
		int minimumElement = getMinimumElement(arr, 0, arr.length - 1);
		System.out.println("Minimum Element: " + minimumElement);

	}

	public static int getMinimumElement(int[] ar, int low, int high) {
		int mid = 0;
		while (low < high) {
			mid = low + ((high - low) / 2);
			if (ar[mid] > ar[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return ar[low];
	}

}
