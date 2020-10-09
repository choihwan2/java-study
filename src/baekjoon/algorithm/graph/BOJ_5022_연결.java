package baekjoon.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5022_연결 {

	static final int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] A1 = new int[] { sc.nextInt(), sc.nextInt() };
		int[] A2 = new int[] { sc.nextInt(), sc.nextInt() };
		int[] B1 = new int[] { sc.nextInt(), sc.nextInt() };
		int[] B2 = new int[] { sc.nextInt(), sc.nextInt() };

		Queue<int[]> que = new LinkedList<int[]>();
		int[][] dirMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dirMap[i], -1);
		}
		dirMap[B1[0]][B1[1]] = -2;
		dirMap[B2[0]][B2[1]] = -2;
		dirMap[A1[0]][A1[1]] = -2;
		que.add(A1);
		while (!que.isEmpty()) {
			int[] now = que.poll();
			int r = now[0];
			int c = now[1];
			if (r == A2[0] && c == A2[1]) {
				// A 점 이었음
				int len = reverseBfs(r,c,dirMap);
				System.out.println(len);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nR = r + dr[i];
				int nC = c + dc[i];
				if (isInMap(nR, nC) && dirMap[nR][nC] == -1) {
					que.add(new int[] { nR, nC });
					dirMap[nR][nC] = i;
				}
			}
		}
	}

	private static int reverseBfs(int r, int c, int[][] dirMap) {
		int len = 0;
		while(dirMap[r][c] != -2) {
			len++;
			int d = dirMap[r][c];
			r -= dr[d];
			c -= dc[d];
		}
		
		return len;
	}

	private static boolean isInMap(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		} else {
			return false;
		}
	}

}
