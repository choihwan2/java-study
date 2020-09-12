package programmers.kakao.blind2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 카카오는 하반기 경력 개발자 공개채용을 진행 중에 있으며 현재 지원서 접수와 코딩테스트가 종료되었습니다. 이번 채용에서 지원자는 지원서 작성 시 아래와 같이 4가지 항목을 반드시 선택하도록 하였습니다.
 * 코딩테스트 참여 개발언어 항목에 cpp, java, python 중 하나를 선택해야 합니다.
지원 직군 항목에 backend와 frontend 중 하나를 선택해야 합니다.
지원 경력구분 항목에 junior와 senior 중 하나를 선택해야 합니다.
선호하는 소울푸드로 chicken과 pizza 중 하나를 선택해야 합니다.
 */
public class Solution_3 {
	final String[] LANG = { "cpp", "java", "python" };
	final String[] POS = { "backend", "frontend" };
	final String[] AGE = { "junior", "senior" };
	final String[] FOOD = { "chicken", "pizza" };

	public int[] solution(String[] info, String[] query) {
		int[] answer = {};
		// 언어 직군 경력 푸드
		HashMap<String, HashMap<String, HashMap<String, HashMap<String, List<Integer>>>>> infoMap = new HashMap<>();
		for (int i = 0; i < LANG.length; i++) {
			String lang = LANG[i];
			infoMap.put(lang, new HashMap<>());
			for (int j = 0; j < POS.length; j++) {
				String pos = POS[j];
				infoMap.get(lang).put(pos, new HashMap<>());
				for (int j2 = 0; j2 < AGE.length; j2++) {
					String age = AGE[j2];
					infoMap.get(lang).get(pos).put(age, new HashMap<>());
					for (int k = 0; k < FOOD.length; k++) {
						String food = FOOD[k];
						infoMap.get(lang).get(pos).get(age).put(food, new ArrayList<>());
					}
				}
			}
		}
		StringTokenizer stk = null;
		for (int i = 0; i < info.length; i++) {
			stk = new StringTokenizer(info[i], " ");
			String lang = stk.nextToken();
			String pos = stk.nextToken();
			String age = stk.nextToken();
			String food = stk.nextToken();
			int score = Integer.parseInt(stk.nextToken());
			infoMap.get(lang).get(pos).get(age).get(food).add(score);
		}
		
		answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			ArrayList<HashMap<String, HashMap<String, HashMap<String, List<Integer>>>>> langList = new ArrayList<>();
			ArrayList<HashMap<String, HashMap<String, List<Integer>>>> posList = new ArrayList<>();
			ArrayList<HashMap<String, List<Integer>>> ageList = new ArrayList<>();
			ArrayList<List<Integer>> foodList = new ArrayList<>();
			int cnt = 0;
			StringBuilder stb = new StringBuilder(query[i].replace(" and ", " "));
			stk = new StringTokenizer(stb.toString()," ");
			String lang = stk.nextToken();
			String pos = stk.nextToken();
			String age = stk.nextToken();
			String food = stk.nextToken();
			int score = Integer.parseInt(stk.nextToken());
			
			if(lang.equals("-")) {
				for (int j = 0; j < LANG.length; j++) {
					langList.add(infoMap.get(LANG[j]));
				}
			}else {
				langList.add(infoMap.get(lang));
			}
			
			if(pos.equals("-")) {
				for (int j = 0; j < langList.size(); j++) {
					HashMap<String, HashMap<String, HashMap<String, List<Integer>>>> temp = langList.get(j);
					for (int j2 = 0; j2 < POS.length; j2++) {
						posList.add(temp.get(POS[j2]));
					}
				}
			}else {
				for (int j = 0; j < langList.size(); j++) {
					HashMap<String, HashMap<String, HashMap<String, List<Integer>>>> temp = langList.get(j);
					posList.add(temp.get(pos));
				}
			}
			
			if(age.equals("-")) {
				for (int j = 0; j < posList.size(); j++) {
					HashMap<String, HashMap<String, List<Integer>>> temp = posList.get(j);
					for (int j2 = 0; j2 < AGE.length; j2++) {
						ageList.add(temp.get(AGE[j2]));
					}
				}
			}else {
				for (int j = 0; j < posList.size(); j++) {
					HashMap<String, HashMap<String, List<Integer>>> temp = posList.get(j);
					ageList.add(temp.get(age));
				}
			}
			
			if(food.equals("-")) {
				for (int j = 0; j < ageList.size(); j++) {
					HashMap<String, List<Integer>> temp = ageList.get(j);
					for (int j2 = 0; j2 < FOOD.length; j2++) {
						foodList.add(temp.get(FOOD[j2]));
					}
				}
			}else {
				for (int j = 0; j < ageList.size(); j++) {
					HashMap<String, List<Integer>> temp = ageList.get(j);
					foodList.add(temp.get(food));
				}
			}
			
			for (int j = 0; j < foodList.size(); j++) {
				List<Integer> list = foodList.get(j);
				for (int k = 0; k < list.size(); k++) {
					if(list.get(k) >= score) {
						cnt++;
					}
				}
			}
			
			answer[i] = cnt;
		}

		return answer;
	}
}
