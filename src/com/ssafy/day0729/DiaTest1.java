package com.ssafy.day0729;

import java.util.Scanner;

public class DiaTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < Math.abs(i - n / 2); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n - 2 * Math.abs(i - n / 2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	/*
	 * 완전탐색을 손으로
	 * npr, ncr 부분
	 * 2001번
	 * 복습 - 오늘 한것, 완탐 다외우기
	 * 암기 -comparator
	 */
}
