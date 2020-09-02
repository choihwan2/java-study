package baekjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15954_인형들 {
	static double answer = Double.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		int[] numArr = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(stk.nextToken());
		}
		
		// K 개 이상이니깐 계속해서 N개까지 커지면서 간다.
		
		for (int i = K; i <= N; i++) {
			
			// 시작점을 가지고 정답을 구해내는 메소드를 호출한다
			for (int j = 0; j <= N - i; j++) {
				go(j, i, numArr);
			}
		}
		System.out.println(answer);
	}

	private static void go(int j, int k, int[] nums) {
		// 평균
		double sum = 0;
		for (int i = j; i < j + k; i++) {
			sum += nums[i];
		}
		double avg = sum / k;

		
		//분산
		double bSan = 0.0;
		for (int i = j; i < j + k; i++) {
			bSan += Math.pow(nums[i] - avg, 2);
		}
		bSan /= k;

		
		// 표준편차
		double temp = Math.sqrt(bSan);

		if (answer > temp) {
			answer = temp;
		}
	}

}
