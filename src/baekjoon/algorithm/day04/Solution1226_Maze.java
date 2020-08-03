package baekjoon.algorithm.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1226_Maze {
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
            if(bfsMaze(1,1)){
                System.out.println("#" + t + " " + 1);
            }else
                System.out.println("#" + t + " " + 0);
        }
    }

    private static boolean bfsMaze(int x, int y){
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);

        while(!que.isEmpty()){
            int mX = que.poll();
            int mY = que.poll();
            for(int i = 0; i<4; i++){
                if(map[mX + dx[i]][mY + dy[i]] == '0'){
                    map[mX + dx[i]][mY + dy[i]] = '1';
                    que.add(mX +dx[i]);
                    que.add(mY +dy[i]);
                }else if(map[mX + dx[i]][mY + dy[i]] == '3'){
                    return true;
                }
            }
        }
        return false;
    }
}
