package selftest.ssafy.hw;

import java.util.Scanner;

public class Main {
	static int[] arr;// 부모를 나타내는 집합
	static int[] cnt;// 자기를 대표로 하는 집합안에 있는 원소의 수

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N + 1];
		cnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
			cnt[i] = 1;
		}
		for (int i = 0; i < M; i++)
			union(sc.nextInt(), sc.nextInt());
		int[] visit = new int[N + 1];// 최종 대표
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			find(i);
			visit[arr[i]]++;
		}
		for (int i = 1; i <= N; i++)
			if (visit[i] != 0)
				ans++;
	}

	static int find(int n) {
		if (n == arr[n])
			return n;
		int p = find(arr[n]);
		arr[n] = p;
		cnt[p]++;// n이 p 안에 들어갔으므로 p 안에 있는 원소를 하나 더 추가한다.
		return p;
	}

	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		if (p1 != p2) {
			if (cnt[p1] < cnt[p2]) {// 더 작은 애를 바꿔줘야 시간초과 안남
				arr[p1] = p2;
				cnt[p1] += cnt[p2];
			} else {
				arr[p2] = p1;
				cnt[p2] += cnt[p1];
			}
		}
	}
}