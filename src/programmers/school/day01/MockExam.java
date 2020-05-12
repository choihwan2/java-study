package programmers.school.day01;

import java.util.ArrayList;

public class MockExam {
	static int[][] MATH_TH = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

	class Solution {
		public int[] solution(int[] answers) {
			int[] num = new int[3];
			ArrayList<Integer> answer = new ArrayList<>();
			int max = 0;
			for (int i = 0; i < answers.length; i++) {
				for (int j = 0; j < 3; j++) {
					if (MATH_TH[j][i % MATH_TH[j].length] == answers[i]) {
						num[j]++;
					}
				}
			}

			for (int i : num) {
				max = Math.max(i, max);
			}

			for (int i = 0; i < 3; i++) {
				if (num[i] == max) {
					answer.add(i + 1);
				}
			}

			int[] end = new int[answer.size()];

			for (int i = 0; i < end.length; i++) {
				end[i] = answer.get(i);
			}

			return end;
		}
	}
}
