package baekjoon.algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Emoticon {
	static final int MAX = 4000;
	static final int MIN = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] list = new int[MAX];
		boolean[] bool_list = new boolean[MAX];
		Queue<Integer> que = new LinkedList<Integer>();
		int first = 1;

		list[first] = 0;
		bool_list[first] = true;
		que.add(first);
		/*
		 * 1
		 * 2 => 2
		 * 4 => 4 // 3 => 3
		 * 8 => 6 6 => 5
		 * 16 => 8 12,7 => 7 5 => 6 
		 */
		while (!que.isEmpty()) {
			int v = que.poll();
			if (v % 2 == 0 && v + v / 2 < MAX) {
				if (!bool_list[v + v / 2]) {
					bool_list[v + v / 2] = true;
					list[v + v / 2] = list[v] + 1;
					que.add(v + v / 2);
				}
			}

			if (v - 1 >= MIN) {
				if (!bool_list[v - 1]) {
					bool_list[v - 1] = true;
					list[v - 1] = list[v] + 1;
					que.add(v - 1);
				}
			}
			if (v * 2 < MAX) {
				if (!bool_list[v * 2]) {
					bool_list[v * 2] = true;
					list[v * 2] = list[v] + 2;
					que.add(v * 2);
				}
			}

		}

		System.out.println(list[N]);

	}

}
