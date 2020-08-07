package com.ssafy.day0807;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2961_DoyoungGoodFood {
	static int answer = Integer.MAX_VALUE, sour[], bitter[], N;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sour = new int[N];
		bitter = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			dfs(0, 0, i);
		}
		System.out.println(answer);
	}

	private static void dfs(int start, int index, int n) {
		if (index == n) {
			int sumSour = 1;
			int sumBitter = 0;
			System.out.println(Arrays.toString(isSelected));
			for (int i = 0; i < isSelected.length; i++) {
				if (isSelected[i]) {
					sumSour *= sour[i];
					sumBitter += bitter[i];
				}
			}
			answer = Math.min(answer, Math.abs(sumSour - sumBitter));
			return;
		}
		for (int i = start; i < N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			dfs(i + 1, index + 1, n);
			isSelected[i] = false;
		}
	}
}
