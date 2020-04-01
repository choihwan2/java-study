package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
// > > >
//

public class Problem2529 {
//	public static void main2(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int num = Integer.parseInt(br.readLine());
//		StringTokenizer stk = new StringTokenizer(br.readLine());
//		int m,n;
//		m = 9;
//		n = 0;
//		Deque<Integer> max_q = new LinkedList<Integer>();
//		Deque<Integer> min_q = new LinkedList<Integer>();
//		
//		max_q.addFirst(m--);
//		min_q.addFirst(n++);
//		while (stk.hasMoreElements()) {
//			String input = stk.nextToken();
//			if (input.equals("<")) {
//				max_q.addFirst(m--);
//				min_q.addLast(n++);
//			}else if (input.equals(">")) {
//				max_q.addLast(m--);
//				min_q.addFirst(n++);
//			}
//		}
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		Stack<Integer> w_max_s = new Stack<>();
		Queue<Integer> w_min_q = new LinkedList<>();
		for (int i = 0; i <= 8; i++) {
			w_max_s.add(i);
		}
		for (int i = 1; i <= 9; i++) {
			w_min_q.add(i);
		}

		Stack<Integer> max_s = new Stack<>();
		Queue<Integer> min_s = new LinkedList<>();
		max_s.add(9);
		min_s.add(0);
		StringBuilder max = new StringBuilder();
		StringBuilder min = new StringBuilder();

		while (stk.hasMoreTokens()) {
			String token = stk.nextToken();
			if (token.equals("<")) {
				max_s.add(w_max_s.pop());
				while (!min_s.isEmpty()) {
					min.append(min_s.poll());
				}
				min.append(w_min_q.poll());
			} else if (token.equals(">")) {
				while (!max_s.isEmpty()) {
					max.append(max_s.pop());
				}
				max.append(w_max_s.pop());
				min_s.add(w_min_q.poll());
			}
		}
		
		while (!max_s.isEmpty()) {
			max.append(max_s.pop());
		}
		while (!min_s.isEmpty()) {
			min.append(min_s.poll());
		}
		System.out.println(max.toString());
		System.out.println(min.toString());
	}

}
