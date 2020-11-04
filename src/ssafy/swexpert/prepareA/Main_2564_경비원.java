package ssafy.swexpert.prepareA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2564_경비원 {

	static final int NORTH = 1, SOUTH = 2, WEST = 3, EAST = 4;

	static final int[] DR = { -1, 1, 0, 0 }, DC = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();

		int S = sc.nextInt();

		int[][] map = new int[R + 1][C + 1];
		boolean[][] isVisited = new boolean[R + 1][C + 1];
		for (int i = 0; i <= R; i++) {
			map[i][0] = 1;
			map[i][C] = 1;
		}

		for (int i = 0; i <= C; i++) {
			map[0][i] = 1;
			map[R][i] = 1;
		}

		int[] start = {0,0,0};
		for (int i = 0; i < S + 1; i++) {
			int pos = sc.nextInt();
			int value = sc.nextInt();

			if (pos == NORTH) {
				map[0][value] = 2;
			} else if (pos == SOUTH) {
				map[R][value] = 2;
			} else if (pos == WEST) {
				map[value][0] = 2;
			} else if (pos == EAST) {
				map[value][C] = 2;
			}
			if(i == S) {
				if (pos == NORTH) {
					start[0] = 0;
					start[1] = value;
				} else if (pos == SOUTH) {
					start[0] = R;
					start[1] = value;
				} else if (pos == WEST) {
					start[0] = value;
					start[1] = 0;
				} else if (pos == EAST) {
					start[0] = value;
					start[1] = C;
				}
			}
		}

		Queue<int[]> que = new LinkedList<>();
		que.add(start);
		isVisited[start[0]][start[1]] = true;
		int sumDist = 0;

		while (!que.isEmpty()) {
			int[] pos = que.poll();
			int x = pos[0];
			int y = pos[1];
			int dist = pos[2];

			if (map[x][y] == 2) {
				sumDist += dist;
			}

			for (int i = 0; i < 4; i++) {
				int mX = x + DR[i];
				int mY = y + DC[i];

				if (mX < 0 || mX > R || mY < 0 || mY > C || map[mX][mY] == 0 || isVisited[mX][mY])
					continue;
				que.add(new int[] { mX, mY, dist + 1 });
				isVisited[mX][mY] = true;
			}
		}
		System.out.println(sumDist);

	}

}
