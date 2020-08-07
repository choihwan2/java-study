package com.choihwan2.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.sun.org.apache.regexp.internal.recompile;

/*
 * 
6 4
0100
1110
1000
0000
0111
0000
 */
public class WallClashAndMove {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] oneLine = br.readLine().split(" ");
		int N = Integer.parseInt(oneLine[0]);
		int M = Integer.parseInt(oneLine[1]);
		char[][] mazeMap = new char[N][M];
		for (int i = 0; i < N; i++) {
			mazeMap[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mazeMap[i][j] == '1') {
					mazeMap[i][j] = '0';
					int n = clashWall(i,j);
					mazeMap[i][j] = '1'; 
				}
			}
		}

	}

	private static int clashWall(int i, int j) {
		int dis = -1;
		return dis;
	}
}
