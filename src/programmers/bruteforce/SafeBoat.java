package programmers.bruteforce;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SafeBoat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 100, 40, 30, 70, 60 ,500,300};
		System.out.println(solution(num, 100));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < people.length; i++) {
			deque.add(people[i]);
		}
		while (deque.size() > 1) {
			int f = deque.peekFirst();
			int l = deque.peekLast();
			if(f + l <= limit) {
				deque.pollFirst();
				deque.pollLast();
				answer++;
			}else {
				deque.pollLast();
				answer++;
			}
		}
		if (!deque.isEmpty()) {
			answer++;
		}
		return answer;
	}

}
