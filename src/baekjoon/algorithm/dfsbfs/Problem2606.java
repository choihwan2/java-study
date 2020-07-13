package baekjoon.algorithm.dfsbfs;

import java.util.*;

public class Problem2606 {
    static boolean[] isNetworkArr;
    static HashMap<Integer, ArrayList<Integer>> computerMap;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        isNetworkArr = new boolean[n + 1];
        computerMap = new HashMap<>();

        for(int i = 0; i< m; i++){
            int start = sc.nextInt();
            int dest = sc.nextInt();
            sc.nextLine();

            if(!computerMap.containsKey(start)) computerMap.put(start,new ArrayList<>());
            if(!computerMap.containsKey(dest)) computerMap.put(dest,new ArrayList<>());

            computerMap.get(start).add(dest);
            computerMap.get(dest).add(start);
        }
        Queue<Integer> virusQue = new LinkedList<>();

        virusQue.add(1);
        isNetworkArr[1] = true;

        while(!virusQue.isEmpty()){
            int now = virusQue.poll();
            if(computerMap.containsKey(now)){
                for(int l : computerMap.get(now)){
                    if(isNetworkArr[l]) continue;
                    isNetworkArr[l] = true;
                    answer++;
                    virusQue.add(l);
                }
            }
        }

        System.out.println(answer);
    }
}
