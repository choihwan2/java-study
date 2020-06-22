package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TravelRoute {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        ArrayList<String> answerList = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> travelMap = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> que = travelMap.getOrDefault(ticket[0], new PriorityQueue<>());
            que.add(ticket[1]);
            travelMap.put(ticket[0], que);
        }
        /*
        TODO 단순하게 우선순위큐로 해결되는 것이 아니라, 모든 항공권을 사용해야하므로 하나씩 확인을 다해줘야한다. 즉 Bruteforce 방식으로 하나씩 다 검사해주는게 맞는것 같다.
         */
        String start = "ICN";
        answerList.add(start);
        while (travelMap.containsKey(start)) {
            if (!travelMap.get(start).isEmpty()) {
                String next = travelMap.get(start).poll();
                answerList.add(next);
                start = next;
            } else
                break;
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
