package ssafy.swexpert.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1210 {
    static int[] dx = { 0, 0, -1 }, dy = { -1, 1, 0 };
    static final int SIZE = 100;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 1; k <= 10; k++) {
            int t = Integer.parseInt(br.readLine());
            map = new int[SIZE][SIZE];
            int x = 0;
            int y = 0;
            for (int i = 0; i < SIZE; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = Integer.parseInt(stk.nextToken());
                    if (map[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }
            while (x > 0) {
                // 범위 안에 들어왔다.
                // r = 0 왼 오 위
                for (int r = 0; r < 3; r++) {
                    if (x + dx[r] >= 0 && x + dx[r] < SIZE && y + dy[r] >= 0 && y + dy[r] < SIZE
                            && map[x + dx[r]][y + dy[r]] == 1) {
                        if (r == 0 || r == 1) {
                            while (x + dx[r] >= 0 && x + dx[r] < SIZE && y + dy[r] >= 0 && y + dy[r] < SIZE
                                    && map[x + dx[r]][y + dy[r]] == 1) {
                                x += dx[r];
                                y += dy[r];
                            }
                            // 무조건 한칸 올리는 처리를 위해 r 을 2로 만들어주려는 부분
                            r = 1;
                        }else {
                            x += dx[r];
                            y += dy[r];
                        }
                    }
                }

            }
//			y = solve(y);

            System.out.println("#" + k + " " + y);
        }



    }

    private static int solve(int y) {
        int top = 99;
        while(top-- != 0) {
            if(y-1 >= 0 && map[top][y-1] == 1)
                while(y-1 >= 0 && map[top][y-1] == 1) y--;
            else if(y + 1 <100 && map[top][y+1] == 1)
                while(y + 1 <100 && map[top][y+1] == 1)  y++;
        }
        return y;
    }
}
