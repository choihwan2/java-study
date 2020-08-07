package com.ssafy.day0722;

import java.util.Scanner;

public class RobotMoveDistance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			int answer = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					map[j][k] = sc.next().charAt(0);
				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					char now = map[j][k];
					if (now == 'A') {
						//우
						for (int y = k + 1; y < N; y++) {
							if (map[j][y] == 'S')
								answer++;
							else
								break;
						}
					} else if (now == 'B') {
						// 우
						for (int y = k + 1; y < N; y++) {
							if (map[j][y] == 'S')
								answer++;
							else
								break;
						}
						// 좌
						for (int y = k - 1; y >= 0; y--) {
							if (map[j][y] == 'S')
								answer++;
							else
								break;
						}
					} else if (now == 'C') {
						// 우
						for (int y = k + 1; y < N; y++) {
							if (map[j][y] == 'S')
								answer++;
							else
								break;
						}
						// 좌
						for (int y = k - 1; y >= 0; y--) {
							if (map[j][y] == 'S')
								answer++;
							else
								break;
						}
						// 상
						for (int x = j - 1; x >= 0; x--) {
							if (map[x][k] == 'S')
								answer++;
							else
								break;
						}
						// 하
						for (int x = j + 1; x < N; x++) {
							if (map[x][k] == 'S')
								answer++;
							else
								break;
						}
					}
				}
			}
			System.out.println("#" + i + " " + answer);
		}
	}

}
