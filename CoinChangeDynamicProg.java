package com.java.dynamicProgramming;

import java.util.Scanner;

public class CoinChangeDynamicProg {

	int count(int[] coin, int size, int sum)
	{
		int[][] table = new int[size][sum+1];
		// Filling First row of the table
		for(int i = 0; i <= sum; i++)
		{

			if(i % coin[0] == 0)
			{
				table[0][i] = 1;
			}
		}
		for(int i = 1; i < size; i++)
		{
			for(int j = 0; j <= sum; j++)
			{
				if(j == 0)
					table[i][j] = 1;
				
				// coin value is greater than sum, then copy above value
				if(coin[i] > j)
				{
					table[i][j] = table[i-1][j];
				}
				else
				{
					table[i][j] = table[i-1][j] + table[i][j-coin[i]];
				}
			}
		}
		return table[size-1][sum];
		
	}
	
	
	public static void main(String[] args) {

		
		CoinChangeDynamicProg ccdp = new CoinChangeDynamicProg();
		Scanner sc = new Scanner(System.in);
		int noOfChange = sc.nextInt();
		int coin[] = new int[noOfChange];
		int sum = sc.nextInt();
		for(int i = 0; i < noOfChange; i++)
		{
			coin[i] = sc.nextInt();
		}
		System.out.println("Total number of ways: "+ ccdp.count(coin, coin.length, sum));
	

	}

}
