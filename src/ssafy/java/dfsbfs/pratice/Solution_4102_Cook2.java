package ssafy.java.dfsbfs.pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4102_Cook2 {
	static int N, map[][], answer;
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			isSelected = new boolean[N];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			getAnswer(0, 0);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void getAnswer(int cnt, int index) {
		if (cnt == N / 2) {
			int team1 = 0;
			int team2 = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (isSelected[r] && isSelected[c]) {
						team1 += map[r][c];
					} else if (!isSelected[r] && !isSelected[c])
						team2 += map[r][c];
				}
			}
			answer = Math.min(answer, Math.abs(team1 - team2));
			return;
		}
		for (int i = index; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			getAnswer(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}

}
