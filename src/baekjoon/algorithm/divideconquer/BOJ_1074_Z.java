package baekjoon.algorithm.divideconquer;

import java.util.Scanner;

public class BOJ_1074_Z {
	static int[] dx = { 0, 0, 1, 1 }, dy = { 0, 1, 0, 1 };
	static int endR, endC;
	static long answer = 0L,index = 0L;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		endR = sc.nextInt();
		endC = sc.nextInt();
		n = (int) Math.pow(2, n);

		divide(0, 0, n);
		System.out.println(answer);
	}

	private static void divide(int r, int c, int s) {
		if (answer != 0)
			return;
		if (s == 2) {
			check(r, c);
		} else {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(r + i * s / 2, c + j * s / 2, s / 2);
				}
			}
		}
	}

	private static void check(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int dR = r + dx[i];
			int dC = c + dy[i];
			if (dR == endR && dC == endC) {
				answer = index;
				return;
			} else {
				index++;
			}

		}
	}
}
