package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NandM3_2 {

	static int[] list;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		list = new int[M];
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		sol(N, M, 0);
		bw.flush();
		bw.close();
	}

	public static void sol(int N, int M, int num) {
		if (num == M) {
			try {
				for (int i : list) {
					bw.write(String.valueOf(i));
					bw.write(" ");
				}
				bw.write("\n");
			} catch (Exception e) {
				// TODO: handle exception
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			list[num] = i;
			sol(N, M, num + 1);
		}
	}

}
