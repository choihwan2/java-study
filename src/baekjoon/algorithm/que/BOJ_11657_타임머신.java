package baekjoon.algorithm.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
	private class Node implements Comparable<Node> {
		int no;
		int totalDistance;

		public Node(int no, int totalDistance) {
			super();
			this.no = no;
			this.totalDistance = totalDistance;
		}



		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.totalDistance, o.totalDistance);
		}

	}

	static int N, M, adjMatrix[][];
	static final int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		adjMatrix = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(adjMatrix[i], MAX);
		}
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			// 거리 최소화
			if (adjMatrix[f][t] > d) {
				adjMatrix[f][t] = d;
			}
		}

		int[] dist = new int[N + 1];
		boolean[] isVisitied = new boolean[N + 1];
		Arrays.fill(dist, MAX);
		dist[1] = 0;
		Queue<Integer> pq = new LinkedList<>();
		pq.add(1);

		while (!pq.isEmpty()) {
			int i = pq.poll();
			if (isVisitied[i])
				continue;
			isVisitied[i] = true;

			for (int j = 1; j <= N; j++) {
				if (adjMatrix[i][j] != MAX && dist[j] > adjMatrix[i][j] + dist[i]) {
					dist[j] = adjMatrix[i][j] + dist[i];
					pq.add(j);
				}
			}
		}
//		System.out.println(Arrays.toString(dist));

		for (int i = 1; i <= N; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				continue;

			for (int j = 1; j <= N; j++) {
				if (adjMatrix[i][j] != MAX && dist[j] > adjMatrix[i][j] + dist[i]) {
					dist[j] = adjMatrix[i][j] + dist[i];
					System.out.println(-1);
					return;
				}
			}
		}

		for (int k = 2; k <= N; k++) {
			System.out.println(dist[k] == MAX ? -1 : dist[k]);
		}
	}
}
