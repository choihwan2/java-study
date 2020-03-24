package selftest.java.datastructure.recursive;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		while (a % b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		System.out.println(b);
	}

}
