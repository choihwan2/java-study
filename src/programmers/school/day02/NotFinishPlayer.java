package programmers.school.day02;

import java.util.HashMap;
import java.util.Map.Entry;

public class NotFinishPlayer {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> playerMap = new HashMap<>();
		for (String player : participant) {
			playerMap.put(player, playerMap.getOrDefault(player, 0) + 1);
		}

		for (String comPlayer : completion) {
			playerMap.put(comPlayer, playerMap.getOrDefault(comPlayer, 2) - 1);
		}

		for (Entry<String, Integer> entry : playerMap.entrySet()) {
			if (entry.getValue() == 1)
				answer = entry.getKey();
		}
		return answer;
	}
}
