package com.ssafy.algo;

import java.util.Scanner;

public class Solution_10032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int answer = N % K == 0 ? 0 : 1;
			System.out.println("#" + i + " " + answer);
		}
	}
}
