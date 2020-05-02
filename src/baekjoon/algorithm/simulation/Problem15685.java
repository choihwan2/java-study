package baekjoon.algorithm.simulation;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;


public class Problem15685 {
	/*
	 * 오른쪽 시작일때
	 * 
	 * x +1 => y -1 y -1 => x -1 x -1 => y +1 y +1 => x +1
	 * 
	 * 0: x좌표가 증가하는 방향 (→) 1: y좌표가 감소하는 방향 (↑) 2: x좌표가 감소하는 방향 (←) 3: y좌표가 증가하는 방향
	 * (↓)
	 */
	static final int[][] DIR = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static int[][] map = new int[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int curv_n = Integer.parseInt(br.readLine());
		for (int i = 0; i < curv_n; i++) {
			String[] curv = br.readLine().split(" ");
			int x = Integer.parseInt(curv[0]);
			int y = Integer.parseInt(curv[1]);
			int dir = Integer.parseInt(curv[2]);
			int gen = Integer.parseInt(curv[3]);
			DragonCurve dCurve = new DragonCurve(x, y, dir);
			dCurve.nextGeneration(gen);
			dCurve.checkArea();
		}
		int answer = checkDrangonCurve();
		System.out.println(answer);
	}

	static class DragonCurve {
		int x;
		int y;
		LinkedList<Point> body = new LinkedList<Point>();
		Stack<Integer> s_dir = new Stack<Integer>();

		public DragonCurve(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			body.add(new Point(x, y));
			body.add(go(dir));
			s_dir.push(dir);
		}

		public void nextGeneration(int gen) {
			for (int i = 0; i < gen; i++) {
				Stack<Integer> temp_s = new Stack<Integer>();
				temp_s.addAll(s_dir);
				while (!temp_s.isEmpty()) {
					int dir = temp_s.pop();
					dir = dir + 1 < 4 ? dir + 1 : 0;
					body.add(go(dir));
					s_dir.push(dir);
				}
			}
		}

		public Point go(int dir) {
			x += DIR[dir][0];
			y += DIR[dir][1];
			return new Point(x, y);
		}

		public void checkArea() {
			for (Point pt : body) {
				map[pt.y][pt.x] = 1;
			}
		}
	}

	public static int checkDrangonCurve() {
		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i][j + 1] == 1) {
					if (map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
						answer++;
					}
				}
			}
		}
		return answer;
	}
}
