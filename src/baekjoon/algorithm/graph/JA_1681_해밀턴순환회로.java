package baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JA_1681_해밀턴순환회로 {
	static int N, map[][], answer;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		/*
		 * 처음 지점을 방문했다는 가정으로 시작 (솔직히 불필요 왜냐면 for 문 안에서 1부터 도니깐.. 아무튼 그러고나서 경로를 탐색을 시작한다
		 */
		isVisited = new boolean[N];
		isVisited[0] = true;
		dfs(0, 0, 1);
		System.out.println(answer);
	}

	/*
	 * 처음에 최단경로라는 말을 보고 다익스트라나 프림을 쓰려고 했지만 모든 정점을 방문하는 최단거리가 결국 마지막에 돌아오는 길 거리로 인해서 최단 거리가 될거라는 보장이 없다.
	 * 그렇다면 남은게 완탐이다.
	 * 시간복잡도를 계산해보면 N 은 12  한번 방문할때마다가 12가지의 경우의 수를 갖는다. 그래서 대략적으로 생각해보면 12의 12승.. 즉 터진다.
	 * 하지만 한번 경로를 구해놓고 그것보다 큰 거리를 구하는 식으로 접근 할때의 가지치기를 해주는 방법을 생각해보았다.
	 * 그리고 문제의 함정으로 0일때 가지 못한다는 조건들이 있으니 그것들을 잘 확인해서 문제를 풀어보았다.
	 */
	private static void dfs(int start, int dist, int cnt) {
		if(dist > answer) {
			return;
		}
		if (cnt == N) {
			if(map[start][0] == 0) {
				return;
			}
			int finalDist = dist + map[start][0];
			if (answer > finalDist)
				answer = finalDist;
			return;
		}

		for (int i = 1; i < N; i++) {
			if(isVisited[i] || map[start][i] == 0) continue;
			isVisited[i] = true;
			dfs(i, dist + map[start][i], cnt + 1);
			isVisited[i] = false;
		}
	}
}
