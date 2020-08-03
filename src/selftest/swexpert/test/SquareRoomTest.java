package selftest.swexpert.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SquareRoomTest {
	static int answer[];
	static int N;
	static final int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			StringTokenizer stk = null;
			answer = new int[2];
			for (int r = 0; r < N; r++) {
				stk = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(stk.nextToken());
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					answer = getBfs(r, c, map);
				}
			}
			System.out.println("#" + t + " " + answer[0] + " " + answer[1]);

		}
	}

	private static int[] getBfs(int x, int y, int[][] map) {
		if (map[x][y] > (N * N - answer[1]))
			return answer;
		int temp = 1;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(x);
		que.add(y);
		while (!que.isEmpty()) {
			int tX = que.poll();
			int tY = que.poll();
			for (int i = 0; i < 4; i++) {
				if (tX + dx[i] >= 0 && tX + dx[i] < N && tY + dy[i] >= 0 && tY + dy[i] < N
						&& map[tX][tY] + 1 == map[tX + dx[i]][tY + dy[i]]) {
					que.add(tX + dx[i]);
					que.add(tY + dy[i]);
					++temp;
				}
			}
		}
		if (temp > answer[1]) {
			return new int[] { map[x][y], temp };
		} else if (temp == answer[1]) {
			return new int[] { Math.min(answer[0], map[x][y]), temp };
		} else {
			return answer;
		}
	}
}
