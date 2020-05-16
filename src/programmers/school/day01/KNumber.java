package programmers.school.day01;

import java.util.Arrays;

public class KNumber {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int target_p = commands[i][2];
			
			int[] sub_arr = new int[end - start + 1];
			for(int j = 0; j< sub_arr.length; j++) {
				sub_arr[j] = array[start + j - 1];
			}
			
			Arrays.sort(sub_arr);
			answer[i] = sub_arr[target_p - 1];
		}
		return answer;
	}

}
