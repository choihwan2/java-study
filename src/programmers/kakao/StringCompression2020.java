package programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class StringCompression2020 {

	public static void main(String[] args) {

	}
	// 문자열을 받고 절반까지 계속해서 개수를 늘려나가며 비교 하고 압축시켜줘야함.
	// que 로 구현해서 해보자.

	public static int solution(String s) {
		int answer = 0;
		int num_length = s.length() / 2;
		for (int i = 0; i < num_length; i++) {
			Queue<Character> work_q = new LinkedList<Character>();
		}

		return answer;
	}

	public static void compression(int length, String s) {

	}

}
