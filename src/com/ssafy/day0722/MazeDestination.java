package com.ssafy.day0722;

import java.util.Scanner;

public class MazeDestination {
	static final int[] dx = { 0, -1, 0, 1, 0 }, dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int jumperNum = sc.nextInt();
			boolean[][] jumperMap = new boolean[N + 1][N + 1];
			boolean isEscape = false;
			for (int j = 0; j < jumperNum; j++) {
				int jumpX = sc.nextInt();
				int jumpY = sc.nextInt();
				jumperMap[jumpX][jumpY] = true;
			}
			int moveNum = sc.nextInt();
			for (int k = 0; k < moveNum; k++) {
				int dir = sc.nextInt();
				int repeatN = sc.nextInt();
				// 탈출했다면  그만할래..
				if (!isEscape) {
					for (int m = 0; m < repeatN; m++) {
						if (x + dx[dir] > 0 && x + dx[dir] < N + 1 && y + dy[dir] > 0 && y + dy[dir] < N + 1
								&& !jumperMap[x + dx[dir]][y + dy[dir]]) {
							x += dx[dir];
							y += dy[dir];
						} else {
							x = 0;
							y = 0;
							isEscape = true;
							break;
						}
					}
				}
			}
			System.out.println("#" + i + " " + x + " " + y);
		}
	}
}
