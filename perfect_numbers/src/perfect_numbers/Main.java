package perfect_numbers;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int sum = 0;

		System.out.print("Please enter a number: ");
		try {
			int number = scn.nextInt();

			for (int i = 1; i < number; i++) {
				if (number % i == 0) {
					sum = sum + i;
				}

			}

			if (sum == number) {
				System.out.println("The number entered is a perfect number.");
			} else {
				System.out.println("The number entered is not a perfect number.");

			}

		} catch (Exception e) {
			System.out.println("You did not enter a number.");
		}

	}

}
