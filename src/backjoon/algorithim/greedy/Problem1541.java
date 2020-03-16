package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		StringTokenizer input_stk = new StringTokenizer(input, "+-");
		Stack<Integer> num_stack = new Stack<>();
		Stack<Integer> tempStack = new Stack<>();
		Stack<Character> sign_stack = new Stack<>();
		int sum = 0;
		
		while (input_stk.hasMoreElements()) {
			num_stack.push(Integer.parseInt(input_stk.nextToken()));
		}
		char[] arr_input = input.toCharArray();

		for (char c : arr_input) {
			if (c == '+' || c == '-') {
				sign_stack.push(c);
			}
		}
		
		while (!num_stack.isEmpty()) {
			tempStack.push(num_stack.pop());
			
			if(!sign_stack.isEmpty() && sign_stack.pop() == '-') {
				while (!tempStack.isEmpty()) {
					sum -= tempStack.pop();
				}
			}
		}
		
		while (!tempStack.isEmpty()) {
			sum += tempStack.pop();
		}
		
		System.out.println(sum);
	}
}
