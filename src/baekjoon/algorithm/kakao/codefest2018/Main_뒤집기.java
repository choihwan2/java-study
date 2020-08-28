package baekjoon.algorithm.kakao.codefest2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_뒤집기 {
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int R, C, checkMap[][];
	static boolean[][] isVisited;
	static char[][] map;
	static final int DIV = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		map = new char[R][];
		isVisited = new boolean[R][C];
		checkMap = new int[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(checkMap[i], 1);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!isVisited[i][j]) {
					bfs(i, j);
				}
			}
		}

		int temp = getCnt();
		int answer = getAnswer(temp);
		System.out.println(answer);
	}

	private static void bfs(int i, int j) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(i);
		que.add(j);
		isVisited[i][j] = true;
		while (!que.isEmpty()) {
			int r = que.poll();
			int c = que.poll();
			char now = map[r][c];
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (isInMap(nr, nc)) {
					if (map[nr][nc] == now) {
						if (isVisited[nr][nc])
							continue;
						isVisited[nr][nc] = true;
						que.add(nr);
						que.add(nc);
					} else {
						checkMap[nr][nc] = 0;
					}
				}
			}
		}

	}

	private static boolean isInMap(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
			return true;
		} else {
			return false;
		}
	}

	private static int getCnt() {
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (checkMap[i][j] == 1)
					cnt++;
			}
		}
		return cnt;
	}

	private static int getAnswer(int cnt) {
		if (cnt == 0) {
			return 1;
		} else {
			return getAnswer(cnt - 1) * 2 % DIV;
		}
	}
}
