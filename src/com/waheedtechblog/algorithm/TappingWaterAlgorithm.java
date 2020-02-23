package com.waheedtechblog.algorithm;

/**
 * YOutube description: https://www.youtube.com/watch?v=zdDeV5v_iUE
 * https://www.youtube.com/watch?v=HmBbcDiJapY
 */
public class TappingWaterAlgorithm {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Total Water Capacity: " + getTotalWater(arr));
    }

    public static int getTotalWater(int[] arr) {
        int totalWater = 0;
        int length = arr.length;

        int[] left = new int[length];
        left[0] = arr[0];
        // traverse in right direction
        for (int i = 1; i < length; i++)
            left[i] = Math.max(arr[i], left[i - 1]);

        //traverse in left Direction
        int[] right = new int[length];
        right[length - 1] = arr[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }

        for (int i = 0; i < length; i++) {
            totalWater += Math.min(left[i], right[i]) - arr[i];
        }
        return totalWater;
    }
}

/**
 * Total Water Capacity: 6
 */

