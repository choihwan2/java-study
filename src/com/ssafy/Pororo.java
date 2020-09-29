package com.ssafy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pororo {
	static int R, C, realPath[][], maxDist = 0;
	static final int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static char[][] map;
	public static int execute(File path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));

		// 구현하세요.
		// 입력
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 거리 맵 초기화
		realPath = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(realPath[i], -1);
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'L' && realPath[r][c] == -1) {
					// 가장 먼 거리의 기준점을 탐색
					int[] pos = findPosInMap(r, c);
					// 기준점의 좌표값으로 다시한번 탐색하면서 realPath를 채움 그리고 기준점에서 가장 먼 거리를 반환받는다.
					int temp = fillRealPath(pos);
					// 보물의 최장거리 갱신
					if (temp > maxDist) {
						maxDist = temp;
					}
				}
			}
		}

		br.close();
		// 가장 먼 거리이면서 최단거리 반환
		return maxDist; // 리턴값을 수정하세요
	} // end of execute

	private static int[] findPosInMap(int r, int c) {
		// BFS 를 통한 기준점 잡기
		boolean[][] isVisited = new boolean[R][C];
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { r, c });
		isVisited[r][c] = true;
		int[] lastPos = new int[2];
		while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int i = 0; i < 4; i++) {
				int mR = now[0] + dr[i];
				int mC = now[1] + dc[i];
				if (isInMap(mR, mC) && !isVisited[mR][mC] && map[mR][mC] == 'L') {
					isVisited[mR][mC] = true;
					que.add(new int[] { mR, mC });
					lastPos[0] = mR;
					lastPos[1] = mC;
				}
			}
		}
		return lastPos;
	}

	private static int fillRealPath(int[] pos) {
		// BFS 를 통해 기준값에서 가장 멀리 떨어져있는 거리를 구한다
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(pos);
		int dist = 0;
		realPath[pos[0]][pos[1]] = 0;
		while (!que.isEmpty()) {
			int qSize = que.size();
			for (int i = 0; i < qSize; i++) {
				int[] now = que.poll();
				for (int j = 0; j < 4; j++) {
					int mR = now[0] + dr[j];
					int mC = now[1] + dc[j];
					if (isInMap(mR, mC) && realPath[mR][mC] == -1 && map[mR][mC] == 'L') {
						que.add(new int[] { mR, mC });
						realPath[mR][mC] = realPath[now[0]][now[1]] + 1;
						dist = realPath[now[0]][now[1]] + 1;
					}
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(execute(new File("input.txt")));
	}

	private static boolean isInMap(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) {
			return true;
		} else
			return false;
	}
} // end of class
