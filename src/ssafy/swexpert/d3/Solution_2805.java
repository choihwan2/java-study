package ssafy.swexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_2805 {
	static final int[][] dir = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };
	static final int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[][] rangeMap = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String oneLine = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(oneLine.charAt(j));
				}
			}
			drawRange(rangeMap, N);
			int answer = getAnswer(map, rangeMap);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static int getAnswer(int[][] map, boolean[][] rangeMap) {
		int answer = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (rangeMap[i][j])
					answer += map[i][j];
			}
		}
		return answer;
	}

	private static void drawRange(boolean[][] rangeMap, int n) {
		if (n == 1) {
			rangeMap[0][0] = true;
			return;
		}
		int x = n / 2;
		int y = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < n / 2; j++) {
				rangeMap[x + dir[i][0]][y + dir[i][1]] = true;
				x += dir[i][0];
				y += dir[i][1];
			}
		}

		Queue<Integer> que = new LinkedList<>();
		que.add(n / 2);
		que.add(n / 2);
		rangeMap[n / 2][n / 2] = true;
		while (!que.isEmpty()) {
			x = que.poll();
			y = que.poll();

			for (int i = 0; i < 4; i++) {
				int mX = x + dx[i];
				int mY = y + dy[i];
				if (!rangeMap[mX][mY]) {
					que.add(mX);
					que.add(mY);
					rangeMap[mX][mY] = true;
				}
			}
		}
	}

}
