/**
 * 
 */
package com.java.dynamicProgramming;

/**
 * @author Rana Ashish
 *
 */
public class FebonacciMemoization {

	int MAX = 100;
	int LOOKUP[] = new int[MAX];
	int NIL = -1;
	
	private void initialize()
	{
		for(int i = 0; i < MAX; i++)
		{
			LOOKUP[i] = NIL;
		}
	}
	
	// Function for nth fibonacci series 0 1 1 2 3 5 8
	int fib(int n)
	{
		if (LOOKUP[n] == NIL) 
		{
			if(n <= 1)
			{
				LOOKUP[n] = n;
			}
			else
			{
				LOOKUP[n] = fib(n-1) + fib(n-2);
			}
		}
		return LOOKUP[n];
	}
	
	public static void main(String[] args) {
		
		FebonacciMemoization fm = new FebonacciMemoization();
		int n = 70;
		fm.initialize();
		System.out.println("Fibonacci Number is: " +fm.fib(n));
		
	}

}
