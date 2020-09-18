package baekjoon.algorithm.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2560_짚신벌레_주희 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int d = s.nextInt();
		int N = s.nextInt();

		Queue<Integer> infancy = new LinkedList<>();
		Queue<Integer> maturity = new LinkedList<>();
		Queue<Integer> senility = new LinkedList<>();
		int totadult = 0;
		int totBug = 1;
		infancy.offer(1);

		for (int i = 1; i <= N; i++) {
			if (infancy.size() >= a) {
				int x = infancy.poll();
				totadult += x;
				maturity.offer(x);
			}
			if (maturity.size() > b - a) {
				int x = maturity.poll();
				totadult -= x;
				senility.offer(x);
			}
			if (senility.size() > d - b) {
				int x = senility.poll();
				totBug -= x;
			}
			infancy.offer(totadult%1000);
			totBug += totadult%1000;
		}
		System.out.println(totBug%1000);
	}

}
