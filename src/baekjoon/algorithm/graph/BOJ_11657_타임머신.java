package baekjoon.algorithm.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
	static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	static int N, M, adjMatrix[][];
	static long dist[];
	static final int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		List<Edge> edgeList = new ArrayList<>();
		adjMatrix = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(adjMatrix[i], MAX);
		}
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			// edge 저장 최소화
			if (adjMatrix[f][t] > d) {
				adjMatrix[f][t] = d;
			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (adjMatrix[i][j] != MAX)
					edgeList.add(new Edge(i, j, adjMatrix[i][j]));
			}
		}
		dist = new long[N + 1];
		Arrays.fill(dist, MAX);
		dist[1] = 0L;

		int edgeSize = edgeList.size();
		for (int i = 0; i < N - 1; i++) {

			for (int j = 0; j < edgeSize; j++) {
				Edge edge = edgeList.get(j);
				if (dist[edge.from] == MAX)
					continue;

				if (dist[edge.from] + edge.weight < dist[edge.to]) {
					dist[edge.to] = dist[edge.from] + edge.weight;
				}
			}
		}
		
		for (int j = 0; j < edgeSize; j++) {
			Edge edge = edgeList.get(j);
			if (dist[edge.from] == MAX)
				continue;

			if (dist[edge.from] + edge.weight < dist[edge.to]) {
				dist[edge.to] = dist[edge.from] + edge.weight;
				System.out.println("-1");
				return;
			}
		}
		
		for (int i = 2; i < N + 1; i++) {
			System.out.println(dist[i] == MAX ? "-1" : dist[i]);
		}
		

	}// main end
}
