package ssafy.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238_Contact {
	static final int SIZE = 101;
	static boolean[][] map = new boolean[SIZE][SIZE];
	static boolean[] isVisted = new boolean[SIZE];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		for (int t = 1; t <= 10; t++) {
			// 초기화
			int start = Integer.parseInt(br.readLine().split(" ")[1]);
			for (int r = 0; r < map.length; r++) {
				Arrays.fill(map[r], false);
			}
			Arrays.fill(isVisted, false);
			stk = new StringTokenizer(br.readLine());
			while (stk.hasMoreTokens()) {
				map[Integer.parseInt(stk.nextToken())][Integer.parseInt(stk.nextToken())] = true;
			}
			Queue<Integer> que = new LinkedList<Integer>();
			que.add(start);
			isVisted[start] = true;
			int max = 0;
			while (!que.isEmpty()) {
				int queSize = que.size();
				max = 0;
				for (int i = 0; i < queSize; i++) {
					int row = que.poll();
					if (max < row)
						max = row;
					for (int c = 0; c < map[row].length; c++) {
						if (map[row][c] == true && !isVisted[c]) {
							isVisted[c] = true;
							que.add(c);
						}
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}

}
