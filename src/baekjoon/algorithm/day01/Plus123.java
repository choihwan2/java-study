package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus123 {

	static int answer;

	public static void main(String[] args) throws IOException {
		int[] answer_num;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t_case = Integer.parseInt(br.readLine());
		answer_num = new int[t_case];

		for (int i = 0; i < t_case; i++) {
			answer = 0;
			sol(0, Integer.parseInt(br.readLine()));
			answer_num[i] = answer;
		}

		for (int i : answer_num) {
			System.out.println(i);
		}

	}

	public static void sol(int start, int purpose_num) {
		if (start == purpose_num) {
			answer++;
			return;
		}

		if (start < purpose_num) {
			for (int i = 1; i <= 3; i++) {
				sol(start + i, purpose_num);
			}
		}
	}

}
