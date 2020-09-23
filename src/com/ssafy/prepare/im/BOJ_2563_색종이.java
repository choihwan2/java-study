package com.ssafy.prepare.im;

import java.util.Scanner;

public class BOJ_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			drawPaper(map, x, y);
		}
		int area = sumMap(map);
		System.out.println(area);
	}

	private static int sumMap(int[][] map) {
		int n = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1)
					n++;
			}
		}
		return n;
	}

	private static void drawPaper(int[][] map, int x, int y) {
		for (int i = y; i < y + 10; i++) {
			for (int j = x; j < x + 10; j++) {
				map[i][j] = 1;
			}
		}
	}

}
