package baekjoon.algorithm.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BallOnChessboard {

	static final int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static final int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[][] map;
	static int[] mapGo;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		map = new int[N][M];
		mapGo = new int[N * M + 1];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		Arrays.fill(mapGo, -1);
		
	}

	public static int whereGo(int x, int y) {
		int go = map[x].length * x + y;
		int now = map[x][y];
		for (int i = 0; i < 8; i++) {
			int tX = x + dx[i];
			int tY = y + dy[i];
			if (tX >= 0 && tX < N && tY >= 0 && tY < M) {
				int temp = map[tX][tY];
				if (now > temp) {
					now = temp;
					go = map[x].length * y + tY;
				}
			}
		}

		return go;
	}
}
