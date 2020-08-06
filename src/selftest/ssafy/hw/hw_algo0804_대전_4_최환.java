package selftest.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hw_algo0804_대전_4_최환 {
	static int[] arr;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		arr = new int[n + 1];
		rank = new int[n + 1]; // 트리의 깊이를 측정
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			union(a,b);
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (i == arr[i])
				cnt++;
		}
		System.out.println(cnt);
	}

	public static int find(int x) {
		if (x == arr[x]) {
			return x;
		}
		return arr[x] = find(arr[x]);
	}

	static void union(int a, int b) {
		int pA = find(a);
		int pB = find(b);

		if (rank[pA] < rank[pB]) {
			// 트리의 깊이를 서로 비교해서 작은것을 큰것아래에 붙인다.(트리의 깊이 최소화)
			arr[pA] = pB;
		} else {
			arr[pB] = pA;
			if (rank[pA] == rank[pB]) {
				rank[pA]++;
			}
		}
	}
}
