package baekjoon.algorithm.string;

import java.util.Scanner;

public class Problem2675 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < a; i++) {
			int num = scanner.nextInt();
			String str = scanner.next();
			for (int j = 0; j < str.length(); j++) {
				for (int z = 0; z < num; z++) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
