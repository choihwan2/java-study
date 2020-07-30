package ssafy.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SquareRoom {

	static final int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			StringTokenizer stk = null;
			int answer[] = new int[2];
			for (int r = 0; r < N; r++) {
				stk = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(stk.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int[] temp = bfs(r, c, map);
					if (answer[1] < temp[1]) {
						answer = temp;
					} else if (answer[1] == temp[1]) {
						if (answer[0] > temp[0])
							answer[0] = temp[0];
					}

				}
			}
			System.out.printf("#" + t + " %d %d", answer[0], answer[1]);
			System.out.println();

		}
	}

	private static int[] bfs(int x, int y, int[][] map) {
		int[] answer = { map[x][y], 1 };
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(x);
		que.offer(y);
		while (!que.isEmpty()) {
			int mX = que.poll();
			int mY = que.poll();
			for (int i = 0; i < 4; i++) {
				int dirX = mX + dx[i];
				int dirY = mY + dy[i];
				if (dirX >= 0 && dirX < N && dirY >= 0 && dirY < N && map[mX][mY] + 1 == map[dirX][dirY]) {
					answer[1]++;
					que.offer(dirX);
					que.offer(dirY);
				}
			}
		}
		return answer;
	}

}
