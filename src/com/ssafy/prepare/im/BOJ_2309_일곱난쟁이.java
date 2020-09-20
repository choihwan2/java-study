package com.ssafy.prepare.im;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {

	static int[] arr, small;
	static boolean[] isSelected;
	static boolean isOver;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		isSelected = new boolean[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		small = new int[7];

		process(0, 0);
	}

	private static void process(int cnt, int sum) {
		if (isOver)
			return;
		if (sum == 100 && cnt == 7) {
			isOver = true;
			Arrays.sort(small);
			for (int i = 0; i < small.length; i++) {
				System.out.println(small[i]);
			}
			return;
		}

		if (cnt == 7 && sum != 100)
			return;

		for (int i = 0; i < arr.length; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			small[cnt] = arr[i];
			process(cnt + 1, sum + arr[i]);
			isSelected[i] = false;
		}
	}

}
