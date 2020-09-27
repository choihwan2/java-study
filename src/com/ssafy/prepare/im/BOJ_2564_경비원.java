package com.ssafy.prepare.im;

import java.util.Scanner;

public class BOJ_2564_경비원 {
	static int R, C, playerR, playerC;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		int[][] map = new int[R + 1][C + 1];

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int dir = sc.nextInt();
			int pos = sc.nextInt();
			marking(dir, pos, map, 1);
		}
		int xDir = sc.nextInt();
		int xPos = sc.nextInt();
		marking(xDir, xPos, map, 2);

		System.out.println("");
	}

	private static void marking(int dir, int pos, int[][] map, int value) {
		int r = 0;
		int c = 0;
		if (dir == 1) {
			r = 0;
			c = pos;
		} else if (dir == 2) {
			r = R;
			c = pos;
		} else if (dir == 3) {
			r = pos;
			c = 0;
		} else if (dir == 4) {
			r = pos;
			c = C;
		}

		if (value == 2) {
			playerR = r;
			playerC = c;
		}

		map[r][c] = value;
	}
}
