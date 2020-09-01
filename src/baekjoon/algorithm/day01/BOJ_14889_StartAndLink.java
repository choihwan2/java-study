package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_StartAndLink {
	static int answer = Integer.MAX_VALUE;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		n = Integer.parseInt(br.readLine());
		boolean[] isSelected = new boolean[n];
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		subSet(0, 0, map, isSelected);
		System.out.println(answer);
	}

	private static void subSet(int cnt, int pos, int[][] map, boolean[] isSelected) {
		if (cnt == n / 2) {
			int t1 = 0;
			int t2 = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (isSelected[i] && isSelected[j])
						t1 += map[i][j];
					else if (!isSelected[i] && !isSelected[j]) {
						t2 += map[i][j];
					}
				}
			}
			int temp = Math.abs(t1 - t2);
			if(answer > temp) {
				answer = temp;
			}
			return;
		}
		if(pos == n) {
			return;
		}

		isSelected[pos] = true;
		subSet(cnt + 1, pos + 1, map, isSelected);
		isSelected[pos] = false;
		subSet(cnt, pos + 1, map, isSelected);

	}

}
