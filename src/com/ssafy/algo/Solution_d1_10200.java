package com.ssafy.algo;

import java.util.Scanner;

public class Solution_d1_10200 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int iT = scanner.nextInt();
		for (int t = 1; t <= iT; t++) {
			int N = scanner.nextInt();
			int A = scanner.nextInt();
			int B = scanner.nextInt();

			int min = A + B - N > 0 ? A + B - N : 0;
			int max = Math.min(A, B);

			System.out.println("#" + t + " " + max + " " + min);
		}
	}
}
