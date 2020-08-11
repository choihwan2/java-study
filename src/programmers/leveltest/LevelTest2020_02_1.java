package programmers.leveltest;

import java.util.Stack;

public class LevelTest2020_02_1 {
	public int solution(String s) {
		int answer = 0;
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!stk.isEmpty()) {
				if (stk.peek() != c) {
					stk.push(c);
				} else {
					stk.pop();
				}
			} else {
				stk.push(c);
			}
		}
		if (stk.isEmpty())
			answer = 1;
		return answer;
	}
}
