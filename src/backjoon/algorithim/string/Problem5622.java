package backjoon.algorithim.string;

import java.util.Scanner;

public class Problem5622 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] num = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };
		int sum = 0;
		String str = scanner.nextLine();
		for (int i = 0; i < str.length(); i++) {
			sum += num[(int) (str.charAt(i) - 'A')] + 1;
		}
		System.out.println(sum);

	}
}
