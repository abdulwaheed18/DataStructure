package com.waheedtechblog.sorting;

/**
 * Sort an array of 0s, 1s and 2s
 */
public class SortArrayOf012 {

    public static void main(String[] args) {

        int[] ar = {0, 2, 1, 2, 0,2,2,2,1,1,1,1,0,0,0,0,2,1,1};
        System.out.println("Sort Array using counting Sort method ");
        sortUsingCountSort(ar, 2);

    }

    public static void sortUsingCountSort(int[] arr, int max) {
        int[] counts = new int[max + 1];
        for (int num : arr) {
            counts[num]++;
        }
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            while (count > 0) {
                System.out.print(i + " ");
                count--;
            }
        }
    }


}
