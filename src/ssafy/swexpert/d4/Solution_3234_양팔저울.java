package ssafy.swexpert.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3234_양팔저울 {
	static int n, answer;
	static boolean[] isSelected;
	static int[] weights;
	static int[] N2 = {1,2,4,8,16,32,64,128,256,512,1024};
	static int[] F = {1,1,2,6,24,120,720,5040,40320,362880};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int iT = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		weights = new int[10];
		for (int t = 1; t <= iT; t++) {
			n = Integer.parseInt(br.readLine());
			isSelected = new boolean[n];
			answer = 0;
			int remain = 0;
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(stk.nextToken());
				remain += weights[i];
			}
			permu(0, 0, 0, remain);
			bw.append("#" + t + " " + answer);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static void permu(int lSum, int rSum, int cnt, int remain) {
		if (lSum >= remain + rSum) {
			answer += N2[n - cnt] * F[n - cnt];
			return;
		}

		if (rSum > lSum) {
			return;
		}

		if (cnt == n) {
			answer++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			permu(lSum + weights[i], rSum, cnt + 1, remain - weights[i]);
			permu(lSum, rSum + weights[i], cnt + 1, remain - weights[i]);
			isSelected[i] = false;
		}
	}
}
