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
public class Solution_6 {
	final String[] LANG = { "cpp", "java", "python" };
	final String[] POS = { "backend", "frontend" };
	final String[] AGE = { "junior", "senior" };
	final String[] FOOD = { "chicken", "pizza" };
	List<String> queryList = new ArrayList<String>();

	public int[] solution(String[] info, String[] query) {
		int[] answer = {};
		// 언어 직군 경력 푸드
		HashMap<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < LANG.length; i++) {
			String lang = LANG[i];
			StringBuilder stb = new StringBuilder(lang);
			stb.append(" ");
			for (int j = 0; j < POS.length; j++) {
				StringBuilder stb2 = new StringBuilder(stb.toString());
				String pos = POS[j];
				stb2.append(pos).append(" ");
				for (int j2 = 0; j2 < AGE.length; j2++) {
					StringBuilder stb3 = new StringBuilder(stb2.toString());
					String age = AGE[j2];
					stb3.append(age).append(" ");
					for (int k = 0; k < FOOD.length; k++) {
						StringBuilder stb4 = new StringBuilder(stb2.toString());
						String food = FOOD[k];
						stb4.append(food);
						map.put(stb4.toString(), new ArrayList<>());
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
			StringBuilder stb = new StringBuilder();
			stb.append(lang).append(" ").append(pos).append(" ").append(age).append(" ").append(food);
			map.get(stb.toString()).add(score);
		}

		answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			int cnt = 0;
			StringBuilder stb = new StringBuilder(query[i].replace(" and ", " "));
			stk = new StringTokenizer(stb.toString(), " ");
			String lang = stk.nextToken();
			String pos = stk.nextToken();
			String age = stk.nextToken();
			String food = stk.nextToken();
			int score = Integer.parseInt(stk.nextToken());
			
			makeQuery(lang,"", 0);

			answer[i] = cnt;
		}

		return answer;
	}
	
	public void makeQuery(String word,String newQuery, int cnt) {
		if(cnt == 5) {
			
			queryList.add(newQuery);
			return;
		}
		
		StringBuilder stb = new StringBuilder(newQuery);
		if(word.equals("-")) {
			
		}
		
	}
}
