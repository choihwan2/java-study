package baekjoon.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404_RGB거리_2 {
	
	static final int RED = 0, GREEN = 1, BLUE = 2;
	static int N,house[][],color[], min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		N = Integer.parseInt(br.readLine());
		house = new int[N][3];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		color = new int[N];
		for (int i = 0; i < 3; i++) {
			color[0] = i;
			process(1,house[0][color[0]]);
		}
		
		
	}

	private static void process(int cnt, int sum) {
		if(cnt == N) {
			
			return;
		}
		
		if(color[cnt -1] == RED) {
			
		}
		
	}

}
