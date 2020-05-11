package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertSign {

	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		String[] inputes = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(inputes[i]);
		}
		String[] signs = br.readLine().split(" ");
		int[] sign = new int[4];
		for (int i = 0; i < 4; i++) {
			sign[i] = Integer.parseInt(signs[i]);
		}
		dfs(1, sign[0], sign[1], sign[2], sign[3], input[0]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int cnt, int p_n, int m_n, int q_n, int d_n, int sum) {
		if (cnt == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		if (p_n - 1 >= 0)
			dfs(cnt + 1, p_n - 1, m_n, q_n, d_n, sum + input[cnt]);
		if (m_n - 1 >= 0)
			dfs(cnt + 1, p_n, m_n - 1, q_n, d_n, sum - input[cnt]);
		if (q_n - 1 >= 0)
			dfs(cnt + 1, p_n, m_n, q_n - 1, d_n, sum * input[cnt]);
		if (d_n - 1 >= 0)
			dfs(cnt + 1, p_n, m_n, q_n, d_n - 1, sum / input[cnt]);
	}

}
