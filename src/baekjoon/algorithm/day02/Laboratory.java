package baekjoon.algorithm.day02;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory {
	static int[][] map;
	static int[][] tMap;
	static int N, M;
	static ArrayList<Point> virusList = new ArrayList<Point>();
	static final int[] dx = { 0, 0, -1, 1 };
	static final int[] dy = { 1, -1, 0, 0 };
	
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mapSize = br.readLine().split(" ");
		N = Integer.parseInt(mapSize[0]);
		M = Integer.parseInt(mapSize[1]);
		map = new int[N][M];
		tMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new Point(i, j));
				}
			}
		}
		
		makeTower(0, 0);
		
		System.out.println(answer);

	}

	public static void makeTower(int start, int num) {
		if (num == 3) {
			for(int i = 0; i< tMap.length; i++) {
				for(int j = 0; j< tMap[i].length; j++) {
					tMap[i][j] = map[i][j];
				}
			}
			int tempSafe = spreadVirus(tMap);
			answer = Math.max(answer, tempSafe);
			return;
		}

		for (int x = start; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (map[x][y] == 2 || map[x][y] == 1)
					continue;
				map[x][y] = 1;
				makeTower(x, num + 1);
				map[x][y] = 0;
			}
		}
	}

	public static int spreadVirus(int[][] towerMap) {
		Queue<Point> que = new LinkedList<Point>();
		for (Point pt : virusList) {
			que.add(pt);
		}
		while (!que.isEmpty()) {
			Point tempPt = que.poll();
			for (int i = 0; i < 4; i++) {
				int dtX = tempPt.x + dx[i];
				int dtY = tempPt.y + dy[i];
				if ((dtX >= 0 && dtX < N) && (dtY >= 0 && dtY < M)) {
					if (towerMap[dtX][dtY] == 1 || towerMap[dtX][dtY] == 2)
						continue;

					if (towerMap[dtX][dtY] == 0) {
						towerMap[dtX][dtY] = 2;
						que.add(new Point(dtX, dtY));
					}
				}
			}
		}
		int safeArea = 0;
		for (int i = 0; i < towerMap.length; i++) {
			for (int j = 0; j < towerMap[i].length; j++) {
				if(towerMap[i][j] == 0) safeArea++;
			}
		}
		return safeArea;
	}

}
