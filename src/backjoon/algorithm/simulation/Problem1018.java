package backjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1018 {

	static final String[] BASIC = { "WBWBWBWB", "BWBWBWBW" };
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] xy = br.readLine().split(" ");
		int height = Integer.parseInt(xy[0]);
		int width = Integer.parseInt(xy[1]);

		int min = 65;

		board = new char[height][width];

		for (int i = 0; i < height; i++) {
			board[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i <= height - 8; i++) {
			for (int j = 0; j <= width - 8; j++) {
				min = Math.min(min, Math.min(compareBoard(j, i, 0), compareBoard(j, i, 1)));
			}
		}
		System.out.println(min);
	}

	public static int compareBoard(int x, int y, int start) {
		int answer = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[y + i][x + j] != BASIC[start].charAt(j)) {
					answer++;
				}
			}
			start = start + 1 < 2 ? start + 1 : 0;
		}
		return answer;
	}
}
