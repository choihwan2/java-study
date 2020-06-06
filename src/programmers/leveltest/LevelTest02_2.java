package programmers.leveltest;

import java.util.Arrays;

public class LevelTest02_2 {

	public static void main(String[] args) {
		int[] heights = { 1, 2, 3, 2, 3 };
		System.out.println(Arrays.toString(solution(heights)));
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < answer.length - 1; i++) {
			for (int j = i + 1; j < answer.length; j++) {
				if (prices[i] <= prices[j] ) {
					answer[i]++;
				}
			}
		}
		return answer;
	}
	// 6 9 5 7 4
}
