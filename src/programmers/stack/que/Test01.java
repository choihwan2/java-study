package programmers.stack.que;

import java.util.*;

public class Test01 {

	public static void main(String[] args) {
		int[] a = { 6, 9, 5, 7, 4 };
		System.out.println(Arrays.toString(solution(a)));
	}

	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		Stack<Tower> w_stack = new Stack<Tower>();
		Stack<Tower> t_stack = new Stack<Tower>();
		for (int i = 0; i < heights.length; i++) {
			w_stack.add(new Tower(heights[i], i + 1));
		}
		while (!w_stack.isEmpty()) {
			t_stack.add(w_stack.pop());
			while (!w_stack.isEmpty() && !t_stack.isEmpty() && w_stack.peek().height > t_stack.peek().height) {
				answer[t_stack.peek().position - 1] = t_stack.pop().position;
			}
		}
		return answer;
	}

}

class Tower {
	int height;
	int position;

	Tower(int height, int pos) {
		this.height = height;
		this.position = pos;
	}
}
