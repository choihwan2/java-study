package codeup.problem100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1099 {
	public static void main(String[] args) throws IOException {
		char[][] map = new char[10][10];
		boolean isGo = true;
		int y = 1;
		int x = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = input.nextToken().charAt(0);
			}
		}

		while (isGo) {
			if (map[y][x] == '2') {
				map[y][x] = '9';
				isGo = false;
			} else if (map[y][x] == '0') {
				map[y][x] = '9';
				if (map[y][x + 1] == '1') {
					if (map[++y][x] == '1') {
						isGo = false;
					}
				} else if (map[y][x + 1] == '0' || map[y][x + 1] == '2') {
					x++;
				}
			}
		}
		System.out.println();

		for(int i = 0; i< 10; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
