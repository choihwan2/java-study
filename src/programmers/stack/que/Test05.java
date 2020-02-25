package programmers.stack.que;

import java.util.Stack;

public class Test05 {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<Character>();
		stack.push('c');
		stack.push('c');
		stack.push('c');
		stack.pop();
		System.out.println(stack.size());
	}
	public int[] solution(int[] prices) {
		int[] answer = {};
		Stack<Product> stack = new Stack<Product>();
		int a = stack.size();
		return answer;
	}

}

class Product {
	int price;
	int time = 0;

	Product(int price) {
		this.price = price;
	}

	public void go() {
		this.time++;
	}
}
