package baekjoon.algorithm.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class WallClashAndMoveSol {

    public static int N, M, ans = Integer.MAX_VALUE;
    public static int[] dirX = new int[] { 0, 0, -1, 1 };
    public static int[] dirY = new int[] { -1, 1, 0, 0 };
    public static int[][] map;
    public static boolean[][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }
        solve();
        if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static void solve() {

        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(0, 0, 1, 0));

        while (!q.isEmpty()) {

            Node node = q.poll();
            int row = node.row;
            int col = node.col;
            int cnt = node.cnt;
            int jump = node.jump;

            if (row == N - 1 && col == M - 1) {
                ans = Math.min(ans, cnt);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dirX[i];
                int nc = col + dirY[i];

                if (isBoundary(nr, nc)) {
                    if (jump == 1) {

                        if (!visited[jump][nr][nc] && map[nr][nc] == 0) {
                            visited[jump][nr][nc] = true;
                            q.offer(new Node(nr, nc, cnt + 1, jump));
                        }

                    } else { // 벽을 안부순 상태

                        if (map[nr][nc] == 1) {
                            if (!visited[jump + 1][nr][nc]) {
                                visited[jump + 1][nr][nc] = true;
                                q.offer(new Node(nr, nc, cnt + 1, jump + 1));
                            }
                        } else if (map[nr][nc] == 0) {
                            if (!visited[jump][nr][nc]) {
                                visited[jump][nr][nc] = true;
                                q.offer(new Node(nr, nc, cnt + 1, jump));
                            }
                        }
                    }
                }

            }

        }
    }

    public static boolean isBoundary(int row, int col) {
        return (row >= 0 && row < N) && (col >= 0 && col < M);
    }
}

class Node {

    int row;
    int col;
    int cnt;
    int jump;

    public Node(int row, int col, int cnt, int jump) {
        super();
        this.row = row;
        this.col = col;
        this.cnt = cnt;
        this.jump = jump;
    }

}