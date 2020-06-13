package baekjoon.algorithm.day03;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JumpNumberBoard {
    static int[][] map = new int[5][5];
    static Set<String> numberSet = new HashSet<>();
    static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                go(i, j, 1, String.valueOf(map[i][j]));
            }
        }

        System.out.println(numberSet.size());
    }

    private static void go(int x, int y, int len, String str) {
        if (len == 6) {
            if (!numberSet.contains(str)) {
                numberSet.add(str);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < 5 && nY >= 0 && nY < 5) {
                go(nX,nY,len +1,str + map[nX][nY]);
            }
        }
    }
}
