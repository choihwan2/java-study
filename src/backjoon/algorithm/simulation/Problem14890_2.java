package backjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14890_2 {
	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] values = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(values[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			sum += check(i, 0, 1) ? 1 : 0;
			sum += check(0, i, 0) ? 1 : 0;
		}
		System.out.println(sum);

	}

	public static boolean check(int x, int y, int dir) {
		boolean answer = true;
		int[] heights = new int[N];
		if (dir == 0) {
			for (int i = 0; i < N; i++) {
				heights[i] = map[y][i];
			}
		} else if (dir == 1) {
			for (int i = 0; i < N; i++) {
				heights[i] = map[i][x];
			}
		}

		int now = heights[0];
		int heights_n = 1;
		int down = L;

		for (int i = 1; i < N; i++) {
			if (now == heights[i] && answer) {
				heights_n++;
			} else if (now + 1 == heights[i] && answer) {
				if (heights_n >= L) {
					now = heights[i];
					heights_n = 1;
					continue;
				} else {
					return false;
				}
			} else if (now - 1 == heights[i]) {
				down--;
				if (down == 0) {
					now = heights[i];
					heights_n = 0;
					down = L;
					answer = true;
				} else {
					answer = false;
				}
			} else {
				return false;
			}
		}

		return answer;
	}

}

