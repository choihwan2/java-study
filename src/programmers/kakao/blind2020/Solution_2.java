package programmers.kakao.blind2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성
 * 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
 */
public class Solution_2 {

	HashMap<Integer, HashMap<Integer, Set<String>>> orderMap;
	int orderLength;

	public String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		orderMap = new HashMap<>();
		orderLength = orders.length;
		for (int i = 0; i < course.length; i++) {
			// 만들고자 하는 길이
			int len = course[i];
			for (int j = 0; j < orders.length; j++) {
				String order = orders[j];
				if (order.length() < len)
					continue;
				if (!orderMap.containsKey(j))
					orderMap.put(j, new HashMap<>());
				orderMap.get(j).put(len, new HashSet<>());
				makeOrder(order, "", 0, 0, j, len);
			}
		}

		ArrayList<String> answerList = new ArrayList<String>();
		for (int i = 0; i < course.length; i++) {
			int len = course[i];
			Set<String> list = compareSet(len, orders);
			answerList.addAll(list);
		}
		Collections.sort(answerList);
		answer = new String[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}

	private Set<String> compareSet(int len, String[] orders) {

		int max = 1;
		Set<String> maxLenString = new HashSet<>();
		for (int j = 0; j < orders.length; j++) {
			String order = orders[j];
			if(order.length() < len) continue;
			Set<String> set = orderMap.get(j).get(len);
			
			for (String string : set) {
				int temp = 1;
				for (int i = 0; i < orders.length; i++) {
					String order2 = orders[i];
					if (order2.length() < len || i == j)
						continue;
					Set<String> tempSet = orderMap.get(i).get(len);
					if (tempSet.contains(string))
						temp++;
				}
				if (temp == 1)
					continue;
				if (max < temp) {
					max = temp;
					maxLenString.clear();
					maxLenString.add(string);
				} else if (max == temp) {
					maxLenString.add(string);
				}
			}
		}
		return maxLenString;

	}

	private void makeOrder(String order, String newWord, int start, int cnt, int index, int len) {
		if (cnt == len) {
			char[] newArr = newWord.toCharArray();
			Arrays.sort(newArr);
			StringBuilder stb2 = new StringBuilder();
			for (int i = 0; i < newArr.length; i++) {
				stb2.append(newArr[i]);
			}
			orderMap.get(index).get(len).add(stb2.toString());
			return;
		}

		StringBuilder stb = new StringBuilder(newWord);
		for (int i = start; i < order.length(); i++) {
			stb.append(order.charAt(i));
			makeOrder(order, stb.toString(), i + 1, cnt + 1, index, len);
			stb.deleteCharAt(stb.length() - 1);
		}
	}
}
