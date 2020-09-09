package programmers.kakao.intership2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_경주로건설 {
	final int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	final int[][] DIR = { { 0, 1, 3 }, { 1, 2, 0 }, { 2, 1, 3 }, { 3, 2, 0 } };

	public int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		final int END = board.length - 1;
		Queue<Node> pq = new LinkedList<>();
		int[][] cost = new int[board.length][board.length];
		pq.add(new Node(0, 0, 1, 0));
		pq.add(new Node(0, 0, 2, 0));
		for (int i = 0; i < cost.length; i++) {
			Arrays.fill(cost[i],Integer.MAX_VALUE);
		}
		cost[0][0] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int x = node.x;
			int y = node.y;
			int d = node.dir;
			int total = node.nowValue;
			if (x == END && y == END) {
				answer = Math.min(total, answer);
				continue;
			}

			for (int i = 0; i < 3; i++) {
				int nextD = DIR[d][i];
				int mX = x + dx[DIR[d][i]];
				int mY = y + dy[DIR[d][i]];
				if (!isInMap(mX, mY, END))
					continue;
				if (board[mX][mY] == 1)
					continue;
				if (d == nextD && cost[mX][mY] < total + 100)
					continue;
				if (d != nextD && cost[mX][mY] < total + 600)
					continue;

				Node newNode = new Node(mX, mY, nextD, total + 100);
				if (d != nextD) {
					newNode.nowValue += 500;
				}
				pq.add(newNode);
				cost[mX][mY] = newNode.nowValue;
			}
		}
		return answer;
	}

	private static boolean isInMap(int r, int c, int END) {
		if (r >= 0 && r < END + 1 && c >= 0 && c < END + 1) {
			return true;
		} else {
			return false;
		}
	}

	private class Node implements Comparable<Node> {
		int x;
		int y;
		int dir;
		int nowValue = 0;

		public Node(int x, int y, int dir, int nowValue) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.nowValue = nowValue;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.nowValue, o.nowValue);
		}

	}
}
