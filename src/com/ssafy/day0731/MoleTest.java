package com.ssafy.day0731;

import java.util.Arrays;
import java.util.Scanner;

public class MoleTest {
	static int N;
	static int[][] map;
	static int[] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		count = new int[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					dfs(i, j, cnt + 1);
				}
			}
		}
		printMap();
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	private static void dfs(int r, int c, int ct) {
		map[r][c] = ct;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isInMap(nr, nc) && map[nr][nc] == 1) {
				dfs(nr, nc, ct);
			}
		}
	}

	private static boolean isInMap(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N) {
			return true;
		} else {
			return false;
		}
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

	}
}
