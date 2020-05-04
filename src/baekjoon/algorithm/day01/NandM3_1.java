package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM3_1 {

	static int[] list;
	static StringBuilder stb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		list = new int[M];
		stb = new StringBuilder();
		
		sol(N, M, 0);
		System.out.println(stb);
	}

	public static void sol(int N, int M, int num) {
		if (num == M) {
			for (int i : list) {
				stb.append(i);
				stb.append(" ");
			}
			stb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			list[num] = i;
			sol(N, M, num + 1);
		}
	}

}
