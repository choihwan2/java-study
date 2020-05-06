package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NMandK {

	static int[][] map;
	static int[][] map_bool;
	static int N, M, K;
	static int max = -40001;
	static int[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMK = br.readLine().split(" ");
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		K = Integer.parseInt(NMK[2]);

		list = new int[K];

		map = new int[N][M];
		map_bool = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		sol(0);

		System.out.println(max);

	}

	public static void sol(int num) {
		if (num == K) {
			int temp = 0;
			for (int i : list) {
				temp += i;
			}
			max = Math.max(max, temp);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map_bool[i][j] > 0)
					continue;
				check(j, i);
				list[num] = map[i][j];
				sol(num + 1);
				uncheck(j, i);
			}
		}
	}

	public static void check(int x, int y) {
		map_bool[y][x]++;
		if (x - 1 >= 0)
			map_bool[y][x - 1]++;
		if (y - 1 >= 0)
			map_bool[y - 1][x]++;
		if (x + 1 < M)
			map_bool[y][x + 1]++;
		if (y + 1 < N)
			map_bool[y + 1][x]++;
	}

	public static void uncheck(int x, int y) {
		map_bool[y][x]--;
		if (x - 1 >= 0)
			map_bool[y][x - 1]--;
		if (y - 1 >= 0)
			map_bool[y - 1][x]--;
		if (x + 1 < M)
			map_bool[y][x + 1]--;
		if (y + 1 < N)
			map_bool[y + 1][x]--;
	}
}
