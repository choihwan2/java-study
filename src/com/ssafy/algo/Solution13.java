package com.ssafy.algo;

import java.util.Scanner;

public class Solution13 {
	static final int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 }, dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			char[][] buildingMap = new char[N][N];
			int answer = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (sc.next().charAt(0) == 'B')
						buildingMap[j][k] = 'B';
					else
						buildingMap[j][k] = 'G';
				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					char now = buildingMap[j][k];
					if (now == 'B') {
						// 8방 확인
						for (int m = 0; m < 8; m++) {
							int mX = j + dx[m];
							int mY = k + dy[m];
							// 맵을 벗어났거나 옆이 빌딩인 경우
							if (mX < 0 || mY < 0 || mX >= N || mY >= N || buildingMap[mX][mY] == 'B') {

							} else if (buildingMap[mX][mY] == 'G') {
								if (answer == 0)
									answer = 2;
								break;
							}

							// 마지막까지 돌았다면?
							if (m == 7) {
								int height = 0;
								for (int x = 0; x < N; x++) {
									if (buildingMap[x][k] == 'B')
										height++;
									if (buildingMap[j][x] == 'B')
										height++;
								}
								if (answer < height)
									answer = height - 1;
							}
						}
					}
				}
			}
			System.out.println("#" + i + " " + answer);
		}
	}
}
