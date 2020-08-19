package programmers.kakao.blind2018;

public class Friends4Block {
    // 블록이 없어지는게 없을때 까지 계속해서 작업을 수행해야한다.
    // board를 유지하면서 없어진 곳을 0으로 채우자
    // 오른쪽을 보고 같으면 아래로 내려가면서 같은게 있는지 보고 그 오른쪽도 똑같이 행동하고 맞다면 지워준다. (틀린생각)
    // 위에서 내려와 오른쪽에 맞출수도 있으니 결국.. 한번 체크하고 지우고 그다음 다 내리고 반복으로 해야하는 시뮬레이션 문제였던것 같다.
    // 반복

    char[][] map;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        int temp = 0;
        while ((temp = cycle(m, n, map)) > 0) {
            answer += temp;
            moveBlock(map);
        }
        return answer;
    }

    private void moveBlock(char[][] map) {
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = map[i].length - 1; j >= 0; j--) {
                // 0이라면 위치 위로 올라가서 가장 처음 만나는 블록과 위치 바꿔주기
                if (map[i][j] == '0') {
                    int mI = i - 1;
                    while (mI >= 0 && map[mI][j] == '0')
                        mI -= 1;
                    if (mI >= 0 && map[mI][j] != '0') {
                        map[i][j] = map[mI][j];
                        map[mI][j] = '0';
                    }
                }
            }
        }
    }

    private int cycle(int m, int n, char[][] map) {
        boolean[][] checkMap = new boolean[m][n];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] != '0') {
                    checkDeleteBlock(i, j, map, checkMap);
                }
            }
        }
        return deleteBlock(map, checkMap);
    }

    private void checkDeleteBlock(int r, int c, char[][] map, boolean[][] checkMap) {
        char a = map[r][c];
        if (isInMap(r + 1, c + 1) && a == map[r + 1][c] && a == map[r][c + 1] && a == map[r + 1][c + 1]) {
            checkMap[r][c] = true;
            checkMap[r][c + 1] = true;
            checkMap[r + 1][c] = true;
            checkMap[r + 1][c + 1] = true;
        }
    }

    private boolean isInMap(int x, int y) {
        if (x < map.length && y < map[0].length) {
            return true;
        } else
            return false;
    }

    private int deleteBlock(char[][] map, boolean[][] checkMap) {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (checkMap[i][j]) {
                    map[i][j] = '0';
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
