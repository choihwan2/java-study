package baekjoon.algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem7576 {
    static final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] tomatoMap = new int[m][n];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tomatoMap[i][j] = sc.nextInt();
                if (tomatoMap[i][j] == 1) {
                    que.add(i);
                    que.add(j);
                }
            }
            sc.nextLine();
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int i = 0; i < 4; i++) {
                int mX = x + dx[i];
                int mY = y + dy[i];

                if (mX >= 0 && mX < m && mY >= 0 && mY < n && tomatoMap[mX][mY] == 0) {
                    tomatoMap[mX][mY] = tomatoMap[x][y] + 1;
                    que.add(mX);
                    que.add(mY);
                }
            }
        }
        System.out.println(checkMap(tomatoMap));
    }

    public static int checkMap(int[][] tomatoMap) {
        int answer = 0;
        for (int i = 0; i < tomatoMap.length; i++) {
            for (int j = 0; j < tomatoMap[i].length; j++) {
                if(tomatoMap[i][j] == 0) return -1;
                if(answer < tomatoMap[i][j]) answer = tomatoMap[i][j];
            }
        }
        return answer - 1;
    }
}
