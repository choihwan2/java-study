package com.ssafy.prepare.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_BlackJack {

	static int m, nums[], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		nums = new int[n];
		m = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(stk.nextToken());
		}
		getAnswer(0, 0, 0);
		System.out.println(answer);
	}

	private static void getAnswer(int cnt, int start, int sum) {
		if (cnt == 3) {
			if (sum <= m && answer < sum) {
				answer = sum;
			}
			return;
		}
		if (start == nums.length)
			return;

		getAnswer(cnt + 1, start + 1, sum + nums[start]);
		getAnswer(cnt, start + 1, sum);
	}
}
