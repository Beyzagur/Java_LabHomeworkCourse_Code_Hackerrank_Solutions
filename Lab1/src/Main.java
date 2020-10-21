import java.util.*;

public class Main {

	//3. Question
	public static double std(int numbers[]) {
		double sd=0;
		double average=0;
		
		for (int i = 0; i < numbers.length; i++) {
			average+=numbers[i];
		}
		
		average= average /numbers.length;
		
		for (int i = 0; i < numbers.length; i++) {
			sd+=Math.pow((numbers[i]-average), 2) / numbers.length;
		}
		
		sd=Math.sqrt(sd);
		return sd;
	}
	
	//6. Question
	static int cube(int x)
	{
		return x * x * x;
	}
	
	static int sumofcubes(int n)
	{
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + cube(i);
		}
		return sum;
	}
	
	
	
	//
	public static void main(String[] args) {
		// If-Then Question
		//1- Write a java program that takes three integer values x, y, and z from the user, 
		//then prints true if the values are strictly ascending or descending (x < y < z or x > y > z), and false otherwise.
		System.out.println("------ 1. Question ------");
		
		Scanner scanner= new Scanner(System.in);
		System.out.print("Enter x:");
		int x=scanner.nextInt();
		System.out.print("Enter y:");
		int y=scanner.nextInt();
		System.out.print("Enter z:");
		int z=scanner.nextInt();
		
		if(x>y && y>z) {
			System.out.println("true");
		}
		else if(z>y && y>x) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
		//Loop Question
		//2- Write a java program that prints the following shape by using nested loops. 
		/*
		 	 *                             
		 	***                           
		   *****                         
	      *******                       
	     *********   
	    ***********
	    
	    */

		System.out.println("\n------ 2. Question ------");
		
		int spaces=5;
		int stars=1;
		int lines=6;
		
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < spaces; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < stars; j++) {
				System.out.print("*");
			}
			System.out.println();
			stars+=2;
			spaces--;
		}
		
		//Array Questions
		//3- Write a java program that finds the standard deviation of an array. 
		System.out.println("\n------ 3. Question ------");
		
		int[] a =new int[] {3,12,9,4,2};
		System.out.println(std(a));
		
		//4- Write a program that determines a given matrix is a scalar matrix or not.  
		//Scalar matrix is a diagonal matrix in which all of the diagonal elements are equal.
		System.out.println("\n------ 4. Question ------");
		
		int[][] matrix = new int[][]{{5,0,0,0,0,0},
									{0,5,0,0,0,0},
									{0,0,5,0,0,0},
									{0,0,0,5,0,0},
									{0,0,0,0,5,0},
									{0,0,0,0,0,5}};
	
		boolean flag=true;
		if(matrix.length !=matrix[0].length) {
			flag=false;
		}
		else {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if((i==j) && (matrix[i][j] != matrix[0][0])) {
						flag=false;
					}
					if((i!=j) && (matrix[i][j] != 0)) {
						flag=false;
					}
				}
				if(!flag) {
					break;
				}
			}
		}
		System.out.println(flag);				

		//String Question
		//5-Write a Java program that displays plural form of each word in the text.
		//instead of “y”,    add "ies”
		//instead of “s”, “c”, “ch”, or “sh”,     add “es”
		//all other cases,    add “s”

		System.out.println("\n------ 5. Question ------");
		
		String str = "bus city country girl";
		String[] words = str.split(" ");
				
		for (int i = 0; i < words.length; i++) {
		   if (words[i].substring(words[i].length() -1 , words[i].length()).equals("y")) 
			System.out.print(words[i].substring(0, words[i].length() - 1) + "ies" + " ");
		   else if(words[i].substring(words[i].length() - 1, words[i].length()).equals("s")) 
			System.out.print(words[i] + "es" + " ");
		   else if(words[i].substring(words[i].length() - 1, words[i].length()).equals("c")) 
		 	System.out.print(words[i] + "es" + " ");
		   else if(words[i].substring(words[i].length() - 2, words[i].length()).equals("ch")) 
			System.out.print(words[i] + "es" + " ");
		   else if(words[i].substring(words[i].length() - 2, words[i].length()).equals("sh")) 
			System.out.print(words[i] + "es" + " ");
		   else 
			System.out.print(words[i] + "s" + " ");
		}
		
		//Function Question
		//6-Write a cube(x) function that calculates x*x*x. 
		//Write a sumofcubes(n) function that calculates the sum of 1 cubed + 2 cubed + ... + n cubed. 
		//Write a main program that takes a number (n) from the user and calls sumofcubes(n) function.

		System.out.println("\n\n------ 6. Question ------");
		
		   // Scanner scanner = new Scanner( System.in); //If you are going to solve the questions separately, you should write this down. 
		                                                 //You used it in the first question and you cannot write this because you are continuing with the same project.
		System.out.print("Enter n:");
		int n = scanner.nextInt();
		    
		System.out.println(sumofcubes(n));		

	}

}
