package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSearch {

	public static void main(String[] args) {
		int[] answer = {};
		ArrayList<Integer> arrInt = new ArrayList<Integer>();
		arrInt.add(1);
		arrInt.add(1);
		arrInt.add(1);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};
		int a[] = { 1, 2, 3, 4, 5 };
		int b[] = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int c[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int count[] = new int[3];
		int max = 0;

		for (int i = 0; i < answers.length; i++) {
			if (a[i % 5] == answers[i]) {
				count[0]++;
			}
			if (b[i % 8] == answers[i]) {
				count[1]++;
			}
			if (c[i % 10] == answers[i]) {
				count[2]++;
			}
		}
		for (int i = 0; i < count.length; i++) {
			if(max < count[i]) {
				max = count[i];
			}
		}
		List<Integer> winner = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			if(max == count[i]) {
				winner.add(i+1);
			}
		}
		answer = new int[winner.size()];
		for (int i = 0; i <answer.length; i++) {
			answer[i] = winner.get(i);
		}
		return answer;
	}

}
