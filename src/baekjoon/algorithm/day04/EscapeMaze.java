package baekjoon.algorithm.day04;


import java.util.Arrays;
import java.util.Scanner;

public class EscapeMaze {
    static final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] moveMap;
    static char[][] map;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int answer = 0;
        N = s.nextInt();
        M = s.nextInt();
        s.nextLine();
        map = new char[N][M];
        moveMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = s.nextLine().toCharArray();
            Arrays.fill(moveMap[i], -1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                go(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (moveMap[i][j] == 1) answer++;
            }
        }
        System.out.println(answer);
    }

    public static int changeCharDirToInt(char dir) {
        if (dir == 'U') return 0;
        else if (dir == 'R') return 1;
        else if (dir == 'D') return 2;
        else return 3;
    }

    public static int go(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return 1;
        if (moveMap[x][y] != -1) return moveMap[x][y];
        moveMap[x][y] = 0;
        int dir = changeCharDirToInt(map[x][y]);
        moveMap[x][y] = go(x + dx[dir], y + dy[dir]);
        return moveMap[x][y];
    }

}
