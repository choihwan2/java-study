package baekjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16434_드래곤앤던전 {
	static final int DUNGEON = 1, POTION = 2;
	static long atk, curHp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken());
		atk = Integer.parseInt(stk.nextToken());
		long maxHp = 0;
		curHp = 0;

		for (int n = 0; n < N; n++) {
			stk = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(stk.nextToken());
			if (type == DUNGEON) {
				int enemyAtk = Integer.parseInt(stk.nextToken());
				int enemyHp = Integer.parseInt(stk.nextToken());

				long totalDmg = enemyHp % atk == 0 ? (enemyHp/atk - 1) * enemyAtk : (enemyHp/atk) * enemyAtk;
				curHp += totalDmg;
				maxHp = Math.max(maxHp, curHp);
				
			} else if (type == POTION) {
				int upDmg = Integer.parseInt(stk.nextToken());
				int upHp = Integer.parseInt(stk.nextToken());
				atk += upDmg;
				curHp -= upHp;
				if(curHp < 0) {
					curHp = 0;
				}
			}
		}
		maxHp = Math.max(maxHp, curHp);
		System.out.println(maxHp + 1);
	}
}
