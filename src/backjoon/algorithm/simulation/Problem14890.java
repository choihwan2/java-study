package backjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14890 {
	static int N, L;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sizeStr = br.readLine().split(" ");
		N = Integer.parseInt(sizeStr[0]);
		L = Integer.parseInt(sizeStr[1]);
		int answer = 0;
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}

		for (int i = 0; i < N; i++) {
			char height = map[i][0];
			int height_num = 1;
			int temp_L = L;
			boolean isCan = true;
			for (int j = 1; j < N; j++) {
				if (height == map[i][j]) {
					height_num++;
				} else if (height + 1 == map[i][j] && temp_L == L) {
					if (height_num >= L) {
						height = map[i][j];
						height_num = 1;
						continue;
					} else {
						isCan = false;
						break;
					}
				} else if (height - 1 == map[i][j]) {
					if (--temp_L != 0) {
						isCan = false;
					} else {
						height = map[i][j];
						temp_L = L;
						height_num = 0;
						isCan = true;
					}
				} else {
					isCan = false;
					break;
				}
			}
			if (isCan) {
				answer++;
			}
		}

		for (int i = 0; i < N; i++) {
			char height = map[0][i];
			int height_num = 1;
			int temp_L = L;
			boolean isCan = true;
			for (int j = 1; j < N; j++) {
				if (height == map[j][i]) {
					height_num++;
				} else if (height + 1 == map[j][i] && temp_L == L) {
					if (height_num >= L) {
						height = map[j][i];
						height_num = 1;
						continue;
					} else {
						isCan = false;
						break;
					}
				} else if (height - 1 == map[j][i]) {
					if (--temp_L != 0) {
						isCan = false;
					} else {
						height = map[j][i];
						height_num = 0;
						temp_L = L;
						isCan = true;
					}
				} else {
					isCan = false;
					break;
				}
			}
			if (isCan) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}
