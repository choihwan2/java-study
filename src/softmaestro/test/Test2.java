package softmaestro.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test2 {

    private static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int num = Integer.parseInt(input);
        String[] results = new String[num];

        for(int i=0; i< num; i++) {
            String mapPos = br.readLine();
            int xSize = Integer.parseInt(mapPos.split(" ")[1]);
            int ySize = Integer.parseInt(mapPos.split(" ")[0]);
            
            int[][] map = new int[ySize][xSize];
            ArrayList<int[]> naturePos = new ArrayList<>();
            
            for(int y=0; y<ySize; y++) {
                String posStr = br.readLine();
                String[] posArr = posStr.split(" ");
                for(int x=0; x<xSize; x++) {
                    map[y][x] = Integer.parseInt(posArr[x]);
                    if(map[y][x] == 0) {
                        int[] tmp = {x, y};
                        naturePos.add(tmp);
                    }
                }
            }

            // 검증 차례
            results[i] = getResult(map, makeMap(map, xSize, ySize, naturePos), xSize, ySize);
        }
        for(String str : results) {
            System.out.println(str);
        }
    }

    private static int[][] makeMap(int[][] map, int xSize, int ySize, ArrayList<int[]> naturePos) {
        boolean result = false;

        int[][] target = new int[ySize][xSize];

        for(int y=0; y<ySize; y++) {
            for(int x=0; x<xSize; x++) {
                if(isPaintArea(naturePos,x,y)) {
                    for(int i=0; i<2; i++) {
                        target[y][x-i] = 1;
                        target[y-i][x] = 1;
                        target[y-i][x-i] =1;
                    }
                }
            }
        }

        return target;
    }

    private static String getResult(int[][] origin, int[][] target, int xSize, int ySize) {
        boolean result = true;
        for(int y=0; y<ySize; y++) {
            for(int x=0; x<xSize; x++) {
                if(origin[y][x] != target[y][x]) {
                    result = false;
                }
            }
        }

        return result ? "YES" : "NO";
    }

    private static boolean isPaintArea(ArrayList<int[]> naturePos, int x, int y) {
        if(isInArea(x,y)) {
            for(int[] pos : naturePos) {
                for(int i=0; i<2; i++) {
                    if( (x-i == pos[0] && y == pos[1]) || (x ==pos[0] && y-i == pos[1]) ) {
//                        System.out.println("nature : " + pos[0] + "," + pos[1]);
//                        System.out.println("색치 불가 지역 : " + x + "," + y);
                        return false;   //불가능
                    }
                }
            }
        } else {    // 구역 벗어났으니까 색칠하면 안됨
//            System.out.println("구역 벗어남 : " +x + "," + y);
            return false;
        }

        return true;
    }

    private static boolean isInArea(int x, int y) {
        return x-1>=0 && y-1 >=0 ? true : false;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}