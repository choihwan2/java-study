package ssafy.swexpert.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution9280 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int t = 1; t <= iT; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] parkingCost = new int[n + 1];
			int[] parkingArea = new int[n + 1];
			int[] carWeight = new int[m + 1];
			Queue<Integer> waitQ = new LinkedList<Integer>();
			for (int i = 1; i < n + 1; i++) {
				parkingCost[i] = sc.nextInt();
			}
			for (int j = 1; j < m + 1; j++) {
				carWeight[j] = sc.nextInt();
			}
			int answer = 0;

			for (int c = 0; c < 2 * m; c++) {
				int order = sc.nextInt();
				if (order > 0) {
					for (int k = 1; k < n + 1; k++) {
						if (parkingArea[k] == 0) { // 주차 공간이 있으면
							parkingArea[k] = order;
							break;
						}
						// 주차할 곳이 없을때.
						if (k == n)
							waitQ.offer(order);
					}
				} else {
					for (int k = 1; k < n + 1; k++) {
						if (parkingArea[k] + order == 0) {
							parkingArea[k] = 0;
							answer += parkingCost[k] * carWeight[order * -1];
							if (!waitQ.isEmpty()) {
								parkingArea[k] = waitQ.poll();
							}
							break;
						}
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

}
