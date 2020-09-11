package programmers.kakao.intership2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution_동굴탐험 {

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

		Map<Integer, List<Integer>> orderMap = new HashMap<>();
		for (int i = 0; i < order.length; i++) {
			int[] o = order[i];
			if (!orderMap.containsKey(o[1])) {
				orderMap.put(o[1], new ArrayList<>());
			}
			orderMap.get(o[1]).add(o[0]);
		}

		boolean[] isVisited = new boolean[n];

//		startAdventure(map, orderMap, isVisited);
		return startAdventure(map, orderMap, isVisited);
	}

	private boolean startAdventure(Map<Integer, List<Integer>> map, Map<Integer, List<Integer>> orderMap,
			boolean[] isVisited) {

		// 시작점이 order에 들어가있다
		if (orderMap.containsKey(START)) {
			return false;
		}

		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> wait_q = new LinkedList<>();
		que.add(START);
		isVisited[START] = true;

		boolean isGame = true;

		while (isGame) {
			while (!que.isEmpty()) {
				int now = que.poll();

				List<Integer> edgeList = map.get(now);
				for (int i = 0; i < edgeList.size(); i++) {
					int next = edgeList.get(i);
					// 이전에 방문한적이있음
					if (isVisited[next])
						continue;

					// 방문하기전에 order를 지켰는지 확인
					boolean canGo = true;
					if (orderMap.containsKey(next)) {
						List<Integer> orderList = orderMap.get(next);
						for (int j = 0; j < orderList.size(); j++) {
							int order = orderList.get(j);
							if (!isVisited[order]) {
								canGo = false;
								break;
							}
						}
					}
					if (canGo) {
						isVisited[next] = true;
						que.add(next);
						while (!wait_q.isEmpty()) {
							que.add(wait_q.poll());
						}
					} else {
						wait_q.add(next);
					}
				}
			}

			int qSize = wait_q.size();
			isGame = false;
			for (int i = 0; i < qSize; i++) {
				int wait = wait_q.poll();
				List<Integer> orderList = orderMap.get(wait);
				boolean isGo = true;
				for (int j = 0; j < orderList.size(); j++) {
					int order = orderList.get(j);
					if (!isVisited[order]) {
						isGo = false;
						break;
					}
				}
				if (isGo) {
					isVisited[wait] = true;
					que.add(wait);
					isGame = true;
				}else {
					wait_q.add(wait);
				}
			}
		}

		for (int i = 0; i < isVisited.length; i++) {
			if (isVisited[i] == false)
				return false;
		}

		return true;
	}
}
