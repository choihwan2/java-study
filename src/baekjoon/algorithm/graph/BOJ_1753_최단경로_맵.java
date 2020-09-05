package baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로_맵 {

	private static class Node implements Comparable<Node> {
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int start = Integer.parseInt(br.readLine());

		boolean[] isVisited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Map<Integer, HashMap<Integer, Integer>> edgeMap = new HashMap<>();

		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());

			if (!edgeMap.containsKey(f)) {
				edgeMap.put(f, new HashMap<>());
				edgeMap.get(f).put(t, w);
			} else {
				if (edgeMap.get(f).containsKey(t)) {
					int beforeW = edgeMap.get(f).get(t);
					if (beforeW > w) {
						edgeMap.get(f).put(t, w);
					}
				} else {
					edgeMap.get(f).put(t, w);
				}
			}
		}

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, dist[start]));

		Node current = null;
		Map<Integer, Integer> distMap = null;
		while (!pq.isEmpty()) {
			current = pq.poll();

			if (isVisited[current.no])
				continue;
			isVisited[current.no] = true;

			for (int i = 1; i <= n; i++) {
				if (!isVisited[i] || !edgeMap.containsKey(i))
					continue;
				distMap = edgeMap.get(i);
				for (int vertex : distMap.keySet()) {
					int nowDist = distMap.getvertex);
					if (dist[vertex] > nowDist + current.totalDistance) {
						dist[vertex] = nowDist + current.totalDistance;
						pq.add(new Node(vertex, dist[vertex]));
					}
				}

			}
		}
		StringBuilder stb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				stb.append("INF").append("\n");
			} else {
				stb.append(dist[i]).append("\n");
			}
		}
		System.out.println(stb.toString());

	}
}
