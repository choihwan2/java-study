package baekjoon.algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Problem2667 {
    static final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[][] map = new char[n][n];
        boolean[][] isMappedArr = new boolean[n][n];
        PriorityQueue<Integer> answerPriorityQue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && !isMappedArr[i][j]) {
                    Queue<Integer> que = new LinkedList<>();
                    int answer = 1;
                    que.add(i);
                    que.add(j);
                    isMappedArr[i][j] = true;

                    while (!que.isEmpty()) {
                        int x = que.poll();
                        int y = que.poll();

                        for (int k = 0; k < 4; k++) {
                            int mX = x + dx[k];
                            int mY = y + dy[k];

                            if (mX >= 0 && mX < n && mY >= 0 && mY < n) {
                                if (map[mX][mY] == '1' && !isMappedArr[mX][mY]) {
                                    isMappedArr[mX][mY] = true;
                                    que.add(mX);
                                    que.add(mY);
                                    answer++;
                                }
                            }
                        }
                    }
                    answerPriorityQue.add(answer);
                }
            }
        }
        System.out.println(answerPriorityQue.size());
        while (!answerPriorityQue.isEmpty()) {
            System.out.println(answerPriorityQue.poll());
        }
    }
}
