package com.ssafy.algo;

import java.util.Scanner;

public class Solution_9839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int[] numArr = new int[N];
			for (int j = 0; j < N; j++) {
				numArr[j] = sc.nextInt();
			}
			int answer = getBestCouple(numArr);
			System.out.println("#" + i + " " + answer);

		}
	}

	public static int getBestCouple(int[] arr) {
		int answer = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			int x = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				int y = arr[j];
				int xy = x * y;
				boolean isOk = true;
				if (xy < 10 && answer < xy) {
					answer = xy;
				}
				char[] numCharArr = String.valueOf(xy).toCharArray();
				if (numCharArr.length > 10)
					continue;
				for (int k = 0; k < numCharArr.length - 1; k++) {
					if (numCharArr[k + 1] - numCharArr[k] != 1) {
						isOk = false;
						break;
					}
				}
				if (isOk && answer < xy)
					answer = xy;
			}
		}

		return answer;
	}
}
