package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution13_2 {
	public static int N, iT;
	public static char[][] build;
	public static int max = -1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		iT = Integer.parseInt(br.readLine().trim());
		for (int T = 1; T <= iT; T++) {
			max = 0;
			N = Integer.parseInt(br.readLine().trim());
			build = new char[N + 2][N + 2];
			for (int i = 0; i < build.length; i++) {
				Arrays.fill(build[i], 'B');
			}
			for (int i = 1; i < build.length - 1; i++) {
				String lines = br.readLine();
				String[] bc = lines.split(" ");
				for (int j = 0; j < bc.length; j++) {
					build[i][j + 1] = bc[j].charAt(0);
				}
			}
			// print(build);
			for (int r = 1; r < build.length - 1; r++) {
				for (int c = 1; c < build.length - 1; c++) {
					if (build[r][c] == 'B')
						max = Math.max(max, go(r, c));
				}
			}
			System.out.printf("#%d %d\n", T, max);
		}

	}

	public static int count(int r, int c) {
		int count = 0;
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int i = 0; i < dc.length; i++) {
			if (r >= 1 && r <= N && c >= 1 && c <= N) {
				if (build[r + dr[i]][c + dc[i]] == 'B') {
					count++;
				}
			}
		}
		return count;
	}

	private static int go(int x, int y) {
		int cnt = 0;
		if (count(x, y) == 8) {
			cnt = width(x, y) + height(x, y) - 1;
		} else {
			cnt = 2;
		}
		return cnt;
	}

	private static int width(int x, int y) {
		int tot = 0;
		for (int i = 1; i < build.length - 1; i++) {
			if (build[x][i] == 'B') {
				tot++;
			}
		}
		return tot;
	}

	private static int height(int x, int y) {
		int tot = 0;
		for (int i = 1; i < build.length - 1; i++) {
			if (build[i][y] == 'B') {
				tot++;
			}
		}
		return tot;
	}

	public static void print(char[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.printf("%c ", b[i][j]);
			}
			System.out.println();
		}
	}
}
