package com.ssafy.day0722;

import java.util.Scanner;

public class WaterStrider {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int striderNum = sc.nextInt();
			boolean[][] isJumpMap = new boolean[N][N];
			int winner = 0;
			for (int j = 1; j <= striderNum; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt();
				if (winner == 0) {
					for (int m = 3; m > 0; m--) {
						if (isJumpMap[x][y]) {
							winner = j;
							break;
						}
						isJumpMap[x][y] = true;
						if (dir == 2) {
							if (y + m < N)
								y += m;
							else
								break;
						} else {
							if (x + m < N)
								x += m;
							else
								break;
						}
					}
				}

			}
			System.out.println("#" + i + " " + winner);
		}
	}
}
