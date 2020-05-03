package baekjoon.algorithm.day01;

import java.util.Scanner;

public class NandM2 {
	static int N, M;

	static int[] list;
	static boolean[] bool_list;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();

		list = new int[M];
		bool_list = new boolean[N + 1]; // 숫자는 1부터 시작해서 가니 N + 1 배열의 위치 = 숫자
		solution(0);
	}

	public static void solution(int num) {
		if (num == M) {
			for (int i = 0; i < list.length; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (bool_list[i] == true)
				continue;
			bool_list[i] = true;
			if (num > 0 && list[num -1] > i) {
				continue;
			}
			list[num] = i;
			solution(num + 1);
			bool_list[i] = false;
		}

	}

}
