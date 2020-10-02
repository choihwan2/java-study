package baekjoon.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404_RGB거리_2 {

	static final int RED = 0, GREEN = 1, BLUE = 2, MAX = 1000001;
	static int N, house[][], color[][], min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		N = Integer.parseInt(br.readLine());
		house = new int[N][3];
		color = new int[N][3];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j)
					house[0][j] = color[0][j];
				else
					house[0][j] = MAX;
			}

			for (int j = 1; j < N; j++) {
				house[j][RED] = Math.min(house[j - 1][GREEN], house[j - 1][BLUE]) + color[j][RED];
				house[j][GREEN] = Math.min(house[j - 1][RED], house[j - 1][BLUE]) + color[j][GREEN];
				house[j][BLUE] = Math.min(house[j - 1][RED], house[j - 1][GREEN]) + color[j][BLUE];
			}

			for (int j = 0; j < 3; j++) {
				if (i == j)
					continue;
				min = Math.min(min, house[N - 1][j]);
			}

		}
		
		System.out.println(min);

	}

}
