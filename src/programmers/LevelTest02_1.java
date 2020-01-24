package programmers;

import java.util.Arrays;

public class LevelTest02_1 {

	public static void main(String[] args) {
		int[] heights = { 6, 9, 5, 7, 4 };
		solution(heights);
		System.out.println(Arrays.toString(solution(heights)));
	}

	public static int[] solution(int[] heights) {
		int length = heights.length;
		int[] answer = new int[length];
		for (int i = length - 1; i > 0; i--) {
//			if (i < length - 2) {
//				if (heights[i] == heights[i+1] ) {
//					answer[i] = answer[i+1]; 
//					continue;
//				}
//			}
			
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}
		return answer;
	}
	// 6 9 5 7 4
}
