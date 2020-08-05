package baekjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13460 {
	static int n, m, rX, rY, bX, bY;
	static char[][] map;
	static boolean[][][][] isVisited;
	static final int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		map = new char[n][m];
		isVisited = new boolean[n][m][n][m];
		for (int r = 0; r < n; r++) {
			map[r] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'R') {
					rX = i;
					rY = j;
					map[i][j] = '.';
				}
				if (map[i][j] == 'B') {
					bX = i;
					bY = j;
					map[i][j] = '.';
				}
			}
		}
		System.out.println(getAnswer());

	}

	private static int getAnswer() {
		int answer = -1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { rX, rY });
		queue.add(new int[] { bX, bY });
		int level = 0;
		boolean isGameOver = false;
		A: while (!queue.isEmpty() && level < 10) {
			level++;
			int qSize = queue.size() / 2;
			for (int i = 0; i < qSize; i++) {
				int[] red = queue.poll();
				int[] blue = queue.poll();
				// 4 방향으로 기울이자
				for (int d = 0; d < 4; d++) {
					// 누구부터 움직여야할지 정해줘야한다.
					int[][] redBlue;
					if (d == 0 && red[1] == blue[1] && red[0] > blue[0]) {
						redBlue = moveRedBlue(red, blue, d, false);
					} else if (d == 1 && red[1] == blue[1] && red[0] < blue[0]) {
						redBlue = moveRedBlue(red, blue, d, false);
					} else if (d == 2 && red[0] == blue[0] && red[1] > blue[1]) {
						redBlue = moveRedBlue(red, blue, d, false);
					} else if (d == 3 && red[0] == blue[0] && red[1] < blue[1]) {
						redBlue = moveRedBlue(red, blue, d, false);
					} else {
						redBlue = moveRedBlue(red, blue, d, true);
					}
					if (redBlue[1][0] == 0 && redBlue[1][1] == 0)
						continue;
					else {
						if (redBlue[0][0] == 0 && redBlue[0][1] == 0) {
							isGameOver = true;
							break A;
						}
						if (isVisited[redBlue[0][0]][redBlue[0][1]][redBlue[1][0]][redBlue[1][1]])
							continue;
						isVisited[redBlue[0][0]][redBlue[0][1]][redBlue[1][0]][redBlue[1][1]] = true;
						queue.add(redBlue[0]);
						queue.add(redBlue[1]);
					}
				}
			}
		}
		return isGameOver ? level : answer;
	}

	private static int[][] moveRedBlue(int[] red, int[] blue, int dir, boolean isRedFirst) {
		int[][] redBlue = new int[2][2];
		if (isRedFirst) {
			red = move(red[0], red[1], dir);
			map[red[0]][red[1]] = 'R';
			blue = move(blue[0], blue[1], dir);
		} else {
			blue = move(blue[0], blue[1], dir);
			map[blue[0]][blue[1]] = 'B';
			red = move(red[0], red[1], dir);
		}
		map[red[0]][red[1]] = '.';
		map[blue[0]][blue[1]] = '.';
		redBlue[0] = red;
		redBlue[1] = blue;
		return redBlue;
	}

	private static int[] move(int x, int y, int d) {
		while (map[x + dx[d]][y + dy[d]] == '.') {
			x += dx[d];
			y += dy[d];
		}
		// 구멍에 들어간 경우
		if (map[x + dx[d]][y + dy[d]] == 'O')
			return new int[] { 0, 0 };
		return new int[] { x, y };
	}
}
