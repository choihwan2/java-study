package baekjoon.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2186_문자판2 {
	static int N, M, K, move[][][], answer;
	static char[][] map;
	static char[] input;

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		map = new char[N][];
		move = new int[100][N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Queue<int[]> que = new LinkedList<>();

		input = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == input[0]) {
					que.add(new int[] { i, j });
				}
			}
		}

		while (!que.isEmpty()) {
			int[] start = que.poll();
			answer += dfs(start, 0);
		}
		System.out.println(answer);

	}

	private static int dfs(int[] start, int cnt) {
		int x = start[0];
		int y = start[1];

		if (cnt + 1 == input.length) {
			move[cnt][x][y] = 1;
			return 1;
		}

		int temp = 0;

		for (int k = 1; k <= K; k++) {
			for (int d = 0; d < 4; d++) {
				int mX = x + dr[d] * k;
				int mY = y + dc[d] * k;
				if (isInMap(mX, mY) && map[mX][mY] == input[cnt + 1]) {
					if (move[cnt + 1][mX][mY] == -1)
						continue;
					if (move[cnt + 1][mX][mY] != 0) {
						temp += move[cnt + 1][mX][mY];
						continue;
					} else {
						temp += dfs(new int[] { mX, mY }, cnt + 1);
					}
				}
			}
		}
		if(temp == 0) {
			move[cnt][x][y] = -1;
			return 0;
		}
		move[cnt][x][y] = temp;
		return move[cnt][x][y];

	}

	private static boolean isInMap(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		} else {
			return false;
		}
	}
}
