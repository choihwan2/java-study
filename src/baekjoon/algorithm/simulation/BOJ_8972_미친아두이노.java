package baekjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_8972_미친아두이노 {

	static final int[][] DIR = { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { -1, -1 },
			{ -1, 0 }, { -1, 1 } };

	/*
	 * 1. 종수움직이기 2. 미친아두이노가 있는칸으로 이동했으면? 게임종료 3. 미친아두이노들 움직이기 4. 종수랑 만났으면? 게임 종료 5.
	 */
	static final int NORMAL = 0, BOOM = 1;
	static int playerX, playerY,R,C;

	private static class Crazy {
		int x;
		int y;

		public Crazy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public void move() {
			int min = Integer.MAX_VALUE;
			int tX = 0;
			int tY = 0;
			for (int i = 1; i <= 9; i++) {
				int mX = x + DIR[i][0];
				int mY = y + DIR[i][1];

				int temp = Math.abs(playerX - mX) + Math.abs(playerY - mY);
				if (min > temp) {
					min = temp;
					tX = mX;
					tY = mY;
				}
			}
			this.x = tX;
			this.y = tY;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		char[][] map = new char[R][];
		Queue<Crazy> que = new LinkedList<>();
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'R') {
					// 미친아두이노
					que.add(new Crazy(r, c));
				} else if (map[r][c] == 'I') {
					// 종수
					playerX = r;
					playerY = c;
				}
			}
		}
		String input = br.readLine();
		startGame(que, input);

	}

	private static void startGame(Queue<Crazy> que, String input) {
		int[][] tempMap = null;
		for (int i = 0; i < input.length(); i++) {
			int order = input.charAt(i) - '0';
			tempMap = new int[R][C];
			playerX += DIR[order][0];
			playerY += DIR[order][1];
			tempMap[playerX][playerY] = -1;
			int qSize = que.size();
			for (int j = 0; j < qSize; j++) {
				Crazy e = que.poll();
				if(e.x == playerX && e.y == playerY) {
					System.out.println("kraj " + (i+1));
					return;
				}
				e.move();
				if(e.x == playerX && e.y == playerY) {
					System.out.println("kraj " + (i+1));
					return;
				}
				tempMap[e.x][e.y]++;
			}
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(tempMap[r][c] == 1) {
						que.add(new Crazy(r, c));
					}
				}
			}
		}
		StringBuilder stb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(tempMap[r][c] == 1) {
					stb.append('R');
				}else if(tempMap[r][c] == -1) {
					stb.append('I');
				}else {
					stb.append('.');
				}
			}
			stb.append("\n");
		}
		System.out.println(stb.toString());
	}
}
