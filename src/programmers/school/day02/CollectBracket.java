package programmers.school.day02;

import java.util.Stack;

public class CollectBracket {
	boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') stk.push(c);
			else if(c == ')') {
				if(!stk.isEmpty()) stk.pop();
				else {
					return false;
				}
			}
		}
		if(!stk.isEmpty())
			answer = false;

		return answer;
	}
}
