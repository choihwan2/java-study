package baekjoon.algorithm.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1079_마피아 {
	static int N, guiltyArr[], map[][], player, answer = 0;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		// 500..
		guiltyArr = new int[N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			guiltyArr[i] = Integer.parseInt(stk.nextToken());
		}
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		isSelected = new boolean[N];
		player = Integer.parseInt(br.readLine());

		process(0, N);
		
		System.out.println(answer);
	}

	private static void process(int cnt, int remain) {
		if (remain == 1) {
			if (answer < cnt) {
				answer = cnt;
			}
			return;
		}

		if (remain % 2 == 0) {
			// 짝수일때 마피아가 사람을 하나 죽인다
			for (int i = 0; i < N; i++) {
				if (i == player || isSelected[i])
					continue;
				isSelected[i] = true;
				calculateMap(i, 1);
				process(cnt + 1, remain - 1);
				calculateMap(i, -1);
				isSelected[i] = false;
			}
		} else {
			// 홀수일때 낮에 가장 큰 유죄지수의 사람이 죽는다
			int kill = judge();
			if (kill == player) {
				if (answer < cnt) {
					answer = cnt;
				}
				return;
			}
			isSelected[kill] = true;
			process(cnt, remain - 1);
			isSelected[kill] = false;
		}
	}

	private static void calculateMap(int i, int how) {
		for (int j = 0; j < guiltyArr.length; j++) {
			guiltyArr[j] += (how * map[i][j]);
		}
	}

	private static int judge() {
		int choose = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			if (max < guiltyArr[i]) {
				max = guiltyArr[i];
				choose = i;
			}
		}
		return choose;
	}

}
