package com.ssafy.day0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {
	static final int SIZE = 100;
	static final int[] dx = { 0, 0, -1 }, dy = { -1, 1, 0 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			String trash = br.readLine();
			map = new int[SIZE][SIZE];
			int x = 99, y = 0;
			for (int i = 0; i < SIZE; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < SIZE; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
					if (map[i][j] == 2)
						y = j;
				}
			}
			y = getY(y);
			System.out.println("#" + t + " " + y);
		}
	}

	private static int getY(int y) {
		int x = 99;
		while (x-- > 0) {
			if (y - 1 >= 0 && map[x][y - 1] == 1)
				while (y - 1 >= 0 && map[x][y - 1] == 1)
					y--;
			else if (y + 1 < SIZE && map[x][y + 1] == 1)
				while (y + 1 < SIZE && map[x][y + 1] == 1)
					y++;

		}
		return y;
	}

}
