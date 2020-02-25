package programmers.bruteforce;

import java.util.Stack;

public class MakeBigNumber {

	public static void main(String[] args) {
		System.out.println(solution2("1924", 2));
	}

	public String solution(String number, int k) {
		String answer = "";
		char[] arr_num = number.toCharArray();
		for (int i = 0; i < k; i++) {
			StringBuffer str = new StringBuffer();
			for (int j = 0; j < arr_num.length; j++) {
			}
		}
		return answer;
	}

	public static String solution2(String number, int k) {
		char[] result = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}
		return new String(result);
	}
}
