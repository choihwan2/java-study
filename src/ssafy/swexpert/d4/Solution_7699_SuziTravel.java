package ssafy.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7699_SuziTravel {
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int r, c, answer;
	static char[][] map;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int i = 1; i <= iT; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			r = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
//			Set<Character> visitSet = new HashSet<>();
			isVisited = new boolean[40];
			answer = 1;

			map = new char[r][c];
			for (int j = 0; j < r; j++) {
				map[j] = br.readLine().toCharArray();
			}
			isVisited[map[0][0] - 'A'] = true;
			go(0, 0, 1);
			System.out.println("#" + i + " " + answer);
		}
	}

	public static void go(int x, int y, int cnt) {
		if (!isInMap(x, y)) {
			answer = Math.max(answer, cnt);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int mX = x + dx[d];
			int mY = y + dy[d];
			if (isInMap(mX, mY)) {
				char now = map[mX][mY];
				if (isVisited[now - 'A'] == true) {
					answer = Math.max(answer, cnt);
				} else {
					isVisited[now - 'A'] = true;
					go(mX, mY, cnt + 1);
					isVisited[now - 'A'] = false;
				}
			}
		}

	}

	public static boolean isInMap(int mX, int mY) {
		if (mX >= 0 && mX < r && mY >= 0 && mY < c) {
			return true;
		} else {
			return false;
		}
	}
}
