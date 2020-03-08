package programmers.practice;

import java.util.Arrays;

public class MakeMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 4 };
		int[] B = { 5, 4, 4 };
		System.out.println(solution(A, B));

	}

	public static int solution(int[] A, int[] B) {

		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < A.length; i++) {
			answer += (A[i] * B[B.length - i - 1]);

		}

		return answer;
	}

}
