package baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2982_국왕의방문_retry {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		int[][] map = new int[N + 1][N + 1];

		stk = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(stk.nextToken());
		int end = Integer.parseInt(stk.nextToken());
		int gap = Integer.parseInt(stk.nextToken());
		int G = Integer.parseInt(stk.nextToken());

		int[] goduralVisit = new int[G];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < G; i++) {
			goduralVisit[i] = Integer.parseInt(stk.nextToken());
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int weight = Integer.parseInt(stk.nextToken());

			if (map[from][to] == 0 || map[from][to] > weight) {
				map[from][to] = weight;
				map[to][from] = weight;
			}
		}
		
		int[] playerDist = new int[N + 1];
		int[] godulaDist = new int[N + 1];
		boolean isVisited[] = new boolean[N + 1];
		Arrays.fill(playerDist, Integer.MAX_VALUE);
		Arrays.fill(godulaDist, Integer.MAX_VALUE);
		godulaDist[goduralVisit[0]] = 0;
		for (int i = 1; i < G; i++) {
			int from = goduralVisit[i-1];
			int to = goduralVisit[i];
			godulaDist[to] = godulaDist[from] + map[from][to];
		}
		
		int min = 0, vertex = start;
		playerDist[start] = gap;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if(!isVisited[i] && playerDist[j] < min) {
					min = playerDist[j];
					vertex = j;
				}
				isVisited[vertex] = true;
				
				for (int k = 0; k < N; k++) {
					if(!isVisited[k] && playerDist[k] > playerDist[vertex] + map[vertex][k]) {
						playerDist[k] = playerDist[vertex] + map[vertex][k];
					}
					
				}
			}
		}
		

	}

}
