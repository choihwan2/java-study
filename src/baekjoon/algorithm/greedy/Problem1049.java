package baekjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1049 {
	// 이 문제에서 중요한건 먼저 돈을 최소로 만드는게 첫번째 중점
	// 낱개로 6개사는게 묶음보다 쌀경우 무조건 낱개로만 사야한다.
	// 번들이 더 쌀 경우에는 6개씩 사는데 낱개로 몇개까지 사는게 경제적인가 체크해야함.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int bundle_p = 1001;
		int one_p = 1001;
		for (int i = 0; i < M; i++) {
			String[] price = br.readLine().split(" ");
			bundle_p = Math.min(bundle_p, Integer.parseInt(price[0]));
			one_p = Math.min(one_p, Integer.parseInt(price[1]));
		}
		if (bundle_p > one_p * 6) {
			System.out.println(N * one_p);
			return;
		}
		int bundle_num = N/6;
		int rest = N % 6;
		int rest_p = bundle_p < rest * one_p ? bundle_p : rest * one_p;
		int answer = bundle_p * bundle_num + rest_p;
		System.out.println(answer);
	}
}
