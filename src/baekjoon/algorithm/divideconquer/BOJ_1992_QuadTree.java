package baekjoon.algorithm.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_QuadTree {
	static char[][] map;
	static StringBuilder stb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		map = new char[s][s];
		stb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		divide(0, 0, s);
		System.out.println(stb.toString());
	}
	
	private static boolean check(int r, int c, int s) {
		char standard = map[r][c];
		for (int i = r; i < r + s; i++) {
			for (int j = c; j < c + s; j++) {
				if(standard != map[i][j])
					return false;
			}
		}
		return true;
	}
	
	private static void divide(int r, int c, int s) {
		if(check(r, c, s)) {
			stb.append(map[r][c]);
		}else {
			stb.append("(");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(r + i * s/2, c + j * s/2, s /2);
				}
			}
			stb.append(")");
		}
	}

}
