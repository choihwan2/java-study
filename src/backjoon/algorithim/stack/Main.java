package backjoon.algorithim.stack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		Scanner scanner = new Scanner(System.in);

		int repeat_num = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i <= repeat_num; i++) {
			String whatToDo = scanner.nextLine();
			myStack.stackProcess(whatToDo);
		}

		scanner.close();
	}

}

class MyStack {

	int[] stack = new int[10000];
	int stack_pos = 0;

	public void stackProcess(String whatToDo) {
		String strString[] = whatToDo.split(" ");
		switch (strString[0]) {
		case "push":
			push(Integer.parseInt(strString[1]));
			break;
			
		case "top":
			System.out.println(top());
			break;

		case "size":
			System.out.println(size());
			break;

		case "empty":
			System.out.println(empty());
			break;

		case "pop":
			System.out.println(pop());
			break;

		default:
			break;
		}
	}

	public void push(int push_stack) {
		stack[stack_pos++] = push_stack;
	}

	public int top() {
		if (stack_pos == 0) {
			return -1;
		} else {
			return stack[stack_pos - 1];
		}
	}

	public int size() {
		return stack_pos;
	}

	public int empty() {
		if (stack_pos == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public int pop() {
		if (stack_pos == 0) {
			return -1;
		} else {
			return stack[--stack_pos];
		}
	}
}
