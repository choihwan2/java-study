package ssafy.swexpert.prepareA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1953_탈주범검거 {

	static final int[] DR = { -1, 1, 0, 0 }, DC = { 0, 0, -1, 1 };
	static final int[][] PIPE = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 },
			{ 0, 1, 0, 1 }, { 0, 1, 1, 0 }, { 1, 0, 1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int t = 1; t <= iT; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int L = sc.nextInt();

			int[][] map = new int[N][M];
			boolean[][] isVisited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int cnt = 0;

			int[] sPos = { R, C };
			isVisited[R][C] = true;

			Queue<int[]> que = new LinkedList<>();
			que.add(sPos);

			for (int i = 0; i < L; i++) {
				int qSize = que.size();
				for (int k = 0; k < qSize; k++) {
					int[] pos = que.poll();
					cnt++;

					int type = map[pos[0]][pos[1]];
					for (int j = 0; j < 4; j++) {

						// 어느방향으로 갈 수 있는지 체크
						if (PIPE[type][j] == 1) {
							int mX = pos[0] + DR[j];
							int mY = pos[1] + DC[j];

							if (mX < 0 || mX >= N || mY < 0 || mY >= M || isVisited[mX][mY])
								continue;

							// 이미 간 방향에서 이어져있는지 체크해야함
							if (checkConnect(j, mX, mY, map)) {
								que.add(new int[] { mX, mY });
								isVisited[mX][mY] = true;
							}
						}
					}
				}
			}

			System.out.println("#" + t + " " + cnt);

		}

	}

	private static boolean checkConnect(int dir, int x, int y, int[][] map) {
		int type = map[x][y];
		if (dir == 0 && PIPE[type][1] == 1) {
			return true;
		} else if (dir == 1 && PIPE[type][0] == 1) {
			return true;
		} else if (dir == 2 && PIPE[type][3] == 1) {
			return true;
		} else if (dir == 3 && PIPE[type][2] == 1) {
			return true;
		}
		return false;
	}
}
