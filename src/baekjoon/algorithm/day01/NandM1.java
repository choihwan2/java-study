package baekjoon.algorithm.day01;

import java.util.Scanner;

public class NandM1 {

	static int[] list;
	static boolean[] bool;
	static int N, M;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();

		list = new int[M];
		bool = new boolean[N + 1];
		
		solution(0);
	}

	public static void solution(int num) {
		if (num == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(bool[i] == true) continue;
			bool[i] = true;
			list[num] = i;
			solution(num + 1);
			bool[i] = false;
		}
	}

}
