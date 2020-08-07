package com.ssafy.day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638_Cheese3 {
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int maxCnt = 0;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		map = new int[N][M];
		int index = 0;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (map[i][j] == 1)
					maxCnt++;
			}
		}

		while (maxCnt > 0) {
			index++;
			makeAir();
			checkCheese();
		}
		System.out.println(index);
	}

	private static void makeAir() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(0);
		que.add(0);
		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for (int i = 0; i < 4; i++) {
				int mX = x + dx[i];
				int mY = y + dy[i];
				if (isInMap(mX, mY) && map[mX][mY] == 0) {
					map[mX][mY] = -1;
					que.add(mX);
					que.add(mY);
				} else if (isInMap(mX, mY) && map[mX][mY] > 0) {
					map[mX][mY]++;
				}
			}
		}
	}

	private static void checkCheese() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= 3) {
					map[i][j] = 0;
					maxCnt--;
				} else if (map[i][j] == -1) {
					map[i][j] = 0;
				} else if (map[i][j] == 2) {
					map[i][j] = 1;
				}
			}
		}
	}

	private static boolean isInMap(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		else {
			return false;
		}
	}
}
