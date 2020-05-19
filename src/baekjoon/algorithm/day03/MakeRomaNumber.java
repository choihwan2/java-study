package baekjoon.algorithm.day03;

import java.util.Scanner;

public class MakeRomaNumber {
	static int N;
	static boolean[] numBool = new boolean[1001];
	static int answer = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N - i; j++) {
				for (int z = 0; z <= N - i - j; z++) {
					if (numBool[i * 1 + j * 5 + z * 10 + (N - i - j - z) * 50] == false) {
						numBool[i * 1 + j * 5 + z * 10 + (N - i - j - z) * 50] = true;
						answer++;
					}
				}
			}
		}

		System.out.println(answer);
		scanner.close();
	}
}
