package com.ssafy.algo;

import java.util.Scanner;

public class Solution_d1_1954 {
	static final int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int[][] answerMap = new int[N][N];
			// 0 0
			int x = 0;
			int y = 0;
			int dir = 0;
			int num = 1;
			int temp = 0;

			//처음 시작 처리
			answerMap[x][y] = num++;
			
			while (true) {
				// 범위의 안쪽이면서 하나씩 진행해 나간다. 처음 방향은 오른쪽
				while (x + dx[dir] < N && x + dx[dir] >= 0 && y + dy[dir] < N && y + dy[dir] >= 0
						&& answerMap[x + dx[dir]][y + dy[dir]] == 0) {
					// 마지막에 4방향을 확인해줘야하니 여기에 들어왔으면 temp 를 초기화.
					temp = 0;
					
					//하나 전진한 칸을 num++ 하면서 넣어준다.
					answerMap[x + dx[dir]][y + dy[dir]] = num++;
					
					// x 와 y의 값을 이동.
					x = x + dx[dir];
					y = y + dy[dir];
				}
				// 한쪽끝에 도달했으면 방향을 틀어준다 오 -> 밑 -> 왼 -> 위 -> 오
				dir = dir + 1 >= 4 ? 0 : dir + 1;
				
				// 방향을 틀어줬다면 temp를 1더해준다.
				temp += 1;
				
				// 4방향이 모두막혔다면 게임은 끝나야한다.
				if (temp == 4)
					break;
			}
			
			// 출력
			System.out.println("#" + i);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.printf(answerMap[r][c] + " ");
				}
				System.out.println();
			}
		}
	}
}
