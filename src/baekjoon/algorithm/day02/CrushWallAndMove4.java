package baekjoon.algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class CrushWallAndMove4 {

	/*
	 * 처음 배열의 자료구조를 잘못 잡았다.. int 로 한후 다시 도전해보자.
	 */

	static int[][] baseMap;
	static int[][] answerMap;
	static boolean[][] groupMap;
	static ArrayList<Integer> arrGroupCnt = new ArrayList<>();
	static char groupNum = 2;
	static final int[][] DIR = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		baseMap = new int[N][M];
		answerMap = new int[N][M];
		groupMap = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				int num = Character.getNumericValue(line.charAt(j));
				baseMap[i][j] = num;
				answerMap[i][j] = num;
			}
		}
		makeGroup();
		crushWall();
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				stb.append(answerMap[i][j]);
			}
			stb.append("\n");
		}

		System.out.println(stb.toString());
	}

	private static void makeGroup() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (baseMap[i][j] == 0) {
					// 그룹화 시키기
					int groupCnt = 0;
					Queue<Integer> que = new LinkedList<Integer>();
					groupMap[i][j] = true;
					baseMap[i][j] = groupNum;
					que.add(i);
					que.add(j);
					while (!que.isEmpty()) {
						int x = que.poll();
						int y = que.poll();
						groupCnt++;
						for (int k = 0; k < 4; k++) {
							int tX = x + DIR[k][0];
							int tY = y + DIR[k][1];
							if (tX >= 0 && tX < N && tY >= 0 && tY < M) {
								if (baseMap[tX][tY] == 0 && !groupMap[tX][tY]) {
									groupMap[tX][tY] = true;
									baseMap[tX][tY] = groupNum;
									que.add(tX);
									que.add(tY);
								} else {
									continue;
								}
							}
						}
					}
					arrGroupCnt.add(groupCnt);
					groupNum++;
				}
			}
		}
	}

	private static void crushWall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (baseMap[i][j] == 1) {
					Set<Integer> temp = new HashSet<Integer>();
					for (int k = 0; k < 4; k++) {
						int tX = i + DIR[k][0];
						int tY = j + DIR[k][1];
						if (tX >= 0 && tX < N && tY >= 0 && tY < M && baseMap[tX][tY] != 1) {
							temp.add(baseMap[tX][tY] - 2);
						}
					}
					int sum = 1;
					for (Integer integer : temp) {
						sum += arrGroupCnt.get(integer);
					}
					answerMap[i][j] = sum % 10;
				}

			}
		}
	}

}
