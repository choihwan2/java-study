package backjoon.algorthim.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 2 2 2 2 0 1 0 1
1 0 2 2 2 2 1 1 0 1
1 0 0 2 2 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
 */
public class Problem14503 {
	static final char[] DIR = { 'N', 'E', 'S', 'W' };
	static final char[] C_DIR = { 'S', 'W', 'N', 'E' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] xy = br.readLine().split(" ");
		int height = Integer.parseInt(xy[0]);
		int width = Integer.parseInt(xy[1]);

		String[] roboXY = br.readLine().split(" ");

	}

	class Robot {
		int x;
		int y;
		char dir;

		public Robot(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = DIR[dir];
		}

		public void changeDir() {
			
		}

	}
}
