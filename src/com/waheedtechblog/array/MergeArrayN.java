package com.waheedtechblog.array;

/**
 * Merge an array of size n into another array of size m+n
 * https://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
 */
public class MergeArrayN {


    public static void main(String[] args) {

        /* Initialize arrays */
        int[] mPlusN = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int[] N = {5, 7, 9, 25};
        int n = N.length;
        int m = mPlusN.length - n;
        moveAraayToEnd(mPlusN);

        merge(mPlusN, N, m, n);
        System.out.println("Merged Array: ");
        printArray(mPlusN);

    }

    // Move the array to the end
    public static void moveAraayToEnd(int[] mPlusN) {
        int j = mPlusN.length - 1;
        for (int i = mPlusN.length - 1; i >= 0; i--) {
            if (mPlusN[i] != -1) {
                mPlusN[j] = mPlusN[i];
                j--;
            }
        }
    }

    // Algoritm similar to merge
    public static void merge(int[] mPlusN, int[] N, int m, int n) {
        int i = n; // inital variable in mPlusN arr
        int j = 0; // iterate N array
        int k = 0; // iterate from start mPlusN array

        while (k < m + n) {
            if ((i < m + n && mPlusN[i] <= N[j]) || j ==n) {
                mPlusN[k] = mPlusN[i];
                k++;
                i++;
            } else {
                mPlusN[k] = N[j];
                j++;
                k++;
            }
        }

    }

    //Print the aaray
    public static void printArray(int[] arr) {
        for (int ar : arr) {
            System.out.print("" + ar + " ");
        }
    }
}
/**
 * Merged Array:
 * 2 5 7 8 9 13 15 20 25
 */
