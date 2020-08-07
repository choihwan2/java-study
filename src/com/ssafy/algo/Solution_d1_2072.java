package com.ssafy.algo;

import java.util.Scanner;

public class Solution_d1_2072 {
	static int T;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int t = 1; t <= T; t++) {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int input = scanner.nextInt();
				if (input % 2 == 1)
					sum += input;
			}

			System.out.println("#" + t + " " + sum);
		}
	}
}
