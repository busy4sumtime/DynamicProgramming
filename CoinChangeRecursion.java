/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
 * So output should be 4. 
 * 
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
 * So the output should be 5.
 */
package com.java.dynamicProgramming;

import java.util.Scanner;

public class CoinChangeRecursion {

	int count(int[] coin, int size, int sum)
	{
		if(sum == 0)
			return 1;
		if (sum < 0)
			return 0; // No Solution Exists
		if(size <=0 && sum > 0)
			return 0; // If no Coins Left and Sum is greater than zero, then no solution exists.
		return count(coin, size - 1, sum) + count(coin, size, (sum - coin[size-1]));
	}
	public static void main(String[] args) {
		
		CoinChangeRecursion ccr = new CoinChangeRecursion();
		Scanner sc = new Scanner(System.in);
		int noOfChange = sc.nextInt();
		int coin[] = new int[noOfChange];
		int sum = sc.nextInt();
		for(int i = 0; i < noOfChange; i++)
		{
			coin[i] = sc.nextInt();
		}
		System.out.println("Total number of ways: "+ ccr.count(coin, coin.length, sum));
	}

}
