package ssafy.swexpert.d4;

import java.util.Scanner;

public class Solution_1952_수영장 {

	static int answer, d, m, t, y;
	static int[] member, plans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();

		for (int tc = 1; tc <= iT; tc++) {
			member = new int[4];
			plans = new int[13];
			answer = 0;

			for (int m = 0; m < 4; m++) {
				member[m] = sc.nextInt();
			}
			for (int p = 1; p <= 12; p++) {
				plans[p] = sc.nextInt();
			}
			// 첫번째 1일 가격과 1달 가격 중 더 낮은 가격을 저장한다.
			plans[1] = Math.min(plans[1] * member[0], member[1]);

			for (int i = 2; i <= 12; i++) {
				d = plans[i] * member[0] + plans[i - 1];
				m = member[1] + plans[i - 1];

				t = Integer.MAX_VALUE;
				y = Integer.MAX_VALUE;

				if (i >= 3)
					t = member[2] + plans[i - 3];
				if (i >= 12)
					y = member[3] + plans[i - 12];
				plans[i] = Math.min(Math.min(d, m), Math.min(t, y));
			}
			answer = plans[12];
			System.out.println("#" + tc + " " + answer);
		}
	}
}
