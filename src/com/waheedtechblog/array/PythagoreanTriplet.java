package com.waheedtechblog.array;

import java.util.Arrays;

public class PythagoreanTriplet {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5};
        int[] arr2 = {10, 4, 6, 12, 5};
        if(isTriplet(arr2)){
            System.out.println("Triplet present in array");
        } else {
            System.out.println("Triplet not found");
        }
    }

    public static boolean isTriplet(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        for (int i = arr.length - 1; i >= 2; i--) {
            int a = 0;
            int b = i - 1;
            int c = i;
            while (a < b) {
                if(arr[a] + arr[b] == arr[c]){
                    return true;
                } else if(arr[a] + arr[b] < arr[c]){
                    a++;
                } else {
                    b--;
                }
            }
        }
        return false;

    }


}
