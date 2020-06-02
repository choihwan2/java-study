package programmers.school.day03;

import java.util.LinkedList;
import java.util.Queue;

public class GameShortestDistance {

	public int solution(int[][] maps) {
		final int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
		int n = maps.length, m = maps[0].length;
		int[][] mapMove = new int[n][m];
		mapMove[0][0] = 1;

		Queue<Position> que = new LinkedList<Position>();
		que.add(new Position(0, 0));

		while (!que.isEmpty()) {
			Position pt = que.poll();
			int x = pt.x;
			int y = pt.y;
			for (int i = 0; i < 4; i++) {
				int tX = x + dx[i];
				int tY = y + dy[i];
				if (tX < 0 || tX >= n || tY < 0 || tY >= m || maps[tX][tY] == 0 || mapMove[tX][tY] != 0)
					continue;
				mapMove[tX][tY] = mapMove[x][y] + 1;
				que.add(new Position(tX, tY));
			}
		}
		return mapMove[n - 1][m - 1] == 0 ? -1 : mapMove[n - 1][m - 1];
	}

	private class Position {
		int x;
		int y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
