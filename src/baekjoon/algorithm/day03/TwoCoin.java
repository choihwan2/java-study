package baekjoon.algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TwoCoin {

	static final int[] dx = { 0, 0, -1, 1 };
	static final int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		char[][] map = new char[N][M];
		int[][] coins = new int[2][2];
		boolean isOne = false;

		Queue<Integer> que = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'o') {
					// 동전위치면 큐에 넣어줌
					que.add(i);
					que.add(j);
				}
			}

		}

		while (!que.isEmpty()) {
			int x1 = que.poll();
			int y1 = que.poll();

			int x2 = que.poll();
			int y2 = que.poll();

			for (int i = 0; i < 4; i++) {
				int tX1;
			}
		}

//		for (int x = 0; x < 2; x++) {
//			for (int y = 0; y < 2; y++)
//				que.add(coins[x][y]);
//		}

	}

}
