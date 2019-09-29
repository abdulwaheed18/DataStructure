package com.waheedtechblog.array;

import java.util.HashMap;

public class CompareTwoArray {

	public boolean isEqual(int[] ar1, int[] ar2) {

		if (ar1.length != ar2.length)
			return false;

		HashMap<Integer, Integer> array1 = new HashMap<>();

		for (int i = 0; i < ar1.length; i++) {
			if (array1.containsKey(ar1[i])) {
				int count = array1.get(ar1[i]);
				array1.put(ar1[i], ++count);
			} else {
				array1.put(ar1[i], 1);
			}
		}

		for (int i = 0; i < ar2.length; i++) {
			if (array1.containsKey(ar2[i])) {
				int count = array1.get(ar2[i]);
				if (count == 0) {
					return false;
				}
				--count;
				array1.put(ar2[i], count);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] ar1 = { 1, 2, 3, 4, 5, 1 };
		int[] ar2 = { 2, 3, 5, 4, 1, 1 };

		CompareTwoArray compareTwoArray = new CompareTwoArray();
		boolean isEqual = compareTwoArray.isEqual(ar1, ar2);

		System.out.println("True/false: " + isEqual);
	}

}
