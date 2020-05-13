package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM2 {

	static StringBuilder stb;
	static int N, M;

	static int[] list;
	static boolean[] bool_list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		list = new int[M];
		bool_list = new boolean[N + 1]; // 숫자는 1부터 시작해서 가니 N + 1 배열의 위치 = 숫자
		stb = new StringBuilder();
		solution(1,0);
		System.out.print(stb);
	}

	public static void solution(int start, int num) {
		if (num == M) {
			for (int i = 0; i < list.length; i++) {
				stb.append(list[i]);
				stb.append(" ");
			}
			stb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			list[num] = i;
			solution(i + 1,num + 1);
		}

	}

}
