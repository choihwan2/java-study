package ssafy.study.algorithm.hw200824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_17619_FrogJump {

	private static class Tree implements Comparable<Tree> {
		int index;
		int start;
		int end;

		public Tree(int index, int start, int end) {
			super();
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.start, o.start);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());
		int[] pA = new int[n + 1];
		for (int i = 0; i < pA.length; i++) {
			pA[i] = i;
		}
		TreeSet<Tree> tSet = new TreeSet<>();
		for (int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			tSet.add(new Tree(i, s, d));
		}
		Tree firstT = tSet.pollFirst();
		int l = firstT.start;
		int r = firstT.end;
		int p = firstT.index;
		while (!tSet.isEmpty()) {
			Tree t = tSet.pollFirst();
			if (t.start >= l && t.start <= r) {
				pA[t.index] = p;
				r = Math.max(t.end, r);
			} else {
				l = t.start;
				r = t.end;
				p = t.index;
			}
		}
		StringBuilder answerStb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			stk = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			if (pA[s] == pA[e])
				answerStb.append("1\n");
			else
				answerStb.append("0\n");
		}
		System.out.println(answerStb);
	}
}
