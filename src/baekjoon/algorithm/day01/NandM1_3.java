package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NandM1_3 {

	static int[] list;
	static boolean[] bool;
	static int N, M;
	static StringBuilder stb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stb = new StringBuilder();
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		list = new int[M];
		bool = new boolean[N + 1];
		solution(0);
		System.out.println(stb);
	}

	public static void solution(int num) {
		if (num == M) {
			for (int i = 0; i < M; i++) {
				stb.append(list[i]);
				stb.append(" ");
			}
			stb.append("\n");
			return;

		}

		for (int i = 1; i <= N; i++) {
			if (bool[i] == true)
				continue;
			bool[i] = true;
			list[num] = i;
			solution(num + 1);
			bool[i] = false;
		}
	}

}
