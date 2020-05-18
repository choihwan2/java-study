package baekjoon.algorithm.day02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CrushWallAndMove4 {

	static char[][] baseMap;
	static int[][] groupMap;
	static ArrayList<Integer> arrGroupCnt = new ArrayList<>();
	static char groupNum = 'A';
	static final int[][] DIR = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		baseMap = new char[N][M];
		for (int i = 0; i < N; i++) {
			baseMap[i] = br.readLine().toCharArray();
		}
		makeGroup();

	}

	private static void makeGroup() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (baseMap[i][j] == '0') {
					// 그룹화 시키
					int groupCnt = 0;
					Queue<Integer> que = new LinkedList<Integer>();
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
								if(baseMap[tX][tY] == '0') {
									baseMap[tX][tY] = groupNum;
									que.add(tX);
									que.add(tY);
								}else {
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
	

}
