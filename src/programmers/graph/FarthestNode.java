package programmers.graph;

import java.util.*;

public class FarthestNode {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] numCntArr = new int[n + 1];
        Arrays.fill(numCntArr,-1);
        numCntArr[1] = 0;
        HashMap<Integer, Set<Integer>> numMap = new HashMap<>();
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        for (int[] node : edge) {
            Set<Integer> list = numMap.getOrDefault(node[0], new HashSet<>());
            Set<Integer> revList = numMap.getOrDefault(node[1], new HashSet<>());
            list.add(node[1]);
            revList.add(node[0]);
            numMap.put(node[0], list);
            numMap.put(node[1], revList);
        }

        while (!que.isEmpty()) {
            int p = que.poll();
            Set<Integer> numSet = numMap.get(p);
            for (Integer i: numSet) {
                if(numCntArr[i] != -1) continue;
                numCntArr[i] = numCntArr[p] + 1;
                que.add(i);
            }
        }
        int temp = 0;
        for(int i = 1 ; i< numCntArr.length; i++){
            if(numCntArr[i] > temp){
                answer = 1;
                temp = numCntArr[i];
            }else if(temp == numCntArr[i]){
                answer++;
            }
        }
        return answer;
    }
}
