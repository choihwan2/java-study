package baekjoon.algorithm.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2178 {
    static final int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] map = new char[n][m];
        int[][] moveMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        que.add(0);
        moveMap[0][0] = 1;

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int i = 0; i < 4; i++) {
                int mX = x + dx[i];
                int mY = y + dy[i];

                if (mX >= 0 && mX < n && mY >= 0 && mY < m && map[mX][mY] == '1' && moveMap[mX][mY] == 0) {
                    moveMap[mX][mY] = moveMap[x][y] + 1;
                    que.add(mX);
                    que.add(mY);
                }
            }
        }

        System.out.println(moveMap[n-1][m-1]);
    }
}
