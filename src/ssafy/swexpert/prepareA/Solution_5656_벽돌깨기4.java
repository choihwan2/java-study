package ssafy.swexpert.prepareA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기4 {
	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	static int N, W, H, min;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());

		for (int t = 1; t <= iT; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(stk.nextToken());
			W = Integer.parseInt(stk.nextToken());
			H = Integer.parseInt(stk.nextToken());

			int[][] map = new int[H][W];
			int total = 0; // 총 벽돌의 개수
			for (int r = 0; r < H; r++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(stk.nextToken());
					if (map[r][c] > 0)
						++total;
				}
			}

			min = Integer.MAX_VALUE;
			go(0, total, map);
			System.out.println("#" + t + " " + min);
		}
	}

	/*
	 * count : 던져진 구슬의 개수 map : 이전 구슬까지의 2차원 배열
	 */
	private static boolean go(int count, int remain, int[][] map) {

		if (remain == 0) {
			min = 0;
			return true;
		}

		if (count == N) {
			// 남아있는 벽돌의 개수 구하여 최소값 갱신
			if (min > remain)
				min = remain;
			return false;
		}

		int[][] newMap = new int[H][W];

		for (int c = 0; c < W; c++) {
			int r = 0;
			while (r < H && map[r][c] == 0)
				++r;

			if (r == H)// 벽돌이 없음.
				continue;
			// 이전 구슬 상태로 배열 복사하여 초기화
			copy(map, newMap);
			// 터트리기
			int bCnt = boom(newMap, r, c);
			// 벽돌 내리기
			down(newMap);
			// 다음 구슬처리
			if (go(count + 1,remain - bCnt, newMap)) {
				return true;
			}

		}
		return false;
	}

	private static int boom(int[][] map, int r, int c) {
		int cnt = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c, map[r][c]));
		map[r][c] = 0; // 방문처리겸 벽돌깨기
		cnt++;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r, nc = p.c;
				for (int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if(map[nr][nc]> 1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));							
						}
						map[nr][nc] = 0;
						cnt++;
					}
				}
			}
		}

		return cnt;

	}

	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) { // 열을 고정하고 실행
			int r = H - 1;
			while (r > 0) {
				if (map[r][c] == 0) {
					int nr = r - 1; // 직전행
					while (nr > 0 && map[nr][c] == 0)
						--nr;
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				--r;
			}
		}

	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}

	}
}
