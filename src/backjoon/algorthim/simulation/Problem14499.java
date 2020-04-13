package backjoon.algorthim.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 지도의 좌표는 (r, c)로 나타내며, r는 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로부터 떨어진 칸의 개수
 * 주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 곳의 좌표는 
 * (x, y) 이다. 가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.
 * 			     { 뒤  왼   위   오   앞   밑}
 * 시작     => 밑면 6 { 2, 4, 1, 3, 5, 6}
 * 1(동) => 밑면 3 { 2, 6, 4, 1, 5, 3} (1 -> 2) (2 -> 3) (3 -> 5) (5 -> 1)
 * 2(서) => 밑면 4 { 2, 1, 3, 6, 5, 4} (5 -> 3) (3 -> 2) (2 -> 1) (1 -> 5)
 * 3(북) => 밑면 2 { 1, 4, 5, 3, 6, 2} (0 -> 5) (5 -> 4) (5 -> 2) (2 -> 0) 
 * 4(남) => 밑면 5 { 0, 0, 0, 0, 0, 0} (4 -> 5) (5 -> 0) (0 -> 2) (2 -> 5)
 * 
 * 시작 => 밑면 5
 * 1 => 밑면 3
 * 지도의 각 칸에는 정수가 하나씩 쓰여져 있다. 주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 
 * 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 
 * 칸에 쓰여 있는 수는 0이 된다.
 * 
 * 주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때, 
 * 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오.
 * 
 * 마지막 줄에는 이동하는 명령이 순서대로 주어진다. 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.
 */
public class Problem14499 {
	static int height, width, x, y, K;

	static int[][] map;

	static int[] dice = { 0, 0, 0, 0, 0, 0 };

	static final int[][] DIR = { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		height = Integer.parseInt(in[0]);
		width = Integer.parseInt(in[1]);

		Queue<Integer> work_q = new LinkedList<Integer>();

		x = Integer.parseInt(in[2]);
		y = Integer.parseInt(in[3]);
		K = Integer.parseInt(in[4]);

		map = new int[height][width];
		for (int i = 0; i < height; i++) {
			String[] m_line = br.readLine().split(" ");
			for (int j = 0; j < m_line.length; j++) {
				map[i][j] = Integer.parseInt(m_line[j]);
			}
		}

		StringTokenizer stk = new StringTokenizer(br.readLine());
		while (stk.hasMoreTokens()) {
			work_q.add(Integer.parseInt(stk.nextToken()));
		}

		while (!work_q.isEmpty()) {
			int dir = work_q.poll();
			boolean isIn = inMap(dir);
			if (isIn) {
				move(dir);
				getMap();
				System.out.println(dice[2]);
			}
		}
	}
//	 * 시작     => 밑면 6 { 2, 4, 1, 3, 5, 6}
//	 * 1(동) => 밑면 3 { 2, 6, 4, 1, 5, 3} (1 -> 2) (2 -> 3) (3 -> 5) (5 -> 1)
//	 * 2(서) => 밑면 4 { 2, 1, 3, 6, 5, 4} (5 -> 3) (3 -> 2) (2 -> 1) (1 -> 5)
//	 * 3(북) => 밑면 2 { 1, 4, 5, 3, 6, 2} (0 -> 5) (5 -> 4) (4 -> 2) (2 -> 0) 
//	 * 4(남) => 밑면 5 { 0, 0, 0, 0, 0, 0} (4 -> 5) (5 -> 0) (0 -> 2) (2 -> 5)

	public static void move(int dir) {

		int[] temp_dice = new int[6];
		switch (dir) {
		case 1:
			temp_dice[0] = dice[0];
			temp_dice[1] = dice[5];
			temp_dice[2] = dice[1];
			temp_dice[3] = dice[2];
			temp_dice[4] = dice[4];
			temp_dice[5] = dice[3];
			break;
		case 2:
			temp_dice[0] = dice[0];
			temp_dice[1] = dice[2];
			temp_dice[2] = dice[3];
			temp_dice[3] = dice[5];
			temp_dice[4] = dice[4];
			temp_dice[5] = dice[1];
			break;
		case 3:
			temp_dice[0] = dice[2];
			temp_dice[1] = dice[1];
			temp_dice[2] = dice[4];
			temp_dice[3] = dice[3];
			temp_dice[4] = dice[5];
			temp_dice[5] = dice[0];
			break;
		case 4:
			temp_dice[0] = dice[5];
			temp_dice[1] = dice[1];
			temp_dice[2] = dice[0];
			temp_dice[3] = dice[3];
			temp_dice[4] = dice[2];
			temp_dice[5] = dice[4];
			break;
		default:
			break;
		}
		dice = temp_dice;
	}

	public static boolean inMap(int dir) {
		boolean isIn = true;
		int x_m = x + DIR[dir][0];
		int y_m = y + DIR[dir][1];
		if (x_m >= 0 && x_m < width) {
			x = x_m;
		} else {
			return false;
		}
		if (y_m >= 0 && y_m < height) {
			y = y_m;
		} else {
			return false;
		}
		return isIn;
	}

	public static void getMap() {
		if (map[y][x] == 0) {
			map[y][x] = dice[5];
		} else {
			dice[5] = map[y][x];
			map[y][x] = 0;
		}
	}
}
