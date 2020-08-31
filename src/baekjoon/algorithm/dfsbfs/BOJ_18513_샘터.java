package baekjoon.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18513_샘터 {

	// 빌딩을 세우기 위한 클래스 정의
	private static class Node {
		// 위치
		int pos;
		// 치킨집과의 거리
		int dist;

		public Node(int pos, int dist) {
			super();
			this.pos = pos;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		// 위치를 방문했는지 여부에 대한 HashSet 생성
		Set<Integer> posSet = new HashSet<Integer>();
		// 가장 가까운 거리부터 집들을 세워하니 큐를 생성한다
		Queue<Node> que = new LinkedList<>();
		// 정답이 될 치킨지수
		long answer = 0L;

		stk = new StringTokenizer(br.readLine());

		// 치킨집을 입력받는다
		for (int i = 0; i < n; i++) {
			int cPos = Integer.parseInt(stk.nextToken());
			// 치킨집이 있는곳에는 집을 지을 수 없으므로 Set에 추가
			posSet.add(cPos);
			// 그리고 큐에 넣어준다
			que.add(new Node(cPos, 0));
		}

		// 초기에 집을 하나도 세우지 않았기에 0으로 초기화
		int houseNum = 0;

		// 반복문 시작
		while (true) {
			// 큐에 들어간 노드를 하나씩 빼서 확인한다.
			Node node = que.poll();
			// 노드의 앞과 뒤 그리고 치킨집과의 거리변수 선언
			int front = node.pos - 1;
			int rear = node.pos + 1;
			int dist = node.dist;
			// 앞의 위치를 방문했는지 검사
			if (!posSet.contains(front)) {
				// 방문하지 않았다면 방문처리
				posSet.add(front);
				// 이후 정답에 자신의 위치 보다 거리값 + 1을 더해줌
				answer += dist + 1;
				// 큐에 자신의 위치와 거리값 + 1의 새로운 노드 추가
				que.add(new Node(front, dist + 1));
				// 지어진 건물 수 증가
				houseNum++;
				// 지어진 건물 수가 총합과 같다면 반복문 탈출 후 종료
				if (houseNum == k) {
					break;
				}
			}

			// 뒤의 위치를 방문했는지 검사
			if (!posSet.contains(rear)) {
				// 방문하지 않았다면 방문처리
				posSet.add(rear);
				// 이후 정답에 거리값을 더해주고
				answer += dist + 1;
				// 큐에 새로운 노드 추가
				que.add(new Node(rear, dist + 1));
				// 지어진 건물 수 증가
				houseNum++;
				// 지어진 건물 수가 총합과 같다면 반복문 탈출 후 종료
				if (houseNum == k) {
					break;
				}
			}
		}

		// 정답 출력
		System.out.println(answer);
	}

}
