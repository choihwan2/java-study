package baekjoon.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_WallClashAndMove1 {
	private static class Node {
		int r;
		int c;
		int cnt;
		int chance;

		public Node(int r, int c, int cnt, int chance) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.chance = chance;
		}

	}

	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int R, C;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		char[][] map = new char[R][C];
		boolean[][][] isVisited = new boolean[R][C][2];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0, 0, 1, 0));
		isVisited[0][0][0] = true;
		while (!que.isEmpty()) {
			Node node = que.poll();
			if (node.r == R - 1 && node.c == C - 1) {
				answer = node.cnt;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int mX = node.r + dx[d];
				int mY = node.c + dy[d];
				int cnt = node.cnt;
				int chance = node.chance;
				if (!isInMap(mX, mY))
					continue;

				if (map[mX][mY] == '0' && !isVisited[mX][mY][chance]) {
					isVisited[mX][mY][chance] = true;
					que.add(new Node(mX, mY, cnt + 1, chance));
				} else if (map[mX][mY] == '1' && !isVisited[mX][mY][1] && chance == 0) {
					isVisited[mX][mY][1] = true;
					que.add(new Node(mX, mY, cnt + 1, chance + 1));
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean isInMap(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) {
			return true;
		} else
			return false;
	}
}
