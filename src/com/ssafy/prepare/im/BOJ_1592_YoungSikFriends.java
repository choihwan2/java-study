package com.ssafy.prepare.im;

import java.util.Scanner;

public class BOJ_1592_YoungSikFriends {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();

		int[] arr = new int[n];
		int now = 0;
		int cnt = 0;
		while(++arr[now] < m) {
			cnt++;
			now = throwBall(now, l, arr);
		}
		System.out.println(cnt);
	}

	private static int throwBall(int now, int l, int[] arr) {
		int next = 0;

		// 짝수
		if (arr[now] % 2 == 0) {
			next = now + l >= arr.length ? now + l - arr.length : now + l;
		} // 홀수
		else {
			next = now - l < 0 ? arr.length + now - l : now - l;
		}
		return next;
	}

}
