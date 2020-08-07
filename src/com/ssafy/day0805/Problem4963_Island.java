package com.ssafy.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem4963_Island {
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 }, dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int w, h;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		while (true) {
			stk = new StringTokenizer(br.readLine());
			w = Integer.parseInt(stk.nextToken());
			h = Integer.parseInt(stk.nextToken());
			if (w == 0 && h == 0)
				break;
			map = new char[h][w];
			for (int r = 0; r < h; r++) {
				stk = new StringTokenizer(br.readLine());
				for (int c = 0; c < w; c++) {
					map[r][c] = stk.nextToken().charAt(0);
				}
			}
			int islandCnt = 0;
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (map[r][c] == '1') {
						++islandCnt;
						makeIsland(r, c);
					}
				}
			}
			System.out.println(islandCnt);
		}
	}

	private static void makeIsland(int r, int c) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(r);
		que.add(c);
		map[r][c] = '2';
		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for (int i = 0; i < 8; i++) {
				int mX = x + dx[i];
				int mY = y + dy[i];
				if (isInMap(mX, mY) && map[mX][mY] == '1') {
					que.add(mX);
					que.add(mY);
					map[mX][mY] = '2';
				}
			}
		}

	}

	private static boolean isInMap(int x, int y) {
		if (x >= 0 && x < h && y >= 0 && y < w) {
			return true;
		} else {
			return false;
		}
	}

}
