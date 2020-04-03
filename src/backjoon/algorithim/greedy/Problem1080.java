package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1080 {

	static boolean[][] inArr;
	static boolean[][] outArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int x, y;
		y = Integer.parseInt(input[0]);
		x = Integer.parseInt(input[1]);
		inArr = new boolean[y][x];
		outArr = new boolean[y][x];
		int answer = 0;

		for (int i = 0; i < y; i++) {
			String oneLine = br.readLine();
			for (int j = 0; j < x; j++) {
				inArr[i][j] = oneLine.charAt(j) == '0' ? false : true;
			}
		}

		for (int i = 0; i < y; i++) {
			String oneLine = br.readLine();
			for (int j = 0; j < x; j++) {
				outArr[i][j] = oneLine.charAt(j) == '0' ? false : true;
			}
		}

		if (x < 3 || y < 3) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (inArr[i][j] != outArr[i][j]) {
						System.out.println(-1);
						return;
					}
				}
			}
			System.out.println(answer);
			return;
		}

		for (int i = 0; i < y - 2; i++) {
			for (int j = 0; j < x - 2; j++) {
				if (inArr[i][j] != outArr[i][j]) {
					flip(inArr, j, i);
					answer++;
				}
			}
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (inArr[i][j] != outArr[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(answer);
	}

	public static void flip(boolean[][] arr, int x, int y) {
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				arr[i][j] = !arr[i][j];
			}
		}
	}

}
