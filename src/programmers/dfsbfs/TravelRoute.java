package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TravelRoute {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        ArrayList<String> answerList = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> travelMap = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> que = travelMap.getOrDefault(ticket[0], new PriorityQueue<>());
            que.add(ticket[1]);
            travelMap.put(ticket[0],que);
        }
        String start = "ICN";
        answerList.add(start);
        while (travelMap.containsKey(start)) {
            String next = travelMap.get(start).poll();
            answerList.add(next);
            start = next;
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
