package com.ssafy.prepare.im;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_2605_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> w_stack = new Stack<>();
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int t = sc.nextInt();
			while (t > 0) {
				w_stack.push(stack.pop());
				t--;
			}
			stack.push(i);
			while(!w_stack.isEmpty()) {
				stack.push(w_stack.pop());
			}
		}
		
		int n = stack.size();
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			stb.insert(0, stack.pop() + " ");
		}
		System.out.println(stb.toString());

	}

}
