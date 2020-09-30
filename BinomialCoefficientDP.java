package com.java.dynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class BinomialCoefficientDP {
	
	HashMap<String, Integer> dpMap = new HashMap<String, Integer>();

	int binomialCoefficient(int n, int k)
	{
		int result = 0;
		String keyVal = ""+n+""+k;
		if(k == 0 || n == k)
		{
			return 1;
		}
		if(dpMap.containsKey(keyVal))
		{
			return dpMap.get(keyVal);
		}
		result = binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
		dpMap.put(keyVal, result);
		return result;
	}
	public static void main(String[] args) {
		
		BinomialCoefficientDP bcdp = new BinomialCoefficientDP();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println("Binomial Coefficient of "+n+" and "+k+" :"+bcdp.binomialCoefficient(n, k));
		System.out.println(bcdp.dpMap);
	}
}
