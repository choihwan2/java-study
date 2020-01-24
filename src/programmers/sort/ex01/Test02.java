package programmers.sort.ex01;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {

	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		while (true) {
			Arrays.sort(scoville);
			if(scoville[1] == 0) {
				return -1;
			}
			scoville[0] = scoville[0] + (scoville[1] * 2);
			answer++;
			if(scoville[0] > K) {
				break;
			}
		}
		return answer;
	}
}
