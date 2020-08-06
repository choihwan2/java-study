package baekjoon.algorithm.recursive;

import java.util.Scanner;

public class Problem2961 {
	static int answer;
	static int[] sour, bitter;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		answer = Integer.MAX_VALUE;
		sour = new int[n];
		bitter = new int[n];
		isSelected = new boolean[n];
		for (int i = 0; i < n; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		getAnswer(0, n);
		System.out.println(answer);
	}

	private static void getAnswer(int start, int n) {
		if (start == n) {
			int sourSum = 1, bitterSum = 0, temp = 0;
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) {
					sourSum *= sour[i];
					bitterSum += bitter[i];
				}
			}
			if (bitterSum == 0)
				return;
			temp = Math.abs(sourSum - bitterSum);
			answer = Math.min(answer, temp);
			return;
		}

		isSelected[start] = true;
		getAnswer(start + 1, n);
		isSelected[start] = false;
		getAnswer(start + 1, n);
	}
}
