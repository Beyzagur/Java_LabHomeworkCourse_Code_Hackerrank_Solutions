package JavaLoops1;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int result = 0;

		if (2 <= n && n <= 20) {

			for (int i = 1; i < 11; i++) {
				result = n * i;
				System.out.println(n + " x " + i + " = " + result);
			}
		}

	}
}
