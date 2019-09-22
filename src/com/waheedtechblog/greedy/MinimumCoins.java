package com.waheedtechblog.greedy;

import java.util.ArrayList;

/**
 * 
 * Greedy Algorithm to find Minimum number of Coins
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public class MinimumCoins {

	// All denominations of Indian Currency
	private int denominations[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
	private int length = denominations.length;

	public void getMinCoinRequired(int value) {
		ArrayList<Integer> totalCount = new ArrayList<>();

		// start from reverse
		for (int i = length - 1; i > 0; i--) {

			while (value >= denominations[i]) {

				value -= denominations[i];
				totalCount.add(denominations[i]);
			}
		}
		totalCount.stream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		MinimumCoins coins = new MinimumCoins();
		int value1 = 5500;
		int value2 = 97;
		System.out.println("Denominations for value : " + value1);
		coins.getMinCoinRequired(value1);

		System.out.println("\nDenominations for value : " + value2);
		coins.getMinCoinRequired(value2);

	}

}

/**
 * 
 * Output:
 * 
 * Denominations for value : 5500
2000
2000
500
500
500

Denominations for value : 97
50
20
20
5
2

 * 
 */
