package ssafy.swexpert.prepareA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_환 {

	static int N, W, H, min;
	static final int[] DR = { -1, 1, 0, 0 }, DC = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(stk.nextToken());
			W = Integer.parseInt(stk.nextToken());
			H = Integer.parseInt(stk.nextToken());

			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			min = Integer.MAX_VALUE;

			process(0, map);

			System.out.println("#" + t + " " + min);
		}
	}

	private static void process(int cnt, int[][] map) {
		if (cnt == N) {
			int result = countMap(map);
			if (min > result)
				min = result;
			return;
		}

		// 어느 곳에 구슬을 떨굴 것인가
		for (int w = 0; w < W; w++) {
			int[][] newMap = new int[H][W];

			// 맵복사
			copyMap(map, newMap);
			// 새로운맵에서 벽돌이 꺠짐
			if (boom(w, newMap)) {
				// 벽돌 내리기
				down(newMap);
				// 새로운 맵에서 다음 행동을 실행하자
				process(cnt + 1, newMap);
			} else {
				process(cnt + 1, map);
			}
		}

	}

	private static int countMap(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			int r = H - 1;
			// 한줄 잡고 위로 쭉 확인하면서 0이면 위치 값을 기록
			// 그다음 또 위로 올라가다 0이 아닌 애를 발견시 교환
			while (r > 0) {
				while (r > 0 && map[r][c] != 0)
					r--;

				int nR = r - 1;
				while (nR >= 0 && map[nR][c] == 0)
					nR--;

				if (nR == -1)
					break;
				map[r][c] = map[nR][c];
				map[nR][c] = 0;
			}
		}
	}

	private static boolean boom(int w, int[][] map) {
		int r = 0;
		while (r < H && map[r][w] == 0)
			r++;

		if (r == H) {
			return false;
		}
		Queue<Integer> que = new LinkedList<>();
		que.add(r);
		que.add(w);
		que.add(map[r][w]);
		map[r][w] = 0;
		while (!que.isEmpty()) {
			int sr = que.poll();
			int sc = que.poll();
			int cnt = que.poll();

			for (int k = 1; k < cnt; k++) {
				for (int d = 0; d < 4; d++) {
					int mR = sr + DR[d] * k;
					int mC = sc + DC[d] * k;

					if (mR < 0 || mR >= H || mC < 0 || mC >= W || map[mR][mC] == 0)
						continue;

					if (map[mR][mC] != 1) {
						que.add(mR);
						que.add(mC);
						que.add(map[mR][mC]);
					}
					map[mR][mC] = 0;
				}

			}
		}

		return true;
	}

	private static void copyMap(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

}
