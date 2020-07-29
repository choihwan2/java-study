package ssafy.swexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_1873 {
	/*
	 * U Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다. D Down : 전차가 바라보는
	 * 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다. L Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한칸
	 * 왼쪽의 칸이 평지라면 그 칸으로 이동한다. R Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그
	 * 칸으로 이동한다. S Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
	 */
	static final int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());

			map = new char[N][M];
			Tank tank = null;
			for (int r = 0; r < N; r++) {
				String oneLine = br.readLine();
				for (int c = 0; c < oneLine.length(); c++) {
					map[r][c] = oneLine.charAt(c);
					if (checkStartPoint(map[r][c])) {
						tank = new Tank(r, c, map[r][c]);
						map[r][c] = '.'; 
					}
				}
			}
			int moveCnt = Integer.parseInt(br.readLine());

			String moveOrder = br.readLine();
			for (int k = 0; k < moveOrder.length(); k++) {
				char dir = moveOrder.charAt(k);
				tank.order(dir);
			}
			map[tank.x][tank.y] = changeDirToChar(tank.dir);

					System.out.print("#" + t + " ");
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}

		}
	}

	private static boolean checkStartPoint(char a) {
		if (a == '<' || a == '>' || a == 'v' || a == '^')
			return true;
		return false;
	}

	private static int changeDirToInt(char dir) {
		if (dir == '^')
			return 0;
		else if (dir == 'v')
			return 1;
		else if (dir == '<')
			return 2;
		else
			return 3;
	}

	private static char changeDirToChar(int dir) {
		if (dir == 0)
			return '^';
		else if (dir == 1)
			return 'v';
		else if (dir == 2)
			return '<';
		else
			return '>';
	}

	private static int changeDirToMove(char dir) {
		if (dir == 'U')
			return 0;
		else if (dir == 'D')
			return 1;
		else if (dir == 'L')
			return 2;
		else
			return 3;
	}

	static class Tank {
		int x;
		int y;
		int dir;

		public Tank(int x, int y, char dir) {
			this.x = x;
			this.y = y;
			this.dir = changeDirToInt(dir);
		}

		public void order(char dir) {
			if (dir == 'S') {
				shoot();
				return;
			}
			int d = changeDirToMove(dir);
			this.dir = d;
			if (x + dx[d] >= 0 && x + dx[d] < N && y + dy[d] >= 0 && y + dy[d] < M
					&& map[x + dx[d]][y + dy[d]] == '.') {
				x += dx[d];
				y += dy[d];
			}
		}

		public void shoot() {
			int nowX = x;
			int nowY = y;
			while (nowX + dx[dir] >= 0 && nowX + dx[dir] < N && nowY + dy[dir] >= 0 && nowY + dy[dir] < M) {
				if (map[nowX + dx[dir]][nowY + dy[dir]] == '#') {
					break;
				} else if (map[nowX + dx[dir]][nowY + dy[dir]] == '*') {
					map[nowX + dx[dir]][nowY + dy[dir]] = '.';
					break;
				}
				nowX += dx[dir];
				nowY += dy[dir];
			}

		}
	}

}
