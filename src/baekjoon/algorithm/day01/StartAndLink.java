package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartAndLink {

	static int[][] map;
	static boolean[] map_bool;
	static int M;
	static int N;
	static int[] start;
	static int[] link;
	static int answer = 100000001;

	static int start_p = 0;
	static int link_p = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		map_bool = new boolean[N];
		M = N / 2;
		start = new int[M];
		link = new int[M];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				map[i][j] += map[j][i];
			}
		}
		startMember(0);
		System.out.println(answer);
	}

	public static void startMember(int num) {
		if (num == M) {
			start_p = 0;
			for (int i : start) {
				start_p += i;
			}
			linkMember(0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if(map_bool[i] == true) continue;
			map_bool[i] = true;
			start[num] = i; 
		}

	}
	// 접근 방식이 잘못 됐다. 다시 할때는 사람을 갖고 체크해준다음 그안에서 게산을 해줘야할것같다.

	public static void linkMember(int num) {
		if (num == M) {
			link_p = 0;
			for (int i : link) {
				link_p += i;
			}
			answer = Math.min(answer, Math.abs(start_p - link_p));
			return;
		}

	}

}
