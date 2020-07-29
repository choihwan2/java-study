package ssafy.swexpert.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2001 {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			int answer = 0;

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int dieFlyCnt = getDieFly(map, i, j);
					if(answer < dieFlyCnt)
						answer = dieFlyCnt;
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}

	}

	private static int getDieFly(int[][] map, int i, int j) {
		int cnt = 0;
		for (int r = i; r < i + M; r++) {
			for (int c = j; c < j + M; c++) {
				cnt += map[r][c];
			}
		}
		return cnt;
	}

}
