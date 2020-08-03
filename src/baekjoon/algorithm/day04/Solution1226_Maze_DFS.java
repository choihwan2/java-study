package baekjoon.algorithm.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1226_Maze_DFS {
    static char[][] map;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t<=10; t++){
            br.readLine();
            map = new char[16][16];
            for(int r = 0; r<16; r++){
                map[r] = br.readLine().toCharArray();
            }
            if(dfsMaze(1,1)){
                System.out.println("#" + t + " " + 1);
            }else
                System.out.println("#" + t + " " + 0);
        }
    }

    private static boolean dfsMaze(int x, int y){
        if(x == 13 && y == 13){
            return true;
        }
        for(int d = 0; d< 4; d++){
            int mX = x + dx[d];
            int mY = y + dy[d];
            if(map[mX][mY] == '0'){
                map[mX][mY] = '1';
                dfsMaze(mX,mY);
            }
        }
        return false;
    }
}
