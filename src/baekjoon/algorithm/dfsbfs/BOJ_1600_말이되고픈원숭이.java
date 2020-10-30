package baekjoon.algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1600_말이되고픈원숭이 {
	static final int[] dr = { -1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 },
			dc = { 0, 0, -1, 1, 1, 2, 2, 1, -1, -2, -2, -1 };

	static class Player {
		int r;
		int c;
		int cnt;
		int k;

		public Player(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}

	}

	static int K, W, H;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean[][][] isVisited = new boolean[H][W][K + 1];
		Player player = new Player(0, 0, 0, 0);
		isVisited[0][0][0] = true;

		Queue<Player> que = new LinkedList<>();
		que.add(player);

		while (!que.isEmpty()) {
			Player now = que.poll();

			if (now.r == H - 1 && now.c == W - 1) {
				System.out.println(now.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int mR = now.r + dr[i];
				int mC = now.c + dc[i];

				if (isInMap(mR, mC) && map[mR][mC] == 0 && !isVisited[mR][mC][now.k]) {
					isVisited[mR][mC][now.k] = true;
					que.add(new Player(mR, mC, now.cnt + 1, now.k));
				}
			}

			if (now.k < K) {
				for (int i = 4; i < 12; i++) {
					int mR = now.r + dr[i];
					int mC = now.c + dc[i];

					if (isInMap(mR, mC) && map[mR][mC] == 0 && !isVisited[mR][mC][now.k + 1]) {
						isVisited[mR][mC][now.k + 1] = true;
						que.add(new Player(mR, mC, now.cnt + 1, now.k + 1));
					}
				}
			}
		}

		System.out.println(-1);
		return;
	}

	private static boolean isInMap(int r, int c) {
		if (r >= 0 && r < H && c >= 0 && c < W) {
			return true;
		} else {
			return false;
		}
	}
}
