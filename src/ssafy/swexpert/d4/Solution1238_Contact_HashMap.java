package ssafy.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238_Contact_HashMap {
	static final int SIZE = 101;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		for (int t = 1; t <= 10; t++) {
			// 초기화
			HashMap<Integer, HashSet<Integer>> contactMap = new HashMap<>();
			boolean[] isVisited = new boolean[101];

			int start = Integer.parseInt(br.readLine().split(" ")[1]);
			stk = new StringTokenizer(br.readLine());
			while (stk.hasMoreTokens()) {
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				if (contactMap.containsKey(from)) {
					contactMap.get(from).add(to);
				} else {
					contactMap.put(from, new HashSet<>());
					contactMap.get(from).add(to);
				}
			}
			Queue<Integer> que = new LinkedList<Integer>();
			que.add(start);
			isVisited[start] = true;
			int max = 0;
			while (!que.isEmpty()) {
				int queSize = que.size();
				max = 0;
				for (int i = 0; i < queSize; i++) {
					int row = que.poll();
					if (max < row)
						max = row;

					if (contactMap.containsKey(row)) {
						for (Integer col : contactMap.get(row)) {
							if (isVisited[col])
								continue;
							isVisited[col] = true;
							que.add(col);
						}
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}

}
