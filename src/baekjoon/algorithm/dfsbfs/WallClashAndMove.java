package baekjoon.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class WallClashAndMove {
    /*
    6 4
0100
1110
1000
0000
0111
0000

     */
    static char[][] map;
    static final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new char[N][M];
        int answer = -1;
        for (int i = 0; i < map.length; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '1') {
                    map[i][j] = '0';
                    int shortDistance = go(map, new int[N][M]);
                    map[i][j] = '1';
                    if(shortDistance == -1) continue;
                    if(answer == -1 || answer > shortDistance){
                        answer = shortDistance;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static int go(char[][] map, int[][] disMap) {
        disMap[0][0] = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        que.add(0);
        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            for (int i = 0; i < 4; i++) {
                int mX = x + dx[i];
                int mY = y + dy[i];
                if (mX >= 0 && mX < N && mY >= 0 && mY < M && disMap[mX][mY] == 0 && map[mX][mY] == '0') {
                    disMap[mX][mY] = disMap[x][y] + 1;
                    que.add(mX);
                    que.add(mY);
                }
            }
        }
        return disMap[N - 1][M - 1] != 0 ? disMap[N - 1][M - 1] : -1;
    }
}
