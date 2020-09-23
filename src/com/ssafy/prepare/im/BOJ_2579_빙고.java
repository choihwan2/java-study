package com.ssafy.prepare.im;

import java.util.Scanner;

public class BOJ_2579_빙고 {
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] order = new int[26];
		for (int i = 1; i < order.length; i++) {
			order[i] = sc.nextInt();
		}

		for (int i = 1; i < order.length; i++) {
			select(order[i]);
			int bingoCnt = checkBingo();
			if(bingoCnt >=3) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void select(int order) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == order)
					map[i][j] = 0;
			}
		}
	}

	private static int checkBingo() {
		int n = 0;
		n += checkRow();
		n += checkCol();
		n += checkDiagonal();
		n += checkDiagonal2();
		return n;
	}

	private static int checkRow() {
		int n = 0;
		boolean isRow;
		for (int i = 0; i < map.length; i++) {
			isRow = true;
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != 0) {
					isRow = false;
					break;
				}
			}
			if (isRow)
				n++;
		}

		return n;
	}

	private static int checkCol() {
		int n = 0;
		boolean isRow;
		for (int i = 0; i < map.length; i++) {
			isRow = true;
			for (int j = 0; j < map.length; j++) {
				if (map[j][i] != 0) {
					isRow = false;
					break;
				}
			}
			if (isRow)
				n++;
		}

		return n;
	}

	private static int checkDiagonal() {
		for (int i = 0, j = 0; i < map.length; i++, j++) {
			if (map[i][j] != 0) {
				return 0;
			}
		}
		return 1;
	}
	
	private static int checkDiagonal2() {
		for (int i = 4, j = 0; i >= 0; i--, j++) {
			if (map[i][j] != 0) {
				return 0;
			}
		}
		return 1;
	}
}
