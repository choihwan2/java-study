package baekjoon.algorithm.simulation;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2804_MakeCrossWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.next();
		String second = sc.next();
		int r = second.length();
		int c = first.length();
		int rPos = 0;
		int cPos = 0;
		char[][] answerMap = new char[r][c];
		for (int i = 0; i < r; i++) {
			Arrays.fill(answerMap[i], '.');
		}
		A: for (int i = 0; i < c; i++) {
			char f = first.charAt(i);
			for (int j = 0; j < r; j++) {
				char s = second.charAt(j);
				if (f == s) {
					cPos = i;
					rPos = j;
					break A;
				}
			}
		}
		answerMap[rPos] = first.toCharArray();
		for (int i = 0; i < r; i++) {
			answerMap[i][cPos] = second.charAt(i);
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(answerMap[i][j]);
			}
			System.out.println();
		}
	}

}
