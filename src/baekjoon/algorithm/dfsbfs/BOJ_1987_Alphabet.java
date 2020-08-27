package baekjoon.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_Alphabet {
	static int R, C, answer;
	static char[][] map;
	static final int MAX_SIZE = 26;
	static boolean[] isVisited;

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		map = new char[R][];
		isVisited = new boolean[MAX_SIZE];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		isVisited[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(answer);
	}

	private static void dfs(int r, int c, int cnt) {
		answer = Math.max(cnt, answer);
		if (answer == MAX_SIZE) {
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (!isInMap(nr, nc) || isVisited[map[nr][nc] - 'A'])
				continue;
			isVisited[map[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt + 1);
			isVisited[map[nr][nc] - 'A'] = false;
		}
	}

	private static boolean isInMap(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) {
			return true;
		} else {
			return false;
		}
	}
}
