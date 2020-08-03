package baekjoon.algorithm.dfsbfs;

import java.util.*;

public class Problem2583 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[m][n];
        int areaCnt = 0;
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int t = 0; t < k; t++) {
            makeSquare(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), map);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 0) {
                    ++areaCnt;
                    answerList.add(getRestArea(i, j, map));
                }
            }
        }
        Collections.sort(answerList);
        System.out.println(areaCnt);
        for (int answer:answerList) {
            System.out.print(answer + " ");
        }

    }

    private static void makeSquare(int x1, int y1, int x2, int y2, int[][] map) {
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                map[y][x] = 2;
            }
        }
    }

    private static int getRestArea(int r, int c, int[][] map) {
        int areaCnt = 1;
        Queue<Integer> que = new LinkedList<>();
        map[r][c] = 1;
        que.add(r);
        que.add(c);
        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            for (int i = 0; i < 4; i++) {
                int mX = x + dx[i];
                int mY = y + dy[i];
                if (isInMap(mX, mY, map) && map[mX][mY] == 0) {
                    map[mX][mY] = 1;
                    que.add(mX);
                    que.add(mY);
                    ++areaCnt;
                }
            }
        }
        return areaCnt;
    }

    private static boolean isInMap(int x, int y, int[][] map) {
        if (x >= 0 && y >= 0 && x < map.length && y < map[x].length) {
            return true;
        } else {
            return false;
        }
    }
}
