package com.ssafy.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3289_test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int[] headX = new int[n + 1];
			int[] rankX = new int[n + 1];
			for (int i = 1; i < headX.length; i++) {
				headX[i] = i;
			}
			StringBuilder stb = new StringBuilder();
			stb.append("#").append(t).append(" ");

			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(stk.nextToken());
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				if (order == 0) {
					union(from, to, headX, rankX);
				} else if (order == 1) {
					if (find(from, headX) == find(to, headX)) {
						stb.append(1);
					} else {
						stb.append(0);
					}
				}
			}
			System.out.println(stb.toString());
		}
	}

	private static int find(int n, int[] headX) {
		if (headX[n] == n)
			return n;
		return headX[n] = find(headX[n], headX);
	}

	private static void union(int a, int b, int[] head, int[] rank) {
		int pA = find(a, head);
		int pB = find(b, head);
		if (pA != pB) {
			if (rank[pA] < rank[pB]) {
				head[pA] = pB;
			} else {
				head[pB] = pA;
				if (rank[pA] == rank[pB])
					rank[pA]++;
			}
		}
	}
}
