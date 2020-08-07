package com.ssafy.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4012_Cook {
	static int N;
	static int min;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			boolean[] isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			StringTokenizer stk = null;
			for (int r = 0; r < N; r++) {
				stk = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(stk.nextToken());
				}
			}
			combination(0, 0, isSelected);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void combination(int start, int selectNum, boolean[] isSelected) {
		if (selectNum > N / 2)
			return;
		if (start == N && selectNum == N / 2) {
			int t1 = 0;
			int t2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isSelected[i] && isSelected[j]) {
						t1 += map[i][j];
					} else if (!isSelected[i] && !isSelected[j]) {
						t2 += map[i][j];
					}
				}
			}
			int sum = Math.abs(t1 - t2);
			min = Math.min(min, sum);
			return;
		}
		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			combination(i + 1, selectNum + 1, isSelected);
			isSelected[i] = false;
		}
	}
}
