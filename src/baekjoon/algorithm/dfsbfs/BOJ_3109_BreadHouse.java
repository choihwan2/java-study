package baekjoon.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_BreadHouse {
	static int R, C;
	static char[][] map;
	static int[] dx = { -1, 0, 1 }, dy = { 1, 1, 1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			answer += makePipe(i, 0);
		}
		System.out.println(answer);

	}

	private static int makePipe(int r, int c) {
		if (c == C - 1) {
			// 파이프가 끝까지 갓당
			return 1;
		}
		for (int d = 0; d < 3; d++) {
			int dr = r + dx[d];
			int dc = c + dy[d];
			if (!isInMap(dr, dc))
				continue;
			if (map[dr][dc] == '.') {
				map[dr][dc] = 'O';
				int temp = makePipe(dr, dc);
				if(temp == 1)
					return 1;
			}
		}
		return 0;
	}

	private static boolean isInMap(int dr, int dc) {
		if (dr >= 0 && dr < R && dc >= 0 && dc < C)
			return true;
		else
			return false;
	}

}
