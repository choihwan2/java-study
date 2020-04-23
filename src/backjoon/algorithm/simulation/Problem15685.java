package backjoon.algorithm.simulation;

import java.awt.Point;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

import javafx.geometry.Side;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class DragonCurve {
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

	}

}
