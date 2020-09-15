package programmers.kakao.intership2020;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution_동탐 {
	final int START = 0;

	public boolean solution(int n, int[][] path, int[][] order) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < path.length; i++) {
			int[] p = path[i];
			if (!map.containsKey(p[0])) {
				map.put(p[0], new ArrayList<>());
			}
			if (!map.containsKey(p[1])) {
				map.put(p[1], new ArrayList<>());
			}

			map.get(p[0]).add(p[1]);
			map.get(p[1]).add(p[0]);
		}

		Map<Integer, Integer> orderMap = new HashMap<>();
		for (int i = 0; i < order.length; i++) {
			int from = order[i][0];
			int to = order[i][1];
			orderMap.put(to, from);
		}

		boolean[] isVisited = new boolean[n];

		return startAdventure(map, orderMap, isVisited);
	}

	private boolean startAdventure(Map<Integer, List<Integer>> map, Map<Integer, Integer> orderMap,
			boolean[] isVisited) {

		// 시작점이 order에 들어가있다
		if (orderMap.containsKey(START)) {
			return false;
		}

		Deque<Integer> deque = new LinkedList<>();
		deque.add(START);

		while (!deque.isEmpty()) {
			int qSize = deque.size();
			// 탐험을 계속 진행할 수 있는지 여부
			boolean isBlock = true;

			// 한 사이클을 돌려야서 확인해야 탐험을 계속할수 있는지 없는지 알수있다
			for (int i = 0; i < qSize; i++) {
				int now = deque.pollFirst();

				// 탐험하고자 하는 곳이 order에 속해있지 않다면 => 바로 탐험시작
				// 탐험하고자 하는 곳이 order에 속해있다 => 그럼 그 orderMap에서 값을 보고 방문했는지 여부를 확인해야한다.
				if (!orderMap.containsKey(now) || isVisited[orderMap.get(now)]) {
					// 방문처리
					isVisited[now] = true;
					// 하나라도 방문했다면 다시 한번 큐 전체를 훑어주기위한 작업
					isBlock = false;
					List<Integer> edgeList = map.get(now);
					for (int j = 0; j < edgeList.size(); j++) {
						int next = edgeList.get(j);
						// 연결되어 있는 곳이 아직 방문하지 않은 곳이라면 큐 제일 앞쪽에 넣어 확인하고 i의 값을 하나 줄여준다
						if (!isVisited[next]) {
							deque.offerFirst(next);
							i--;
						}
					}
				} else {
					deque.offerLast(now);
				}
			}

			// 한사이클을 돌았는데 방문할 곳이 늘어나지는 않았고 큐가 비지않았다
			if (isBlock) {
				return false;
			}

		}

		return true;
	}
}
