package backjoon.algorthim.simulation;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 게임은 NxN 정사각 보드위에서 진행되고
 * 보드의 상하좌우 끝에 벽이 있다. 
 * 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 
 * 뱀은 처음에 오른쪽을 향한다.
 * 
 * 뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.
 * 
 * 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
 * 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
 * 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.
 * 
 * 첫째 줄에 보드의 크기 N이 주어진다. (2 ≤ N ≤ 100) 
 * 다음 줄에 사과의 개수 K가 주어진다. (0 ≤ K ≤ 100)
 * 
 * 다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 
 * 두 번째 정수는 열 위치를 의미한다. 사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.
 */
public class Problem3190 {
	static int N, K, L;
	static int[][] map;
	static final int[][] DIR = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < N + 1; i++) {
			map[0][i] = 1;
			map[N][i] = 1;
			map[i][0] = 1;
			map[i][N] = 1;
		} // 맵 제일 겉에 부분 벽으로 만들기.

		for (int i = 0; i < K; i++) {
			String[] a_xy = br.readLine().split(" ");
			map[Integer.parseInt(a_xy[1])][Integer.parseInt(a_xy[0])] = 3;
		}

		L = Integer.parseInt(br.readLine());
		
		

	}

	class Snake {
		int length = 1;
		Deque<Point> body = new LinkedList<Point>();
		int[] dir = DIR[0];
		
		public Snake() {
			body.addLast(new Point(1,1));
		}
		
	}
}
