package backjoon.algorthim.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 B A 0 1 0 1
1 0 0 3 2 9 1 1 0 1
1 0 0 4 5 8 1 1 0 1
1 0 0 0 6 7 0 0 0 1
1 1 1 1 1 1 1 1 1 1
 */
public class Problem14503 {
	static final int[] DIR = { 3, 0, 1, 2 };
	static final int[][] C_DIR = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } }; // y, x 의 오른쪽
	static final int[][] R_DIR = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } }; // y, x 의 반대방향
	static int x, y, dir;
	static char[][] map;
	static int rotation;
	static boolean isMove = true;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] xy = br.readLine().split(" ");
		int map_h = Integer.parseInt(xy[0]);
		int map_w = Integer.parseInt(xy[1]);

		map = new char[map_h][map_w];

		String[] roboXY = br.readLine().split(" ");
		y = Integer.parseInt(roboXY[0]);
		x = Integer.parseInt(roboXY[1]);
		dir = Integer.parseInt(roboXY[2]);

		for (int i = 0; i < map_h; i++) {
			String input = br.readLine().replace(" ", "");
			map[i] = input.toCharArray();
		}

		while (isMove) {
			cleanArea();
			checkArea();
		}
		System.out.println(answer);

//		출력을 위한 부분
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	public static void cleanArea() {
		if (map[y][x] == '0') {
			map[y][x] = '2';
			answer++;
		}
	}

	public static void checkArea() {
		rotation = 0;
		while (rotation < 4) {
			if (map[y + C_DIR[dir][0]][x + C_DIR[dir][1]] == '0') {
				y += C_DIR[dir][0];
				x += C_DIR[dir][1];
				dir = DIR[dir];
				return;
			} else {
				dir = DIR[dir];
				rotation++;
			}
		}

		if (map[y + R_DIR[dir][0]][x + R_DIR[dir][1]] == '1') {
			isMove = false;
			return;
		} else {
			y += R_DIR[dir][0];
			x += R_DIR[dir][1];
			return;
		}

	}
}
