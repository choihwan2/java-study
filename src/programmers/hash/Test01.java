package programmers.hash;

import java.util.HashMap;

public class Test01 {
	public static void main(String[] args) {

	}

	public static String solution(String[] participant, String[] completion) {
		String answer = null;
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (String string : participant) {
			if (hashMap.containsKey(string)) {
				hashMap.put(string, hashMap.get(string) + 1);
			} else {
				hashMap.put(string, 1);
			}
		}
		for (String string : completion) {
			if (hashMap.containsKey(string)) {
				hashMap.put(string, hashMap.get(string) - 1);
			} else {
				return string;
			}
		}
		for (String string : hashMap.keySet()) {
			if (hashMap.get(string) == 1) {
				answer = string;
			}
		}
		return answer;
	}

	public static String solution2(String[] participant, String[] completion) {
		HashMap map = new HashMap<>();
		for (int i = 0; i < participant.length; i++) {
			map.compute(participant[i], (k, v) -> v != null ? null : 1);
			if (i < completion.length)
				map.compute(completion[i], (k, v) -> v != null ? null : 1);
		}
		return (String) map.keySet().iterator().next();
	}
}
