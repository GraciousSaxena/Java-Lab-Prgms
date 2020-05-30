
//				MY PROGRAM

package prgm8;

import java.util.Scanner;

/*

Write the following methods that return a lambda expression performing a specified action:

(i) 	PerformOperation isOdd(): The lambda expression must return true if a number is odd
		or false if it is even.
(ii) 	PerformOperation isPrime(): The lambda expression must return true if a number is
		prime or false if it is composite.
(iii) 	PerformOperation isPalindrome(): The lambda expression must return true if a
		number is a palindrome or false if it is not.

Write a JAVA program using above lambda expressions to take 2 integers as input where the first integer specifies the 
condition to check for (case 1 for Odd/Even, case 2 for
Prime/Composite, or case 3 for Palindrome). The second integer denotes the number to be
checked.

*/

interface PerformOperation {
	boolean operation(int x);
}

public class prgm8 {
	public static void main(String[] args) {
		PerformOperation isOdd = (int a)-> a%2 != 0;
		PerformOperation isPrime = (int a)->{
			for(int i=2; i<=a/2; i++)
				if(a%i==0)
					return false;
			return true;
		};
		PerformOperation isPalindrome = (int a)->{
			int n = 0, t=a;
			while(t>0) {
				n *= 10;
				n += t%10;
				t /= 10;
			}
			return n == a;
		};
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			int ch=0, n=0;
			ch = in.nextInt();
			n = in.nextInt();
			
			switch(ch) {
				case 1: System.out.println("isOdd " + isOdd.operation(n));
						break;
				case 2: System.out.println("isPrime " + isPrime.operation(n));
						break;
				case 3: System.out.println("isPalin " + isPalindrome.operation(n));
						break;
				default: System.exit(1);
			}			
		}
	}
}




/*
				NOT MY PROGRAM
			
package LambdaExpressions;

import java.io.*;
import java.util.*;

interface Operation {
	int check(int n);
}

class Op {
	public int tester(Operation p, int n) {
		return p.check(n);
	}

	Operation Even() {
		Operation p = (a)-> {return a & 1;};
		return p;
	}

	Operation Prime() {
		Operation p = (a)-> {
			if (a == 1)
				return 0;
			boolean ok = true;

			for (int i = 2; i <= a / 2; i++) {
				if (a % i == 0) {
					ok = false;
					break;
				}
			}
			return (ok ? 1 : 0);
		};

		return p;
	}

	Operation Pdrome() {
		Operation p = (a)-> {
			String num = "" + a;
			boolean ok = true;
			int n = num.length();

			for (int i = 0; i < n / 2; i++) {
				if (num.charAt(i) != num.charAt(n - i - 1)) {
					ok = false;
					break;
				}
			}
			return (ok ? 1 : 0);
		};

		return p;
	}
}

public class Main {
	public static void main(String args[]) throws IOException {
		System.out.println("Lambda Expressions  \r\n" + 
				"\r\n" + 
				"Write the following methods that return a lambda expression performing a specified action:\r\n" + 
				"(i) PerformOperation isOdd(): The lambda expression must return true if a number is odd\r\n" + 
				"or false if it is even.\r\n" + 
				"(ii) PerformOperation isPrime(): The lambda expression must return true if a number is\r\n" + 
				"prime or false if it is composite.\r\n" + 
				"(iii) PerformOperation isPalindrome(): The lambda expression must return true if a\r\n" + 
				"number is a palindrome or false if it is not.\r\n" + 
				"Write a JAVA program using above lambda expressions to take 2 integers as input where the first integer specifies the condition to check for (case 1 for Odd/Even, case 2 for\r\n" + 
				"Prime/Composite, or case 3 for Palindrome). The second integer denotes the number to be\r\n" + 
				"checked.\r\n" + 
				"\r\n" + 
				"");
		Op obj = new Op();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the number of testcases: ");
		int tc = Integer.parseInt(br.readLine());

		Operation p;

		int retval = 0;
		String ans = null;

		System.out.println("1. Even/Odd Parity \t 2. Prime or not \t 3. Palindrome or not");

		while (tc-- > 0) {
			System.out.println("Input the choice and the operand separated by spaces: ");

			String inp = br.readLine().trim();

			StringTokenizer str = new StringTokenizer(inp);

			int choice = Integer.parseInt(str.nextToken());
			int number = Integer.parseInt(str.nextToken());

			switch (choice) {
				case 1:
					p = obj.Even();
					retval = obj.tester(p, number);
					ans = (retval == 1 ? "Number is Odd..." : "Number is Even...");
					break;
				case 2:
					p = obj.Prime();
					retval = obj.tester(p, number);
					ans = (retval == 1 ? "Number is prime..." : "Number is not prime!!!");
					break;
				case 3:
					p = obj.Pdrome();
					retval = obj.tester(p, number);
					ans = (retval == 1 ? "Number is a palindrome..." : "Number is not a palindrome!!!");
			}

			System.out.println(ans);
		}
	}
}
*/
