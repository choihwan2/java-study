package programmers.school.day03;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
	// 먼저 배열의 값만큼 boolean 배열을 만들어주고 하나씩 값을 넣고
	// 거기에 연결되어있는 배열로 들어가 찾기 (BFS)
	public int solution(int n, int[][] computers) {
		boolean[] isVisted = new boolean[n];
		int answer = 0;
		Queue<Integer> que = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			if (isVisted[i])
				continue;
			isVisted[i] = true;
			que.add(i);
			answer++;
			
			while (!que.isEmpty()) {
				int[] conn = computers[que.poll()];
				for (int j = 0; j < conn.length; j++) {
					if(conn[j] == 1 && !isVisted[j]) {
						isVisted[j] = true;
						que.add(j);
					}
				}
			}
		}
		return answer;
	}
}
