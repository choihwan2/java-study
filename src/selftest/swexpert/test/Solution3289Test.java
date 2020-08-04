package selftest.swexpert.test;

import java.util.Scanner;

public class Solution3289Test {
	static int T, N, M;
	static int[] parents;
	static int c, a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			parents = new int[N + 1];
			for (int i = 1; i < parents.length; i++) {
				parents[i] = i;
			}

			StringBuilder stb = new StringBuilder();
			stb.append("#").append(t).append(" ");

			for (int i = 0; i < M; i++) {
				c = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();
				switch (c) {
				case 0:
					union(a, b);
					break;
				case 1:
					stb.append((find(a) == find(b)) ? "1" : "0");
					break;
				}
			}
			System.out.println(stb.toString());
		}
	}

	private static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	private static void union(int x, int y) {
		int xZZang = find(x);
		int yZZang = find(y);
		if (xZZang != yZZang)
			parents[yZZang] = xZZang;
	}
}
