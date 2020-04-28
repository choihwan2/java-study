package programmers.heap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Hotter {
	/*
	 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	 */
	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		System.out.println(solution(scoville, 7));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < scoville.length; i++) {
			list.add(scoville[i]);
		}
		Collections.sort(list);
		Stack<Integer> wait_s = new Stack<Integer>();
		while (list.peekFirst() < K) {
			if (list.size() >= 2) {
				int min = list.pollFirst();
				int min2 = list.pollFirst();

				int hotter = min + (min2 * 2);
				while (!list.isEmpty() && list.peek() < hotter) {
					wait_s.add(list.poll());
				}
				list.addFirst(hotter);
				while (!wait_s.isEmpty()) {
					list.addFirst(wait_s.pop());
				}
				answer++;
			} else {
				return -1;
			}
		}

		return answer;
	}

	public static int solution2(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> list = new PriorityQueue<Integer>();
		for (int i = 0; i < scoville.length; i++) {
			list.offer(scoville[i]);
		}
		while (list.peek() < K) {
			if (list.size() >= 2) {
				int min = list.poll();
				int min2 = list.poll();

				int hotter = min + (min2 * 2);
				list.offer(hotter);
				answer++;
			}else {
				return -1;
			}
		}
		return answer;
	}
}
