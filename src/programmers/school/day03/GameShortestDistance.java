package programmers.school.day03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GameShortestDistance {
	private final int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
	private int[][] mapBool;
	private int n, m;

	public int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;
		mapBool = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(mapBool[i], -1);
		}
		mapBool[0][0] = 1;
		go(maps);
		return mapBool[n - 1][m - 1];
	}

	private void go(int[][] maps) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(0);
		que.add(0);

		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for (int i = 0; i < 4; i++) {
				int tX = x + dx[i];
				int tY = y + dy[i];
				if (tX < 0 || tX >= n || tY < 0 || tY >= m || maps[tX][tY] == 0 || mapBool[tX][tY] != -1)
					continue;
				mapBool[tX][tY] = mapBool[x][y] + 1;
				que.add(tX);
				que.add(tY);
			}
		}
	}
}
