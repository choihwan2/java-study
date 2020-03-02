package programmers.practice;

import java.util.Stack;

public class Properbracket {

	public static void main(String[] args) {
		System.out.println(solution2("((((())))))"));
	}
	public static boolean solution(String s) {
		boolean answer = false;
		int a =0;
		for(int i =0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				a++;
			}else {
				a--;
			}
		}
		
		if(a == 0) {
			answer = true;
		}
		
		return answer;
	}
	
	public static boolean solution2(String s) {
		boolean answer = false;
		StringBuffer str = new StringBuffer(s.replace("()", ""));
		while(str.toString().contains("()")) {
			str = new StringBuffer(str.toString().replace("()", ""));
		}
		if(str.length() == 0) {
			answer = true;
		}
		
		return answer;
	}
	public static boolean solution3(String s) {
		boolean answer = false;
		Stack<Character> stack = new Stack<Character>();
		for(int i =0; i<s.length(); i++) {
			if(s.charAt(i) =='(') {
				stack.push(s.charAt(i));
				continue;
			}else {
				if(stack.isEmpty()) {
					return false;
				}else {
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()) {
			answer = true;
		}
		return answer;
	}

}
