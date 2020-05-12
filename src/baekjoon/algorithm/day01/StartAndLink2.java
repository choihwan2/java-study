package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartAndLink2 {
	static int N;
	static int[][] map;
	static boolean[] team_bool;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		team_bool = new boolean[N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		sol(0, 0);
		System.out.println(min);
	}

	public static void sol(int first, int num) {
		if (N / 2 == num) {
			min = Math.min(min, getScore());
			return;
		}

		for (int i = first + 1; i < N; i++) {
			if (team_bool[i] == true)
				continue;
			team_bool[i] = true;
			sol(first, num + 1);
			team_bool[i] = false;
		}

	}

	public static int getScore() {
		int start = 0;
		int link = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (team_bool[i] && team_bool[j])
					start += map[i][j];
				else if (!team_bool[i] && !team_bool[j])
					link += map[i][j];
			}
		}

		return Math.abs(start - link);
	}

}
