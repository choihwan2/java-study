package baekjoon.algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TwoCoin {

	static final int[] dx = { 0, 0, -1, 1 };
	static final int[] dy = { -1, 1, 0, 0 };
	static int answer = -1;
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new char[N][M];

		Queue<Integer> coinQue = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'o') {
					// 동전위치면 큐에 넣어줌
					coinQue.add(i);
					coinQue.add(j);
				}
			}
		}

		go(coinQue.poll(), coinQue.poll(), coinQue.poll(), coinQue.poll(), 0);
		System.out.println(answer);
	}

	public static int go(int x1, int y1, int x2, int y2, int index) {
		if (index == 11) {
			return -1;
		}
		boolean isOneFall = false, isTwoFall = false;

		if (x1 < 0 || x1 >= N || y1 < 0 || y1 >= M)
			isOneFall = true;
		if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M)
			isTwoFall = true;

		if (isOneFall && isTwoFall)
			return -1;
		if (isOneFall || isTwoFall)
			return index;

		for (int i = 0; i < 4; i++) {
			int tX1 = x1 + dx[i];
			int tY1 = y1 + dy[i];

			int tX2 = x2 + dx[i];
			int tY2 = y2 + dy[i];

			if (tX1 >= 0 && tX1 < N && tY1 >= 0 && tY1 < M && map[tX1][tY1] == '#') {
				tX1 = x1;
				tY1 = y1;
			}
			if (tX2 >= 0 && tX2 < N && tY2 >= 0 && tY2 < M && map[tX2][tY2] == '#') {
				tX2 = x2;
				tY2 = y2;
			}

			int temp = go(tX1, tY1, tX2, tY2, index + 1);
			if (temp == -1)
				continue;
			if (answer == -1 || answer > temp)
				answer = temp;
		}

		return answer;
	}

}
