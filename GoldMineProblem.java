/* Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. 
 * Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from 
 * a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. 
 * Find out maximum amount of gold he can collect.
 * Input : mat[][] = {{1, 3, 3},
                   {2, 1, 4},
                  {0, 6, 4}};
Output : 12 
{(1,0)->(2,1)->(2,2)}

Input: mat[][] = { {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}};
Output : 16
(2,0) -> (1,1) -> (1,2) -> (0,3) OR
(2,0) -> (3,1) -> (2,2) -> (2,3)

Input : mat[][] = {{10, 33, 13, 15},
                  {22, 21, 04, 1},
                  {5, 0, 2, 3},
                  {0, 6, 14, 2}};
Output : 83
*/
package com.java.dynamicProgramming;

import java.util.Scanner;

public class GoldMineProblem {
	
	int max = 0;
	int findMaxGold(int[][] goldMineArray, int n, int m)
	{
		// Find Max in first column
		int counter = 0;
		int result = 0;
		for(int j = 0; j < m; j++)
		{
			if (max < goldMineArray[j][0]) {
				max = goldMineArray[j][0];
				counter = j;
			}
		}
		result = max;
		for(int i = 1; i < n; i++)
		{
			int previousRow;
			int sameRow = goldMineArray[counter] [i];
			int nextRow;
			int max1 = 0;
			if((counter - 1) < 0)
			{
				previousRow = 0;
			}
			else
			{
				previousRow = goldMineArray[counter-1] [i];
			}
			if((counter + 1) >= m)
			{
				nextRow = 0;
			}
			else
			{
				nextRow = goldMineArray[counter+1] [i];
			}
			max1 = Math.max(Math.max(previousRow, sameRow), nextRow);
			if(max1 == previousRow)
				counter = counter - 1;
			if(max1 == nextRow)
				counter = counter + 1;
			result += max1;
		}
		return result;
	}
	public static void main(String[] args) {
		
		GoldMineProblem gmp = new GoldMineProblem();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] goldMindArray = new int[n][m];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				goldMindArray[i][j] = sc.nextInt();
			}
		}

		System.out.println("Maximum Amount of Gold: " +gmp.findMaxGold(goldMindArray, n, m));
	}

}
