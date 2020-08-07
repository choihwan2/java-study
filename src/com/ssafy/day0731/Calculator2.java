package com.ssafy.day0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			Stack<Character> calStack = new Stack<>();
			Stack<Integer> sumStack = new Stack<>();
			StringBuilder stb = new StringBuilder();
			String line = br.readLine();

			// 후위연산자로 변환
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (c >= '0' && c <= '9') {
					stb.append(c);
				} else {
					while (!calStack.isEmpty() && calStack.peek() <= c) {
						stb.append(calStack.pop());
					}
					calStack.push(c);
				}
			}
			while (!calStack.isEmpty()) {
				stb.append(calStack.pop());
			}
			System.out.println(stb.toString());
			// 밑에는 계산
			for (int i = 0; i < stb.length(); i++) {
				if (stb.charAt(i) >= '0' && stb.charAt(i) <= '9')
					sumStack.push(stb.charAt(i) - '0');
				else if (stb.charAt(i) == '+') {
					sumStack.push(sumStack.pop() + sumStack.pop());
				} else if (stb.charAt(i) == '*') {
					sumStack.push(sumStack.pop() * sumStack.pop());
				}
			}

			System.out.println("#" + t + " " + sumStack.pop());

		}
	}

}
