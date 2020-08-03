package selftest.swexpert.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator2Test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			String input = br.readLine();
			StringBuilder stb = new StringBuilder();
			Stack<Character> opStack = new Stack<>();
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c >= '0' && c <= '9')
					stb.append(c);
				else {
					if (opStack.isEmpty()) {
						opStack.push(c);
						continue;
					} else {
						while (!opStack.isEmpty() && compareOper(c, opStack.peek()) <= 0) {
							stb.append(opStack.pop());
						}
						opStack.push(c);
					}
				}
			}
			while (!opStack.isEmpty()) {
				stb.append(opStack.pop());
			}
			Stack<Integer> numStack = new Stack<>();
			for (int i = 0; i < stb.length(); i++) {
				char c = stb.charAt(i);
				if (c >= '0' && c <= '9') {
					numStack.push(c - '0');
				} else {
					numStack.push(calculator(c, numStack));
				}
			}
			System.out.println("#" + t + " " + numStack.pop());
		}
	}

	private static int compareOper(char now, char topStack) {
		if (now == '*') {
			if (topStack == '+')
				return 1;
			else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	private static int calculator(char c, Stack<Integer> numStack) {
		int answer = 0;
		if (c == '+') {
			answer = numStack.pop() + numStack.pop();
		} else if (c == '*') {
			answer = numStack.pop() * numStack.pop();
		}
		return answer;
	}
}
