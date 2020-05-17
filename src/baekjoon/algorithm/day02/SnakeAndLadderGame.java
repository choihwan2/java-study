package baekjoon.algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] snakeAndLadder = br.readLine().split(" ");
		int snakeN = Integer.parseInt(snakeAndLadder[0]);
		int ladderN = Integer.parseInt(snakeAndLadder[1]);
		int[] map = new int[101];
		int[] mapCnt = new int[101];
		int x = 1;

		Queue<Integer> que = new LinkedList<Integer>();
		que.add(x);
		mapCnt[1] = 0;

		for (int i = 0; i < snakeN + ladderN; i++) {
			String[] startEnd = br.readLine().split(" ");
			map[Integer.parseInt(startEnd[0])] = Integer.parseInt(startEnd[1]);
		}

		while (!que.isEmpty()) {
			int top = que.poll();
			for (int i = 1; i <= 6; i++) {
				if (top + i > 100)
					continue;
				if (map[top + i] == 0 && mapCnt[top + i] == 0) {
					mapCnt[top + i] = mapCnt[top] + 1;
					que.add(top + i);
				} else if (map[top + i] != 0 && mapCnt[map[top + i]] == 0) {
					mapCnt[top + i] = mapCnt[top] + 1;
					mapCnt[map[top + i]] = mapCnt[top] + 1;
					que.add(map[top + i]);
				}
			}
		}

		System.out.println(mapCnt[100]);
	}
}
