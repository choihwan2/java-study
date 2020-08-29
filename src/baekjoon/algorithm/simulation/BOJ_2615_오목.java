package baekjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
	static final int SIZE = 19, BLACK = 1, WHITE = 2, NONE = 0;

	// 방향 아래 오른쪽 왼쪽아래 오른쪽위
	static final int[][] DIR = { { 1, 0 }, { 0, 1 }, { 1, 1 }, { -1, 1 } };

	// 정답
	static int winner, endR, endC;

	static boolean[][] isVisited = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int[][] map = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			checkMap(map, i);
		}
		checkUpRightMap(map);
		System.out.println(winner);
		if (winner != 0) {
			System.out.println(endR + " " + endC);
		}
	}

	private static void checkMap(int[][] map, int d) {
		isVisited = new boolean[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (map[r][c] == 1 || map[r][c] == 2) {
					if(isVisited[r][c]) continue;
					isVisited[r][c] = true;
					int now = map[r][c];
					int nr = r + DIR[d][0];
					int nc = c + DIR[d][1];
					int cnt = 1;
					while (isInMap(nr, nc) && map[nr][nc] == now) {
						isVisited[nr][nc] = true;
						cnt++;
						nr += DIR[d][0];
						nc += DIR[d][1];
					}
					if (cnt == 5) {
						winner = now;
						endR = r + 1;
						endC = c + 1;
					}
				}
			}
		}
	}
	
	private static void checkUpRightMap(int[][] map) {
		isVisited = new boolean[SIZE][SIZE];
		for (int r = SIZE -1; r > 0 ; r--) {
			for (int c = 0; c < SIZE; c++) {
				if (map[r][c] == 1 || map[r][c] == 2) {
					if(isVisited[r][c]) continue;
					isVisited[r][c] = true;
					int now = map[r][c];
					int nr = r + DIR[3][0];
					int nc = c + DIR[3][1];
					int cnt = 1;
					while (isInMap(nr, nc) && map[nr][nc] == now) {
						isVisited[nr][nc] = true;
						cnt++;
						nr += DIR[3][0];
						nc += DIR[3][1];
					}
					if (cnt == 5) {
						winner = now;
						endR = r + 1;
						endC = c + 1;
					}
				}
			}
		}
	}

	private static boolean isInMap(int nr, int nc) {
		if (nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE) {
			return true;
		} else {
			return false;
		}
	}

}
