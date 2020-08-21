package ssafy.study.algorithm.hw200824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10836_QueenBee {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int[] growWarm = new int[2 * N - 1];
		int[][] warm = new int[N][N];
		Arrays.fill(growWarm, 1);

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int g1 = Integer.parseInt(stk.nextToken());
			int g2 = Integer.parseInt(stk.nextToken());
			int g3 = Integer.parseInt(stk.nextToken());

			for (int j = 0; j < growWarm.length; j++) {
				if (g1-- > 0) {
					continue;
				}
				if (g2-- > 0) {
					growWarm[j] += 1;
					continue;
				}
				if (g3-- > 0) {
					growWarm[j] += 2;
					continue;
				}
			}
		}
		StringBuilder baseStb = new StringBuilder();

		for (int i = 0; i < growWarm.length; i++) {
			if (N - 1 - i >= 0) {
				warm[N - 1 - i][0] = growWarm[i];
			} else {
				warm[0][Math.abs(N - 1 - i)] = growWarm[i];
				baseStb.append(growWarm[i] + " ");
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				warm[i][j] = warm[i - 1][j];
			}
		}

		for (int i = 0; i < warm.length; i++) {
			bw.append(warm[i][0] + " ");
			bw.append(baseStb.toString());
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
