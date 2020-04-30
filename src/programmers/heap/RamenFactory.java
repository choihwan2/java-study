package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RamenFactory {

	public static void main(String[] args) {
		// 4, [1, 2, 3, 4], [10, 40, 30, 20], 100

		int[] dates = { 1, 2, 3, 4 };
		int[] supplies = { 10, 40, 30, 20 };
		int k = 100;
		System.out.println(solution(4, dates, supplies, k));
	}
	/*
	 * stock 에 있는 값으로 처음에 들어올 dates 값을 정한다.
	 */

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
		int index = 0;
		for (int i = 0; i < k; i++) {
			if (index < dates.length && i == dates[index]) {
				pq.add(supplies[index++]);
			}

			if (stock == 0) {
				stock += pq.poll();
				answer++;
			}
			stock -= 1;
		}
		return answer;

	}

}
