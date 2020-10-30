package arkadas_sayilar;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int sum1 = 0;
		int sum2 = 0;

		try {
			System.out.print("Lütfen birinci sayýyý giriniz: ");
			int number1 = scn.nextInt();

			System.out.print("Lütden ikinci sayýyý giriniz: ");
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
				System.out.println("\nBu iki sayý arkadaþ sayýdýr.");
			}
			else {
				System.out.println("\nBu iki sayý arkadaþ sayý deðildir.");
			}
			
			System.out.println("\n*** En küçük arkadaþ sayý çifti 220 ve 284'tür. ");

		} catch (Exception e) {
			System.out.println("Sayý girmediniz!");
		}

	}

}
