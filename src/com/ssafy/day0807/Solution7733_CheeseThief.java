package com.ssafy.day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7733_CheeseThief {
	static int max, N, answer;
	static int[][] map;
	static boolean[][] isMelt;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		for (int t = 1; t <= iT; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			isMelt = new boolean[N][N];
			max = N * N;
			answer = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}

			for (int day = 0; day <= 100; day++) {
				meltCheese(day);
				initMelt();
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] != 0 && isMelt[i][j] == false) {
							makeCheese(i, j);
							cnt++;
						}
					}
				}
				answer = Math.max(answer, cnt);
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void meltCheese(int day) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				if (map[i][j] <= day) {
					max--;
					map[i][j] = 0;
				}
			}
		}
	}

	private static void makeCheese(int i, int j) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(i);
		que.add(j);
		isMelt[i][j] = true;
		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for (int k = 0; k < 4; k++) {
				int mX = x + dx[k];
				int mY = y + dy[k];
				if (isInMap(mX, mY) && isMelt[mX][mY] == false && map[mX][mY] > 0) {
					isMelt[mX][mY] = true;
					que.add(mX);
					que.add(mY);
				}
			}
		}
	}

	private static boolean isInMap(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N) {
			return true;
		} else
			return false;
	}

	private static void initMelt() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(isMelt[i], false);
		}
	}
}
