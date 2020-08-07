package com.ssafy.day0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468_SafeArea {
	static int N, map[][];
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int answer = 0;
		int day = 0;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				day = Math.max(day, map[i][j]);
			}
		}

		for (int i = 0; i <= day; i++) {
			boolean[][] isSinked = new boolean[N][N];
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] > i && isSinked[r][c] == false) {
						makeLand(r, c, i, isSinked);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

	private static void makeLand(int r, int c, int day, boolean[][] isSinked) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(r);
		que.add(c);
		isSinked[r][c] = true;
		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for (int i = 0; i < 4; i++) {
				int mX = x + dx[i];
				int mY = y + dy[i];
				if (mX >= 0 && mX < N && mY >= 0 && mY < N && map[mX][mY] > day && isSinked[mX][mY] == false) {
					isSinked[mX][mY] = true;
					que.add(mX);
					que.add(mY);
				}
			}
		}
	}

}
