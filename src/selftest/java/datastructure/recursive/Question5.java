package selftest.java.datastructure.recursive;

import java.util.Stack;

public class Question5 {

	public static void main(String[] args) {
		recur3(5);
	}

	static void recur3(int n) {

		if (n > 0) {
			recur3(n - 1);
			recur3(n - 2);
			System.out.println(n);
		}
	}

	static void nonRecur3(int n) {
		Stack<Integer> stack = new Stack<Integer>();
		while (true) {
			if (n > 0) {
				stack.add(n);
				n = n - 1;
			}
			if(stack.isEmpty() != true) {
				n = stack.pop();
				System.out.println(n);
			}
		}
	}

}
