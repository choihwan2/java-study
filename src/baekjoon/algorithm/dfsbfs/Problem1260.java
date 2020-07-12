package baekjoon.algorithm.dfsbfs;

import java.util.*;

public class Problem1260 {
    static boolean[] isVisitedArr;
    static HashMap<Integer, PriorityQueue<Integer>> nodeMap;
    static HashMap<Integer, PriorityQueue<Integer>> nodeMap2;
    static StringBuilder dfsStb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int nodeStart = sc.nextInt();
        sc.nextLine();
        isVisitedArr = new boolean[n + 1];
        nodeMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int dest = sc.nextInt();
            sc.nextLine();

            if (!nodeMap.containsKey(start)) {
                nodeMap.put(start, new PriorityQueue<>());
            }
            if(!nodeMap.containsKey(dest)){
                nodeMap.put(dest,new PriorityQueue<>());
            }
            nodeMap.get(start).add(dest);
            nodeMap.get(dest).add(start);
        }

        nodeMap2 = new HashMap<>();
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry : nodeMap.entrySet()){
            nodeMap2.put(entry.getKey(),new PriorityQueue<>(entry.getValue()));
        }

        dfs(nodeStart);

        Arrays.fill(isVisitedArr, false);

        StringBuilder bfsStb = bfs(nodeStart);

        dfsStb.deleteCharAt(dfsStb.length() -1);
        bfsStb.deleteCharAt(bfsStb.length() -1);

        System.out.println(dfsStb.toString());
        System.out.println(bfsStb.toString());

    }

    public static void dfs(int startNum) {

        if (isVisitedArr[startNum]) return;
        isVisitedArr[startNum] = true;
        dfsStb.append(startNum);
        dfsStb.append(" ");
        if (nodeMap.containsKey(startNum)) {
            PriorityQueue<Integer> childNodeQue = nodeMap.get(startNum);
            while(!childNodeQue.isEmpty()){
                dfs(childNodeQue.poll());
            }
        }

    }

    public static StringBuilder bfs(int startNum) {
        Queue<Integer> bfsQue = new LinkedList<>();
        StringBuilder stb = new StringBuilder();

        bfsQue.add(startNum);
        isVisitedArr[startNum] = true;

        while(!bfsQue.isEmpty()){
            int top = bfsQue.poll();
            if(nodeMap2.containsKey(top)){
                PriorityQueue<Integer> childNodeQue = nodeMap2.get(top);
                while(!childNodeQue.isEmpty()){
                    int l = childNodeQue.poll();
                    if(isVisitedArr[l]) continue;
                    isVisitedArr[l] = true;
                    bfsQue.add(l);
                }
            }
            stb.append(top);
            stb.append(" ");
        }

        return stb;
    }

}
