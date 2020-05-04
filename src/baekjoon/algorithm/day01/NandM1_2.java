package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NandM1_2 {

	static int[] list;
	static boolean[] bool;
	static int N, M;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		list = new int[M];
		bool = new boolean[N + 1];
		solution(0);

		bw.flush();
		bw.close();
	}

	public static void solution(int num) {
		if (num == M) {
			try {
				for (int i = 0; i < M; i++) {
					bw.write(String.valueOf(list[i]));
					bw.write(" ");
				}
				bw.write("\n");
				return;
			} catch (Exception e) {
			}

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
