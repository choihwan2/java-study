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

		return true;
	}

}
