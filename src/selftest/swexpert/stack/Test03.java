package selftest.swexpert.stack;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Test03 {
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int[][] map = new int[2][100];
			answer = 0;
			sc.nextLine();
			StringTokenizer stk = new StringTokenizer(sc.nextLine());
			while (stk.hasMoreTokens()) {
				int start = Integer.parseInt(stk.nextToken());
				int dir = Integer.parseInt(stk.nextToken());
				
				if (map[0][start] == 0) map[0][start] = dir;
				else map[1][start] = dir;
			}
			sol(0, map);
			System.out.println("#" + (i+1) + " " + answer);
		}
	}
	
	public static void sol(int start, int[][] map) {
		if(map[0][start] == 99 || map[1][start] == 99) {
			answer = 1;
			return;
		}
		if(map[0][start] == 0) return;		
		sol(map[0][start],map);
		if(map[1][start] == 0) return;
		sol(map[1][start],map);
	}
}
