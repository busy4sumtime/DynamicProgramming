package com.java.dynamicProgramming;

import java.util.Scanner;

public class PermutationCoefficientDP {

	int permutationCoefficient(int n, int k) {
		
		int Fn = 1, Fk = 1; 
	      
        // Compute n! and (n-k)! 
        for (int i = 1; i <= n; i++) 
        { 
            Fn *= i; 
            if (i == n - k) 
            Fk = Fn; 
        } 
        int coeff = Fn / Fk; 
        return coeff; 
	}
	public static void main(String[] args) {
		PermutationCoefficientDP pcdp = new PermutationCoefficientDP();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println("Permutation Coefficient of "+n+" and "+k+" :"+pcdp.permutationCoefficient(n, k));
	}
}
