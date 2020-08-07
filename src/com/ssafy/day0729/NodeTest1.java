package com.ssafy.day0729;

import java.util.Arrays;
import java.util.Comparator;

public class NodeTest1 {
	private static class Points implements Comparator<Points> {
		int r;
		int c;
		
		public Points() {
			// TODO Auto-generated constructor stub
		}

		public Points(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Points [r=" + r + ", c=" + c + "]";
		}

		@Override
		public int compare(Points p1, Points p2) {
			// Lexico 사전식 정렬
			// 'B' - 'A' = 66 - 65 = 1
			double r1 = Math.sqrt(p1.r * p1.r + p1.c * p1.c);
			double r2 = Math.sqrt(p2.r * p2.r + p2.c * p2.c);
			if (r1 - r2 > 0) {
				return 1; // ascending
			} else if (r1 - r2 < 0) {
				return -1;
			} else
				return 0;
		}

	}

	public static void main(String[] args) {
		Points[] points = new Points[5];
		points[0] = new Points(1, 2);
		points[1] = new Points(-4, 2);
		points[2] = new Points(-1, 2);
		points[3] = new Points(1, 3);
		points[4] = new Points(2, 3);

		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
			
		}
		System.out.println("---------------------------");
		Arrays.sort(points, new Points());
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
	}

}
