package com.ssafy.day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7465_ChangYongTown {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int max = N;
			int[] pX = new int[N + 1];
			for (int i = 0; i < pX.length; i++) {
				pX[i] = i;
			}
			for (int i = 0; i < M; i++) {
				stk = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				if (union(from, to, pX)) {
					max--;
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}

	private static boolean union(int f, int t, int[] pX) {
		f = find(f, pX);
		t = find(t, pX);
		if (f != t) {
			pX[f] = t;
			return true;
		} else {
			return false;
		}
	}

	private static int find(int f, int[] pX) {
		if (pX[f] == f)
			return f;
		else
			return pX[f] = find(pX[f], pX);
	}
}
