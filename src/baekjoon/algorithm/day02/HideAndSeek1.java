package baekjoon.algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek1 {
	static final int MAX = 200000;
	static boolean[] pos_bool;
	static int[] list;
	static int sister_p;
	static Queue<Integer> que = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		pos_bool = new boolean[MAX];
		list = new int[MAX];
		int subin_p = Integer.parseInt(input[0]);
		int sister_p = Integer.parseInt(input[1]);
		list[subin_p] = 0;
		que.add(subin_p);
		pos_bool[subin_p] = true;

		while (!que.isEmpty()) {
			int v = que.poll();

			if (v - 1 >= 0) {
				if (!pos_bool[v - 1]) {
					pos_bool[v - 1] = true;
					que.add(v - 1);
					list[v - 1] = list[v] + 1;
				}
			}
			
			if (v + 1 < MAX) {
				if (!pos_bool[v + 1]) {
					pos_bool[v + 1] = true;
					que.add(v + 1);
					list[v + 1] = list[v] + 1;
				}
			}
			if (v * 2 < MAX) {
				if (!pos_bool[v * 2]) {
					pos_bool[v * 2] = true;
					que.add(v * 2);
					list[v * 2] = list[v] + 1;
				}
			}
		}

		System.out.println(list[sister_p]);
	}

}
