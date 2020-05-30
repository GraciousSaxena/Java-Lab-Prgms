/*

String Handling 

i)	 Write a Java program to find the penultimate (next to last) word of a sentence.
ii)	 Write program to replace a string "python" with "java" and "java" with "python" in a given string.
iii) Write a program that splits a string into a number of substrings with the help of string split() method and then 
	 prints the substrings.

*/

package stringHandling;

import java.util.*;
public class replace {
	public static void main(String[] args) {
		System.out.println("Enter the sentence: ");
		Scanner in = new Scanner(System.in);

		String inp = in.nextLine();
		
		in.close();
		
		String words[] = inp.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (words[i].toLowerCase().equals("java"))
				words[i] = "Python";
			else if (words[i].toLowerCase().equals("python"))
				words[i] = "Java";

			System.out.print(words[i] + " ");
		}
	}
}
