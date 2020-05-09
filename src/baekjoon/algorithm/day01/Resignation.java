package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Resignation {

	static int max = 0;
	static int min_num = 0;
	static int N;
	static Work[] works;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		works = new Work[N];
		for (int i = 0; i < N; i++) {
			String[] TP = br.readLine().split(" ");
			works[i] = new Work(Integer.parseInt(TP[0]), Integer.parseInt(TP[1]));
		}
		sol(0, 0, 0);

		System.out.println(max);

	}

	public static void sol(int day, int tem_max, int num) {
		if (day > N)
			return;

		if (day <= N) {
			max = Math.max(max, tem_max);
		}

		for (int i = day; i < N; i++) {
			sol(i + works[i].T, tem_max + works[i].P, num + 1);
		}
	}

}

class Work {
	int T;
	int P;

	public Work(int t, int p) {
		super();
		T = t;
		P = p;
	}

}
