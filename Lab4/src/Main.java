import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1.Question
		/*
		 * Write a main program that - inserts randomly generated 10 numbers (between 12
		 * and 32) into a stack - prints the content of the stack - take an integer from
		 * the user, search this integer in the stack and determine whether it exists or
		 * not. (At the end of the program, the stack must be the same)
		 * 
		 * You must use ONLY stack(s), don’t use other data structures such as pure
		 * array structure, string etc.
		 */

		System.out.println("------ 1. Question ------");
		Stack s = new Stack(10);

		Random rnd = new Random();

		for (int i = 0; i < 10; i++)
			s.push(rnd.nextInt(21) + 12);

		Stack tempstack = new Stack(10);

		while (!(s.isEmpty())) {
			System.out.println(s.peek());
			tempstack.push(s.pop());
		}

		while (!(tempstack.isEmpty()))
			s.push(tempstack.pop());

		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number:");
		int number = scn.nextInt();

		boolean isFound = false;

		while (!(s.isEmpty())) {
			if ((int) s.peek() == number) {
				isFound = true;
				break;
			} else
				tempstack.push(s.pop());
		}

		while (!(tempstack.isEmpty()))
			s.push(tempstack.pop());

		System.out.println(isFound);

		// 2.Question
		/*
		 * Write a main program that takes a decimal number from the user and then
		 * displays its octal equivalent by using a stack. You must use ONLY stack(s),
		 * don’t use other data structures such as normal array, string etc. Example:
		 * Input: 4321 (decimal) Output: 10341 (octal)
		 */

		System.out.println("\n------ 2. Question ------");
		// Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number:");
		int num = scn.nextInt();

		Stack stc = new Stack(12);
		int temp = 0;

		while (num >= 8) {
			temp = num % 8;
			num = num / 8;
			stc.push(temp);
		}

		stc.push(num);

		while (!(stc.isEmpty())) {
			System.out.print(stc.pop());
		}

		// 3.Question
		/*- Write a main program that removes the numbers which occur more than once. 
		 * In other words, only one copy of each number should appear in the same stack.
		 * You must ONLY use stack data structure.  Don’t use other data structures like normal array or string.
		 */

		System.out.println("\n\n------ 3. Question ------");
		Stack mainStack = new Stack(10);
		Stack tempStack = new Stack(10);
		Stack taken = new Stack(10);

		mainStack.push(7);
		mainStack.push(8);
		mainStack.push(2);
		mainStack.push(8);
		mainStack.push(8);
		mainStack.push(2);
		mainStack.push(8);
		mainStack.push(7);
		mainStack.push(4);
		mainStack.push(4);

		System.out.println("Before: ");
		while (!(mainStack.isEmpty())) {
			System.out.print(mainStack.peek() + " ");
			tempStack.push(mainStack.pop());
		}
		while (!(tempStack.isEmpty())) {
			mainStack.push(tempStack.pop());
		}

		while (!(mainStack.isEmpty())) {
			int element = (int) mainStack.peek();
			while (!(mainStack.isEmpty())) {
				if (element == (int) mainStack.peek())
					mainStack.pop();
				else
					tempStack.push(mainStack.pop());
			}
			while (!(tempStack.isEmpty())) {
				mainStack.push(tempStack.pop());
			}
			taken.push(element);
		}
		while (!(taken.isEmpty())) {
			mainStack.push((int) taken.pop());
		}
		System.out.println();
		System.out.println("After: ");
		while (!(mainStack.isEmpty())) {
			System.out.print(mainStack.pop() + " ");
		}

	}

}
