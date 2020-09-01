package baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5582_공통부분문자열DP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();

		int[][] dp = new int[s1.length][s2.length];
		int answer = 0;
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				if (s1[i] == s2[j]) {
					if (i == 0 || j == 0)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i - 1][j - 1] + 1;

					if (answer < dp[i][j])
						answer = dp[i][j];
				}
			}
		}
		System.out.println(answer);
	}
}
