package com.ssafy.day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636_Cheese {
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		map = new int[N][M];
		int maxCnt = 0;
		int index = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (map[i][j] == 1)
					maxCnt++;
			}
		}
		while (maxCnt > 0) {
			answer = makeAir();
			index++;
			maxCnt -= answer;
		}
		System.out.println(index);
		System.out.println(answer);
	}

	private static int makeAir() {
		Queue<Integer> que = new LinkedList<Integer>();
		isVisited = new boolean[N][M];
		int cnt = 0;
		que.add(0);
		que.add(0);
		isVisited[0][0] = true;
		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for (int i = 0; i < 4; i++) {
				int mX = x + dx[i];
				int mY = y + dy[i];
				if (isInMap(mX, mY) && map[mX][mY] == 0 && !isVisited[mX][mY]) {
					isVisited[mX][mY] = true;
					que.add(mX);
					que.add(mY);
				} else if (isInMap(mX, mY) && map[mX][mY] == 1) {
					map[mX][mY] = 2;
					cnt++;
				}
			}
		}
		deleteCheese();
		return cnt;
	}

	private static void deleteCheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2)
					map[i][j] = 0;
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
