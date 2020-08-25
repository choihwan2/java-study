package ssafy.study.algorithm.hw200824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_17619_FrogJumpUnionfind {

	private static class Log implements Comparable<Log> {
		int sX;
		int eX;
		int index;

		public Log(int sX, int eX, int index) {
			super();
			this.sX = sX;
			this.eX = eX;
			this.index = index;
		}

		@Override
		public int compareTo(Log o) {
			return Integer.compare(this.sX, o.sX);
		}

	}

	static int[] pA;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());
		pA = new int[n + 1];
		for (int i = 1; i < pA.length; i++) {
			pA[i] = i;
		}

		ArrayList<Log> logArr = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine());
			int sX = Integer.parseInt(stk.nextToken());
			int eX = Integer.parseInt(stk.nextToken());
			logArr.add(new Log(sX, eX, i));
		}

		Collections.sort(logArr);
		for (int i = 1; i < logArr.size(); i++) {
			if (logArr.get(i).sX <= logArr.get(i - 1).eX) {
				union(logArr.get(i).index, logArr.get(i - 1).index);
				logArr.get(i).eX = Math.max(logArr.get(i).eX, logArr.get(i - 1).eX);
			}
		}

		for (int i = 0; i < q; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			if (findUp(a) == findUp(b)) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}

	}

	private static int findUp(int a) {
		if (pA[a] == a)
			return a;
		pA[a] = findUp(pA[a]);
		return pA[a];
	}

	private static void union(int a, int b) {
		int parentA = findUp(a);
		int parentB = findUp(b);

		pA[parentB] = parentA;
	}

}
