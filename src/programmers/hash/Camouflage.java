package programmers.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Camouflage {

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<Integer> num_list = new ArrayList<>();
		for (int i = 0; i < clothes.length; i++) {
			ArrayList<String> list;
			if(map.containsKey(clothes[i][1])) {
				list = map.get(clothes[i][1]);
				list.add(clothes[i][0]);
			}else {
				map.put(clothes[i][1], new ArrayList<>());
				list = map.get(clothes[i][1]);
				list.add(clothes[i][0]);
			}
		}
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			ArrayList<String> clothList = map.get(key);
			num_list.add(clothList.size());
		}
		for (int i : num_list) {
			answer *= (i+1);
		}
		return answer;
	}

}
