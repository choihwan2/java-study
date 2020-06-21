package baekjoon.algorithm.day03;


import java.util.Scanner;

public class Gerrymandering {

    static final int[] dx = {1,1,-1,-1}, dy = {1,-1,-1,1};
    static int[][] groupMap;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] map = new int[N][N];
        groupMap = new int[N][N];
        int[] peopleList = new int[6];
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                map[i][j] = scanner.nextInt();
            }
        }

    }

    private static void makeGroup(int x, int y, int d1, int d2){
        groupMap[x][y] = 4;
//        for(int )

    }
}
