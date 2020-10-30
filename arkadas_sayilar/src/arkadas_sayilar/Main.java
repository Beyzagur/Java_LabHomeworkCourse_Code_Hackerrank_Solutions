package arkadas_sayilar;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int sum1 = 0;
		int sum2 = 0;

		try {
			System.out.print("L�tfen birinci say�y� giriniz: ");
			int number1 = scn.nextInt();

			System.out.print("L�tden ikinci say�y� giriniz: ");
			int number2 = scn.nextInt();

			for (int i = 1; i < number1; i++) {
				if (number1 % i == 0) {
					sum1 = sum1 + i;
				}

			}
			
			for (int i = 1; i < number2; i++) {
				if (number2 % i == 0) {
					sum2 = sum2 + i;
				}
			}
			
			if(number1==sum2 && number2==sum1) {
				System.out.println("\nBu iki say� arkada� say�d�r.");
			}
			else {
				System.out.println("\nBu iki say� arkada� say� de�ildir.");
			}
			
			System.out.println("\n*** En k���k arkada� say� �ifti 220 ve 284't�r. ");

		} catch (Exception e) {
			System.out.println("Say� girmediniz!");
		}

	}

}
