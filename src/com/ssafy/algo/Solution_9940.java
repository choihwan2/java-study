package com.ssafy.algo;

import java.util.Scanner;

public class Solution_9940 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int iT = scanner.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = scanner.nextInt();
			int[] permutationArr = new int[N + 1];
			boolean isPermu = true;
			for (int j = 0; j < N; j++) {
				permutationArr[scanner.nextInt()]++;
			}

			for (int k = 1; k <= N; k++) {
				if (permutationArr[k] != 1) {
					isPermu = false;
					break;
				}
			}

			if (isPermu)
				System.out.println("#" + i + " Yes");
			else
				System.out.println("#" + i + " No");
		}
		scanner.close();

	}
}
