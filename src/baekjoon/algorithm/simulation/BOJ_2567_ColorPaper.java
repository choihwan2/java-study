package baekjoon.algorithm.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2567_ColorPaper {
	static final int MAP_SIZE = 102, PAPER_SIZE = 10;
	static final int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int[][] map = new int[MAP_SIZE][MAP_SIZE];
	static boolean[][] isVisited = new boolean[MAP_SIZE][MAP_SIZE];
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int left = sc.nextInt();
			int bottom = sc.nextInt();
			makePaper(left, bottom);
		}
		for (int r = 0; r < MAP_SIZE; r++) {
			for (int c = 0; c < MAP_SIZE; c++) {
				if (!isVisited[r][c] && map[r][c] == 1) {
					countRound(r, c);
				}
			}
		}
		System.out.println(answer);
	}

	private static void countRound(int r, int c) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(r);
		que.offer(c);
		isVisited[r][c] = true;
		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for (int i = 0; i < 4; i++) {
				int mX = x + dx[i];
				int mY = y + dy[i];
				if (map[mX][mY] == 0) {
					answer++;
				} else if (map[mX][mY] == 0 && !isVisited[mX][mY]) {
					isVisited[mX][mY] = true;
					que.offer(mX);
					que.offer(mY);
				}
			}
		}
	}

	private static void makePaper(int left, int bottom) {
		for (int r = bottom; r < bottom + PAPER_SIZE; r++) {
			for (int c = left; c < left + PAPER_SIZE; c++) {
				map[r][c] = 1;
			}
		}
	}

}
