package baekjoon.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17220_마약수사대 {

	static int N, M, map[][], connect[], answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		map = new int[N][N];
		connect = new int[N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int f = stk.nextToken().charAt(0) - 'A';
			int t = stk.nextToken().charAt(0) - 'A';
			map[f][t] = 1;
			connect[t]++;
		}

		stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		for (int i = 0; i < n; i++) {
			int arrest = stk.nextToken().charAt(0) - 'A';
			boolean[] isVisited = new boolean[N];
			connect[arrest] = -1;
			dfs(arrest, isVisited);
		}

		for (int i = 0; i < N; i++) {
			if (connect[i] > 0) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void dfs(int vertex, boolean[] isVisited) {
		isVisited[vertex] = true;
		for (int i = 0; i < N; i++) {
			if (map[vertex][i] == 1 && isVisited[i] == false) {
				dfs(i, isVisited);
				connect[i]--;
			}
		}

	}

}
